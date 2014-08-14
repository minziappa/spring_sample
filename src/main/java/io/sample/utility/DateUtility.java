package io.sample.utility;

import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	private static int MINUTE_IN_MILLIS = 60000;
	private static int HOUR_IN_MILLIS = 3600000;
	private static int DAY_IN_MILLIS = 86400000;

	@SuppressWarnings("unused")
	private static Date getHourDate(int intNumber) {

		long currentMillis = System.currentTimeMillis();
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(currentMillis);
		calSevenDay.add(Calendar.HOUR_OF_DAY, intNumber);

		return calSevenDay.getTime();
	}

	public static Date getHourOfDayMoveTime(Date date, int intMoveTime) {

		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTime(date);
		calSevenDay.add(Calendar.HOUR_OF_DAY, intMoveTime);

		return calSevenDay.getTime();
	}

	public static Date getMinuteOfHourMoveTime(Date date, int intMoveTime) {

		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTime(date);
		calSevenDay.add(Calendar.MINUTE, intMoveTime);

		return calSevenDay.getTime();
	}

	public static Date getMinuteInMillisAfter(int afterMinute) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + MINUTE_IN_MILLIS * afterMinute;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getHourInMillisAfter(int afterDate) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + HOUR_IN_MILLIS * afterDate;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getDayInMillisAfter(int afterDate) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + DAY_IN_MILLIS * afterDate;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getMinuteInMillisBefore(int beforeMinute) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - MINUTE_IN_MILLIS * beforeMinute;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getHourInMillisBefore(int beforeHour) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - HOUR_IN_MILLIS * beforeHour;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getDayInMillisBefore(int beforeDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - DAY_IN_MILLIS * beforeDay;

		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getDaySet(int year, int month, int day, int hour, int minute, int second) {

		Calendar calDay = Calendar.getInstance();
		calDay.set(year, month-1, day);
		calDay.set(Calendar.HOUR_OF_DAY, hour);
		calDay.set(Calendar.MINUTE, minute);
		calDay.set(Calendar.SECOND, second);

		return calDay.getTime();
	}

	public static Date getStartToday(int year, int month, int day, int hour) {

		Calendar calDay = Calendar.getInstance();
		calDay.set(year, month-1, day);
		calDay.set(Calendar.HOUR_OF_DAY, hour);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getEndToday(int year, int month, int date, int hour) {

		Calendar calDay = Calendar.getInstance();
		calDay.set(year, month-1, date);
		calDay.set(Calendar.HOUR_OF_DAY, hour);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getStartToday() {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getStartBeforeDay(int beforeDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - DAY_IN_MILLIS * beforeDay;

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(afterSevenMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getEndBeforeDay(int beforeDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - DAY_IN_MILLIS * beforeDay;

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(afterSevenMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 23);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getEndToday() {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 23);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getStartAfterDay(int afterDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + DAY_IN_MILLIS * afterDay;

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(afterSevenMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getNowTime() {
		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();
		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);

		return calDay.getTime();
	}

	public static int getNowYear() {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.YEAR);
	}

	public static int getNowYear(long timeMillis) {
		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(timeMillis);
		return calDay.get(Calendar.YEAR);
	}

	public static int getNowMonth() {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.MONTH) + 1;
	}

	public static int getNowDay() {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.DATE);
	}

}