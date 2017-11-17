package com.tcs.weather.domain;

/**
 * Output parameters
 * 
 * @author bibin
 */
public class WeatherOutputParameters {

	private Double temperatureForecast;
	private Double pressureForecast;
	private Double humidityForecast;
	private String locationOut;
	private String latitudeOut;
	private String longitudeOut;
	private String position;
	private String elevationOut;
	private String classificationOut;
	private String predictionDateOut;

	public Double getForecastTemp() {
		return temperatureForecast;
	}

	public void setForecastTemp(Double forecastTemp) {
		this.temperatureForecast = forecastTemp;
	}

	public Double getForecastPressure() {
		return pressureForecast;
	}

	public void setForecastPressure(Double forecastPressure) {
		this.pressureForecast = forecastPressure;
	}

	public Double getForecastHumidity() {
		return humidityForecast;
	}

	public void setForecastHumidity(Double forecastHumidity) {
		this.humidityForecast = forecastHumidity;
	}

	public String getLocationOut() {
		return locationOut;
	}

	public void setLocationOut(String locationOut) {
		this.locationOut = locationOut;
	}

	public String getLatitudeOut() {
		return latitudeOut;
	}

	public void setLatitudeOut(String latitudeOut) {
		this.latitudeOut = latitudeOut;
	}

	public String getLongitudeOut() {
		return longitudeOut;
	}

	public void setLongitudeOut(String longitudeOut) {
		this.longitudeOut = longitudeOut;
	}

	public String getElevationOut() {
		return elevationOut;
	}

	public void setElevationOut(String elevationOut) {
		this.elevationOut = elevationOut;
	}

	public String getClassificationOut() {
		return classificationOut;
	}

	public void setClassificationOut(String classificationOut) {
		this.classificationOut = classificationOut;
	}

	public String getPredictionDateOut() {
		return predictionDateOut;
	}

	public void setPredictionDateOut(String predictionDateOut) {
		this.predictionDateOut = predictionDateOut;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(locationOut + "|" + position + "|" + predictionDateOut + "|" + classificationOut + "|"
				+ temperatureForecast + "|" + pressureForecast + "|" + humidityForecast);
		return builder.toString();
	}
}
