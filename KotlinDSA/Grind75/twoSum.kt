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

// you have target, and want to find x,y. What you do is target - x = y', if y'==y then you've found what you were looking for
fun twoSum3(num: IntArray, target: Int): IntArray {
    val numMap = mutableMapOf<Int, Int>()//value=key, index=value

    num.forEachIndexed { index, number ->
        val indexOfDiff = numMap[number] // index is a value in the map

        if (indexOfDiff != null) {  //Before adding a difference to the map, the function checks if that difference is already present, preventing the same index from being used again
            return intArrayOf(indexOfDiff, index)
        }
        numMap[target - number] = index
    }
    return intArrayOf()
}


/** Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 *  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */
fun findThreeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()

    var resp: MutableSet<List<Int>> = mutableSetOf()
    nums.sort()

    for(curr in 0..nums.size - 2) {
        var left = curr + 1
        var right = nums.size - 1
        while (left < right) {
            var sum = nums[curr] + nums[left] + nums[right]
            when {
                (sum == 0) -> resp.add(listOf(nums[curr], nums[left++], nums[right--])) // increase left and decrease right
                sum < 0 -> left++ // increase left to increase sum
                sum > 0 -> right-- // decrease right to decrease sum
            }
        }
    }
    return resp.toList()
}

