
fun main() {
    //similar to InstanceOf()
    if (ProviderImpl() is ServiceProvider) {

    }

    //negation
    if (ProviderImpl() !is ServiceProvider) {

    }
}

interface PrintProvider

interface ServiceProvider {
    fun provideService()
}

class ProviderImpl: PrintProvider, ServiceProvider {
    override fun provideService() {
        print("Service")
    }
}

//like instanceOf()

fun casting() {
    //cast a object
    var name:String = "123"

    var cast:Int = (name as Int)
}

fun smartCast(printProvider: PrintProvider) {
    if (printProvider is ServiceProvider) {
        (printProvider as ServiceProvider).provideService()
    }

    //a smart cast takes the conditional and now implicitly
    //provides the cast for you
    if (printProvider is ServiceProvider) {
        printProvider.provideService()
    }

    //Remember you need to cast it to the other interface
    //and cannot do this automatically:
    //printProvider.provideService()
}