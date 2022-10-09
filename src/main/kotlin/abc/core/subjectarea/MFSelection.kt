package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class MFSelection:Entity{
    var files:EntityLinkList<MeasureFile> = EntityLinkList<MeasureFile>()
    var user:EntityLink<User> = EntityLink<User>()
    var createDate:OwnDateTime=OwnDateTime()
    var name:String=""
    constructor() {}
}
