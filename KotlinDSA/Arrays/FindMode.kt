/**
 * Given an array arr of size N and an element k.
 * The task is to find the count of elements in the array that appear more than n/k times.
 */ // mode


fun countAppearance(array: Array<Int>, n: Int, k: Int): IntArray {
    val targetCount = n / k
    val countingMap = mutableMapOf<Int, Int>()
    for (i in array){
        countingMap[i] = countingMap.getOrDefault(i,0) + 1

    }

    val mode = countingMap.filter { it.value > targetCount }
    return mode.keys.toIntArray()
}

fun main(){
    val arr = arrayOf(3,1,2,2,1,2,3,3) //ans 3,2
    println(countAppearance(arr, n = 8, k =4 ).contentToString())
}
