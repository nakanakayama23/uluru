package com.uluru.dao;

import com.uluru.model.Station;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ukawa on 15/11/21.
 */
public class StationDao {

	private final String SELECT_STATION_SQL = "SELECT name, station_id, line_id FROM STATION WHERE station_id = ?";

	/**
	 * <pre>
	 * 駅名をもとに、DBから候補駅リストを取得
	 * 例：駅名が「日本橋」の場合、「日本橋（東京）」と「日本橋（大阪）」のリストを返す
	 * </pre>
	 * 
	 * とりあえずDBから駅情報を取ってきた仮定で書いています
	 * 
	 * @return 候補駅リスト
	 */
	public List<Station> getCandidateStation(String stationName) {

		// TODO : 候補駅リストを取得する処理を記述

		List<Station> candidateStationList = new ArrayList<Station>();

		Station station1 = new Station();
		station1.setId(001);
		station1.setName(stationName + "駅（東京）");
		station1.setRouteId(101);
		station1.setRouteName("有楽町線");
		candidateStationList.add(station1);

		Station station2 = new Station();
		station2.setId(002);
		station2.setName(stationName + "駅（大阪府）");
		station2.setRouteId(102);
		station2.setRouteName("ゆりかもめ");
		candidateStationList.add(station2);

		return candidateStationList;
	}

	/**
	 * 駅IDリストをもとに、DBから駅リストを取得
	 * 
	 * @param stationIdList
	 * @return 駅リスト
	 */
	public List<Station> getStationListByIds(List<Integer> stationIdList) {
		List<Station> stationList = new ArrayList<Station>();

		for (int id : stationIdList) {
			Station station = getStationById(id);
			stationList.add(station);
		}

		return stationList;
	}

	/**
	 * 駅IDをもとに、DBから駅情報を取得
	 * 
	 * @param id 駅ID
	 * @return 駅
	 */
	public Station getStationById(int id) {
		Station station = new Station();

		try (	ConnectionManager con = new ConnectionManager();
				 PreparedStatement ps = con.getPreparedStatement(SELECT_STATION_SQL)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				station.setId(rs.getInt("station_id"));
				station.setName(rs.getString("name"));
				station.setRouteId(rs.getInt("line_id"));
				station.setRouteName("埼京線"); // LINE tableとの結合はしてない。
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return station;
	}
}
