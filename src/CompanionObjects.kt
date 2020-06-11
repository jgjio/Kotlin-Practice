interface IdProvider {
    fun getId():String
}


class CompanionDemonstration private constructor(name:String) {

    //these can also inherent from interfaces and store
    //const properties for object

    //only way to really get static classes/members/fields
    companion object : IdProvider {
        const val id = "154"

        override fun getId(): String {
            return "154"
        }

        fun create() = CompanionDemonstration(getId())
    }

    /* commented out because only one companion can exist
       even with different names

    //usually Factory is sometimes a good name
    companion object Named {
        fun create() = CompanionDemonstration("another example")
    }

    to call this one:
    CompanionDemonstration.Named.create()
    */

}

fun main() {
    /*
    In a companion object object you have access to all
    private properties of a class. With a private constructor
    It would never be instantiated except that the companion
    can control its object creations
     */

    val companion = CompanionDemonstration.create()

}