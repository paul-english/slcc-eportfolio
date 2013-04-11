package gray.adts.binarysearchtree;

/**
 * The exception that is thrown whenever an operation on a
 * Binary Search Tree is in violation of a method precondition.
 */
public class SearchTreeException extends RuntimeException {

  public SearchTreeException() {
    super();
  }

  public SearchTreeException( String errMsg ) {
    super( " " + errMsg );
  }
}
