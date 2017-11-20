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

package com.tcs.weather.forecast;

import java.io.PrintWriter;

import com.tcs.weather.domain.WeatherInputParameters;
import com.tcs.weather.domain.WeatherOutputParameters;
import com.tcs.weather.utils.CommonUtils;

/**
 * Makes necessary input formatting for ARIMA and returns the weather
 * predictions.
 * 
 * @author bibin
 */
public class PredictWeather {

	public void writeToFile(WeatherOutputParameters simulation, PrintWriter writer) {
		writer.println(simulation.toString());
	}

	/**
	 * This is the output bean class to write the files
	 * 
	 * @param weatherParams
	 * @return
	 */
	public WeatherOutputParameters getPrediction(WeatherInputParameters weatherParams) {

		ArimaSimulator callArima = new ArimaSimulator();
		WeatherOutputParameters predictionValues = new WeatherOutputParameters();
		double[] temperatureForAlgo = weatherParams.getTemperature().stream().mapToDouble(Double::doubleValue)
				.toArray();

		double[] pressureForAlgo = weatherParams.getPressure().stream().mapToDouble(Double::doubleValue).toArray();
		double[] humidityForAlgo = weatherParams.getHumidity().stream().mapToDouble(Double::doubleValue).toArray();

		double temperatureOut = callArima.getForecastData(temperatureForAlgo);
		predictionValues.setForecastTemp(temperatureOut);
		double pressureOut = callArima.getForecastData(pressureForAlgo);
		predictionValues.setForecastPressure(pressureOut);
		double humidityOut = callArima.getForecastData(humidityForAlgo);
		predictionValues.setForecastHumidity(humidityOut);

		predictionValues.setLocationOut(weatherParams.getLocation());
		predictionValues.setPosition(weatherParams.getPositionOut());
		predictionValues.setPredictionDateOut(weatherParams.getPredictionDate());
		predictionValues
				.setClassificationOut(CommonUtils.climateClassification(temperatureOut, pressureOut, humidityOut));
		return predictionValues;
	}

}
