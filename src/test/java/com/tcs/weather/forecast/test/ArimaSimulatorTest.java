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



