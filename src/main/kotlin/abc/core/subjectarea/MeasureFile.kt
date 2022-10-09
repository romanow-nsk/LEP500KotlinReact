package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class MeasureFile:Entity{
    var Support:EntityLink<Support> = EntityLink<Support>()
    var artifact:EntityLink<Artifact> = EntityLink<Artifact>()
    var importDate:OwnDateTime=OwnDateTime()
    var measureDate:OwnDateTime=OwnDateTime()
    var sensor:String=""
    var powerLineName:String=""
    var supportName:String=""
    var comment:String=""
    var gps:GPSPoint=GPSPoint()
    var expertResult:Int=0
    var fileFreq:Double=0.0
    var measureCounter:Int=0
    var userId:Long=0
    constructor() {}
}
