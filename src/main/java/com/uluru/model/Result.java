package com.uluru.model;

import java.util.List;

/**
 * 結果クラス
 * 
 * @author imazato
 *
 */
public class Result {

	/**
	 * 集合駅の名前
	 */
	private String destinationStationName;

	/**
	 * 集合時間
	 */
	private TimeData meetingTime;
	
	/**
	 * 出発駅ごとの結果リスト
	 */
	private List<ResultItem> resultStationList;

	/**
	 * @return the destinationStationName
	 */
	public String getDestinationStationName() {
		return destinationStationName;
	}

	/**
	 * @param destinationStationName
	 *            the destinationStationName to set
	 */
	public void setDestinationStationName(String destinationStationName) {
		this.destinationStationName = destinationStationName;
	}

	/**
	 * @return the meetingTime
	 */
	public TimeData getMeetingTime() {
		return meetingTime;
	}

	/**
	 * @param meetingTime
	 *            the meetingTime to set
	 */
	public void setMeetingTime(TimeData meetingTime) {
		this.meetingTime = meetingTime;
	}

	/**
	 * @return the resultStationList
	 */
	public List<ResultItem> getResultStationList() {
		return resultStationList;
	}

	/**
	 * @param resultStationList the resultStationList to set
	 */
	public void setResultStationList(List<ResultItem> resultStationList) {
		this.resultStationList = resultStationList;
	}

}
