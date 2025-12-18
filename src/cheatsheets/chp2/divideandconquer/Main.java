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


// 1. 사고 -> 뭘 골랐는지 어떻게 알지 / 사고


// 하나를 해도 사고 + 부족함 누수는 태도로
// A 사고 연습 + 이후
// 일단 큰 틀 + 세부 복기는 이후 + 이후 언어 미정 + A aaa A
