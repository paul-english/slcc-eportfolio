/**
 * Thrown when an empty heap has been accessed.
 */

public class EmptyHeapException extends RuntimeException {

  public EmptyHeapException() {
    super();
  }

  public EmptyHeapException( String errMsg ) {
    super( " " + errMsg );
  }
}
