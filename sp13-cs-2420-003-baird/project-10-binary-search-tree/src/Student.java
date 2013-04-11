import java.io.Serializable;

/**
 * Project : Binary Search Tree
 * File : Student.java
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
public class Student implements Comparable<Student>, Serializable
{

	private static final long serialVersionUID = 1L;
	public String firstName;
	public double gpa;
	public String lastName;
	public String major;
	public int studentNumber;

	public Student(String firstName, String lastName, String major, double gpa,
			int studentNumber)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMajor(major);
		this.setGpa(gpa);
		this.setStudentNumber(studentNumber);
	}

	@Override
	public int compareTo(Student o)
	{
		if (this.getLastName().compareTo(o.getLastName()) == 0)
		{
			return this.getFirstName().compareTo(o.getFirstName());
		}
		else
		{
			return this.getLastName().compareTo(o.getLastName());
		}
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public double getGpa()
	{
		return this.gpa;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public String getMajor()
	{
		return this.major;
	}

	public int getStudentNumber()
	{
		return this.studentNumber;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public void setStudentNumber(int studentNumber)
	{
		this.studentNumber = studentNumber;
	}

	@Override
	public String toString()
	{
		return this.getLastName() + ", " + this.getFirstName() + "; number:"
				+ this.getStudentNumber() + "; gpa:" + this.getGpa()
				+ "; major:" + this.getMajor();

	}
}
