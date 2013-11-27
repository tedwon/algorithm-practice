package com.realtimecep.algorithm.permutation.princeton;

/**
 * <p/>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */

/**
 * ********************************************************************** Compilation:  javac
 * Permutations.java Execution:    java Permutations N
 *
 * Enumerates all permutations on N elements. Two different approaches are included.
 *
 * % java Permutations 3 abc acb bac bca cab cba
 *
 * ***********************************************************************
 */

public class Permutations {

  // print N! permutation of the characters of the string s (in order)
  public static void perm1(String s) {
    perm1("", s);
  }

  private static void perm1(String prefix, String s) {
    int N = s.length();
    if (N == 0) {
//      System.out.println(prefix);
    } else {
      for (int i = 0; i < N; i++) {
        System.out.println(s.substring(0, i) + " + " + s.substring(i + 1, N));
        perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N));
      }
    }

  }

  // print N! permutation of the elements of array a (not in order)
  public static void perm2(String s) {
    int N = s.length();
    char[] a = new char[N];
    for (int i = 0; i < N; i++) {
      a[i] = s.charAt(i);
    }
    perm2(a, N);
  }

  private static void perm2(char[] a, int n) {
    if (n == 1) {
      System.out.println(a);
      return;
    }
    for (int i = 0; i < n; i++) {
      swap(a, i, n - 1);
      perm2(a, n - 1);
      swap(a, i, n - 1);
    }
  }

  // swap the characters at indices i and j
  private static void swap(char[] a, int i, int j) {
    char c;
    c = a[i];
    a[i] = a[j];
    a[j] = c;
  }

  public static void main(String[] args) {

    String elements = "123";
    perm1(elements);
    System.out.println();
//    perm2(elements);
  }
}
