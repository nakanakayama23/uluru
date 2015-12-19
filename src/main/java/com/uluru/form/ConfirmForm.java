package com.uluru.form;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.uluru.utils.Constant;

/**
 * 入力確認情報フォーム
 * 
 * @author imazato
 *
 */
public class ConfirmForm {

	/**
	 * 年
	 */
	private String year;

	/**
	 * 月
	 */
	private String month;

	/**
	 * 日
	 */
	private String day;

	/**
	 * 時
	 */
	private String hour;

	/**
	 * 分
	 */
	private String minute;

	/**
	 * 入力確認画面から送られてきた駅IDリスト
	 */
	private List<Integer> stationIdList;

	public ConfirmForm(UriInfo info) {

		year = info.getQueryParameters().getFirst("year");
		month = info.getQueryParameters().getFirst("month");
		day = info.getQueryParameters().getFirst("day");
		hour = info.getQueryParameters().getFirst("hour");
		minute = info.getQueryParameters().getFirst("minute");

		stationIdList = new ArrayList<Integer>();
		for (int i = 1; i <= Constant.MAX_STATION_NUMBER; i++) {

			// 駅名が入力されていたらその駅のIDをリストに追加
			String stationId = info.getQueryParameters().getFirst("station" + i);
			if (stationId != null) {
				stationIdList.add(Integer.parseInt(stationId));
			}
		}

	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public String getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(String minute) {
		this.minute = minute;
	}

	/**
	 * @return the stationIdList
	 */
	public List<Integer> getStationIdList() {
		return stationIdList;
	}

	/**
	 * @param stationIdList
	 *            the stationIdList to set
	 */
	public void setStationIdList(List<Integer> stationIdList) {
		this.stationIdList = stationIdList;
	}

}
