/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureconversionmodification;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author nrub
 */
public class AppFrame extends JFrame
{

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private Temperature temp = new Temperature();

	public AppFrame()
	{
		super("Temperature Converter");
		setLayout(new GridLayout(3, 2, 5, 5));

		label1 = new JLabel("Fahrenheit");
		add(label1);

		field1 = new JTextField(5);
		field1.setHorizontalAlignment(SwingConstants.RIGHT);
		field1.setText(String.format("%.2f", temp.getFahrenheit()));
		field1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				temp.setFahrenheit(Double.valueOf(field1.getText()));
				field2.setText(String.format("%.2f", temp.getCelsius()));
				field3.setText(String.format("%.2f", temp.getKelvin()));
			}
		});
		add(field1);

		label2 = new JLabel("Celsius");
		add(label2);

		field2 = new JTextField(5);
		field2.setHorizontalAlignment(SwingConstants.RIGHT);
		field2.setText(String.format("%.2f", temp.getCelsius()));
		field2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				temp.setCelsius(Double.valueOf(field2.getText()));
				field1.setText(String.format("%.2f", temp.getFahrenheit()));
				field3.setText(String.format("%.2f", temp.getKelvin()));
			}
		});
		add(field2);

		label3 = new JLabel("Kelvin");
		add(label3);

		field3 = new JTextField(5);
		field3.setHorizontalAlignment(SwingConstants.RIGHT);
		field3.setText(String.format("%.2f", temp.getKelvin()));
		field3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				temp.setKelvin(Double.valueOf(field3.getText()));
				field1.setText(String.format("%.2f", temp.getFahrenheit()));
				field2.setText(String.format("%.2f", temp.getCelsius()));
			}
		});
		add(field3);

	}
}
