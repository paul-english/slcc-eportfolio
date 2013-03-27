/**
 * <p>The interface for the Heap ADT.</p>
 * <P>
 * This interface can describe either a minheap or a maxheap.
 * <UL>
 * <LI> <B>minheap</B> - the element at the root of a heap is
 * less than or equal to the elements in its children, which
 * are also the roots of heaps.</LI>
 * <LI><B>maxheap</B> - the element at the root of a heap is
 * greater than or equal to the elements in its children, which
 * are also the roots of heaps.</LI>
 * </UL>
 */
public interface Heap<E> {
  /**
   * Insert the given element into the heap.
   * @param element The element to add to the heap.
   * @throws NullPointerException if <code>element</code>
   * is null
   */
  public void add( E element );

  /**
   * Remove and return the top element of the heap.
   * @return The top element of the heap.
   * @throws EmptyHeapException if the heap is empty.
   */
  public E top();

  /**
   * Removes all of the elements from this heap.
   */
  public void clear();

  /**
   * Return the element at the top of this heap without
   * removing it.
   * @return The top element of the heap.
   * @throws EmptyHeapException if the heap is empty.
   */
  public E peek();

  /**
   * Return the number of elements stored in this heap.
   * @return The number of elements in this heap.
   */
  public int size();

  /**
   * Determine if this heap is empty.
   * @return <code>true</code> if this heap is empty
   * (<code>size() == 0</code>), otherwise return <code>false</code>.
   */
  public boolean isEmpty();
}
