import abc.core.subjectarea.RestAPIBase
import abc.core.subjectarea.User
import kotlinx.browser.document
import kotlinx.browser.window
import react.create
import react.dom.client.createRoot
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit


suspend fun keepAlive2(token:String): String {
    val response = window
        .fetch("http://localhost:4567/api/keepalive", RequestInit("get", Headers().append("SessionToken",token)))
        .await()
        .text()
        .await()
    return response
}
var token:String=""
suspend fun main(args: Array<String>) {
    val container = document.createElement("div")
    document.body!!.appendChild(container)
    val api: RestAPIBase = RestAPIBase()
    api.ip="217.71.138.9"
    api.port=4567
    val ss = api.keepalive("1111111")
    val userPair = api.login("9137777777","1234")
    var out = ""
    if (!userPair.valid())
        out = userPair.mes
    else {
        token = userPair.data!!.sessionToken
        val list = api.getEntityList(token,"User",0,0)
        val format = Json { ignoreUnknownKeys = true }
        for (vv in list.data!!){
            var user2 = format.decodeFromString<User>(vv.jsonObject)
            out += user2.lastName+"_"+user2.firstName+" "
        }
    }
    val welcome = Welcome.create {
        name = api.ip+" "+token+" "+out

    }
    createRoot(container).render(welcome)
}