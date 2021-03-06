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

package com.tcs.weather.entry;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.tcs.weather.constants.Constants;
import com.tcs.weather.exception.WeatherPredictorException;
import com.tcs.weather.forecast.WeatherForecast;
import com.tcs.weather.utils.CommonUtils;
import com.tcs.weather.utils.DateUtils;

/**
 * 
 * This is the entry point of the Weather Predictor The program takes as input a
 * Future Date for forecasting the weather.
 * 
 * @author bibin
 */
public class Trigger {

	private static final Logger LOGGER = Logger.getLogger(Trigger.class);

	/**
	 * User input future date in the format yyyy-MM-dd
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) {

		// Log4j configuration
		BasicConfigurator.configure();

		try {
			// Validates the input argument null check and count
			if (args == null || args.length > 1) {
				LOGGER.error("Invalid number of input arguments. Expecting an input date. Exiting now.");
				System.exit(1);
			}

			// Passes the Future date for weather prediction
			final String inputdate = args[0];

			// Check if the input date is a valid date.
			if (!DateUtils.isValidDate(inputdate)) {
				LOGGER.error("Invalid date. Check the input date entered. Exiting now.");
				System.exit(1);
			}
			
			boolean isFuture = DateUtils.checkIfFutureDate(inputdate);
			
			// Check if the input date is a future date.
			if (!isFuture) {
				LOGGER.error("Invalid input value. Expecting a future date. Exiting now.");
				System.exit(1);
			}

			// Gets the input directory containing the weather data files
			final String inputPath = Constants.INPUT_PATH;

			// Create the output file
			PrintWriter writer = CommonUtils.createOutputFile(inputdate);
			final WeatherForecast weatherForecast = new WeatherForecast();
			final Set<String> distinctLocation = weatherForecast.getLocations(inputPath);

			// Read the corresponding weather parameters for the location from
			// the
			// history data
			weatherForecast.getWeatherList(distinctLocation, inputPath, inputdate, writer);
			LOGGER.info("Weather prediction completed.");
		} catch (WeatherPredictorException e) {
			LOGGER.error(e);
		}
	}
}