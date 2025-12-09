package cheatsheets.chp2.divideandconquer;

import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        dfs(0, 1);
    }

    // 깊이에 따라 1 ~ N 중 하나를 선택하는 함수 -> 그 경로로 진행
    private static void dfs(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}




