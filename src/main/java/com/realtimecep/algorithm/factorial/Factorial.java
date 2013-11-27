package com.realtimecep.algorithm.factorial;

/**
 * Factorial.
 *
 * Recursion & Divide and Conquer (재귀와 분할 정복) <p/>
 *
 * <pre>
 * factorial(n) = n * (n-1) * (n-2) * ... * 1 (if n>0)
 * factorial(n) = n * factorial(n-1) (if n>0)
 * factorial(0) = 1
 * </pre>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class Factorial {

  public static void main(String[] args) {
    int n = 5;
    int nfactorial = new Factorial().factorial(n);

    System.out.println(" = " + nfactorial);
  }

  private int factorial(int n) {

    if (n == 0 || n == 1) {
      System.out.print(1);
      return 1;
    }

    System.out.print(n + " * ");

    return n * factorial(n - 1);
  }
}