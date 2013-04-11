package gray.adts.binarysearchtree;

public class MyBSTSample {

  public static void main( String[] args ) {
    BinarySearchTree<Integer> tree = new LinkedBST<Integer> ();

    // Test LL
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 27 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 17 ) );
    tree.add( new Integer( 12 ) );
    System.out.println( "\nTree information: LL case 1" );

    for ( Integer i : tree ) {
      System.out.println( i );
    }
    // Test LL
    tree = new LinkedBST<Integer> ();
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 27 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 5 ) );

    System.out.println( "\nTree information: LL case 2" );
    for ( Integer i : tree ) {
      System.out.println( i );
    }

    // Test LR
    tree = new LinkedBST<Integer> ();
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 27 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 12 ) );

    System.out.println( "\nTree information: LR case 1" );
    for ( Integer i : tree ) {
      System.out.println( i );
    }

    // Test LR
    tree = new LinkedBST<Integer> ();
    tree.add( new Integer( 12 ) );
    tree.add( new Integer( 8 ) );
    tree.add( new Integer( 16 ) );
    tree.add( new Integer( 4 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 14 ) );
    tree.add( new Integer( 2 ) );
    tree.add( new Integer( 6 ) );
    tree.add( new Integer( 5 ) );
    System.out.println( "\nTree information: LR case 2" );
    for ( Integer i : tree ) {
      System.out.println( i );
    }

    // Test RL
    tree = new LinkedBST<Integer> ();
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 7 ) );
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 25 ) );
    tree.add( new Integer( 23 ) );
    System.out.println( "\nTree information: RL case 1" );
    for ( Integer i : tree ) {
      System.out.println( i );
    }

    // Test RL
    tree = new LinkedBST<Integer> ();
    tree.add( new Integer( 12 ) );
    tree.add( new Integer( 8 ) );
    tree.add( new Integer( 16 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 14 ) );
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 18 ) );
    tree.add( new Integer( 22 ) );
    tree.add( new Integer( 19 ) );
    System.out.println( "\nTree information: RL case 2" );
    for ( Integer i : tree ) {
      System.out.println( i );
    }
  }
}
