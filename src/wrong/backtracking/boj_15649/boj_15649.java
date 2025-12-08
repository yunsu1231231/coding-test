package wrong.backtracking.boj_15649;

import java.util.*;

public class boj_15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
    }

    private static void dfs(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int a : arr){
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

// depth가 가변 -> 그래서 for문 불가능


// 1. 내 스스로 구현
// 2. 템플렛 암기