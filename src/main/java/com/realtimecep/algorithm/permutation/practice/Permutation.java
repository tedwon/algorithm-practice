package com.realtimecep.algorithm.permutation.practice;

/**
 * <p/>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class Permutation {

  public static void main(String[] args) {

    String[] strings = {"1", "2", "3"};
    int r = 3;
    permutate(strings, r);
  }

  public static void permutate(String[] strings, int r) {

    int n = strings.length;

    if (r == 1) {
      for (String str : strings) {
        System.out.print(str + ", ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < n; i++) {
      swap(strings, i, r - 1);
      permutate(strings, r - 1);
      swap(strings, i, r - 1);
    }
  }

  // swap the characters at indices i and j
  private static void swap(String[] strings, int i, int j) {
    String c;
    c = strings[i];
    strings[i] = strings[j];
    strings[j] = c;
  }
}
