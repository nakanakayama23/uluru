package com.uluru.service;

import java.util.ArrayList;
import java.util.List;

import com.uluru.dao.StationDao;
import com.uluru.model.InputStationItem;
import com.uluru.model.Station;

/**
 * 駅情報を操作するクラス
 * 
 * @author imazato
 *
 */
public class StationService {

	StationDao stationDao = new StationDao();

	public List<InputStationItem> findInputStationItemList(List<String> inputStationList, List<String> errorMessages) {
		List<InputStationItem> inputStationItemList = new ArrayList<InputStationItem>();

		for (int i = 0; i < inputStationList.size(); i++) {
			String stationName = inputStationList.get(i);
			InputStationItem stationItem = findInputStationItem((i + 1), stationName, errorMessages);
			inputStationItemList.add(stationItem);
		}

		return inputStationItemList;
	}

	public InputStationItem findInputStationItem(int inputNumber, String stationName, List<String> errorMessages) {
		InputStationItem stationItem = new InputStationItem();
		stationItem.setNumber(inputNumber);

		List<Station> candidateStationList = findCandidateStationList(stationName);
		stationItem.setStationList(candidateStationList);

		if (candidateStationList.size() == 0) {
			errorMessages.add("駅" + inputNumber + "が見つかりません");
		}

		return stationItem;
	}

	public List<Station> findCandidateStationList(String stationName) {
		return stationDao.getCandidateStation(stationName);
	}

}
