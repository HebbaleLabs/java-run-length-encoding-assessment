package com.talfinder.assessment;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class RunLengthEncoderTest {

  @Test
  public void encodeEmptyString() {
    String encodedValue = RunLengthEncoder.encode("");
    assertThat(encodedValue, is(equalTo("")));
  }

  @Test
  public void encodeSingleCharacters() {
    String encodedValue = RunLengthEncoder.encode("a");
    assertThat(encodedValue, is(equalTo("a1")));

    encodedValue = RunLengthEncoder.encode("b");
    assertThat(encodedValue, is(equalTo("b1")));

    encodedValue = RunLengthEncoder.encode("m");
    assertThat(encodedValue, is(equalTo("m1")));

    encodedValue = RunLengthEncoder.encode("y");
    assertThat(encodedValue, is(equalTo("y1")));

    encodedValue = RunLengthEncoder.encode("z");
    assertThat(encodedValue, is(equalTo("z1")));
  }

  @Test
  public void encodeStringWithUniqueCharacters() {
    String encodedValue = RunLengthEncoder.encode("abc");
    assertThat(encodedValue, is(equalTo("a1b1c1")));

    encodedValue = RunLengthEncoder.encode("mnopq");
    assertThat(encodedValue, is(equalTo("m1n1o1p1q1")));

    encodedValue = RunLengthEncoder.encode("uvwxyz");
    assertThat(encodedValue, is(equalTo("u1v1w1x1y1z1")));
  }

  @Test
  public void encodeStringWithSequentialCharacters() {
    String encodedValue = RunLengthEncoder.encode("aaa");
    assertThat(encodedValue, is(equalTo("a3")));

    encodedValue = RunLengthEncoder.encode("aaabbc");
    assertThat(encodedValue, is(equalTo("a3b2c1")));

    encodedValue = RunLengthEncoder.encode("mnnooo");
    assertThat(encodedValue, is(equalTo("m1n2o3")));
  }

  @Test
  public void encodeStringWithMultipleSequentialCharacters() {
    String encodedValue = RunLengthEncoder.encode("aaabaaa");
    assertThat(encodedValue, is(equalTo("a3b1a3")));

    encodedValue = RunLengthEncoder.encode("rrrssttssrrr");
    assertThat(encodedValue, is(equalTo("r3s2t2s2r3")));
  }
}