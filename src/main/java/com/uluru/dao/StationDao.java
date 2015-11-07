package com.uluru.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uluru.model.Station;

/**
 * Created by ukawa on 15/10/24.
 */
public class StationDao {
	/**
	 * PostgreSQLにアクセスし、表を作って削除するテスト用クラス DB:hellodbを用意。
	 */
	public void testDbAccess() {
		Connection db = null; // DB接続オブジェクト
		Statement st = null; // SQL文オブジェクト
		ResultSet rs = null; // 問合せ結果オブジェクト

		String url = "jdbc:postgresql:hellodb"; // URL
		String usr = "postgres"; // ユーザ名
		String pwd = "passw0rd";

		try {
			Class.forName("org.postgresql.Driver");

			// データベース接続
			System.out.println("Connecting to " + url);
			db = DriverManager.getConnection(url, usr, pwd);
			st = db.createStatement();

			// 表の作成
			st.executeUpdate("create table hellotbl (item varchar(16))");

			// データの登録
			st.executeUpdate("insert into hellotbl values ('Hello world!')");
			st.executeUpdate("insert into hellotbl values ('ようこそ！')");

			// データの検索
			rs = st.executeQuery("select * from hellotbl");
			if (rs != null) {
				while (rs.next()) {
					String item = rs.getString("item");
					System.out.println(item);
				}
			}
			rs.close();

			// 表の削除
			st.executeUpdate("drop table hellotbl");

			// データベース切断
			st.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	 * @param id
	 * @return 駅
	 */
	private Station getStationById(int id) {
		Station station = new Station();

		// TODO : IDから駅情報を取得する処理を記述

		station.setId(id);
		station.setName("出発駅");
		station.setRouteId(0);
		station.setRouteName("埼京線");

		return station;
	}
}
