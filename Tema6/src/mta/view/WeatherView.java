package mta.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JPanel;

import mta.interfaces.IController;
import mta.interfaces.IModel;
import mta.interfaces.IView;
import mta.model.WeatherModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class WeatherView implements IView,IModel {

	private IController mController;

    private WeatherModel mModel;
	
	public JFrame frame;
	private JTextField txtWeatherInformations;
	private JTextField txtTemperature;
	private JTextField txtWindSpeed;
	private JTextField textField_1_write;
	private JTextField textField_2_write;
	private JButton btnNewButton = new JButton("Show ");
	/**
	 * Launch the application.
	 */
	public WeatherView() {
		initialize();
		
	}
	public void addModel(WeatherModel model) {
        mModel = model;
    }
	public void addController(IController controller) {
        btnNewButton.setActionCommand(IController.ACTION_CALCULATE);
        btnNewButton.addActionListener(controller);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	public  int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtWeatherInformations = new JTextField();
		txtWeatherInformations.setBounds(0, 0, 584, 27);
		txtWeatherInformations.setForeground(Color.BLUE);
		txtWeatherInformations.setEnabled(false);
		txtWeatherInformations.setEditable(false);
		txtWeatherInformations.setHorizontalAlignment(SwingConstants.CENTER);
		txtWeatherInformations.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		txtWeatherInformations.setBackground(Color.YELLOW);
		txtWeatherInformations.setText("Weather Informations");
		frame.getContentPane().add(txtWeatherInformations);
		txtWeatherInformations.setColumns(10);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nr=randInt(-50, 50);
				String nr_string=Integer.toString(nr);
				nr_string+="°C";
				textField_1_write.setText(nr_string);
				nr=randInt(1, 100);
				nr_string=Integer.toString(nr);
				nr_string+="m/s";
				textField_2_write.setText(nr_string);
				
			}
		});
		
	  
		btnNewButton.setBounds(184, 122, 195, 23);
		frame.getContentPane().add(btnNewButton);
		
		txtTemperature = new JTextField();
		txtTemperature.setText("Temperature");
		txtTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		txtTemperature.setForeground(Color.BLUE);
		txtTemperature.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		txtTemperature.setEnabled(false);
		txtTemperature.setEditable(false);
		txtTemperature.setColumns(10);
		txtTemperature.setBackground(Color.WHITE);
		txtTemperature.setBounds(22, 63, 143, 27);
		frame.getContentPane().add(txtTemperature);
		
		txtWindSpeed = new JTextField();
		txtWindSpeed.setText("Wind Speed");
		txtWindSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtWindSpeed.setForeground(Color.BLUE);
		txtWindSpeed.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		txtWindSpeed.setEnabled(false);
		txtWindSpeed.setEditable(false);
		txtWindSpeed.setColumns(10);
		txtWindSpeed.setBackground(Color.WHITE);
		txtWindSpeed.setBounds(398, 63, 143, 27);
		frame.getContentPane().add(txtWindSpeed);
		
		textField_1_write = new JTextField();
		textField_1_write.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1_write.setForeground(Color.BLUE);
		textField_1_write.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		textField_1_write.setEnabled(false);
		textField_1_write.setEditable(false);
		textField_1_write.setColumns(10);
		textField_1_write.setBackground(Color.WHITE);
		textField_1_write.setBounds(22, 122, 134, 70);
		frame.getContentPane().add(textField_1_write);
		
		textField_2_write = new JTextField();
		textField_2_write.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2_write.setForeground(Color.BLUE);
		textField_2_write.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		textField_2_write.setEnabled(false);
		textField_2_write.setEditable(false);
		textField_2_write.setColumns(10);
		textField_2_write.setBackground(Color.WHITE);
		textField_2_write.setBounds(407, 122, 134, 70);
		frame.getContentPane().add(textField_2_write);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, txtWeatherInformations}));
		
		
		
	}

	@Override
	public void onUpdate() {
		 
		JOptionPane.showMessageDialog(null, "dasdasdas", "fsdfsdfs", 0); 
		textField_1_write.setText(mModel.gettemp());
		textField_2_write.setText(mModel.getspeed());
	}
}
