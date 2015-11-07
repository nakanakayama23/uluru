package com.uluru.model;

import java.util.List;

/**
 * 入力駅クラス
 * 
 * @author imazato
 *
 */
public class InputStationItem {

	/**
	 * <pre>
	 * 入力された駅番号と対応する番号
	 * 例：駅１に入力されたものは"１"
	 * </pre>
	 */
	private int number;

	/**
	 * <pre>
	 * 候補駅リスト
	 * 駅が一意に確定する場合は要素数１。
	 * 同じ名前の駅が複数存在する場合は、その候補リスト。
	 * </pre>
	 */
	private List<Station> stationList;

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
	 * @return the station
	 */
	public List<Station> getStationList() {
		return stationList;
	}

	/**
	 * @param station the station to set
	 */
	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

}