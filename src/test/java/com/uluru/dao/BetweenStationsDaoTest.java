package com.uluru.dao;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Created by nagai on 15/11/21.
 */
public class BetweenStationsDaoTest {

	@Test
	public void getTimeTest() {
		BetweenStationsDao bsd = new BetweenStationsDao();
		
		ArrayList<Integer> i = bsd.getTime("品川", "新宿");
		assertEquals((int)i.get(0), 20);
	}
	
}
