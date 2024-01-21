fun main() {
    //val arr1 = intArrayOf(7,6,5,4,2)
    val arr1 = intArrayOf(1,2,3,4,5)
    println(rotateArrayLeftB(array = arr1, k = 2).contentToString())
    println(rotateArrayRightB(array = arr1, k = 2).contentToString())

}

//the key is to find rotations: > 1. k%size 2. newPos = k ; its modulo to avoid unnecessary rotations e.g. 6mod5 = 1 = 1mod5
fun rotateArrayLeftB(array: IntArray, k: Int): IntArray {
    val size = array.size
    if (size == 0 || k % size == 0) {
        return array
    }

    val rotations = k % size

    val newArray = IntArray(size)
    for (i in 0 until size) {
        val newPosition = (i - rotations + size) % size
        newArray[newPosition] = array[i]
    }
    return newArray
}

//same as rotate left but no need to add +size since there's no -ve; use a newArray to avoid overwriting
fun rotateArrayRightB(array: IntArray, k: Int): IntArray {
    val size = array.size
    if (size == 0 || k % size == 0) return array

    val rotations = k % size

    val newArray = IntArray(size)
    for (i in 0 until size) {
        val newPosition = (i + rotations) % size
        newArray[newPosition] = array[i]
    }
    return newArray
}
