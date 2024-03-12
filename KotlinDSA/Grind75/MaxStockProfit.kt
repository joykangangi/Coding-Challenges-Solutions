/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

fun main() {
    val myPrices = intArrayOf(7,1,5,3,6,4)
    val result1 = maxProfit(myPrices)
    println("The result is: $result1")

    val myPrices2 = intArrayOf(7,6,4,3,1)
    val result2 = maxProfit(myPrices2)
    println("The result is: $result2")

}

//Space Complexity = 0(1); Time Complexity = 0(n)
fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty() || prices.size == 1) return 0


    var leastPrice: Int = prices[0]
    var maxProfit = 0


    for (i in 1 until prices.size) {
        val currentPrice = prices[i]
        if (currentPrice < leastPrice) {
            leastPrice = currentPrice
        }
        val profit = currentPrice - leastPrice
        if (profit > maxProfit) {
            maxProfit = profit
        }
    }

    return maxProfit
}
