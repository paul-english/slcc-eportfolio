package gray.adts.priorityqueue;

/**
 * A priority queue observes the protocol that the highest priority element in the queue is
 * the first element out (HPIFO). This interface assumes that the <code>Object</code> being
 * inserted has its priorty embedded within it and that the implementor will provide a
 * <code>Comparator</code> for comparing the elements to determine which element in the
 * priority queue has the highest priority.
 */

public interface PriorityQueue<E> {

    /**
     * Enque this element into this priority queue.
     * @pre:  the element must be comparable to the other elements in
     *        the priority queue.
     * @post:	element is placed in the priority queue
     * @post:  size is incremented by 1
     */
    public void enqueue( E element );

    /**
     * Remove and return the element with the highest priority as determined
     * by this priority queue's comparator.
     * @pre the priority queue is not empty
     * @post the previously highest priority element has been removed from the
     *       priority queue
     * @post size is decremented by 1
     * @throws an <code>EmptyPriorityQueueException</code> if this priority queue is empty
     */
    public E dequeue();

    /**
     * Removes all of the elements from this priority queue.
     * @post size is 0
     */
    public void clear();

    /**
     * Looks at the element in this priority queue that has the highest priority
     * without removing it from the priority queue.
     * @pre The priority queue is not empty.
     * @return The top element of the priority queue.
     * @throws <code>EmptyPriorityQueueException</code> if the priority queue is empty.
     */
    public E peek();

    /**
     * Return the number of elements stored in this priority queueeap.
     * @return The number of elements in this priority queue.
     */
    public int size();

    /**
     * Determine if this priority queue is empty.
     * @return true if this priority queue is empty (<code>size() == 0</code>), otherwise
     *         return false.
     */
    public boolean isEmpty();
}
