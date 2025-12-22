package solved.dp.boj_9095;

import java.util.*;

public class boj_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i = 0; i < a; i++){
            int b = sc.nextInt();
            if(b <= 2){
                if(b == 0){
                    System.out.println(0);
                    continue;
                } else if (b == 1){
                    System.out.println(1);
                    continue;
                } else {
                    System.out.println(2);
                    continue;
                }
            }
            logic(b); // 3 이상일때만
        }
    }
    private static void logic(int b){
        int[] dp = new int[b + 1]; // 0 based
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= b; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        System.out.println(dp[b]);
    }
}

// 0 1 2 3
// 0 // 0 => 0도 하나의 경우의수임을 간과
// 1 // 1
// 1 1, 0 2 // 2
// 1 2, 1 1 1, 2 1, 0 3 // 3


