package com.uluru.utils;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ukawa on 16/04/02.
 */
public class MinimumFactorTest {
    @Test
    public void zeroVarTest() {
        MinimumFactor target = new MinimumFactor.VarFactor();
        assertThat(target.getValue(), is(Double.MAX_VALUE));
    }

    @Test
    public void someVarTest() {
        MinimumFactor target = new MinimumFactor.VarFactor();
        target.addItem(50);
        target.addItem(60);
        target.addItem(70);
        target.addItem(70);
        target.addItem(100);
        assertThat(target.getValue(), is(280.0));
    }

    @Test
    public void zeroMinMaxTest() {
        MinimumFactor target = new MinimumFactor.MinMaxFactor();
        assertThat(target.getValue(), is(Double.MAX_VALUE));
    }

    @Test
    public void someMinMaxTest() {
        MinimumFactor target = new MinimumFactor.MinMaxFactor();
        target.addItem(50);
        target.addItem(60);
        target.addItem(70);
        target.addItem(70);
        target.addItem(101);
        assertThat(target.getValue(), is(51.0));
    }

}
