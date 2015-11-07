package com.uluru.model;

/**
 * 出発駅ごとの結果クラス
 * @author imazato
 *
 */
public class ResultItem {

	/**
	 * <pre>
	 * 入力された駅番号と対応する番号
	 * 例：駅１に入力されたものは"１"
	 * </pre>
	 */
	private int number;

	/**
	 * 出発駅の名前
	 */
	private String startStationName;

	/**
	 * 運賃
	 */
	private int fare;
	
	/**
	 * 出発時刻
	 */
	private TimeData departureTime;
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the startStationName
	 */
	public String getStartStationName() {
		return startStationName;
	}

	/**
	 * @param startStationName the startStationName to set
	 */
	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	/**
	 * @return the fare
	 */
	public int getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(int fare) {
		this.fare = fare;
	}

	/**
	 * @return the departureTime
	 */
	public TimeData getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(TimeData departureTime) {
		this.departureTime = departureTime;
	}

}
