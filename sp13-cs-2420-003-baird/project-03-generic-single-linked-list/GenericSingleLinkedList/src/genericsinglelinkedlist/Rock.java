/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsinglelinkedlist;

/**
 *
 * @author nrub
 */
public class Rock
{

	private String classification;

	/**
	 *
	 * @param classification
	 */
	public Rock(String classification)
	{
		this.classification = classification;
	}

	@Override
	public String toString()
	{
		return "Rock (" + this.classification + ")";
	}
}
