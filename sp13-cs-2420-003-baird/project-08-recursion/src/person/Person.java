// Person class
// CS1410, CS2420
// @Override equals(), hashCode(), toString()
// implements Comparable

package person;

public class Person implements Comparable< Person >
{
	private Integer age;
	// fields, variables, data members
	private String name;

	// constructor
	public Person( )
	{
	}

	public Person( String n, Integer a )
	{
		this.name = n;
		this.age = a;
	}// end Person()

	@Override
	public int compareTo( Person p )
	{
		return this.age.compareTo( p.age );
	}

	@Override
	public boolean equals( Object o )
	{
		Person p = (Person) o;
		return this.name.equals( p.name ) && ( this.age == p.age );
	}// end equals()

	public Integer getAge( )
	{
		return this.age;
	}// end getAge()

	// accessor methods
	public String getName( )
	{
		return this.name;
	}// end getName()

	@Override
	public int hashCode( )
	{
		return this.name.hashCode( ) + ( this.age.hashCode( ) * 227 );
	}

	public void setAge( Integer a )
	{
		this.age = a;
	}// end setAge()

	// mutator methods
	public void setName( String n )
	{
		this.name = n;
	}// end sestName()

	@Override
	public String toString( )
	{
		return this.getName( ) + ", " + this.getAge( );
	}// end toString()

}// end class Person
