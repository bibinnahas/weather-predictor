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

package com.tcs.weather.exception;

/**
 * Custom Exception class
 * 
 * @author bibin
 *         
 */

public class WeatherPredictorException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String customErrorMessage;

	/**
	 * @param message
	 *            : Custom messages for each exceptions
	 */
	public WeatherPredictorException(String message) {
		this.customErrorMessage = message;
	}

	/**
	 * @param cause
	 *            :state the cause of the exception
	 * @param message
	 *            : Custom messages for each exceptions that may occur
	 */
	public WeatherPredictorException(Throwable cause, String message) {
		super(cause);
		this.customErrorMessage = message;
	}

	@Override
	public String getMessage() {
		return this.customErrorMessage;
	}
}
