package com.uluru.dao;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by nagai on 15/11/21.
 */
public class BetweenStationsDaoTest {

	/**
	 * 検索結果がある場合
	 */
	@Ignore
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
	 * 運賃を取得できること。
	 */
	@Ignore
	@Test
	public void getFareTest() {
		BetweenStationsDao bsd = new BetweenStationsDao();

		Integer fare = bsd.getFareBetween(1131211, 1131207);
		assertThat(fare, is(0));// 154
	}

	/**
	 * 近い駅名を取得できること。
	 */
	@Ignore
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
	@Ignore
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
	@Ignore
	@Test
	public void getTimeBetweenTest() {
		BetweenStationsDao target = new BetweenStationsDao();

		Integer actual = target.getTimeBetween(1130208, 1130207); // 新宿 to 代々木
		// これ、実行結果から持ってきたのでDBのデータで正しいか微妙なのと、検索時間によって順番変わるならあかん。
		Integer expected = 2;
		assertThat(actual, is(expected));
	}

	/**
	 * 駅リストから各駅までの時間が取得できること。
	 */
	@Ignore
	@Test
	public void getTimeTableTest() {
		BetweenStationsDao target = new BetweenStationsDao();

		Integer[] inputIds = {1130208, 1130210}; // 新宿 to 高田馬場
		List<Integer> input = new ArrayList<>();
		for (Integer id : inputIds) {
			input.add(id);
		}
		Map<Integer, Map<Integer, Integer>> actual = target.getTimeTable(input);

		assertThat(actual.keySet(), contains(inputIds));
		for (Integer id : inputIds) {
			Map<Integer, Integer> arriveTable = actual.get(id);
			List<TestEntry> expecteds = getExpected(id);
			for (TestEntry expected : expecteds) {
				assertThat(arriveTable, hasEntry(expected.key, expected.value));
			}
		}
	}

	private List<TestEntry> getExpected(Integer id) {
		if(id == 1130208) {
			return getExpected1130208();
		} else if(id == 1130210) {
			return getExpected1130210();
		}
		return null;
	}
	private List<TestEntry> getExpected1130208() {
		List<TestEntry> expected = new ArrayList<>();
		expected.add(new TestEntry(1130208, 0));
		expected.add(new TestEntry(1130207, 2));
		expected.add(new TestEntry(1130209, 2));
		expected.add(new TestEntry(1131214, 4));
		expected.add(new TestEntry(1130206, 4));
		expected.add(new TestEntry(1130210, 4));
		expected.add(new TestEntry(1130211, 6));
		expected.add(new TestEntry(1131207, 7));
		expected.add(new TestEntry(1130205, 7));
		expected.add(new TestEntry(1130212, 9));
		return expected;
	}
	private List<TestEntry> getExpected1130210() {
		List<TestEntry> expected = new ArrayList<>();
		expected.add(new TestEntry(1130211, 2));
		expected.add(new TestEntry(1130209, 2));
		expected.add(new TestEntry(1130212, 4));
		expected.add(new TestEntry(1131211, 5));
		expected.add(new TestEntry(1130208, 5));
		expected.add(new TestEntry(1131214, 6));
		expected.add(new TestEntry(1130213, 7));
		expected.add(new TestEntry(1130207, 7));
		expected.add(new TestEntry(1130214, 9));
		expected.add(new TestEntry(1130206, 9));
		return expected;
	}
	public class TestEntry {
		public Integer key;
		public Integer value;

		public TestEntry(Integer k, Integer v) {
			key = k;
			value = v;
		}
	}
}
