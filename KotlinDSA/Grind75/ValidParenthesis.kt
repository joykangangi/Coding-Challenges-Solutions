
/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */


//Brute Force;Time=0(n), Space = 0(n)
fun isValid(s: String): Boolean {

    //val charStack = ArrayDeque<Char>()
    val charStack = mutableListOf<Char>()
    val charMap = mapOf(']' to '[', ')' to '(', '}' to '{')


    s.forEach { char ->
        if (char == '[' || char == '(' || char == '{') {
            charStack.add(char)
        }

        else if (char == ']' || char == ')' || char == '}')  {
            if (charStack.isEmpty()) return false //Stack is empty, but closing bracket found

           val lastOpening  = charStack.removeAt(charStack.size-1)
            val expendedOpening = charMap[char]
            if (lastOpening != expendedOpening) return false //The function should return true (indicating a valid string) only after the entire string has been processed and no mismatches were found.
        }
    }
    return charStack.isEmpty()

}

fun main() {
    val valid = isValid("(){}[")
    println("The string is valid: $valid")
}
