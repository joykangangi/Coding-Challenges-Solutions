fun main() {
    val mArray = intArrayOf(1,7,8,4,5,2,5,4,3)
    val result = getSmallest(mArray,4)
    println(result.contentToString())
    val result1 = getLargest(mArray, 4)
    println(result1.contentToString())
    val array = intArrayOf(1, 2, 5, 0, 3, 0, 4, 6)
    val res = pushZeros(array)
    println(res.contentToString())

}

//BubbleSort -> After each iteration, push the largest element to the end of the array
// hence the array will be sorted from smallest to largest
// time complexity -> 0(n2) Space complexity ->0(n) no. of iterations = n*(n-1)/2
fun getSmallest(array: IntArray, n: Int): IntArray {
    val size = array.size
    var temp: Int

    for (i in 0 until size) {
        for (j in 1 until size - i) {
            if (array[j-1] > array[j]) {
                temp = array[j-1]
                array[j-1] = array[j]
                array[j] = temp
            }
        }
    }

    return array.copyOf(n)
}


//still a BubbleSort but now pushing the smallest number to the end of the array
fun getLargest(array: IntArray, n: Int): IntArray {
    val size = array.size
    var temp: Int

    for (i in 0 until size) {
        for (j in 1 until size-i) {
            if (array[j-1] < array[j]) {
                temp = array[j-1]
                array[j-1] = array[j]
                array[j] = temp
            }
        }
    }

    return array.copyOf(n)
}

fun pushZeros(array: IntArray): IntArray {
    val size = array.size
    var temp: Int

    for (i in 0 until size - 1) {
        for (j in 1 until size -i) {
            if (array[j-1] == 0) {
                temp = array[j-1]
                array[j-1] = array[j]
                array[j] = temp
            }
        }
    }
    return array
}
