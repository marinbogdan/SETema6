package mta.interfaces;

import java.awt.event.ActionListener;

public interface IController extends ActionListener {
	public static final String ACTION_RESET = "RESET";
    public static final String ACTION_CALCULATE = "CALCULATE";
    public String getTemperature();
    public String getWindSpeed();
    

}
