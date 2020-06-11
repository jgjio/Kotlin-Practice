
fun main() {

}

class SimpleClass:ServiceProvider {
    override fun provideService() {
        println("simple class implementation of service")
    }
}

//inheritance
//correct syntax but is an error because by default
//all classes are final
//class SimpleChild : SimpleClass() {

//}

//open to declare non final classes
open class NonFinalSimpleClass:ServiceProvider {
    //default is that these values are also not overrideable
    //these values are now only able to be seen in children
    //due to protected if not added then they are public
    protected val myVal:String = "My Val"
    protected open val myOtherVal = "My Other Val"

    override fun provideService() {
        println("non final simple class implementation of service")
    }

}

class SimpleChild : NonFinalSimpleClass() {

    //declared open
    override val myOtherVal: String
        //get() = super.myOtherVal
        get() = "New"

    override fun provideService() {
        super.provideService()
        println("more code")
    }
}