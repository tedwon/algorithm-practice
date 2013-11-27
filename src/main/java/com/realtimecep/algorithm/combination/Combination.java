package com.realtimecep.algorithm.combination;

import java.util.Arrays;

/**
 * Combination.
 *
 * <pre>
 * Computes nCr -- all the ways you can combine r choices among n total objects. Unlike
 * permutations, here order does not matter, so {0,1,2} is the same as {0,2,1}.
 * </pre>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class Combination {

  private int n, r;
  private int[] index;
  private boolean hasNext = true;

  public Combination(int[] strings, int r) {
    this.n = strings.length;
    this.r = r;
    index = strings;
  }

  public static void main(String[] args) {
    int[] strings = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Combination p = new Combination(strings, 3);
    while (p.hasNext()) {
      int[] a = p.next();
      System.out.println(Arrays.toString(a));
    }
  }

  // Based on code from KodersCode:
  // The algorithm is from Applied Combinatorics, by Alan Tucker.
  // Move the index forward a notch. The algorithm finds the rightmost
  // index element that can be incremented, increments it, and then
  // changes the elements to the right to each be 1 plus the element on their left.
  //
  // For example, if an index of 5 things taken 3 at a time is at {0 3 4}, only the 0 can
  // be incremented without running out of room. The next index is {1, 1+1, 1+2) or
  // {1, 2, 3}. This will be followed by {1, 2, 4}, {1, 3, 4}, and {2, 3, 4}.

  public boolean hasNext() {
    return hasNext;
  }

  private void moveIndex() {
    int i = rightmostIndexBelowMax();
    if (i >= 0) {
      index[i] = index[i] + 1;
      for (int j = i + 1; j < r; j++) {
        index[j] = index[j - 1] + 1;
      }
    } else {
      hasNext = false;
    }
  }

  public int[] next() {
    if (!hasNext) {
      return null;
    }
    int[] result = new int[r];
    for (int i = 0; i < r; i++) {
      result[i] = index[i];
    }
    moveIndex();
    return result;
  }

  // return int,the index which can be bumped up.
  private int rightmostIndexBelowMax() {
    for (int i = r - 1; i >= 0; i--) {
      if (index[i] < n - r + i) {
        return i;
      }
    }
    return -1;
  }
}
