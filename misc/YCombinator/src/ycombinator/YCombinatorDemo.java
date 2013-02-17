/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ycombinator;

/**
 * Demonstrates the principles of the Y-Combinator in java.
 *
 * http://bologma.blogspot.com/2009/07/understanding-y-combinator-using-java.html
 */
public class YCombinatorDemo
{

	/**
	 * Let's start with a simple function implemented recursively: factorial
	 */
	static int factorial(int n)
	{
		return n == 0 ? 1 : n * factorial(n - 1);
	}

	/**
	 * conceptually, factorial implements an interface that takes an integer
	 * and returns an integer
	 */
	interface IntFunc
	{

		int apply(int n);
	}

	/**
	 * Here it is again in terms of a class implementing this interface:
	 */
	static class SimpleFactorial implements IntFunc
	{

		public int apply(int n)
		{
			return n == 0 ? 1 : n * apply(n - 1);
		}
	}

	/**
	 * Suppose java didn't support recursive calls. How can we accomplish
	 * the same thing? Let's start by abstracting away the recursive call by
	 * delegating to some other function.
	 *
	 * This won't work unless we find a way to get that function to call
	 * back into us...
	 */
	static class DelegatingFactorial implements IntFunc
	{

		private final IntFunc f;

		public DelegatingFactorial(IntFunc f)
		{
			this.f = f;
		}

		public int apply(int n)
		{
			// we can't call apply directly, so delegate
			return n == 0 ? 1 : n * f.apply(n - 1);
		}
	}

	/**
	 * Let's start by defining something that can generate a function in
	 * terms of some other.
	 */
	interface IntFuncToIntFunc
	{

		IntFunc apply(IntFunc f);
	}

	/**
	 * And then implement it for factorial. This will generate a function
	 * that delegates to the passed in argument.
	 *
	 * But we still need to pass in the right argument to make the
	 * "recursion" work...
	 */
	static class FactGen implements IntFuncToIntFunc
	{

		public IntFunc apply(IntFunc f)
		{
			return new DelegatingFactorial(f);
		}
	}

	/**
	 * That's where the Y-combinator comes in. It finds the fixed point of
	 * any {@link IntFuncToIntFunc}. That is, it finds the function for
	 * which calling {@link IntFuncToIntFunc} one more time will yield the
	 * same function.
	 *
	 * This is all just a fancy way of saying that it contains the plumbing
	 * to make sure the original function that needs to get calls back into
	 * itself will get them.
	 *
	 * This implements recursion for any {@link IntFuncToIntFunc} that
	 * generates a function that calls back to the passed in function.
	 */
	static class YCombinator implements IntFunc
	{

		private final IntFuncToIntFunc mIntFuncToIntFunc;

		public YCombinator(IntFuncToIntFunc intFuncToIntFunc)
		{
			mIntFuncToIntFunc = intFuncToIntFunc;
		}

		/**
		 * The fixed point works by kicking of the first call to
		 * generate the int function. We pass in ourselves as the
		 * argument so it will call back to our {@link #apply(int)} as
		 * necessary.
		 */
		public IntFunc fixedPoint()
		{
			return mIntFuncToIntFunc.apply(this);
		}

		/**
		 * If the function calls back into us, we generate another
		 * function that calls back into us again. This will keep
		 * happening until it knows the answer itself (its base case).
		 */
		public int apply(int n)
		{
			// setup another function with ourselves as
			// the callback again
			final IntFunc func = mIntFuncToIntFunc.apply(this);

			// then just apply it
			return func.apply(n);
		}
	}

	public static void main(String args[])
	{
		final IntFuncToIntFunc factGen = new FactGen();

		// if we apply the ycombinator to factgen, we have
		// a working implementation of factorial
		final IntFunc factorial = new YCombinator(factGen).fixedPoint();

		System.out.println(factorial.apply(3));
	}
}