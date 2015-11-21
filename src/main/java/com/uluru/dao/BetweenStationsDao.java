package com.uluru.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by nagai on 15/11/12.
 */
public class BetweenStationsDao {
	
	private final String CONNECTION_URL = "jdbc:mysql://160.16.94.166:54321/ULURU_DB?useUnicode=true&characterEncoding=utf8";
	private final String DB_USER = "uluru";
	private final String DB_PASS = "Mysql/Uluru";
	
	private final String SELECT_TIME_SQL = "SELECT S1.name AS s1, station_id1 AS id1, S2.name AS s2, station_id2 AS id2, time FROM BETWEEN_STATIONS, STATION AS S1, STATION AS S2 WHERE station_id1 = S1.station_id AND station_id2 = S2.station_id AND S1.name = ? AND S2.name = ?";
	
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
		
		try (	Connection con = DriverManager.getConnection(CONNECTION_URL,DB_USER,DB_PASS);
				PreparedStatement ps = con.prepareStatement(SELECT_TIME_SQL)){
            ps.setString(1, s1);
            ps.setString(2, s2);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
	            while(rs.next()) {
	                times.add(rs.getInt("time"));
	            }
            } else {
            	times.add(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return times;
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