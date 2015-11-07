package com.uluru.model;

import java.util.List;

/**
 * 検索結果モデル
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
	 * @return the resultStationList
	 */
	public List<ResultItem> getResultStationList() {
		return departureStationList;
	}

	/**
	 * @param resultStationList the resultStationList to set
	 */
	public void setResultStationList(List<ResultItem> resultStationList) {
		this.departureStationList = resultStationList;
	}

}
