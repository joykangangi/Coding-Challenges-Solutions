package geeks4geeks.arrays.subarray

//A sub-array is contiguous, shares the same border, for [1,2,3,4] 1 and 3 is not a sub-array
// Finding the maximum sum of a sub-array


fun main() {
    val arr3 = arrayOf(-2,1,-3,4)

    val dnc = DivideAndConquerMaxSubArray()

    val trial3 = dnc.maxSubArraySum(arr = arr3.toIntArray(), low = 0, high = arr3.size - 1)
    println("The max sum is: $trial3")
}

//Space complexity = O(log n) & Time complexity = O(n log n); recursion effect
class DivideAndConquerMaxSubArray {
    //Divide and Conquer
    private var iteration = 0

    fun maxSubArraySum(arr: IntArray, low: Int, high: Int): Int {
        iteration++
        println("Iteration: $iteration , $low, $high")

        //if there's only one element return it
        if (low == high) {
            println("low = $low, high = $high")
            return arr[low]
        }

        val mid = (low + high) / 2
        println("IterationII: $iteration , $mid")



        // Recursive step: Find the maximum sub-array sum in the left and right halves
        // The entire array is passed to each recursive call because we are interested
        // in finding the maximum sub-array sum within that sub-array
        println("Creating max, $iteration, $low, $high")
        val maxLeft = maxSubArraySum(arr = arr, low = low, high = mid)
        println("Creating maxLefts, $iteration, high = $high")
        val maxRight = maxSubArraySum(arr = arr, low = mid + 1, high = high)
        println("Creating maxRights, $iteration, ${mid+1}, $high")

        // Find the maximum sub-array sum crossing the midpoint.
        val maxCrossing = maxCrossingSum(arr, low, mid, high)

        // Return the maximum of maxLeft, maxRight, and maxCrossing.
        return maxOf(maxLeft, maxRight, maxCrossing)
    }

    private fun maxCrossingSum(arr: IntArray, low: Int, mid: Int, high: Int): Int {
        var sum = 0
        var leftSum = Int.MIN_VALUE

        // Find the maximum sum of the sub-array in the left half
        for (i in low..mid) {
            println("The left arr is: ${arr.contentToString()}, low = $low, high = $high")
            sum += arr[i]
            if (sum > leftSum) {
                leftSum = sum
            }
        }
        println("The leftSum is: $leftSum")

        sum = 0
        var rightSum = Int.MIN_VALUE

        // Find the maximum sum of the sub-array in the left half
        for (i in mid + 1..high) {
            println("The right arr is: ${arr.contentToString()}, low = $low, high = $high")
            sum += arr[i]
            if (sum > rightSum) {
                rightSum = sum
            }
        }
        println("The rightSum is: $rightSum")

        // Return the sum of the maximum sub-arrays in the left and right halves.
        return leftSum + rightSum


    }
}
