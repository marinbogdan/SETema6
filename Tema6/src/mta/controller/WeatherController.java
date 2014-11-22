package mta.controller;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.scene.control.TextField;
import mta.interfaces.IController;
import mta.interfaces.IView;
import mta.model.WeatherModel;

public class WeatherController implements IController {

	private WeatherModel mModel;

	private List<IView> mViews;
	String temperature = null;
	String windSpees = null;

	public int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public void addView(IView view) {
		if (mViews == null) {
			mViews = new ArrayList<IView>();
		}

		mViews.add(view);
	}

	public String getTemperature() {
		return temperature;
	}

	public String getWindSpeed() {
		return windSpees;
	}

	public void addModel(WeatherModel model) {
		mModel = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(ACTION_CALCULATE)) {
			JOptionPane.showMessageDialog(null, "Check out the new update!!",
					"Update", 0);

			//
			int nr = randInt(-50, 50);
			String nr_string = Integer.toString(nr);
			nr_string += "°C";
			temperature = nr_string;
			nr = randInt(1, 100);
			nr_string = Integer.toString(nr);
			nr_string += "m/s";
			windSpees = nr_string;
		}
	}
}
