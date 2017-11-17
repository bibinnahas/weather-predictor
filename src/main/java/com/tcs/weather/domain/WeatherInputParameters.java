package com.tcs.weather.domain;

import java.util.List;

/**
 * Weather input parameters such as temperature, pressure, humidity, location
 * etc..
 * 
 * @author bibin
 */
public class WeatherInputParameters {

	private List<Double> temperatureHist;
	private List<Double> pressureHist;
	private List<Double> humidityHist;
	private String location;
	private String positionLatLongEle;
	private String classification;
	private String predictionDate;

	public List<Double> getTemperature() {
		return temperatureHist;
	}

	public void setTemperature(List<Double> temperature) {
		this.temperatureHist = temperature;
	}

	public List<Double> getPressure() {
		return pressureHist;
	}

	public void setPressure(List<Double> pressure) {
		this.pressureHist = pressure;
	}

	public List<Double> getHumidity() {
		return humidityHist;
	}

	public void setHumidity(List<Double> humidity) {
		this.humidityHist = humidity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getPredictionDate() {
		return predictionDate;
	}

	public void setPredictionDate(String predictionDate) {
		this.predictionDate = predictionDate;
	}

	public String getPositionOut() {
		return positionLatLongEle;
	}

	public void setPositionOut(String positionOut) {
		this.positionLatLongEle = positionOut;
	}
}