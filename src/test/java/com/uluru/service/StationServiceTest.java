package com.uluru.service;

import com.uluru.model.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ukawa on 15/11/21.
 */
public class StationServiceTest {
    @Test
    public void searchUluruSpotTest() {
        StationService target = new StationService();
        List<Integer> input = new ArrayList<>();
        input.add(1130208);
        input.add(1130210);
        Result actual = target.searchUluruSpot(input);

        assertThat(actual.getDestinationStationName(), is("新大久保"));
    }
}
