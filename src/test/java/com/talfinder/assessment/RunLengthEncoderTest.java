package com.talfinder.assessment;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RunLengthEncoderTest {

  @Parameters
  public static Collection<Object[]> parameters() {
    return Arrays.asList(new Object[][] {
        {"abc", "a1b1c1"},
        {"aaabaaa", "a3b1a3"},
        {"mmmrrrqqqpsssssmmm", "m3r3q3p1s5m3"},
        {"rrrssttssrrr", "r3s2t2s2r3"},
        {"hhhaaarrssshhhaa", "h3a3r2s3h3a2"},
        {"xyzzyxxyz", "x1y1z2y1x2y1z1"}
    });
  }

  private String input;
  private String expectedValue;

  public RunLengthEncoderTest(String input, String expectedValue) {
    this.input = input;
    this.expectedValue = expectedValue;
  }

  @Test
  public void encodeString() {
    Assert.assertEquals("input:" + input , expectedValue, RunLengthEncoder.encode(input));
  }
}