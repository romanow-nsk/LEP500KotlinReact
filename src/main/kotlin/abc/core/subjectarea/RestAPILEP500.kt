package abc.core.subjectarea

import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RestAPILEP500 (var ip: String = "127.0.0.1", var port: Int = 4567){
    suspend fun getMeasureSelection(SessionToken:String,note:Int,userId:Long,line:String,support:String) : R<ArrayList<MeasureFile>> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/lep500/measure/select?note="+note+"&userId="+userId+"&line="+line+"&support="+support+"",RequestInit("get",headers))
            .await()
        if (!res.ok)
            return R(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return R("",format.decodeFromString<ArrayList<MeasureFile>>(res2))
    }
    suspend fun splitMeasure(SessionToken:String,measureId:Long,size32768:Boolean,startOver:Int,startLevelProc:Int,skipTimeMS:Int) : R<MFSelection> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/lep500/measure/split?measureId="+measureId+"&size32768="+size32768+"&startOver="+startOver+"&startLevelProc="+startLevelProc+"&skipTimeMS="+skipTimeMS+"",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return R(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return R("",format.decodeFromString<MFSelection>(res2))
    }
    suspend fun addMeasure(SessionToken:String,artId:Long) : R<MeasureFile> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/lep500/measure/add?artId="+artId+"",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return R(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return R("",format.decodeFromString<MeasureFile>(res2))
    }
    suspend fun analyse(SessionToken:String,paramId:Long) : R<ArrayList<AnalyseResult>> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/lep500/analyse?paramId="+paramId+"",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return R(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return R("",format.decodeFromString<ArrayList<AnalyseResult>>(res2))
    }
    suspend fun setExpertNote(SessionToken:String,measureId:Long,note:Int) : R<JEmpty> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/lep500/measure/expertnote/set?measureId="+measureId+"&note="+note+"",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return R(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return R("",format.decodeFromString<JEmpty>(res2))
    }
}
