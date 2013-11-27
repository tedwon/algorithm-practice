package com.realtimecep.algorithm.combination.practice;

import java.lang.reflect.Array;

/**
 * Combination.
 *
 * 경우의 수 - 순열과 조합 (順列 - 組合 permutation, combination)<p/>
 * <pre>
 * nCr = n! / (n-r)! * r!
 *
 * 조합은 순서를 생각하지 않고 단지 선택만 한다.
 * 순서에 관계 없이 원소가 같으면 같은 경우로 본다.
 * </pre>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class Combination {

  public static void main(String[] args) {
    String set = "1,2,3,4,5,6";
    String[] strings = set.split(",");
    int size = strings.length;
    for (int combination = 0; combination < size; combination++) {
      generateSubSet(strings, combination);
    }
  }

  private static void generateSubSet(String[] strings, int combination) {
    for (int sourceIndex = 0; sourceIndex < strings.length; sourceIndex++) {
      String string = strings[sourceIndex];
      if (combination == 0) {
        concat(string);
      } else {
        for (int targetIndex = sourceIndex + 1; targetIndex < strings.length - combination + 1;
             targetIndex++) {
          Object[] objects = subarray(strings, targetIndex, targetIndex + combination);
          concat(string, (String[]) objects);
        }
      }
    }
  }

  private static void concat(String key, String[] values) {
    System.out.println(key + "," + arrayToString(values));
  }

  private static void concat(String value) {
    System.out.println(value);
  }

  public static <T> T[] subarray(final T[] array, int startIndexInclusive, int endIndexExclusive) {
    if (array == null) {
      return null;
    }
    if (startIndexInclusive < 0) {
      startIndexInclusive = 0;
    }
    if (endIndexExclusive > array.length) {
      endIndexExclusive = array.length;
    }
    final int newSize = endIndexExclusive - startIndexInclusive;
    final Class<?> type = array.getClass().getComponentType();
    if (newSize <= 0) {
      @SuppressWarnings("unchecked") // OK, because array is of type T
      final T[] emptyArray = (T[]) Array.newInstance(type, 0);
      return emptyArray;
    }
    @SuppressWarnings("unchecked") // OK, because array is of type T
    final
    T[] subarray = (T[]) Array.newInstance(type, newSize);
    System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
    return subarray;
  }

  public static String arrayToString(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    StringBuffer sbuf = new StringBuffer();
    sbuf.append(strs[0]);
    for (int idx = 1; idx < strs.length; idx++) {
      sbuf.append(",");
      sbuf.append(strs[idx]);
    }
    return sbuf.toString();
  }
}
