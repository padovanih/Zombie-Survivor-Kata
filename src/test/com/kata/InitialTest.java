package com.kata;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class InitialTest {

    @Test
    public void shouldSumFirstToSecondArgument() {
        Initial test = new Initial();
        Assert.assertEquals(5, test.sum(1, 4));
    }
}
