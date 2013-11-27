package com.realtimecep.algorithm.permutation;

/**
 * Permutation.
 *
 * <p/>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class LoopPermutation {

  public static void main(String[] args) {

    printPermute(5);

  }

  public static void printPermute(int m) {

    int iters = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= m; j++) {
        for (int k = 1; k <= m; k++) {
          if ((i != j) && (j != k) && (i != k)) {
            System.out.print("[" + i + "," + j + "," + k + "]");

            if ((++iters % 5) == 0) {
              System.out.println();
            }
          }

        }
      }
    }

    System.out.println(m + "_P_3 = " + iters + "개");

  }
}