/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureconversionmodification;

/**
 *
 * @author nrub
 */
public class Temperature
{

	private double fahrenheit = 0;

	public Temperature()
	{
	}

	public void setCelsius(double celsius)
	{
		fahrenheit = celsius * (9.0 / 5.0) + 32.0;
	}

	public double getCelsius()
	{
		return (5.0 / 9.0) * (fahrenheit - 32.0);
	}

	public void setKelvin(double kelvin)
	{
		setCelsius(kelvin - 273.15);
	}

	public double getKelvin()
	{
		return getCelsius() + 273.15;
	}

	public void setFahrenheit(double fahrenheit)
	{
		this.fahrenheit = fahrenheit;
	}

	public double getFahrenheit()
	{
		return fahrenheit;
	}
}
