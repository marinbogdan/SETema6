package mta.model;

import java.util.ArrayList;
import java.util.List;

import mta.interfaces.IModel;

public class WeatherModel {

	public String temperature = null;
	public String windSpees = null;
	private List<IModel> mListeners;

	public void addModelListener(IModel listener) {

		if (mListeners == null) {
			mListeners = new ArrayList<IModel>();
		}

		mListeners.add(listener);
	}

	private void notifyListeners() {
		if (mListeners != null && !mListeners.isEmpty()) {
			for (IModel listener : mListeners)
				listener.onUpdate();
		}
	}

	public String gettemp() {
		notifyListeners();
		return this.temperature;
	}

	public String getspeed() {
		notifyListeners();
		return this.windSpees;
	}

}
