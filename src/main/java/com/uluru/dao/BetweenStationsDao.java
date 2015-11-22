package com.uluru.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * Created by nagai on 15/11/12.
 */
public class BetweenStationsDao {

	private final String SELECT_TIME_SQL = "SELECT S1.name AS s1, station_id1 AS id1, S2.name AS s2, station_id2 AS id2, time FROM BETWEEN_STATIONS, STATION AS S1, STATION AS S2 WHERE station_id1 = S1.station_id AND station_id2 = S2.station_id AND S1.name = ? AND S2.name = ?";
	private final String SELECT_TIME_BETWEEN = "SELECT time FROM BETWEEN_STATIONS WHERE station_id1 = ? AND station_id2 = ? ORDER BY time";
	private final String SELECT_NEAR_STATION = "SELECT S1.name AS s1, station_id1 AS id1, S2.name AS s2, station_id2 AS id2, time FROM BETWEEN_STATIONS, STATION AS S1, STATION AS S2 WHERE station_id1 = S1.station_id AND station_id2 = S2.station_id AND S1.name = ? ORDER BY time";
	private final String SELECT_NEAR_STATION_ID = "SELECT station_id2, time FROM BETWEEN_STATIONS WHERE station_id1 = ? ORDER BY time";

	/**
	 * 出発駅と到着駅を引数に受け取って、2駅間の移動にかかる時間を返します。
	 * 検索結果がない場合は-1を返します。
	 * 
	 * @param s1 出発駅
	 * @param s2 到着駅
	 * @return 2駅間の時間が格納されたArrayList<Ineger>インスタンス
	 */
	public ArrayList<Integer> getTime(String s1, String s2) {
		ArrayList<Integer> times = new ArrayList<>();
		
		try (	ConnectionManager con = new ConnectionManager();
				PreparedStatement ps = con.getPreparedStatement(SELECT_TIME_SQL)){
            ps.setString(1, s1);
            ps.setString(2, s2);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
	            while(rs.next()) {
	                times.add(rs.getInt("time"));
	            }
            } else {
            	times.add(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return times;
	}

	/**
	 * ある駅からある駅までの最短所要時間を取得する。
	 *
	 * @param stationId1 駅ID1
	 * @param stationId2 駅ID2
	 * @return 最短所要時間
	 */
	public Integer getTimeBetween(Integer stationId1, Integer stationId2) {
		try ( ConnectionManager con = new ConnectionManager();
			  PreparedStatement ps = con.getPreparedStatement(SELECT_TIME_BETWEEN)) {
			ps.setInt(1, stationId1);
			ps.setInt(2, stationId2);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * ある駅から近い順で駅名を取得する。
	 *
	 * @param stationName 基準駅名
	 * @return 基準駅から近い順の駅リスト
	 */
	public List<String> getNearStation(String stationName) {
		Set<String> nearStationsSet = new LinkedHashSet<>();

		try ( ConnectionManager con = new ConnectionManager();
			  PreparedStatement ps = con.getPreparedStatement(SELECT_NEAR_STATION)) {
			ps.setString(1, stationName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				nearStationsSet.add(rs.getString("s2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> nearStations = new ArrayList<>(nearStationsSet);
		return nearStations;
	}

	/**
	 * ある駅から近い順で駅IDを取得する。
	 *
	 * @param stationId 基準駅ID
	 * @return 基準駅から近い順の駅IDリスト
	 */
	public List<Integer> getNearStation(Integer stationId) {
		List<Integer> nearStations = new ArrayList<>();

		try ( ConnectionManager con = new ConnectionManager();
			  PreparedStatement ps = con.getPreparedStatement(SELECT_NEAR_STATION_ID)) {
			ps.setInt(1, stationId);
			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				nearStations.add(rs.getInt("station_id2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nearStations;
	}

	/**
	 * 駅から各駅まで必要な時間を取得する。
	 * DBが大きくなるとメモリが絶対足りないと思う。
	 *
	 * @param stationIds 出発駅IDリスト
	 * @return 出発駅から各駅までの所要時間
	 */
	public Map<Integer, Map<Integer, Integer>> getTimeTable(List<Integer> stationIds) {
		Map<Integer, Map<Integer, Integer>> timeTable = new LinkedHashMap<>();

		try ( ConnectionManager con = new ConnectionManager();
			  PreparedStatement ps = con.getPreparedStatement(SELECT_NEAR_STATION_ID)) {
			for (Integer id : stationIds) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				Map<Integer, Integer> arriveTime = new LinkedHashMap<>();
				timeTable.put(id, arriveTime);

				while (rs.next()) {
						arriveTime.put(rs.getInt("station_id2"), rs.getInt("time"));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return timeTable;
	}

	/**
	 * 料金を返すメソッドのモック
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int getFare(String s1, String s2) {
		return -1;
	}
}