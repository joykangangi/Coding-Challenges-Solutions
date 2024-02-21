import java.util.PriorityQueue

/**
 * Queue Interface -> FIFO (Queue)
 * Deque Interface -> LIFO & FIFO (Queue & Stack) e.g ArrayDeque, LinkedList
 */

fun main() {
    //Array Deque (Kotlin-Stack)
    val stack = ArrayDeque<Int>()

    //add elements-LIFO
    stack.addFirst(10)
    stack.addFirst(20)
    stack.addFirst(30)

    //accessing the top element
    println("The top element = ${stack.first()}")

    //poppingElements
    stack.removeFirst()

    println("Is stack empty = ${stack.isEmpty()}")

    println(stack)

    //Array Deque (Kotlin-Queue)
    val queue = ArrayDeque<Int>()

    //addElements to queue
    queue.addLast(50)
    queue.addLast(60)
    queue.addLast(70)

    //access top element
    println("The top element is ${queue.first()}")

    //popping
    queue.removeFirst()

    println(queue)

    val stack2 = mutableListOf<Int>()
    stack2.add(1)
    stack2.add(2)
    stack2.add(3)

    val topElement = stack2.removeAt(stack2.size - 1) // Pop element from the stack
    println(topElement) //Output: 3

    val queue2 = mutableListOf<String>()

    queue2.add("A")
    queue2.add("B")
    queue2.add("C")

    val frontElement = queue2.removeAt(0)
    println(frontElement) //Output: A

    //PQ
    // Create a PriorityQueue of tasks with custom priority ordering
    val taskQueue = PriorityQueue<Task> { task1, task2 ->
        /**
         *  By subtracting task2.priority from task1.priority,
         *  the lambda expression determines the ordering based on
         *  the difference in priorities. If the result is negative,
         *  result == -ve; task1 higher priority
         *  result == +ve; task2 higher priority
         *  result == 0; equal priority
         */
        task1.priority - task2.priority
    }


    // Add tasks to the priority queue
    taskQueue.offer(Task(name = "Task with priority 2", priority = 2))
    taskQueue.offer(Task(name = "Task with priority 3", priority = 3))
    taskQueue.offer(Task(name = "Task with priority 1", priority = 1))


    // Process tasks based on priority
    //The poll() method retrieves and removes the highest-priority element from the priority queue

    while (taskQueue.isNotEmpty()) {
        val task = taskQueue.poll()
        println("The removed task is: ${task?.name}")
    }
    println("Final: Is taskEmpty =${taskQueue.isEmpty()}")

}


/** Priority Queue
 *A PriorityQueue class in Kotlin is a special type of queue where elements
 * are ordered based on their priority.
 * It ensures that the element with the highest priority is
 * always at the front of the queue and will be the first one to be removed.
 * In this way, PriorityQueue helps to efficiently manage elements with different levels of importance or urgency.
 */

data class Task(val name: String, val priority: Int)

