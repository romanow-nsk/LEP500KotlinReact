package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class AnalyseResult:Entity{
    var title:String=""
    var firstFreq:Double=0.0
    var lastFreq:Double=0.0
    var dFreq:Double=0.0
    var nFirst:Int=0
    var nLast:Int=0
    var message:String=""
    var valid:Boolean=false
    var measure:MeasureFile=MeasureFile()
    constructor() {}
}
