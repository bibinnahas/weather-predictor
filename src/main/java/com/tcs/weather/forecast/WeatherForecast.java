package com.tcs.weather.forecast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tcs.weather.constants.Constants;
import com.tcs.weather.domain.WeatherInputParameters;
import com.tcs.weather.domain.WeatherOutputParameters;
import com.tcs.weather.exception.WeatherPredictorException;
import com.tcs.weather.utils.CommonUtils;
import com.tcs.weather.utils.DateUtils;

/**
 * Reads the input for Weather Forecasting and lists the values of temperature,
 * pressure and humidity to be passed to the ARIMA Algorithm
 * 
 * @author bibin
 */
public class WeatherForecast {


	/**
	 * Get distinct locations from the input file names
	 * 
	 * @param inputPath
	 * @return
	 */
	public Set<String> getLocations(final String inputPath) {
		final Set<String> loc = new HashSet<String>();
		final File folder = new File(inputPath);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				loc.add(fileEntry.getName());
			}
		}
		return loc;
	}

	/**
	 * Read the input files by iterating through the distinct locations and
	 * relevant months. Relevant months are months between the future date and
	 * the last date after subtracting the period of history days for prediction
	 * 
	 * @param locations
	 * @param inputPath
	 * @param inputdate
	 * @throws WeatherPredictorException
	 * @throws IOException
	 * @throws ParseException
	 */
	public WeatherInputParameters getWeatherList(final Set<String> locations, final String inputPath,
			final String inputdate, final PrintWriter writer) throws WeatherPredictorException {

		final WeatherInputParameters weatherInputParams = new WeatherInputParameters();
		final PredictWeather predictWeather = new PredictWeather();
		WeatherOutputParameters forecastValues = null;

		final ArrayList<String> historyDays = new ArrayList<String>();
		final List<Double> temperature = new ArrayList<Double>();
		final List<Double> humidity = new ArrayList<Double>();
		final List<Double> pressure = new ArrayList<Double>();

		// month coefficient is used to compute list of months to consider for
		// prediction.
		final int monthCoefficient = (int) Math.round((Constants.PERIOD / Constants.SHIFT_PERIOD) + 0.5);
		int inputReferenceMonth;
		try {
			inputReferenceMonth = DateUtils.getMonth(inputdate, Constants.DATE_FORMAT);
		} catch (ParseException e) {
			throw new WeatherPredictorException("Invalid date format; expecting 'yyyy-MM-dd'");
		}

		// Get the list of history months for predicting the future date
		final int[] relevantHistoryMonths = CommonUtils.getHistoryMonths(inputReferenceMonth, monthCoefficient);

		setHistoryDays(inputdate, historyDays);

		for (String location : locations) {
			for (int month : relevantHistoryMonths) {
				try {
					final String inputFileLocation = inputPath + "/" + location + Constants.SLASH_SEPARATOR + month
							+ Constants.CSV_EXTENSION;
					final BufferedReader in = new BufferedReader(new FileReader(inputFileLocation));

					// To skip header from input file
					in.readLine();
					String inputData;
					while ((inputData = in.readLine()) != null) {
						final String[] elements = inputData.split(Constants.COMMA_SEPARATOR, -1);
						final String position = elements[1] + "," + elements[2] + "," + elements[3];
						getPredictionVariables(historyDays, temperature, humidity, pressure, elements);
						weatherInputParams.setLocation(location);
						weatherInputParams.setPositionOut(position);
						weatherInputParams.setPredictionDate(inputdate);
					}
					in.close();
				} catch (FileNotFoundException e) {
					throw new WeatherPredictorException("Weather input file not found");
				} catch (IOException e) {
					throw new WeatherPredictorException("Unable to read the input weather data");
				}
			}

			weatherInputParams.setHumidity(humidity);
			weatherInputParams.setPressure(pressure);
			weatherInputParams.setTemperature(temperature);
			forecastValues = predictWeather.getPrediction(weatherInputParams);
			predictWeather.writeToFile(forecastValues, writer);
		}
		writer.close();
		return weatherInputParams;
	}

	/**
	 * Get double array values for Arima input.
	 * 
	 * @param historyDays
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 * @param elements
	 */
	private void getPredictionVariables(final ArrayList<String> historyDays, final List<Double> temperature,
			final List<Double> humidity, final List<Double> pressure, final String[] elements) {
		for (int i = 0; i < historyDays.size(); i++) {
			final String dateFromData = elements[4].substring(5, 10);
			if (dateFromData.equals(historyDays.get(i).substring(5, 10))) {
				temperature.add(CommonUtils.getMean(Double.parseDouble(elements[5]),
						Double.parseDouble(elements[6].isEmpty() ? elements[5] : elements[6])));
				humidity.add(CommonUtils.getMean(Double.parseDouble(elements[14]),
						Double.parseDouble(elements[20].isEmpty() ? elements[14] : elements[20])));
				pressure.add(CommonUtils.getMean(Double.parseDouble(elements[18]),
						Double.parseDouble(elements[24].isEmpty() ? elements[18] : elements[24])));
			}
		}
	}

	/**
	 * Finds the relevant days for predicting weather.
	 * 
	 * @param inputdate
	 * @param historyDays
	 * @throws WeatherPredictorException
	 * @throws ParseException
	 */
	private void setHistoryDays(final String inputdate, final ArrayList<String> historyDays)
			throws WeatherPredictorException {
		List<Date> dates;
		try {
			dates = DateUtils.listPreviousDates(inputdate, Constants.DATE_FORMAT, Constants.PERIOD);
			for (Date date : dates) {
				final String dateString = DateUtils
						.dateToString(DateUtils.toDate(DateUtils.dateToString(date, Constants.CONVERTED_DATE_FORMAT),
								Constants.CONVERTED_DATE_FORMAT), Constants.DATE_FORMAT);
				historyDays.add(dateString);
			}
		} catch (ParseException e) {
			throw new WeatherPredictorException("Unable to parse the input date; expecting 'yyyy-MM-dd' format");
		}

	}
}