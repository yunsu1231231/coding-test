package wrong.backtracking.boj_15652;

import java.util.*;

public class boj_15652 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        dfs(0, 1);   // depth=0부터, 숫자는 1부터 시작
    }

    private static void dfs(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int x : arr) sb.append(x).append(" ");
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
