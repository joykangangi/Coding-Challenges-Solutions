package codility

/**
 * Regular Functions: Fixed behavior on changing variables.
 * Extension Functions: Extend class functionality with fixed behavior.
 * Lambda with Receiver: Apply various behaviors to a fixed object.
 *
 */


/**
 * Create a Rectangle class with properties width and height.
 * Implement a function to calculate the area of the rectangle.
 */

//regular function
class Rectangle(val width: Double, val height: Double) {

    fun findArea() = width * height
}

fun main() {
    val rect = Rectangle(width = 5.00, height = 9.00)
    println(rect.findArea())
    println(rect.getArea())
    getArea {
        println(this.width * this.height)
    }
    //2.
    val circle = Circle(radius = 2.0)
    println(circle.circumference())

    val circle2 = Circle2(radius = 2.0)
    println(circle2.getCircumference())

    println("=========")
    doPeri(
        init = {
            println(2 * Math.PI * radius)
        }
    )

    //3.
    val person = Person(firstName = "Alex", lastName = "Genius")
    println(person.getName())
    val person2 = Person2(firstName = "Sharon", lastName = "Muthomi")
    println(person2.getFullName())
    personObject {
        println(firstName + lastName)
    }

}

//extension function
fun Rectangle.getArea(): Double {
    return this.width * this.height
}

//lambda with receiver
fun getArea(init: Rectangle.() -> Unit): Rectangle {
    val rect2 = Rectangle(5.0, 9.0)
    rect2.init()
    return rect2
}

/**
 * Create a Circle class with a property radius.
 * Implement a function to calculate the circumference of the circle (use 2 * Math.PI * radius).
 */
//Regular Function
class Circle(val radius: Double) {
    fun circumference() = 2 * Math.PI * radius
}

//extension function
class Circle2(val radius: Double)

fun Circle2.getCircumference() = 2 * Math.PI * radius

//lambda with receiver
fun doPeri(init: Circle2.() -> Unit): Circle2 {
    val peri = Circle2(radius = 2.0)
    init(peri) //peri.init()
    return peri
}

/**
 * Create a Person class with properties firstName and lastName.
 * Implement a function to return the full name of the person.
 */

class Person(val firstName: String, val lastName: String) {

    fun getName() = firstName + lastName
}

class Person2(val firstName: String, val lastName: String)

//extension function
fun Person2.getFullName() = firstName + lastName


//lambda function with receiver
/**
 * Use when you have a fixed object that you want to configure or initialize in various ways.
 * They are particularly useful for creating DSLs (Domain-Specific Languages) where you need a more expressive and readable syntax.
 */
fun personObject(init: Person2.() -> Unit): Person2 {
    val person2 = Person2(firstName = "Joy", lastName = "SuperStar")
    //person2.getFullName() //can also be used
    person2.init() //give value to the object before returning it, otherwise it will return nothing;
    //If you didn't call init, the lambda wouldn't have the opportunity to modify the object before it's returned.
    //This would be equivalent to simply returning the newly created object without any additional customization.
    return person2
}

/**
 * ANDROID EXAMPLE
 */

@get:Rule
val rule: ComposeContentTestRule by lazy {
    createComposeRule()
}

private fun withCompose(testCases: ComposeContentTestRule.() -> Unit) {
    //The lambda has a receiver of type ComposeContentTestRule,
    //allowing you to call methods on rule within the lambda.
    rule.testCases()
}

private fun withWorkContent(
    testCases: ComposeContentTestRule.() -> Unit,
) = withCompose {
    setContent {
        MyTestTheme {
            MyApp2()
        }
    }
    //After setting the content, testCases() is called.
    //This means that after the content is set, the lambda passed to withWorkContent (which contains the test cases) is executed.
    testCases()
}
