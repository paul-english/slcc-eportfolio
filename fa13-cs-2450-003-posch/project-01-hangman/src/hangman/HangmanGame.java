package hangman;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame
{

	private final String[] bodyParts =
	{ "0", "/", "|", "\\", "/", "\\" };
	private final Set<String> guesses = new HashSet<>();
	private final Scanner input = new Scanner(System.in);

	private String word = "morphologies";

	public HangmanGame()
	{
		this.word = this
				.getWord("http://api.wordnik.com/v4/words.json/randomWord"
						+ "?hasDictionaryDef=false"
						+ "&minCorpusCount=0"
						+ "&maxCorpusCount=-1"
						+ "&minDictionaryCount=1"
						+ "&maxDictionaryCount=-1"
						+ "&minLength=5"
						+ "&maxLength=-1"
						+ "&api_key=ae05411c4c5701894e00d05d8ac02a55d2c37710ea85d5fe7");
	}

	private String[] getBodyParts(String word, Set<String> guesses)
	{
		int lives = this.getLives(word, guesses);
		ArrayList<String> hangingParts = new ArrayList<>();
		for (int i = 0; i < (6 - lives); i++)
		{
			hangingParts.add(this.bodyParts[i]);
		}
		for (int i = hangingParts.size(); i < 6; i++)
		{
			hangingParts.add(" ");
		}
		String[] out = new String[hangingParts.size()];
		return hangingParts.toArray(out);
	}

	private int getLives(String word, Set<String> guesses)
	{
		int lives = 6;
		for (String guess : guesses)
		{
			if (!word.contains(guess))
			{
				lives--;
			}
			if (lives == 0)
			{
				break;
			}
		}
		return lives;
	}

	private String getWord(String urlString)
	{
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try
		{
			url = new URL(urlString);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null)
			{
				result += line;
			}
			rd.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// JSON hack!
		return result.split("\"")[5];
	}

	private String obfuscateWord(String word, Set<String> guesses)
	{
		String out = "";
		for (int i = 0; i < word.length(); i++)
		{
			String character = word.substring(i, i + 1);
			if (guesses.contains(character))
			{
				out += character;
			}
			else
			{
				out += "_";
			}
		}
		return out.replace("", " ").trim();
	}

	private void printState()
	{
		String[] bodyParts = this.getBodyParts(this.word, this.guesses);
		String hiddenWord = this.obfuscateWord(this.word, this.guesses);

		System.out.print("\n\n");
		System.out.println(String.format(" ;--,     Lives left: %d",
				this.getLives(this.word, this.guesses)));
		System.out.println(String.format(" |  %s", bodyParts[0]));
		System.out.println(String.format(" | %s%s%s", bodyParts[1],
				bodyParts[2], bodyParts[3]));
		System.out.println(String.format(" | %s %s    %s", bodyParts[4],
				bodyParts[5], hiddenWord));
		System.out.println(String.format("_|______"));
		System.out.print("\n");
	}

	public void start()
	{
		System.out.println("Welcome to hang man!");

		while (true)
		{
			this.step();
		}
	}

	private void step()
	{
		if (this.getLives(this.word, this.guesses) == 0)
		{
			System.out.printf("You've lost! The word was: %s", this.word);
			System.exit(0);
		}
		else if (this.weHaveWon(this.word, this.guesses))
		{
			System.out.printf(
					"Congratulations, you won! The full word was: %s",
					this.word);
			System.exit(0);
		}
		else
		{
			this.printState();
			System.out.print("Guess a letter: ");
			String letter = this.input.next();
			this.guesses.add(letter);
		}
	}

	private boolean weHaveWon(String word, Set<String> guesses)
	{
		return !this.obfuscateWord(word, guesses).contains("_");
	}
}
