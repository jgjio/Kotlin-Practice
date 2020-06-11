

fun main() {

}

//remember in java it is a inner class with no name
//thus "anonymous" kotlin uses object expressions
//for this
fun anonymousClasses() {
    //Don't need to make a whole new named class
    //good for click listeners in Android
    val simpleClass = object : ServiceProvider {
        override fun provideService() {
            println("example of override")
        }

    }


}