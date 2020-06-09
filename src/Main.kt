var higherScope: String = "Higher scope"

fun main() {
    //const can only be assigned at compile time
    //val can be assigned at runtime
    //var can be assigned at both
    //equivalent to using final in Java
    val name: String = "my string"
    //this is a mutable type
    var nameTwo: String = "my mutable string"

    //ex
    val returnedString = newFunc()
    println(newFunc())
    println(newerFunc())
    array()
    callingVarArguments()
}

fun ex1() {
    //doesn't nee type due to type inference
    val name = "new"
}

fun ex2() {
    var name = "example"
    //cannot make it null due to NonNull by default
    //name = null
    //? allows null to be assigned to this string
    var nullType: String? = null
    //var nullType2: String = null error
}

fun ex3() {
    //if similar to java
    if (higherScope == null) {
        println("is null")
    }
}

//similar to switch statement
fun ex4() {
    when(higherScope){
        "specific" -> println("true")
        null -> println("var is null")
        else -> println("default")
    }

}

fun ex5() {
    var myString:String = "myString"

    var second = if(myString==null) "new" else "not"

    second = when(myString) {
        null -> "HI"
        else -> "NOT HI"
    }
}

//return type
fun newFunc():String {
    return "myString"
}

//function definition

fun newerFunc():String = "myString"

//use inference on the data type
//it infers its use when it gets to it

fun inference() = "myString"

//parameter

fun parameter(param:String) {
    //$ is a template
    println("print param$param")
}

//simple

fun simpleFunc(param:String) = println("print param $param")


fun array() {
    //infer the types
    val array = arrayOf(1,2,3,4,5,6)
    println(array[0])
    forLoop(array)
}

fun forLoop(array: Array<Int>) {
    for(item in array) {
        println(item)
    }
}

//more functional approach to collection

//you are still calling a function but don't need the parameters
//because it is being simplified through a notation dealing with
//the lambda (not yet learned how to do)
fun functionalForLoop(array:Array<Int>) {
    //it is the item
    array.forEach { println(it) }

    //or use a lambda to change it
    array.forEach { myItem->
        println(myItem)
    }
    //if we need index
    array.forEachIndexed{index, i ->
    }
}

fun lists() {
    //implementation of a array list not a linked or other list
    val newThings = listOf(1,2,3,4,5)
    newThings.last()
}

// these are key value pairs
fun mapOf() {
    //this uses a function to easily create object wrappers
    val newMap = mapOf(1 to "a", 2 to "b")

    newMap.forEach{key, value->
        println("Pair:$key:$value")
    }
    //notice there is no functions below because the type is val
    //therefore it is immutable
    //newMap.add
    //newMap.remove
}

//the default is to make everything immutable
//you have to explicitly declare a mutable map
fun mutableList() {
    val newList = mutableListOf(1,2,3)

    newList.add(6)

    newList.forEach {
        println(it)
    }
}

fun callingVarArguments () {
    //these are all acceptable

    //instead of sending an empty list, no longer needed
    varArguments()

    //also
    varArguments("one")

    //also
    varArguments("one", "two", "three")

    //these are all being passed as an array
    //however to pass *in* an array to the function
    //is an error ex;
    val myArray = arrayOf("one","two","three")


    //this is an error
    //varArguments(myArray)
    //instead use a * operator known as a spread
    //this converts the list to a list of parameters
    //for this function
    //uses java spread builder to decompile

    varArguments(*myArray)
}

//vararg for when there is a variable number of parameters including 0
//similar to (Param ... params)
//multiple varArg types are not allowed obviously
//in java there can only be one and at the end
fun varArguments(vararg arg:String){
    println("Current number of arguments")

    arg.forEach {
        println(it)
    }

    //or remember you can update lambda
    arg.forEach { item->

    }

}

//named parameters

fun regularFunction(name:String, greeting:String)=println("$greeting $name")

//notice we can call parameter values out of place
fun usingNamedParameters() {
    regularFunction(greeting = "hi", name = "Ralph")
}

//default parameters
fun defaultParam(name:String = "Ralph", greeting: String = "Hi") =println("$greeting $name")

//calling on default parameters
fun usingDefaultParameters() {
    //both use default values
    defaultParam()
    //notice it can now be out of order
    //one default used
    //if you use one named syntax for one parameter
    //then you must use the named syntax for all parameters
    defaultParam(greeting = "Hello")
    //also named used as it's specified first without default parameter
    defaultParam("Jimmy")

    //NOTE: It allows better way to handle the builder pattern in code
    //that is the pattern that does: Object.setThis().setThis()
}
