package solved.dp.boj_2839;

import java.util.*;

public class boj_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        // 1. dp 배열
        int[] dp = new int[a + 6]; // index = 킬로, 값 = 최소 개수,, 0 based
        for(int i = 0; i <= 2; i++){
            dp[i] = 5000;
        }
        dp[3] = 1;
        dp[4] = 5000;
        dp[5] = 1;
        // 2. dp 초기화
        for(int i = 6; i <= a; i++){
            dp[i] = Math.min(dp[i-3],dp[i-5]) + 1;
        }
        if(dp[a] >= 5000){
            System.out.println("-1");
        } else{
            System.out.println(dp[a]);
        }
    }
}

// 정석풀이 한 번 보기




