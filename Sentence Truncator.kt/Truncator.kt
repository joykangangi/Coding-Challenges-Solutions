
import java.util.regex.Pattern

/*fun main() {
    println(trimSentence("To crop or not to crop", 21))
    println(trimSentence("Codility we test coders", 14))
    println(trimSentence("Why not", 100))
    println(trimSentence("the quick brown fox jumps over the lazy dog", 39))
}
fun trimSentence(sentence: String, finIndex: Int): String {
     val sLength = sentence.length
     return sentence.substring(0, sLength.coerceAtMost(finIndex))
  }

 */

/**
 * To crop or not to
 * Codility we
 * Why not
 * The quick brown fox jumps over the lazy
 */
fun main() {
    println(trimSentence("To crop or not to crop", 21))
    println(trimSentence("Codility we test coders", 14))
    println(trimSentence("Why not", 100))
    println(trimSentence("the quick brown fox jumps over the lazy dog", 39))
}
fun trimSentence(sentence: String, finIndex: Int): String {
    //check if the index is out of bounds and return the sentence instead
    if (sentence.length < finIndex) return sentence

    //if the index of the last space in the sentence is less than the final index or equal to it, split at that index
    val lastSpace = sentence.lastIndexOf(" ")
    return if (lastSpace <= finIndex) sentence.substring(0, lastSpace)
    else{
        val s = sentence.substring(0,finIndex)
        s.substringBeforeLast(" ")
    }

 /*
 val spaces = Regex(Pattern.quote(" ")) //build the regex
     .findAll(sentence)                   //get the matches
     .map { it.range.first }              //get the indices
     .filter { it >= finIndex }           //get those greater than the index
     .first()                             //get the first, i.e, the smallest, i.e, the next space
    return sentence.substring(0, spaces)
  */
}








