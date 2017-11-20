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