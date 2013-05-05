package gray.adts.priorityqueue;

import java.util.Comparator;

/**
 * <p>Title: PriorityQueue</p>
 * <p>Description: An implementation of the Priority Queue ADT using an adapter
 * pattern and a Heap as the backing store.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Ashland University</p>
 * @author Simon Gray
 * @version 1.0
 */

public class HeapPriorityQueue<E> implements PriorityQueue<E> {

    private gray.adts.heap.Heap<E> heap;

    /**
     * Construct an empty priority queue. The ordering of elements in the priority
     * queue is defined by <code>compare</code>.
     * @throws NullPointerException if compare is null.
     */
    public HeapPriorityQueue( Comparator<E> compare ) {
        if ( compare == null )
           throw new NullPointerException();

        heap = new gray.adts.heap.ArrayMinHeap<E>( compare );
    }
    /**
     * Enqueue this element into this priority queue.
     * @pre:  the element must be comparable to the other elements in
     *        the priority queue.
     * @post:	element is placed in the priority queue
     * @post:  size is incremented by 1
    */
    public void enqueue( E element ){
           heap.add( element );
    }

    /**
     * Remove and return the element with the highest priority as determined
     * by this priority queue's comparator.
     * @pre the priority queue is not empty
     * @post the previously highest priority element has been removed from the
     *       priority queue
     * @post size is decremented by 1
     * @throws an EmptyPriorityQueueException if this priority queue is empty
     */
    public E dequeue() {
       return heap.top();
    }

    /**
     * Removes all of the elements from this priority queue.
     * @post size is 0
     */
    public void clear() {
        heap.clear();
    }

    /**
     * Looks at the element in this priority queue that has the highest priority
     * without removing it from the priority queue.
     * @pre The priority queue is not empty.
     * @return The top element of the priority queue.
     * @throws EmptyPriorityQueueException if the priority queue is empty.
     */
    public E peek(){
        return heap.peek();
    }

    /**
     * Return the number of elements stored in this priority queueeap.
     * @return The number of elements in this priority queue.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Determine if this priority queue is empty.
     * @return true if this priority queue is empty (size() == 0), otherwise
     *         return false.
    */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
