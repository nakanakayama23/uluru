package com.uluru.bean;

import java.util.List;

import com.uluru.model.ResultItem;
import com.uluru.model.TimeData;

/**
 * 結果表示画面用Bean
 * 
 * @author imazato
 *
 */
public class ResultBean {

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
	private List<ResultItem> departureStationList;

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
	 * @return the departureStationList
	 */
	public List<ResultItem> getDepartureStationList() {
		return departureStationList;
	}

	/**
	 * @param departureStationList
	 *            the departureStationList to set
	 */
	public void setDepartureStationList(List<ResultItem> departureStationList) {
		this.departureStationList = departureStationList;
	}

}
