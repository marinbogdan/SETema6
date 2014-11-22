package mta.main;

import mta.controller.WeatherController;
import mta.model.WeatherModel;
import mta.view.WeatherView;


public class Main {

	public static void main(String[] args) {
		
				try {
					WeatherView view = new WeatherView();
					WeatherController controller=new WeatherController();
					WeatherModel model=new WeatherModel();
				
					model.addModelListener(view);
					
					view.addController(controller);
					view.addModel(model);
					
					controller.addModel(model);
					controller.addView(view);
					
					view.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

}