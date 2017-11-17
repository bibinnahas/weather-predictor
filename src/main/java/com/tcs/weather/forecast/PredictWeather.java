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
