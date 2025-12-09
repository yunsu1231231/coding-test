package cheatsheets.chp2.test.kbc.q_1;

import java.util.*;

// 3개 -> 2개 -> 1개 // 포함값 로직 추가해서 사고는 이후 한 번 더 하기.

public class Main {
    public static void main(String[] args) {

        int[] arr = {1,1,2,3,4,5};

        // 1단계: 6개 중 3개 뽑기
        List<List<Integer>> comb3 = comb(arr, 3);

        for (List<Integer> c3 : comb3) {
            System.out.println("3개 선택: " + c3);

            int[] left1 = leftover(arr, c3);

            // 2단계: leftover에서 2개 뽑기
            List<List<Integer>> comb2 = comb(left1, 2);

            for (List<Integer> c2 : comb2) {
                System.out.println("  2개 선택: " + c2);

                int[] left2 = leftover(left1, c2);

                // 3단계: leftover에서 1개 뽑기
                List<List<Integer>> comb1 = comb(left2, 1);

                for (List<Integer> c1 : comb1) {
                    System.out.println("    1개 선택: " + c1);
                }
            }
        }
    }

    // 1) List로 leftover를 모두 모은다
    // 2) size가 정해지면 그때 배열로 바꾼다
    static int[] leftover(int[] arr, List<Integer> selected) {
        List<Integer> temp = new ArrayList<>();
        for (int x : arr) {
            if (!selected.contains(x)) {
                temp.add(x);
            }
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) res[i] = temp.get(i);
        return res;
    }

    static List<List<Integer>> comb(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(arr, k, 0, temp, result);
        return result;
    }

    static void dfs(int[] arr, int k, int start, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            dfs(arr, k, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}



