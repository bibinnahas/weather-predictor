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
