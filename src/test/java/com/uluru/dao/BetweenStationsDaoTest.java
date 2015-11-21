package com.uluru.dao;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by nagai on 15/11/21.
 */
public class BetweenStationsDaoTest {

	/**
	 * 検索結果がある場合
	 */
	@Test
	public void getTimeTest01() {
		BetweenStationsDao bsd = new BetweenStationsDao();
		
		ArrayList<Integer> i = bsd.getTime("品川", "新宿");
		assertEquals((int)i.get(0), 20);
	}
	
	/**
	 * 検索結果がない場合
	 */
	@Test
	public void getTimeTest02() {
		BetweenStationsDao bsd = new BetweenStationsDao();
		
		ArrayList<Integer> i = bsd.getTime("大阪", "新宿");
		assertEquals((int)i.get(0), -1);
	}

	/**
	 * 近い駅名を取得できること。
	 */
	@Test
	public void getNearStationTest() {
		BetweenStationsDao target = new BetweenStationsDao();

		List<String> actual = target.getNearStation("新宿");
		// これ、実行結果から持ってきたのでDBのデータで正しいか微妙なのと、検索時間によって順番変わるならあかん。
		String[] expected = {"新宿", "代々木", "新大久保", "原宿", "高田馬場", "中野(東京都)",
				"目白", "渋谷", "四ツ谷", "恵比寿", "池袋", "高円寺", "荻窪"};
		assertThat(actual.subList(0, expected.length), contains(expected));
	}

	/**
	 * 近い駅IDを取得できること。
	 */
	@Test
	public void getNearStationIdTest() {
		BetweenStationsDao target = new BetweenStationsDao();

		List<Integer> actual = target.getNearStation(1131211); // 新宿
		// これ、実行結果から持ってきたのでDBのデータで正しいか微妙なのと、検索時間によって順番変わるならあかん。
		Integer[] expected = {1130208, 1130207, 1130209, 1130206, 1130210, 1130205, 1131207, 1131214, 1130211};
		assertThat(actual.subList(0, expected.length), contains(expected));
	}

	/**
	 * 最短所要時間
	 */
	@Test
	public void getTimeBetweenTest() {
		BetweenStationsDao target = new BetweenStationsDao();

		Integer actual = target.getTimeBetween(1130208, 1130207); // 新宿 to 新大久保
		// これ、実行結果から持ってきたのでDBのデータで正しいか微妙なのと、検索時間によって順番変わるならあかん。
		Integer expected = 2;
		assertThat(actual, is(expected));
	}
}
