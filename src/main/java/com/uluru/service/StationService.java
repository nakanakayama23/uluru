package com.uluru.service;

import java.util.ArrayList;
import java.util.List;

import com.uluru.dao.StationDao;
import com.uluru.model.InputStationItem;
import com.uluru.model.Result;
import com.uluru.model.ResultItem;
import com.uluru.model.Station;
import com.uluru.model.TimeData;

/**
 * 駅情報を操作するクラス
 * 
 * @author imazato
 *
 */
public class StationService {

	StationDao stationDao = new StationDao();

	/**
	 * 入力されたすべての駅の情報リストを取得する
	 * 
	 * @param inputStationList
	 *            入力された駅名のリスト
	 * @param errorMessages
	 *            エラーメッセージリスト
	 * @return 入力された駅の情報リスト
	 */
	public List<InputStationItem> findInputStationItemList(List<String> inputStationList, List<String> errorMessages) {
		List<InputStationItem> inputStationItemList = new ArrayList<InputStationItem>();

		for (int i = 0; i < inputStationList.size(); i++) {
			String stationName = inputStationList.get(i);
			InputStationItem stationItem = findInputStationItem((i + 1), stationName, errorMessages);
			inputStationItemList.add(stationItem);
		}

		return inputStationItemList;
	}

	/**
	 * 駅の情報を取得する
	 * 
	 * @param inputNumber
	 *            入力画面における番号（例：駅１のテキストボックスに入力された場合は“1”）
	 * @param stationName
	 *            駅名
	 * @param errorMessages
	 *            エラーメッセージリスト
	 * @return 駅情報
	 */
	private InputStationItem findInputStationItem(int inputNumber, String stationName, List<String> errorMessages) {
		InputStationItem stationItem = new InputStationItem();
		stationItem.setNumber(inputNumber);

		List<Station> candidateStationList = findCandidateStationList(stationName);
		stationItem.setStationList(candidateStationList);

		if (candidateStationList.size() == 0) {
			errorMessages.add("駅" + inputNumber + "が見つかりません");
		}

		return stationItem;
	}

	/**
	 * 引数とする駅名から、その候補となる駅のリストを取得する
	 * 
	 * @param stationName
	 *            駅名
	 * @return 候補となる駅のリスト
	 */
	private List<Station> findCandidateStationList(String stationName) {
		return stationDao.getCandidateStation(stationName);
	}

	/**
	 * 各駅の中間地点を検索する
	 * 
	 * @param stationIdList
	 *            駅のIDリスト
	 * @return 検索結果
	 */
	public Result searchUluruSpot(List<Integer> stationIdList) {
		List<Station> stationList = stationDao.getStationListByIds(stationIdList);

		// TODO : 中間地点を検索する処理を記述

		// それぞれの出発駅について、結果情報（出発時間、運賃など）のリストを作成
		List<ResultItem> resultItemList = new ArrayList<ResultItem>();
		for (int i = 0; i < stationList.size(); i++) {
			Station station = stationList.get(i);

			ResultItem resultItem = new ResultItem();
			resultItem.setNumber(i + 1);
			resultItem.setDepartureStationName(station.getName());
			TimeData time = new TimeData();
			time.setDate("2016", "01", "01");
			time.setTime("15", "26");
			resultItem.setDepartureTime(time);
			resultItem.setFare(120);

			resultItemList.add(resultItem);
		}
		
		// 検索結果のオブジェクトを作成
		Result result = new Result();
		result.setDestinationStationName("集合駅");
		result.setResultStationList(resultItemList);

		return result;
	}

}
