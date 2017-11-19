package com.tcs.weather.utils.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.tcs.weather.constants.Constants;
import com.tcs.weather.exception.WeatherPredictorException;
import com.tcs.weather.utils.DateUtils;

public class DateUtilsTest {
	public static Calendar cal = Calendar.getInstance();
	String date = "2018-10-05";
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

	@Test
	public void getMonthTest() throws ParseException {
		assertEquals(10, DateUtils.getMonth(date, Constants.DATE_FORMAT));
	}

	@Test
	public void dateToStringTest() {
		Date startDate;
		try {
			startDate = df.parse(date);
			assertEquals(date, DateUtils.dateToString(startDate, Constants.DATE_FORMAT));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toDateTest() {
		Date thisDate;
		try {
			thisDate = df.parse(date);
			assertEquals(thisDate, DateUtils.toDate(date, Constants.DATE_FORMAT));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void listPreviousDatesTest() {
		Date testDate;
		try {
			testDate = formatter.parse("Sun Dec 31 00:00:00 IST 2017");
			assertEquals(testDate, DateUtils.listPreviousDates("2018-01-02", Constants.DATE_FORMAT, 2).get(0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void checkIfFutureDateTest() throws ParseException, WeatherPredictorException {
		assertTrue(DateUtils.checkIfFutureDate(date));
		assertFalse(DateUtils.checkIfFutureDate("2015-05-06"));
	}

	@Test
	public void isValidDateTest() {
		String testDate;
		testDate = "2018-13-12";
		assertEquals(false, DateUtils.isValidDate(testDate));

	}
}