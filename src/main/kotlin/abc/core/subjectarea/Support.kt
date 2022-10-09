package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class Support:Entity{
    var measureState:Int=0
    var PowerLine:EntityLink<PowerLine> = EntityLink<PowerLine>()
    var files:EntityRefList<MeasureFile> = EntityRefList<MeasureFile>()
    var name:String=""
    constructor() {}
}
