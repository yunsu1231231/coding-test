package solved.backtracking.boj_9663;

import java.util.*;

public class boj_9663 {
    static boolean[] col;
    static boolean[] right;
    static boolean[] left;
    static int N;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new boolean[N]; // 1 based
        right = new boolean[N * 2];
        left = new boolean[N * 2];
        dfs(0);
        System.out.println(count);
    }

    // 깊이 당 하나씩 고르고 -> 끝 도달: + 1
    private static void dfs(int depth){
        if(depth == N){
            count++;
            return;
        }
        // based 대원칙
        for(int i = 0; i < N; i++){
            // 1. 중복 처리
            if(col[i]){
                continue;
            }
            if(left[depth + i]){
                continue;
            }
            if(right[-(depth - i) + N ]){
                continue;
            }
            // 2. 방문 처리 -> 다음 dfs
            col[i] = true;
            left[depth + i] = true;
            right[-(depth - i) + N ] = true;
            dfs(depth + 1);
            col[i] = false;
            left[depth + i] = false;
            right[-(depth - i) + N ] = false;
        }
    }
}

// 1. 놓을 수 있는지 체크하는 조건
// 2.


// (r,c) -> 이게 인자 or 로직 / 판단 기준

// N N N
// N N N
// N N N

// 순서를 / 위로 통일

// N - (depth - i + 1)

// 0      1          2        3    4
// 20 / 10 01 / 00 11 22 / 01 12 / 02  오른쪽 아래 대각선

// -(depth - i) + N // 2 ~ -2

// 00 / 10 01/ 20 11 02 // 12 21 // 22   // 왼쪽 아래 대각선

// 문제점
// 1.