package com.tcs.weather.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.tcs.weather.constants.Constants;
import com.tcs.weather.exception.WeatherPredictorException;

/**
 * This class houses all the date functions used in the Weather Predictor
 * 
 * @author bibin
 */
public class DateUtils {

	public static Calendar cal = Calendar.getInstance();

	/**
	 * Extract month from given Date String and returns it
	 * 
	 * @param dateString
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static int getMonth(final String dateString, final String format) throws ParseException {

		Date date = toDate(dateString, format);
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * Converts a date to String with given date format
	 * 
	 * @param date
	 * @param format
	 * @return date as string
	 */
	public static String dateToString(final Date date, final String format) {

		final DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * @param passedDate
	 * @param format
	 * @return
	 * 
	 * 		Extract month from given Date and returns it
	 */
	public static int getMonth(final Date passedDate, final String format) {

		cal.setTime(passedDate);
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * Convert a string to Date in the given format
	 * 
	 * @param dateString
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(final String dateString, final String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		Date date = df.parse(dateString);
		return date;
	}

	/**
	 * @param dateString
	 * @param format
	 * @param period
	 * @return
	 * @throws ParseException
	 * 
	 *             Returns List of dates between the input Future Date and the
	 *             date after subtracting the period of days
	 */
	public static List<Date> listPreviousDates(final String dateString, final String format, final int period)
			throws ParseException {

		List<Date> dateList = new ArrayList<Date>();
		Date inpDate = toDate(dateString, format);
		cal.setTime(inpDate);
		cal.add(Calendar.DATE, -period);
		// Date prevDate = cal.getTime();
		while (cal.getTime().before(inpDate)) {
			Date result = cal.getTime();
			dateList.add(result);
			cal.add(Calendar.DATE, 1);
		}
		dateList.add(inpDate);
		return dateList;
	}

	/**
	 * Checks whether the given date is future date.
	 * 
	 * @param inputdate
	 * @return boolean
	 * @throws WeatherPredictorException 
	 * @throws ParseException
	 */
	public static boolean checkIfFutureDate(final String inputdate) throws WeatherPredictorException {

		final Date current = new Date();
		final String myFormatString = Constants.DATE_FORMAT;
		final SimpleDateFormat df = new SimpleDateFormat(myFormatString);
		Date givenDate;
		try {
			givenDate = df.parse(inputdate);
			final Long longTime = givenDate.getTime();
			final Date next = new Date(longTime);
			return (next.after(current) || (next.equals(current))) ? true : false;
			
		} catch (ParseException e) {
			throw new WeatherPredictorException("Incorrect date format; Expecting 'yyyy-MM-dd' format");
		}
		
	}
}
