
class WorkingWithInterfacesInKotlin{
    fun workWithInterfaces() {
        val provider = BasicInfoProvider()
        provider.printInfo(Person("Buddy", "Pal"))

        val defaultExample = UsesDefaultMethodsImpl()

        defaultExample.printInfo(Person("Pal", "Buddy"))
    }
}

//notice we could have done this from main
fun main() {

}

//empty but valid
interface Simple

//implement interface
class AClassThatIsSimple : Simple

interface InfoProvider {
    fun printInfo(person:Person)
}

class Person(val firstName:String = "Pal", val lastName:String = "Buddy") {

}

//implement and interface
class BasicInfoProvider: InfoProvider {
    override fun printInfo(person: Person) {
        println("name: ${person.firstName} ${person.lastName}")
    }
}

//provide a default implementation

interface UsesDefaultMethods {
    fun printInfo(person: Person) {
        println("name: ${person.firstName} ${person.lastName}")
    }
}
//uses this implementation
class UsesDefaultMethodsImpl :UsesDefaultMethods  {

}

//use properties

interface UsesProperties {
    val properties:String

    fun printInfo(person: Person) {
        println(properties)
    }
}

class UsesPropertiesImpl : UsesProperties {

    // Java 8 introduced the default methods
    // (not really an added extra of kotlin)
    // basically, use child to provide the values,
    // not the general function that can be used
    // by all children, reduces code redundancy
    // remove implementation detail from interface
    override val properties: String
        get() = "Buddy Pal"
}

//use multiple interfaces

interface ImExtra {
    fun doSomethingExtra();
}

/*
How does this following work?
Class(override val properties: String) : UsesProperties

First notice, you cannot have the two in the same classes/interface

    val properties:String
    fun getProperties(): String

The val keyword automatically makes this properties value private
and then creates a getter that is hidden from you named getProperties()
therefor the property is just a get method and could have been accomplished
as easily in java. Consequently, the constructor also does the same generation
to the "fields" passed into it (and all "fields" created). If they are named
the same as the method definitions then the generated methods are also the same.
The override keyword must simply generate that @Overrride annotation on the
methods it creates to satisfy the interface
 */

//syntax for more than one interface
class MoreThanOne(override val properties: String) : UsesProperties, ImExtra{
    override fun doSomethingExtra() {
        TODO("Not yet implemented")


    }



}