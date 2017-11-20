/*****************************************************************************
 * Copyright (C) 2017-2018 Bibin Nahas
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 ********************************************************************************/

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
				+ Math.round(temperatureForecast * 100D) / 100D + "|" + Math.round(pressureForecast * 100D) / 100D + "|"
				+ Math.round(humidityForecast * 100D) / 100D);
		return builder.toString();
	}

}
