
class PracticeClasses {

    fun practiceWithObjects() {
        val example = ClassThatUsesDefaultValues()

        /*
        This looks like it is accessing the field first
        but it is creating getters/setters that you can't
        see but later you can use them to provide constraints
        without requiring that we change all the callers to
        get this field and allows the proper encapsulations

        Background:
        Getters/setters are necessary to provide policy
        and constraint to member variables for objects.
        With only fields it is impossible to provide that
        constraint/policy.
        If you refer to fields directly and want to add a
        constraint 'later on' it requires that we take all
        the classes that use it and change them to use methods
        therefore it breaks encapsulation. The calling class
        shouldn't care if the value is that specific variable only
        that the value provide the message it needs or tell it
        what we need to tell it.
        So it is typical in JAVA to provide all members as
        private then use get/set methods to provide for the
        possibility of that happening in the future even if
        it doesn't seem like it matters. In kotlin this is
        seen as 'boiler-plate'
        With kotlin, it looks like a regular field but it
        allows us to make the method later without changing
        outside classes.
        */

        println(example.first)

        val exampleTwo = ClassThatRemovesFirst()

        //notice this is a call to a method not a field
        println(exampleTwo.first)



        //the getter is available for this, we set
        //private to the setter
        //println(example.aPrivate)

        //we cannot access this one:
        //println(example.aClassPrivate)

    }

}


//start with this:

class SimplestClassPossible

class ObjectOrientedKotlinPractice {
}

//the () is actually the constructor
class exampleOne()

//however you are able to be more explicit
class ExampleTwo constructor()


/* notice this is invalid and it asks you to change the name of
   ExampleThree function
class ExampleThree
    fun ExampleThree() {

    }*/

//successful passing of parameter
class ClassWithParameter(first:String)

//initializing parameters
class ClassWithParameterAndUsesInit(_first:String) {
    val first:String
    //called on initialization much like a constructor
    init {
        first =_first
    }
}

//just use it on declaration

class ClassWithParameterAndUsesDeclaration(_first: String) {
    val first:String = _first
}

//don't even initialize it, let Kotlin do it:

class ClassWithParameterAndUsesDeclarationOfPropertyDirectlyInConstructor(val first: String)
//there is now a value first that can be used by the class


//multiple constructors

class MultipleConstructor(val first:String, val last:String) {
    //calls above constructor
    constructor(): this("Default", "Name") {
        println("Do work needed for default construction")
    }

    //notice when making this class that if you don't call second
    //constructor that the body won't be run. However, a init
    //block will always run on object creation
    init {
        println("Do general work")
    }
    //notice
    init {
        println("Do More work")
    }
    //also note that init blocks run before the second constructor
}

//But do you need it?

//Do you need a body for for construction specific to your default
//values? Do you need to provide multiple forms of acceptable default values?

class ClassThatUsesDefaultValues(val first: String = "Default",
    val second: String = "Name"
) {
    //private needs to be made explicit and public is default
    var aPrivate: Int = 5 // property is visible everywhere
        private set
    private var aClassPrivate: Int = 6
}


class ClassThatRemovesFirst(val second: String = "Name") {
    //private needs to be made explicit and public is default
    var aPrivate: Int = 5 // property is visible everywhere
        //declare that you don't want to be able to set this
        //outside of the class
        private set /* also declare the get as private too: */get
    private var aClassPrivate: Int = 6

    val first: String
        //overriding the getting of a variable
        //which is not known outside of classes
        //to classes outside it would seem like
        //it is just accessing a field directly
        get () = this.toString()

        //or get() {return field}

    //it still doesn't automatically generate a getFirst method
    //see above for how it works. We can also change the set or
    //restrict it all-together.
    fun getFirst() : Int {
        return aClassPrivate
    }

    var varOverridesItsSetMethod:String = "Hello"
            set(value) {
                //set constraints / other code
                println("A code")

                //if you want to update the field for class
                //do it like this
                field = value
            }
}

class ClassMethods(val first: String = "Default", val second: String = "Name") {

    //use fields
    fun print() {
        println("$first $second")
    }

}

//everything is already public in kotlin so why declare public?
//not needed
public class publicClass

//restrict the class for use only in the package/module like protected
internal class inteneralClass

//only available in this file
private class privateClass

class accessModifiers() {
    //in this case protected is available to class and all extensions of class
    //just like Java
    protected val name ="newName"
    //not accessible to extended class accessible only to file
    private val privateName = "anotherName"

    //same rules apply to methods
    private fun privateMethod() {

    }
}

