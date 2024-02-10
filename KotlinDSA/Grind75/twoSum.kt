**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * Time-15 min
 */

fun main() {
    val mArray = intArrayOf(2, 7, 11, 15)
    val res = twoSum(mArray,9)
    println(res.contentToString())

    val array2 = intArrayOf(3,2,4)
    val res2 = twoSum(array2,6)
    println(res2.contentToString())
}


//brute-force; tc=0(n^2); sc=0(1)
fun twoSum(num: IntArray, target: Int): IntArray {
    val sumArray = IntArray(size = 2)

    for (i in num.indices) {
        for (j in i + 1 until num.size) { //prevent similar indices
            if (num[i] + num[j] == target) {
                sumArray[0] = i
                sumArray[1] = j
            }
        }
    }

    return sumArray
}

//use map to find compliment value at each iteration; time complexities = 0(n), Space = 0(n)
fun twoSum2(num: IntArray, target: Int): IntArray {
    val numMap = mutableMapOf<Int, Int>()//value=key, index=value

    num.forEachIndexed { index, number ->
        val diff = target - number
        val indexOfDiff = numMap[diff] //check if diff exist in map
        if (indexOfDiff != null) {
            return intArrayOf(indexOfDiff, index)
        }
        numMap[number] = index
        println(numMap)
    }
    throw IllegalArgumentException("No solution found")
}

