package com.uluru.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uluru.model.InputStationItem;
import com.uluru.model.TimeData;

@XmlRootElement
public class ConfirmBean {
	
	/**
	 * 集合時間
	 */
	private TimeData meetingTime;
	
	/**
	 * 入力駅リスト
	 */
	private List<InputStationItem> inputStationItemList;

	/**
	 * @return the meetingTime
	 */
	@XmlElement
	public TimeData getMeetingTime() {
		return meetingTime;
	}

	/**
	 * @param meetingTime the meetingTime to set
	 */
	public void setMeetingTime(TimeData meetingTime) {
		this.meetingTime = meetingTime;
	}

	/**
	 * @return the inputStationItemList
	 */
	@XmlElement
	public List<InputStationItem> getInputStationItemList() {
		return inputStationItemList;
	}

	/**
	 * @param inputStationItemList the inputStationItemList to set
	 */
	public void setInputStationItemList(List<InputStationItem> inputStationItemList) {
		this.inputStationItemList = inputStationItemList;
	}

}
