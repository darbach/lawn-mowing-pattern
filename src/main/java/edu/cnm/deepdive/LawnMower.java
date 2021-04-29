package edu.cnm.deepdive;

import java.util.Arrays;

/**
 * Your employer has purchased a programmable lawnmower. Your task is not to program it, however,
 * but to determine whether a desired pattern of grass heights can be mowed, subject to the
 * limitations of the lawnmower. In short, these limitations are:
 *
 *     - The lawnmower can only be used on rectangular lawns.
 *
 *     - It can only mow in straight, rectilinear (i.e parallel or perpendicular to the rectangle’s
 *     sides) paths that go directly from one of the four sides of the lawn directly to the opposite
 *     side.
 *
 *     - The height of the cutting blade can be set prior to each straight-line pass over the lawn;
 *     it can’t be changed in the middle of a mowing pass.
 *
 *     - The width of each mowing pass is 1 meter.
 *
 * Your specific task will be to implement a method that takes an int[][] heights (i.e. a
 * 2-dimensional array of int values) as an input parameter. These represent the desired grass
 * heights (in cm) on 1 m2 patches of lawn, where the total dimensions of the lawn (in meters) are
 * heights.length X heights[0].length.
 *
 * Your code must return a boolean value from the method, indicating whether the lawn can be mowed
 * to the desired heights, subject to the above restrictions.
 *
 * For example, we might have
 *
 * int[][] heights = {
 *     {2, 1},
 *     {1, 2}
 * }
 *
 * This represents a 2m X 2m lawn (pretty small), where the desired heights form a checkerboard
 * pattern of 1cm and 2cm. However, since the lawnmower makes complete passes from one side of the
 * lawn to the other, we can easily see that there’s no way to cut both the NE and SW patches to a
 * height of 1cm, without also cutting either the NW patch or the SE patch to a height of 1cm as
 * well.
 *
 * On the other hand, we could have
 *
 * int[][] heights = {
 *     {2, 1, 2},
 *     {1, 1, 1}
 * }
 *
 * This pattern is feasible, with three passes of the lawnmower:
 *
 *     1. From NW to NE, at a height of 2cm.
 *     2. From SW to SE, at a height of 1cm.
 *     3. From N to S, in the center, at a height of 1cm.
 */
public abstract class LawnMower {

  /**
   * Determine whether the programmable lawn mower can successfully mow the requested grass heights
   * of a rectangular lawn with full sweeps from edge-to-edge and without changing the blade height
   * during a sweep.
   *
   * @param heights The required grass heights. The 2-d array must be even lengths on all sides.
   * @return Whether the mower can successfully mow this pattern
   */
  public static boolean isMowable(int[][] heights) {
    boolean mowable = true;
    int[] rowMax = new int[heights.length];
    int[] colMax = new int[heights[0].length];
    Arrays.fill(rowMax, Integer.MIN_VALUE);
    Arrays.fill(colMax, Integer.MIN_VALUE);
    for (int row = 0; row < heights.length; row++) {
      for (int col = 0; col < heights[row].length; col++) {
        int value = heights[row][col];
        rowMax[row] = Math.max(value, rowMax[row]);
        colMax[col] = Math.max(value, colMax[col]);
      }
    }
    for (int row = 0; row < heights.length; row++) {
      for (int col = 0; col < heights[row].length; col++) {
        int value = heights[row][col];
        if (value < rowMax[row] && value < colMax[col]) {
          mowable = false;
          break;
        }
      }
    }
    return mowable;
  }

}
