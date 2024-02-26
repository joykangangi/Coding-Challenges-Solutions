/**
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list
*/



fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) {
            return null
        }
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            return list1
        }
        list2.next = mergeTwoLists(list2.next, list1)
        return list2
    }
