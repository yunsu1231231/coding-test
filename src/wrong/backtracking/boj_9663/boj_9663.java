package wrong.backtracking.boj_9663;

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
        col = new boolean[N]; // 열
        right = new boolean[2 * N];// 오른쪽 아래 대각선
        left = new boolean[2 * N]; // 왼쪽 아래 대각선

        dfs(0);

        System.out.println(count);
    }

    // depth = 행
    private static void dfs(int depth){
        if(depth == N){
            count++;
            return;
        }

        // 0 based, N = 열
        for(int i = 0; i < N; i++){
            // 1. 놓을 수 있는지 체크 조건
            if(col[i]){
                continue;
            }
            if(left[depth + i]){
                continue;
            }
            // 1. 가능한 범위 2. shift
            if(right[depth - i + (N - 1)]){
                continue;
            }
            col[i] = true;
            right[depth - i + (N - 1)] = true;
            left[depth + i] = true;
            dfs(depth + 1);
            col[i] = false;
            right[depth - i + (N - 1)] = false;
            left[depth + i] = false;
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

// 00 / 10 01/ 20 11 02 // 12 21 // 22   // 왼쪽 아래 대각선

// 문제점
// 1.