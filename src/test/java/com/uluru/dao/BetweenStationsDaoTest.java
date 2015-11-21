package com.uluru.dao;

import static org.junit.Assert.*;
import java.util.ArrayList;
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
	
}
