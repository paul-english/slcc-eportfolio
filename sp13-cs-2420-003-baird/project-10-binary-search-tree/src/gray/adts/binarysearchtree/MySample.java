package gray.adts.binarysearchtree;

public class MySample {

  public static void main( String[] args ) {
    AVLTree tree = new AVLTree();

    // Test LL
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 27 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 17 ) );
    tree.add( new Integer( 12 ) );
    System.out.println( "\nTree information: LL case 1" );
    java.util.Iterator iter = tree.iterator();
    while ( iter.hasNext() ) {
      System.out.println( ( AVLNode ) iter.next() );
    }

    // Test LL
    tree = new AVLTree();
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 27 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 5 ) );

    System.out.println( "\nTree information: LL case 2" );
    iter = tree.iterator();
    while ( iter.hasNext() ) {
      System.out.println( ( AVLNode ) iter.next() );
    }

    // Test LR
    tree = new AVLTree();
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 27 ) );
    tree.add( new Integer( 10 ) );
    tree.add( new Integer( 12 ) );

    System.out.println( "\nTree information: LR case 1" );
    iter = tree.iterator();
    while ( iter.hasNext() ) {
      System.out.println( ( AVLNode ) iter.next() );
    }

    // Test LR
    tree = new AVLTree();
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
    iter = tree.iterator();
    while ( iter.hasNext() ) {
      System.out.println( ( AVLNode ) iter.next() );
    }

    // Test RL
    tree = new AVLTree();
    tree.add( new Integer( 15 ) );
    tree.add( new Integer( 7 ) );
    tree.add( new Integer( 20 ) );
    tree.add( new Integer( 25 ) );
    tree.add( new Integer( 23 ) );
    System.out.println( "\nTree information: RL case 1" );
    iter = tree.iterator();
    while ( iter.hasNext() ) {
      System.out.println( ( AVLNode ) iter.next() );
    }

    // Test RL
    tree = new AVLTree();
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
    iter = tree.iterator();
    while ( iter.hasNext() ) {
      System.out.println( ( AVLNode ) iter.next() );
    }

  }
}
