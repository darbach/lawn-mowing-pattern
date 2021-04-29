package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LawnMowerTest {

  @ParameterizedTest(name = "[{index}]Asserting isMowable({0}) == {1}")
  @MethodSource("edu.cnm.deepdive.LawnMowerTestSource#isMowable")
  void isMowable(int[][] input, boolean expected) {
    assertEquals(expected, LawnMower.isMowable(input));
  }

}