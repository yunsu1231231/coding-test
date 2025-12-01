package wrong.stringparsing.boj_9251;

import java.util.*;

public class boj_9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        char[] aa = a.toCharArray(); // 0 based
        char[] bb = b.toCharArray(); // 0 based
        int[][] dp = new int[a.length() + 1][b.length() + 1]; // 1 based
        // dp.length와 dp[0].length가 다를 수 있는데, 같은 범위로 초기화 -> 범위 초과 발생
//        for(int i = 0; i < dp.length; i++){
//            dp[i][0] = 0;
//            dp[0][i] = 0;
//        }

        for(int i = 0; i <= a.length(); i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= b.length(); j++){
            dp[0][j] = 0;
        }

        // dp 배열 1 based => i,j 자체가 1 based: 데이터 정합성 고려
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(aa[i-1] == bb[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a = sc.next();
//        String b = sc.next();
//        int[][] dp = new int[a.length() + 1][b.length() + 1];
//        char[] aa = a.toCharArray();
//        char[] bb = b.toCharArray();
//
//        for(int i = 0; i < dp.length; i++){
//            dp[i][0] = 0;
//            dp[0][i] = 0;
//        }
//        // 시작 인덱스 혼선
//        for(int i = 1; i < dp.length; i++){
//            for(int j = 1; j < dp.length; j++){ // dp[0].length
//                if(aa[i] == bb[j]){ // aa[i-1] == bb[j-1]
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1; // dp[i-1][j-1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        System.out.println(dp[a.length()][b.length()]);
//    }
}



// 왜 dp인지:
// dp[][]