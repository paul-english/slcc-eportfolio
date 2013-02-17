// Fig. 22.4: EmptyListException.java
// Class EmptyListException declaration.
package orderedlist;

public class EmptyListException extends RuntimeException
{
	// no-argument constructor

	public EmptyListException()
	{
		this("List"); // call other EmptyListException constructor
	} // end EmptyListException no-argument constructor

	// one-argument constructor
	public EmptyListException(String name)
	{
		super(name + " is empty"); // call superclass constructor
	} // end EmptyListException one-argument constructor
} // end class EmptyListException
/**
 * ************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ************************************************************************
 */
