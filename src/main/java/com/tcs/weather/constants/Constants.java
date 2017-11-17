package com.tcs.weather.constants;

/**
 * This class defines the constants used in the Weather Predictor application
 * 
 * @author bibin
 */
public class Constants {

	// Input Constants
	public static final String INPUT_PATH = "input/";

	// Constants for Date Utilities
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String CONVERTED_DATE_FORMAT = "E MMM dd HH:mm:ss Z yyyy";

	// Constants for period of days to consider the variables for prediction
	public static final int PERIOD = 10;
	public static final int SHIFT_PERIOD = 30;
	public static final int[] MONTHS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	// Constants for symbols
	public static final String COMMA_SEPARATOR = ",";
	public static final String SLASH_SEPARATOR = "/";
	public static final String UNDER_SCORE = "_";

	// Constants for file extension
	public static final String CSV_EXTENSION = ".csv";

	// Constants for ARIMA model
	public static final int ARIMA_p = 1;
	public static final int ARIMA_d = 0;
	public static final int ARIMA_q = 1;
	public static final int ARIMA_P = 1;
	public static final int ARIMA_D = 1;
	public static final int ARIMA_Q = 0;
	public static final int ARIMA_m = 1;
}
