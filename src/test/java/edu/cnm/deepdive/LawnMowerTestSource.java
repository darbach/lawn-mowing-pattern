package edu.cnm.deepdive;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LawnMowerTestSource {

  static Stream<Arguments> isMowable() {
    return Stream.of(
        Arguments.of(new int[][]{new int[]{2, 1}, new int[]{1, 2}}, false),
        Arguments.of(new int[][]{new int[]{2, 1, 2}, new int[]{1, 1, 1}}, true)
    );
  }
}
