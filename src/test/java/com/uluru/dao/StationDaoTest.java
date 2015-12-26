package com.uluru.dao;

import com.uluru.model.Station;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by ukawa on 15/10/24.
 */
public class StationDaoTest{

    /**
     * 駅名から候補駅が取得できること。
     */
    @Test
    public void getCandidateStationTest() {
        StationDao target = new StationDao();
        List<Station> actual = target.getCandidateStation("日暮里");
        Station expected = new Station();
        expected.setId(1130218);
        expected.setName("日暮里");
        expected.setRouteId(11302);
        expected.setRouteName("埼京線"); // Dao未対応のため
        assertThat(actual.get(0), equalTo(expected));
        expected.setId(1130217);
        expected.setName("西日暮里");
        expected.setRouteId(11302);
        expected.setRouteName("埼京線");
        assertThat(actual.get(1), equalTo(expected));
    }

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