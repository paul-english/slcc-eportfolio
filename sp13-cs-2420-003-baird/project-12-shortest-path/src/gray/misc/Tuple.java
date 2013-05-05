package gray.misc;

/**
 * A tuple consists of two elements of the same type. This class
 * illustrates the definition of a generic type with two type
 * parameters <code>T</tt> and <code>E</code>.
 */
public class Tuple<T, E> {
  private T firstElement;
  private E secondElement;

  /**
   * Default constructor.
   */
  public Tuple() {
    this.firstElement = null;
    this.secondElement = null;
  }

  /**
   * Construct an instance of a <code>Tuple</tt> initialized to the
   * given elements.
   * @param e1 the first element of this tuple
   * @param e2 the second element of this tuple
   * @throws NullPointerException if either <code>e1</tt> or
   *   <code>e2</tt> is <code>null</tt>.
   */
  public Tuple( T e1, E e2 ) {
    if ( ( e1 == null ) || ( e2 == null ) ) {
      throw new NullPointerException();
    }
    this.firstElement = e1;
    this.secondElement = e2;
  }

  /**
   * Return the value of the first element of this tuple.
   * @return the first element of this tuple
   */
  public T getFirstElement() {
    return this.firstElement;
  }

  /**
   * Return the value of the second element of this tuple.
   * @return the second element of this tuple
   */
  public E getSecondElement() {
    return this.secondElement;
  }

  /**
   * Set the first element of this tuple to the new value.
   * @param newFirst the new value for the first element of
   *   this tuple
   * @throws NullPointerException if <code>newFirst</tt> is
   *   <code>null</tt>.
   */
  public void setFirstElement( T newFirst ) {
    if ( newFirst == null ) {
      throw new NullPointerException();
    }

    this.firstElement = newFirst;
  }

  /**
   * Set the second element of this tuple to the new value.
   * @param newSecond the new value for the second element of
   *    this tuple
   * @throws NullPointerException if <code>newSecond</tt> is
   *   <code>null</tt>.
   */
  public void setSecondElement( E newSecond ) {
    if ( newSecond == null ) {
      throw new NullPointerException();
    }
    this.secondElement = newSecond;
  }

  /**
   * Returns a string representation of the object: this is
   * the string representation of element 1 followed by the
   * string representation of element 2.
   * @returns a string representation of the object.
   */
  public String toString() {
    return "< " + this.firstElement + ", " +
        this.secondElement + " >";
  }

  public boolean equals( Object o ) {
    Tuple<T, E> tuple = ( Tuple<T, E> ) o;
    return tuple.getFirstElement().equals( firstElement ) &&
        tuple.getSecondElement().equals( secondElement );
  }
}
