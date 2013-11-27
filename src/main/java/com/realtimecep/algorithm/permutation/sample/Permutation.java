package com.realtimecep.algorithm.permutation.sample;

import java.util.ArrayList;

/**
 * <p/>
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 0.1.0
 * @since 0.1.0
 */
public class Permutation {

  // n : 전체 원소의 개수
  // picked : 지금까지 고른 원소의 개수
  // isPick : 이전에 선택된 원소인지 저장하고있는 변수
  // n개의 원소의 모든 순열을 구하는 방법
  int n = 2;

  public static void main(String[] args) {

    ArrayList<Integer> picked = new ArrayList<Integer>();
    picked.add(1);
    picked.add(2);
    picked.add(3);

    boolean isPick[] = new boolean[10];

    new Permutation().permutation(picked, isPick);
  }

  private void permutation(ArrayList<Integer> picked, boolean isPick[]) {
    // 기저사례 : 모든 개수를 뽑아냈다.
    if (picked.size() == n) {
      System.out.println(picked);
      return;
    }

    for (int next = 0; next < n; next++) {
      if (isPick[next]) {
        continue;
      }

      picked.add(next);
      isPick[next] = true;

      permutation(new ArrayList<Integer>(picked), isPick);

      picked.remove(picked.size() - 1);
      isPick[next] = false;
    }
  }
}
