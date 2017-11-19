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
	String pastDate = "2017-10-10";
	String invalidDate = "2018-13-29";
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
			testDate = formatter.parse("Wed Oct 03 00:00:00 IST 2018");
			assertEquals(testDate, DateUtils.listPreviousDates(date, Constants.DATE_FORMAT, 2).get(0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void checkIfFutureDateTest() throws ParseException, WeatherPredictorException {
		assertTrue(DateUtils.checkIfFutureDate(date));
		assertFalse(DateUtils.checkIfFutureDate(pastDate));
	}

	@Test
	public void isValidDateTest() {
		assertEquals(false, DateUtils.isValidDate(invalidDate));

	}

	@Test
	public void toIsoFormatTimeStampTest() {
		try {
			assertEquals("2018-10-05T00:00:00Z", DateUtils.toIsoFormatTimeStamp(date));
		} catch (WeatherPredictorException e) {
			e.printStackTrace();
		}
	}
}