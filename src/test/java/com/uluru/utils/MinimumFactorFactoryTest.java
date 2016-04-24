package com.uluru.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by ukawa on 16/04/02.
 */
public class MinimumFactorFactoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwException() {
        expectedException.expect(IllegalArgumentException.class);
        MinimumFactorFactory.createMinimumFactor(0);
    }

    @Test
    public void createVarTest() {
        MinimumFactor actual = MinimumFactorFactory.createMinimumFactor(MinimumFactorFactory.VAR);
        assertThat(actual, instanceOf(MinimumFactor.VarFactor.class));
    }

    @Test
    public void createMinMaxTest() {
        MinimumFactor actual = MinimumFactorFactory.createMinimumFactor(MinimumFactorFactory.MINMAX);
        assertThat(actual, instanceOf(MinimumFactor.MinMaxFactor.class));
    }
}
