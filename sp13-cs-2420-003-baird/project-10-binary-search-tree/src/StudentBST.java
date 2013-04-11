import gray.adts.binarysearchtree.LinkedBST;
import gray.adts.binarysearchtree.Visitor;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Project : Binary Search Tree
 * File : StudentBST.java
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
public class StudentBST
{

	private static LinkedBST<Student> students;

	public StudentBST()
	{
		StudentBST.students = new LinkedBST<>();
	}

	public static StudentBST loadStudentCollection()
	{
		ObjectInputStream input = null;
		StudentBST students = new StudentBST();
		int count = 0;
		try
		{
			input = new ObjectInputStream(new FileInputStream("students.ser"));
			Student student = null;
			while (true)
			{
				student = (Student) input.readObject();
				StudentBST.students.add(student);
				count++;
			}
		}
		catch (EOFException e)
		{
			String plural = (count > 1) ? "s" : "";
			System.out.println("Loaded " + count + " student" + plural);
		}
		catch (FileNotFoundException e)
		{
			System.out
					.println("Students file doesn't exist, we'll save one when you exit");
		}
		catch (IOException e)
		{
			System.out.println("--- ioexception while loading");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (input != null)
				{
					input.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return students;
	}

	public void add(Student student)
	{
		StudentBST.students.add(student);
	}

	private Student findStudentByNumber(int studentNumber)
	{
		for (Student student : StudentBST.students)
		{
			if (student.getStudentNumber() == studentNumber)
			{
				return student;
			}
		}
		return null;
	}

	public void printAllStudents()
	{
		for (Student student : StudentBST.students)
		{
			System.out.println(student);
		}
	}

	public void printStudentsByGPA(double gpa)
	{
		this.printStudentsByGPA(gpa, false);
	}

	public void printStudentsByGPA(double gpa, boolean lessThan)
	{
		for (Student student : StudentBST.students)
		{
			if (lessThan && (student.getGpa() < gpa))
			{
				System.out.println(student);
			}
			else if (!lessThan && (student.getGpa() > gpa))
			{
				System.out.println(student);
			}
		}
	}

	public void printStudentsByMajor(String major)
	{
		for (Student student : StudentBST.students)
		{
			if (student.getMajor().equals(major))
			{
				System.out.println(student);
			}
		}
	}

	public void remove(int studentNumber)
	{
		Student student = this.findStudentByNumber(studentNumber);
		StudentBST.students.remove(student);
	}

	public void saveStudentCollection()
	{
		ObjectOutputStream output = null;
		try
		{
			output = new ObjectOutputStream(
					new FileOutputStream("students.ser"));
			Visitor<Student> visitor = new WriteVisitor<>(output);
			StudentBST.students.postOrderTraversal(visitor);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (output != null)
				{
					output.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
