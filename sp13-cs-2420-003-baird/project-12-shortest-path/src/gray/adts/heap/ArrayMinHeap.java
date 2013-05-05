package gray.adts.heap;

import java.util.Comparator;
import java.util.Collection;

/**
 * An array implementation of the <code>Heap</code> interface.
 */
public class ArrayMinHeap<E> implements Heap<E> {

  private static final int DEFAULT_HEAP_SIZE = 100;
  private static final int NO_CHILD = -1;
  private static final int TOP = 0;

  private int size;
  // left child is in position 2 * i + 1
  // right child is in position 2 * i + 2
  // parent is in position  (i - 1) / 2
  private E[] heap;
  private Comparator<? super E>comparator;

  /**
   * Construct an empty minheap. The ordering of elements in
   * the minheap is defined by <code>compare</code>.
   * @throws NullPointerException if compare is null.
   */
  public ArrayMinHeap( Comparator<? super E>compare ) {
    if ( compare == null ) {
      throw new NullPointerException();
    }
    size = 0;
    heap = ( E[] )new Object[DEFAULT_HEAP_SIZE];
    comparator = compare;
  }

  /**
   * Construct a minheap with the elements from
   * <code>collection</code> using the ordering defined by
   * <code>compare</code>.
   * @throws NullPointerException if either argument is null.
   */
  public ArrayMinHeap( Collection<? extends E> collection,
                       Comparator<? super E>compare ) {
    if ( ( compare == null ) || ( collection == null ) ) {
      throw new NullPointerException();
    }

    comparator = compare;
    buildHeap( collection );
  }

  /**
   * Insert the given element into the heap.
   * @param element The element to add to the heap.
   * @throws NullPointerException if element is null
   */
  public void add( E element ) {
    if ( element == null ) {
      throw new NullPointerException();
    }

    // insert the new element as the new rightmost leaf
    if ( size == heap.length ) {
      resize();
    }
    heap[size] = element;
    size++;
    int child = size - 1;
    int parent = ( child - 1 ) / 2;

    // while the new element has a parent and the new element
    // is less than its parent
    while ( ( child != TOP ) &&
            ( comparator.compare( heap[child],
                                  heap[parent] ) < 0 ) ) {
      // swap the parent and child elements
      E temp = heap[parent];
      heap[parent] = heap[child];
      heap[child] = temp;
      child = parent;
      parent = ( child - 1 ) / 2;
    }
  }

  /**
   * Remove and return the top element of the heap.
   * @return The top element of the heap.
   * @throws EmptyHeapException if the heap is empty.
   */
  public E top() {
    if ( this.isEmpty() ) {
      throw new EmptyHeapException();
    }

    E oldTop = heap[TOP];
    heap[TOP] = heap[size - 1];
    heap[size - 1] = null;
    size--;
    fixHeap( TOP );
    return oldTop;
  }

  /**
   * Removes all of the elements from this heap.
   * @post size is 0
   */
  public void clear() {
    for ( int i = 0; i < size; i++ ) {
      heap[i] = null;
    }
    size = 0;
  }

  /**
   * Looks at the object at the top of this heap without removing
   * it from the heap.
   * @return The top element of the heap.
   * @throws EmptyHeapException if the heap is empty.
   */
  public E peek() {
    if ( this.isEmpty() ) {
      throw new EmptyHeapException();
    }
    return heap[TOP];
  }

  /**
   * Fix the heap rooted at parent.
   * @pre parent is in the range 0 to size - 1 (NOT VALIDATED)
   * @post the heap rooted at parent is a valid minheap
   */
  private void fixHeap( int parent ) {

    int child = smallestChild( parent );

    // while the parent has a child and the parent's element
    //  is greater than the element in either child
    while ( ( child != NO_CHILD ) &&
            ( comparator.compare( heap[child],
                                  heap[parent] ) < 0 ) ) {
      //invariant: the parent's children are roots of
      //   valid heaps
      //swap the parent's element with the element of the
      //  smaller of its children
      E temp = heap[parent];
      heap[parent] = heap[child];
      heap[child] = temp;
      //invariant: the parent and its children are a
      //    now valid heap
      // move parent to the swapped child
      parent = child;
      child = smallestChild( parent );
    }
    //loop postcondition: the binary tree rooted at node is
    //  a valid heap
  }

  /**
   * Return the number of elements stored in this heap.
   * @return The number of elements in this heap.
   */
  public int size() {
    return this.size;
  }

  /**
   * Determine if this heap is empty.
   * @return true if this heap is empty (size() == 0), otherwise
   *         return false.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  private void resize() {
    E[] tempHeap = ( E[] )new Object[heap.length * 2];
    System.arraycopy( heap, 0, tempHeap, 0, heap.length );
    heap = tempHeap;
  }

  /**
   * Return index of the smaller of parent's two children.
   * If parent is a leaf (and has no children), return the
   * constant NO_CHILD.
   */
  private int smallestChild( int parent ) {

    // see if the parent is actually a leaf
    if ( parent > ( size / 2 ) - 1 ) {
      return NO_CHILD;
    }

    // parent has at least one child
    int leftChild = 2 * parent + 1;
    int rightChild = leftChild + 1;

    // if parent has no right child, return left child
    if ( rightChild >= size ) {
      return leftChild;
    }

    // parent has two children, return the smaller of them
    if ( comparator.compare( heap[leftChild],
                             heap[rightChild] ) < 0 ) {
      return leftChild;
    }
    return rightChild;
  }

  /**
   * Construct a valid minheap from a collection of elements.
   * @pre c is not null  (NOT VALIDATED)
   * @post heap is a valid minheap
   */
  private void buildHeap( Collection<? extends E> c ) {
    // move the elements of c into a complete binary tree
    //  rooted at top
    heap = ( E[] ) c.toArray();
    size = c.size();
    // let cursor be the rightmost interior node
    int cursor = ( size / 2 ) - 1;

    // invariant: the children of cursor are valid heaps
    // while there are heaps to fix
    while ( cursor >= TOP ) {
      fixHeap( cursor ); // fix the heap rooted at cursor
      cursor--; // move cursor to the next
      // rightmost unvisited interior
      // node
    }
  }
}
