package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class LEP500Params:Entity{
    var paramListName:String=""
    var FirstFreq:Double=0.0
    var LastFreq:Double=0.0
    var nTrendPoints:Int=0
    var nTrendPointsSpectrum:Int=0
    var p_BlockSize:Int=0
    var p_OverProc:Int=0
    var kSmooth:Int=0
    var winFun:Int=0
    var measureDuration:Int=0
    var measureGroup:String=""
    var measureTitle:String=""
    var measureCounter:Int=0
    var fullInfo:Boolean=false
    var measureFreq:Double=0.0
    var amplLevelProc:Int=0
    var powerLevelProc:Int=0
    var alarmFreqKoef:Double=0.0
    var mailToSend:String=""
    var K1:Double=0.0
    var K2:Double=0.0
    var K3:Double=0.0
    var K4:Double=0.0
    var K5:Double=0.0
    var K6:Double=0.0
    var K7:Double=0.0
    var autoCorrelation:Int=0
    var groupNormalize:Boolean=false
    var name:String=""
    constructor() {}
}
