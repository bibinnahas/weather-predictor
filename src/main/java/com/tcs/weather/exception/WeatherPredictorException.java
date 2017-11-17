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
