package wrong.backtracking.boj_15650;

import java.util.*;

public class boj_15650 {
    public static int N;
    public static int M;
    public static int[] arr; // 1. arr는 DFS에서 "하나의 경로에 대해" depth번째에 선택한 숫자를 저장하는 배열
    public static void main(String[] args) {
//        for(int i = 1; i <= 4; i++){
//            for(int j = i + 1; j <= 4; j++){
//                System.out.println(i + " " + j);
//            }
//        }

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        dfs(0,1);
    }

    // 깊이에서 1 ~ N 선택 후 이후 선택은 무조건 그 이후부터
    private static void dfs(int depth, int start){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i : arr){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = start; i <= N; i++){
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
