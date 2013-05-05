package gray.misc;

/**
 * A pair consists of two elements of the same type. This class
 * illustrates the definition of a generic type with type parameter
 * <tt>T</tt>.
 */
public class Pair<T> {
  private T firstElement;
  private T secondElement;

  /**
   * Default constructor.
   */
  public Pair() {
    this.firstElement = null;
    this.secondElement = null;
  }

  /**
   * Construct an instance of a <tt>Pair</tt> initialized to the
   * given elements.
   * @param e1 the first element of this pair
   * @param e2 the second element of this pair
   * @throws NullPointerException if either <tt>e1</tt> or
   *   <tt>e2</tt> is <tt>null</tt>.
   */
  public Pair(T e1, T e2) {
    if ( (e1 == null) || (e2 == null)) {
      throw new NullPointerException();
    }
    this.firstElement = e1;
    this.secondElement = e2;
  }

  /**
   * Return the value of the first element of this pair.
   * @return the first element of this pair
   */
  public T getFirstElement() {
    return this.firstElement;
  }

  /**
   * Return the value of the second element of this pair.
   * @return the second element of this pair
   */
  public T getSecondElement() {
    return this.secondElement;
  }

  /**
   * Set the first element of this pair to the new value.
   * @param newFirst the new value for the first element of
   *   this pair
   * @throws NullPointerException if <tt>newFirst</tt> is
   *   <tt>null</tt>.
   */
  public void setFirstElement(T newFirst) {
    if (newFirst == null) {
      throw new NullPointerException();
    }

    this.firstElement = newFirst;
  }

  /**
   * Set the second element of this pair to the new value.
   * @param newSecond the new value for the second element of
   *    this pair
   * @throws NullPointerException if <tt>newSecond</tt> is
   *   <tt>null</tt>.
   */
  public void setSecondElement(T newSecond) {
    if (newSecond == null) {
      throw new NullPointerException();
    }
    this.secondElement = newSecond;
  }

  /**
   *  Swap the two elements.
   */
  public void swapElements() {
    T temp = this.firstElement;
    this.firstElement = this.secondElement;
    this.secondElement = temp;
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

  /**
   * Determine if either element of this <tt>Pair</tt> is equal
   * to the argument.
   * @param e the object to compare to the elements of this <tt>Pair</tt>
   * @return the first element of this <tt>Pair</tt> found equal
   *   to <tt>e</tt>, <tt>null</tt> if neither element is equal to
   *   <tt>e</tt>.
   */
  public T elementEqualTo(T e) {
    if (e == null) {
      throw new NullPointerException();
    }

    if (this.firstElement.equals(e) || this.secondElement.equals(e)) {
      return e;
    }
    else {
      return null;
    }
  }

}
