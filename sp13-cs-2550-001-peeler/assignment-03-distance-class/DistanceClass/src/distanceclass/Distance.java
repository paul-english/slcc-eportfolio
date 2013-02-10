package distanceclass;

/**
 * Distance class with feet and inches
 *
 * @author nrub
 */
public class Distance implements Comparable<Distance>
{

	private int feet;
	private int inches;
	private final int DEFAULT_FT = 1;
	private final int DEFAULT_IN = 1;

	/**
	 * A custom exception for out of range validation errors.
	 */
	public static class OutOfRangeException extends Exception
	{

		public OutOfRangeException(String msg)
		{
			super(msg);
		}
	}

	/**
	 * A custom exception thrown when invalid inches values are used.
	 */
	public static class InchesOutOfRangeException extends OutOfRangeException
	{

		public InchesOutOfRangeException(String msg)
		{
			super(msg);
		}
	}

	/**
	 * A custom exception thrown when invalid feet values are used.
	 */
	public static class FeetOutOfRangeException extends OutOfRangeException
	{

		public FeetOutOfRangeException(String msg)
		{
			super(msg);
		}
	}

	//constructors
	/**
	 * Constructs a distance using default values for feet and inches.
	 */
	public Distance()
	{
		feet = DEFAULT_FT;
		inches = DEFAULT_IN;
	}

	/**
	 * Constructs a distance using passed in feet & inches.
	 *
	 * @param ft
	 * @param in
	 * @throws unittesting.Distance.OutOfRangeException
	 */
	public Distance(int ft, int in) throws OutOfRangeException
	{
		setFeet(ft);
		setInches(in);
	}

	//get methods
	/**
	 * Returns the feet value of this distance.
	 *
	 * @return
	 */
	public int getFeet()
	{
		return feet;
	}

	/**
	 * Returns the inches of this distance.
	 *
	 * @return
	 */
	public int getInches()
	{
		return inches;
	}

	//set methods - validate + whole integers only
	/**
	 * Sets the feet value of a distance.
	 *
	 * @throws FeetOutOfRangeException
	 */
	public void setFeet(int ft) throws FeetOutOfRangeException
	{
		if (ft < 0)
		{
			throw new FeetOutOfRangeException("Inches must be a positive whole number.");
		}

		feet = ft;
	}

	/**
	 * Sets the inches value of a distance.
	 *
	 * @throws InchesOutOfRangeError
	 */
	public void setInches(int in) throws InchesOutOfRangeException
	{
		if (in < 0)
		{
			throw new InchesOutOfRangeException("Inches must be a positive whole number.");
		}

		inches = in;
	}

	//method to add two distance objects
	/**
	 * Add two distances together.
	 *
	 * @param a
	 * @param b
	 * @return
	 * @throws unittesting.Distance.OutOfRangeException
	 */
	public static Distance add(Distance a, Distance b) throws OutOfRangeException
	{
		return new Distance(a.getFeet() + b.getFeet(),
				    a.getInches() + b.getInches());
	}

	//method to subtract two distance objects
	/**
	 * Subtract one distance from another.
	 *
	 * @param a
	 * @param b
	 * @return
	 * @throws unittesting.Distance.OutOfRangeException
	 */
	public static Distance subtract(Distance a, Distance b) throws OutOfRangeException
	{
		return new Distance(a.getFeet() - b.getFeet(),
				    a.getInches() - b.getInches());
	}

	//equals() - compares two distance objects for equality
	/**
	 * Will return true if the obj argument is equal to the current object.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Distance other = (Distance) obj;
		if (this.feet != other.feet)
		{
			return false;
		}
		if (this.inches != other.inches)
		{
			return false;
		}
		return true;
	}

	//hashCode() - same hash code for equal objects
	/**
	 * Provides a hashCode for the current object.
	 *
	 * @return
	 */
	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 79 * hash + this.feet;
		hash = 79 * hash + this.inches;
		return hash;
	}

	/**
	 * Converts the internal feet value to inches.
	 *
	 * @return Total feet in inches.
	 */
	private int feetToInches()
	{
		return feet * 12;
	}

	/**
	 * Provides the distance in inches. This makes it easier to compare
	 * values.
	 *
	 * @return Total distance in inches.
	 */
	private int totalInches()
	{
		return feetToInches() + inches;
	}

	//compareTo() - compares two distance objects ( <, >, == )
	/**
	 * Compares the object with another Distance object.
	 *
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Distance o)
	{
		if (feet == o.getFeet() && totalInches() == o.totalInches())
		{
			return 0;
		}
		else if (totalInches() > o.totalInches())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

	@Override
	public String toString()
	{
		return String.format("%d' %d\"", feet, inches);
	}
}