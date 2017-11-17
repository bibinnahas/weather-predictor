package com.tcs.weather.forecast.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tcs.weather.forecast.ArimaSimulator;

public class ArimaSimulatorTest {

	double[] temp = {23,25,22,25,18,19,20,21,22,24,23,25,22,25,18,19,20,21,22,24,23,25,22,25,18,19,20,21,22,24};
	@Test
	public void getForecastDataTest(){
		ArimaSimulator arima = new ArimaSimulator();
		assertEquals(23.391952649140492, arima.getForecastData(temp), 0);
	}
}



