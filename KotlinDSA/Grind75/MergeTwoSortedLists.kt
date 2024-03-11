/**
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list
*/


fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 != null && list2 != null) {
        if (list1.data < list2.data) {
            list1.next = mergeTwoLists2(list1.next,list2)
            return list1
        } else {
            list2.next = mergeTwoLists2(list1, list2.next)
            return list2
        }
    }

    if (list1 != null) {
        return list1
    }
    return list2

}

class ListNode(var data: Int) {
    var next: ListNode? = null
}

/** MERGE SORTED ARRAY
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1. To accommodate this,
 * nums1 has a length of m + n, where the first m elements denote the elements
 * that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n
 */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    if (m == 0) {
        return nums2.sort()
    }
    if (n == 0) {
        return nums1.sort()
    }

    var index = m
    nums2.forEach{
        nums1[index++] = it
    }
    nums1.sort()
}
