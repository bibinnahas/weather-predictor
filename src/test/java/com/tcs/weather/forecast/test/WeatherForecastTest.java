package com.tcs.weather.forecast.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

import com.tcs.weather.domain.WeatherInputParameters;
import com.tcs.weather.exception.WeatherPredictorException;
import com.tcs.weather.forecast.WeatherForecast;

public class WeatherForecastTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void getWeatherListTest() throws IOException, ParseException, WeatherPredictorException {
		final List<Double> expectedHumidity = new ArrayList<>();
		expectedHumidity.add(56.0);
		final File output = folder.newFolder("output");
		final Set<String> location = new HashSet<String>();
		location.add("SYDNEY");
		final String futureDate = "2018-01-01";
		final PrintWriter printWriter = new PrintWriter(output + "/out-" + futureDate + ".txt");
		final WeatherForecast weatherForcast = new WeatherForecast();
		WeatherInputParameters weatherInputParms = new WeatherInputParameters();
		weatherInputParms = weatherForcast.getWeatherList(location, "input/", futureDate, printWriter);
		double test = weatherInputParms.getHumidity().get(0);
		assertEquals(expectedHumidity.get(0), test, 0);
	}
}
