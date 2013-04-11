import gray.adts.binarysearchtree.BSTNode;
import gray.adts.binarysearchtree.Visitor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Project : Binary Search Tree
 * File : WriteVisitor.java
 * Name : Paul English
 * Date : April 11, 2013
 * 
 * Description :
 * 
 * Implement a student list as a binary search tree (BST) with natural ordering
 * defined as last name, first name.
 * 
 * Specification
 * 
 * 1) Each Student record should have the following fields:
 * - studentNumber:Integer
 * - lastname:String
 * - firstName:String
 * - major:String
 * - gpa:Double
 * 2) Run the program from an appropriate menu allowing for the following
 * operations:
 * - Adding a Student record
 * - Deleting a Student record
 * - Listing students by:
 * -- All students
 * -- A given major
 * -- GPA above a certain value
 * -- GPA below a certain value
 * 3) Automatically load the Student records from secondary storage each time
 * the program runs.
 * 4) Automatically save the Student records before the program ends.
 * 5) Use a custom Visitor object to write the Student records.
 */
public class WriteVisitor<E extends Comparable<? super E> & Serializable>
		implements Visitor<E>
{

	private final ObjectOutputStream stream;

	public WriteVisitor(ObjectOutputStream stream)
	{
		this.stream = stream;
	}

	@Override
	public void visit(BSTNode<E> node)
	{
		try
		{
			this.stream.writeObject(node.getElement());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
