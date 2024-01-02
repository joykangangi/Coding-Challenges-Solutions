package geeks4geeks.arrays.subarray

fun allSubArrays(K: Array<Int>) {

   // val listArr = mutableListOf<Array<Int>>()

    //Pick starting point
    for (i in K.indices) {

        //Pick ending point
        for (j in i until K.size) {

            // Print sub-array between current starting
            // and ending points
            for (k in i..j) {
                print("${K[k]} ")
            }
            println()
        }
    }
}


fun main() {
    val arr = arrayOf(1,2,3,4)
    allSubArrays(arr)
}