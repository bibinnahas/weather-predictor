package com.tcs.weather.utils.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

import com.tcs.weather.exception.WeatherPredictorException;
import com.tcs.weather.utils.CommonUtils;

public class CommonUtilsTest {
	int[] month ={10,11,12,1};
	String date = "2017-01-10";

		@Test
	public void  getHistoryMonthsTest(){
			assertArrayEquals(month, CommonUtils.getHistoryMonths(01, 3));
	}
		@Test
		public void getMeanTest(){
			assertEquals(15.0, CommonUtils.getMean(20.0, 10.0), 0);
		}
		
		@Test
		public void createOutputFileTest() throws FileNotFoundException, WeatherPredictorException{
			PrintWriter writer = CommonUtils.createOutputFile(date);
			assertNotNull(writer);
		}
		
		@Test
		public void climateClassificationTest(){
			assertEquals("Rain",CommonUtils.climateClassification(10,990,60));
		}
}
