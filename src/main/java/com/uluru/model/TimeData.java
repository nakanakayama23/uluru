package com.uluru.model;

/**
 * 日時クラス
 * 
 * @author imazato
 *
 */
public class TimeData {

	/**
	 * 年
	 */
	private int year;

	/**
	 * 月
	 */
	private int month;

	/**
	 * 日
	 */
	private int day;

	/**
	 * 時
	 */
	private int hour;

	/**
	 * 分
	 */
	private int minute;

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	public TimeData() {}

	public TimeData(TimeData t) {
		setYear(t.getYear());
		setMonth(t.getMonth());
		setDay(t.getDay());
		setHour(t.getHour());
		setMinute(t.getMinute());
	}

	/**
	 * 日付を設定する
	 */
	public void setDate(String year, String month, String day) {
		setYear(Integer.parseInt(year));
		setMonth(Integer.parseInt(month));
		setDay(Integer.parseInt(day));

	}
	
	/**
	 * 時刻を設定する
	 */
	public void setTime(String hour, String minute){
		setHour(Integer.parseInt(hour));
		setMinute(Integer.parseInt(minute));
	}

	/**
	 * 時間を巻き戻す。
	 */
	public void before(int minute) {
		int diffMin = this.minute - minute;
		if (diffMin < 0) {
			int dHour = diffMin / 60 + 1;
			this.minute = dHour * 60 + diffMin;
			int diffHour = this.hour - dHour;
			if ( false ) {
				// 日付をまたぐ処理はとりあえず考慮しない。
			} else {
				this.hour = diffHour;
			}
		} else {
			this.minute = diffMin;
		}
	}
}
