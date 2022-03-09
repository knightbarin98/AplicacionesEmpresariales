package designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer {

	Observable observable;
	private float currentPreasure = 29.92F;
	private float lastPreasure;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.lastPreasure = currentPreasure;
			this.currentPreasure = weatherData.getPressure();
			System.out.println(toString());
		}
	}

	@Override
	public String toString() {
		return "ForecastDisplay [observable=" + observable + ", currentPreasure=" + currentPreasure + ", lastPreasure="
				+ lastPreasure + "]";
	}

	

}
