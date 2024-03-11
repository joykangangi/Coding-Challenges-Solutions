
fun main() {

    var head: ListNode2<Int>? = null
    head = addListNode(1, head)
    head = addListNode(4, head)
    head = addListNode(8, head).also {
        printAllNodes(it)
    }
}

class ListNode2<T>(var data: T) {
    var next: ListNode2<T>? = null
    override fun toString(): String {
        return "$data"
    }
}


/**
 * adds at the end of linkedList
 *
 * the [data] of the node you want to add, [afterNode] is the node AFTER to insert the new data
 * If [afterNode] is null, it means you want to insert the new node at the beginning of the list.
 * 1 ->2 ->3
 * 1 ->2 ->X->3
 */

fun <T> addListNode(data: T, afterNode: ListNode2<T>?): ListNode2<T> {
    val newNode: ListNode2<T> = ListNode2(data)

    // If the list is empty, the new node becomes the head
    if (afterNode == null){
        return newNode
    }

    var current: ListNode2<T> = afterNode // This variable is used to traverse the list and find the last node.

    while (current.next != null){
        // traverses the list by moving current to the next node until it reaches the last node
        current = current.next!!
    }

    current.next = newNode
    return afterNode

//    newNode.next = afterNode?.next //insert in between, not at the end
//    afterNode?.next = newNode
}

fun <T> printAllNodes(head: ListNode2<T>) {
    var current: ListNode2<T>? = head
    while (current != null) {
        println("Current ${current.data}, Next ${current.next}")
        current = current.next
    }
    println()
}
