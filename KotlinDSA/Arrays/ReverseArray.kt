fun main() {

    val arr1 = arrayOf(1,2,3,4,5)
    val arr2 = arrayOf(0,1,2,3)
    val arr3 = arrayOf(5)

    println(reverseArray(arr1).contentToString()) //54321
    println(reverseArray(arr2).contentToString()) //3210
    println(reverseArray(arr3).contentToString()) //5
}

//The key is to use Mid-point and temp; Time->O(n); Space ->O(1)
fun reverseArray(array: Array<Int>): Array<Int> {
    val midPoint = array.size / 2 - 1 //for correct mid-point calculation esp array with odd size
    if (midPoint < 0) return array
    var lastIndex = array.size - 1


    for (i in 0..midPoint) {
        val temp = array[i]
        array[i] = array[lastIndex]
        array[lastIndex] = temp
        lastIndex--
    }
    return array
}
