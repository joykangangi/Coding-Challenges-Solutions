

fun main() {
    val kingCharlesTheEleventh = Human()
    val kingCarolusRex = Human()

    var king = kingCharlesTheEleventh
    king = kingCarolusRex
    println("""
        WE NEED
        
        TO LEARN KOTLIN
        
        AS QUICKLY AS POSSIBLE
        """.trimIndent())



  println(  "content".substringAfter("t") )
println("1")
   println( "content".substringBefore("c"))
    println("2")
           println( "content".substring(0,0))
    println("3")
           println( "content".substring(1,1))
    println("4")
   // "content".substring(-1,-1)

           println( "content".substring(0,1))

    println("result".substring(1, 4).substring(1, 2))

    //val regex = Regex("\\.\\?")
    /*Using special characters, create a regex instance named regex that matches all the strings below:

    "20 rings", "9 rings", "7 rings", "3 rings", "1 ring".
     */

    val regex = Regex(".?..rings?")
    val test = "9 rings"
    val test2 = "1 ring"
    val test3 = "many different rings"
    val test4 = "100 rings"
    val test5 = "20 rings"

    println(test.matches(regex))
    println(test2.matches(regex))
    println(test3.matches(regex))
    println(test4.matches(regex))
    println(test5.matches(regex))
}

class Human()
/*
val regex = Regex("cat") // creating the "cat" regex

val stringCat = "cat"
val stringDog = "dog"
val stringCats = "cats"

println(stringCat.matches(regex))   // true
println(stringDog.matches(regex))   // false
println(stringCats.matches(regex))  // false
 */
