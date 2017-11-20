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

package com.tcs.weather.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import com.tcs.weather.constants.Constants;
import com.tcs.weather.exception.WeatherPredictorException;

/**
 * This houses the common utils required for the Weather Predictor
 * 
 * @author bibin
 */
public class CommonUtils {

	private static final Logger LOGGER = Logger.getLogger(CommonUtils.class);

	/**
	 * The month extracted from the Future date for which the weather is
	 * predicted and the Month coefficient is passed as arguments. Returns the
	 * months between the future date and the last date. (Period of history Days
	 * considered/30) gives the Month Coefficient
	 * 
	 * @param predictionMonth
	 * @param monthValue
	 * @return List of integers of relevant months.
	 */
	public static int[] getHistoryMonths(final int predictionMonth, final int monthValue) {

		final int[] monthSplitA = Arrays.copyOfRange(Constants.MONTHS, 0, predictionMonth);
		final int[] monthSplitB = Arrays.copyOfRange(Constants.MONTHS, predictionMonth, Constants.MONTHS.length);
		final int[] monthBA = ArrayUtils.addAll(monthSplitB, monthSplitA);
		return Arrays.copyOfRange(monthBA, Constants.MONTHS.length - monthValue - 1, Constants.MONTHS.length);
	}

	/**
	 * Finds the mean of two numbers
	 * 
	 * @param firstValue
	 * @param secondValue
	 * @return
	 */
	public static double getMean(final double firstValue, final double secondValue) {

		return ((firstValue + secondValue) / 2);
	}

	/**
	 * Creates an output file.
	 * 
	 * @param date
	 *            - Used to name the file
	 * @return PrintWriter
	 * @throws WeatherPredictorException
	 * @throws FileNotFoundException
	 */
	public static PrintWriter createOutputFile(final String date) throws WeatherPredictorException {

		final File outputDirectory = new File(System.getProperty("user.dir") + "/output");
		// if the directory does not exist, create it
		if (!outputDirectory.exists()) {
			try {
				outputDirectory.mkdir();
			} catch (SecurityException se) {
				LOGGER.error(se);
			}
		}
		final String outputLocationName = outputDirectory + "/out" + "_" + date + ".txt";
		try {
			return new PrintWriter(outputLocationName);
		} catch (FileNotFoundException e) {
			throw new WeatherPredictorException(
					"Failed to create output file at " + System.getProperty("user.dir") + "/output");
		}
	}

	/**
	 * Classifies the climate based on weather parameters.
	 * 
	 * @param temperature
	 * @param pressure
	 * @param Humidity
	 * @return
	 */
	public static String climateClassification(final double temperature, final double pressure, final double Humidity) {

		String classification = "";
		if (temperature > 24 && pressure > 1005) {
			classification = "Sunny";
		} else if (temperature >= 5 && temperature <= 24 && Humidity >= 60 && pressure <= 990) {
			classification = "Rain";
		} else if (temperature < 24 && Humidity < 60 && pressure < 990) {
			classification = "Rain";
		} else if (temperature < 24 && Humidity > 60 && pressure > 990) {
			classification = "Rain";
		} else if (temperature > 24 && Humidity < 60 && pressure > 990) {
			classification = "Sunny";
		} else if (temperature < 5 && Humidity >= 60) {
			classification = "Snow";
		} else if (temperature > 24 && pressure <= 990) {
			classification = "Rain";
		} else if (temperature >= 5 && temperature <= 24 && Humidity < 60 && pressure > 1005) {
			classification = "Sunny";
		} else if (temperature < 24 && Humidity > 60 && pressure >= 1005) {
			classification = "Rain";
		} else if (temperature > 24 && Humidity < 60 && pressure > 999 && pressure > 1005) {
			classification = "Rain";
		} else {
			classification = "Missing";
		}
		return classification;
	}
}