package com.uluru.dao;

import com.uluru.model.Station;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ukawa on 15/11/21.
 */
public class StationDao {

	private final String SELECT_STATION_SQL = "SELECT name, station_id, line_id FROM STATION WHERE station_id = ?";
	private final String CANDIDATE_STATION_SQL = "SELECT name, station_id, line_id FROM STATION WHERE name LIKE ?";

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

		List<Station> candidateStationList = new ArrayList<Station>();

		try (	ConnectionManager con = new ConnectionManager();
				 PreparedStatement ps = con.getPreparedStatement(CANDIDATE_STATION_SQL)){
			ps.setString(1, "%" + stationName + "%");
			ResultSet rs = ps.executeQuery();

			Set<String> registerStation = new HashSet<String>();
			while (rs.next()) {
				if (registerStation.add(rs.getString("name"))) {
					Station station = new Station();
					station.setId(rs.getInt("station_id"));
					station.setName(rs.getString("name"));
					station.setRouteId(rs.getInt("line_id"));
					station.setRouteName("埼京線"); // LINE tableとの結合はしてない。
					candidateStationList.add(station);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

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
