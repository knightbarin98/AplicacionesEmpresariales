package designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer{
	
	Observable observable;
	private float temperature;
	private float humidity;
	
	
	
	public CurrentConditionDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}



	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			System.out.println(toString());
		}
		
	}

	@Override
	public String toString() {
		return "CurrentConditionDisplay [observable=" + observable + ", temperature=" + temperature + ", humidity="
				+ humidity + "]";
	}
	
	

}
