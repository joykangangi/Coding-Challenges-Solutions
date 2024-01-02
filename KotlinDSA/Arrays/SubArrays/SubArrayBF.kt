package geeks4geeks.arrays.subarray

fun main() {
    val arr1 = arrayOf(1, 2, 3, -2, 5)
    val arr2 = arrayOf(-1, -2, -3, -4)

    val trial1 = maxSumInSubArray1(arr1)
    val trial2 = maxSumInSubArray1(arr2)
    println("The max sum is: $trial1")
    println("The max sum is: $trial2")

    val trial3 = maxSumInSubArray2(arr1)
    val trial4 = maxSumInSubArray2(arr2)
    println("The max sum is: $trial3")
    println("The max sum is: $trial4")

    val trial5 = maxSumInSubArray3(arr1)
    val trial6 = maxSumInSubArray3(arr2)
    println("The max sum is: $trial5")
    println("The max sum is: $trial6")

    val trial7 = maxSumInSubArray4(arr1)
    val trial8 = maxSumInSubArray4(arr2)
    println("The max sum is: $trial7")
    println("The max sum is: $trial8")
}

//Brute-Force, okay for positive and negative, but computationally expensive
fun maxSumInSubArray1(array: Array<Int>): Map<List<Int>, Int> {

    val listSubArrays = mutableListOf<List<Int>>()

    //the starting point;0-3;
    for (i in array.indices) {

        //end-point 0-3; j=i;j<array.size; j++
        for (j in i until array.size) {
            //var sum = 0
            val subArray = mutableListOf<Int>()

            for (k in i..j) {
                subArray.add(array[k])
                //sum += array[k]
            }
            listSubArrays.add(subArray)

        }
    }

    val listMaxSum = mutableListOf<Int>()
    val mapSumArrays = mutableMapOf<List<Int>, Int>()

    listSubArrays.forEach { list ->
        var sum = 0
        for (i in list) {
            sum += i
        }
        listMaxSum.add(sum)
        mapSumArrays[list] = sum
    }
    return mapSumArrays.filter { map -> map.value == listMaxSum.maxOf { it } }
}

fun maxSumInSubArray4(array: Array<Int>): Pair<List<Int>, Int> {

    var maxSum = Int.MIN_VALUE
    var start = 0
    var end = 0

    //the starting point;
    for (i in array.indices) {

        //end-point 0-3; j=i;j<array.size; j++
        for (j in i until array.size) {
            var sum = 0
            val subArray = mutableListOf<Int>()

            for (k in i..j) {
                subArray.add(array[k])
                sum += array[k]
            }
            if (sum > maxSum) {
                maxSum = sum
                start = i
                end = j
            }
        }
    }
    val subarr = array.slice(start..end)
    val maxPair = Pair(subarr, maxSum)
    //its pair coz just one couple to return
    return maxPair
}



//Time complexity: O(n^3), due to nested loops and map operations.
//Space complexity: O(n^2), as it stores all sub-arrays in the map.
fun maxSumInSubArray2(array: Array<Int>): Map<List<Int>, Int> {
    val mapSumArray = mutableMapOf<List<Int>, Int>()
    for (i in array.indices) {
        var sum = 0
        for (j in i until array.size) {
            sum += array[j]
            val subArray = array.slice(i..j) //return elements in btwn

            mapSumArray[subArray] = sum
        }

    }

    val maxSum = mapSumArray.values.maxOrNull()
    return mapSumArray.filter { it.value == maxSum }
}


//v3; time comp = 0(n^2) spaceComp = 0(1)
fun maxSumInSubArray3(array: Array<Int>): Int {

    var maxSum = Int.MIN_VALUE
    var start = 0 //just to get the sub array with max sum
    var end = 0

    for (i in array.indices) {
        var currentSum = 0
        for (j in i until array.size) {
            currentSum += array[j]
            if (currentSum > maxSum) {
                maxSum = currentSum
                start = i // Update start index of maxSum sub-array
                end = j // Update end index of maxSum sub-array
            }
        }

    }

    // Print or return the maxSum and corresponding sub-array indices
    println("Max Sub-array: ${array.sliceArray(start..end).contentToString()}")

    return maxSum

}

