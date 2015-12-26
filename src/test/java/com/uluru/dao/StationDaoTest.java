package com.uluru.dao;

import com.uluru.model.Station;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by ukawa on 15/10/24.
 */
public class StationDaoTest{

    /**
     * 駅IDから駅情報が取得できること。
     */
    @Test
    public void getStationTest() {
        StationDao target = new StationDao();
        Station actual = target.getStationById(1130208);
        Station expected = new Station();
        expected.setId(1130208);
        expected.setName("新宿");
        expected.setRouteId(11302);
        expected.setRouteName("埼京線"); // Dao未対応のため
        assertThat(actual, equalTo(expected));
    }
}