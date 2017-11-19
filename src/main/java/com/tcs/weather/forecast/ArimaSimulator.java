package com.tcs.weather.forecast;

import com.tcs.weather.constants.Constants;
import com.tcs.weather.utils.CommonUtils;
import com.workday.insights.timeseries.arima.Arima;
import com.workday.insights.timeseries.arima.struct.ArimaParams;
import com.workday.insights.timeseries.arima.struct.ForecastResult;

/**
 * Predicts the weather using ARIMA.
 * 
 * @author bibin
 */
public class ArimaSimulator {

	/**
	 * Gets forecast data.
	 * 
	 * @param tempList
	 * @return double
	 */
	public double getForecastData(final double[] tempList) {
		// Setting ARIMA parameters
		final int p = Constants.ARIMA_p;
		final int d = Constants.ARIMA_d;
		final int q = Constants.ARIMA_q;
		final int P = Constants.ARIMA_P;
		final int D = Constants.ARIMA_D;
		final int Q = Constants.ARIMA_Q;
		final int m = Constants.ARIMA_m;
		int forecastSize = 1;
		ArimaParams arimaParams = new ArimaParams(p, d, q, P, D, Q, m);
		// Forecast result
		final ForecastResult forecastResult = Arima.forecast_arima(tempList, forecastSize, arimaParams);
		final double[] upper = forecastResult.getForecastUpperConf();
		final double[] lower = forecastResult.getForecastLowerConf();
		// Find the mean of upper and lower values returned by the model
		return CommonUtils.getMean(upper[0], lower[0]);
	}
}