package com.uluru.dao;

import org.junit.Test;

/**
 * Created by ukawa on 15/10/24.
 */
public class StationDaoTest{

    @Test
    public void testTest1() throws Exception {
        System.out.println("test run");
        StationDao target = new StationDao();
        target.testDbAccess();
    }
}