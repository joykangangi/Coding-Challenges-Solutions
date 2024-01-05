package geeks4geeks.arrays.subarray

fun main() {
    val arr1 = arrayOf(-2,-3,4,-1,-2,1,5,-3)
    val arr2 = arrayOf(1, 2, 3, -2, 5)
    val arr3 = arrayOf(-2, -3, -4, -1)

    val trial1 = kadaneAlgo(arr1)
    val trial2 = kadaneAlgo(arr2)
    val trial3 = kadaneAlgo(arr3)
    println("The maxSum1 is: ${trial1.first}, ${trial1.second.contentToString()}")
    println("The maxSum2 is: ${trial2.first}, ${trial2.second.contentToString()}")
    println("The maxSum3 is: ${trial3.first}, ${trial3.second.contentToString()}")

}

// Time complexity 0(n) Space complexity 0(1)
fun kadaneAlgo(arr: Array<Int>): Pair<Int, Array<Int>> {
    var maxSum = Int.MIN_VALUE //initializing it to minvalue also helps in handling empty arrays
    var currentSum = 0

    var start = 0
    var end = 0

    for (i in arr.indices){
        currentSum += arr[i]
        
        if (currentSum > maxSum){
            maxSum = currentSum
            end = i
        }
        if (currentSum < 0 ) {
            currentSum = 0
            start = if (i + 1 < arr.size) i + 1 else i //to avoid going beyond the bounds of the array
        }

    }

    // Ensure start and end are different before creating the sliced array
    val subArray =  arr.sliceArray(start..end)

    return maxSum to  subArray
}