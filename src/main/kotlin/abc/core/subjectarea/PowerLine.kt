package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class PowerLine:Entity{
    var measureState:Int=0
    var group:EntityRefList<Support> = EntityRefList<Support>()
    var name:String=""
    constructor() {}
}
