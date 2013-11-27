package com.realtimecep.algorithm.permutation.practice;

/**
 * <p/>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class Permutation2 {

  public static void main(String[] args) {

    String[] strings = {"1", "2", "3"};
    int r = 3;
    permutate(strings, r);
  }

  public static void permutate(String[] strings, int r) {
    permutate("", strings, r);
  }

  public static void permutate(String prefix, String[] strings, int r) {

    if (r == 0) {
      System.out.println(prefix);
      return;
    }

    for (int i = 0; i < r; i++) {
      // 0 ~ i
      // i + 1 ~ r
//      permutate(prefix + strings[i], , );
    }
  }

}
