package telephonenumberwordgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nrub
 */
public final class PhoneNumber
{

	private String phone_number;
	private HashMap<Integer, String[]> telephoneCharacters = new HashMap<Integer, String[]>()
	{

		{
			put(new Integer(2), new String[]
				{
					"A", "B", "C"
				});
			put(new Integer(3), new String[]
				{
					"D", "E", "F"
				});
			put(new Integer(4), new String[]
				{
					"G", "H", "I"
				});
			put(new Integer(5), new String[]
				{
					"J", "K", "L"
				});
			put(new Integer(6), new String[]
				{
					"M", "N", "O"
				});
			put(new Integer(7), new String[]
				{
					"P", "R", "S"
				});
			put(new Integer(8), new String[]
				{
					"T", "U", "V"
				});
			put(new Integer(9), new String[]
				{
					"W", "X", "Y"
				});
		}
	};

	/**
	 *
	 */
	public PhoneNumber()
	{
	}

	/**
	 *
	 * @param number
	 */
	public PhoneNumber(String number) throws IllegalArgumentException
	{
		setNumber(number);
	}

	/**
	 *
	 * @param number
	 */
	public void setNumber(String number) throws IllegalArgumentException
	{
		// remove ".()- "
		phone_number = number.replace(".", "")
			.replace("(", "")
			.replace(")", "")
			.replace("-", "")
			.replace(" ", "");

		// normalize to 7 digits (remove area code, country code)
		if (phone_number.length() > 7)
		{
			phone_number = phone_number.substring(phone_number.length() - 7);
		}

		// require at least a 7 digit number
		if (phone_number.length() != 7)
		{
			phone_number = null;
			throw new IllegalArgumentException("Your phone number must contain at least 7 digits.");
		}

		// if phone number contains 0 or 1 throw error
		if (phone_number.contains("0") || phone_number.contains("1"))
		{
			phone_number = null;
			throw new IllegalArgumentException("We cannot work with phone numbers that contain 0 or 1");
		}

		if (!phone_number.matches("^[0-9]+$"))
		{
			phone_number = null;
			throw new IllegalArgumentException("Number contains invalid characters");
		}
	}

	/**
	 *
	 * @return
	 */
	public String getNumber()
	{
		return phone_number;
	}

	/**
	 *
	 * @return
	 */
	public String[] getWords()
	{
		return getWords(new ArrayList<String>(), phone_number);
	}

	// Does Java support tail call optimization?
	// Does this fit the bill for tail-call optimizable?
	/**
	 *
	 * @param words
	 * @param num
	 * @return
	 */
	private String[] getWords(ArrayList<String> words, String num)
	{
		if (num.length() == 0)
		{

			// In the base case we just return our calculated words array
			return words.toArray(new String[words.size()]);

		}
		else
		{

			ArrayList<String> newWords = new ArrayList<>();
			char currentNumber = num.charAt(0);
			Integer number = new Integer(Character.getNumericValue(currentNumber));
			String[] map = telephoneCharacters.get(number);

			// for each letter in our map we will clone the set of words and add our letter at the end
			for (int i = 0; i < map.length; i++)
			{
				if (words.isEmpty())
				{
					newWords.add(map[i]);
				}
				else
				{
					// append our current letter to each word and store it.
					for (int j = 0; j < words.size(); j += 1)
					{
						// add letter to the end of the current word
						newWords.add(words.get(j) + map[i]);
					}
				}
			}

			// Tail call optimized
			return getWords(newWords, num.substring(1));
		}
	}
}
