package wrong.implementation.boj_1018;

//import java.util.*;
//
//public class boj_1018 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt(); // 행
//        int M = sc.nextInt(); // 열
//        // 배열 vs 리스트, 배열일 때 String vs char 대원칙
//        char[][] arr = new char[N][M]; // 0 based
//        for(int i = 0; i < N; i++){
//            String a = sc.next();
//            char[] cur = a.toCharArray();
//            arr[i] = cur;
//        }
//        // i = 행
//        int result = Integer.MAX_VALUE;
//        for(int i = 0; i <= N - 8; i++){
//            for(int j = 0; j <= M - 8; j++){
//                // i, j 시작 기점
////                int count = 0;
//                char[][] cur = new char[8][8];
//                for(int k = i; k <= i + 7; k++){
//                    for(int p = j; p <= j + 7; p++){
//                        // k,p는 이제 각 변수
//                        cur[k-i][p-j] = arr[k][p];
//                    }
//                }
//                int countB = 0;
//                int countW = 0;
//
//                if(cur[0][0] == 'B'){
//                    // l = 행, ll = 열
//                    for(int l = 0; l <= 7; l++){
//                        for(int ll = 0; ll <=7; ll++){
//                            if((l + ll) % 2 ==0){
//                                if(cur[l][ll] != 'B'){
//                                    countB++;
//                                }
//                                if(cur[l][ll] != 'W'){
//                                    countW++;
//                                }
//                            } else {
//                                if(cur[l][ll] != 'W'){
//                                    countB++;
//                                }
//                                if(cur[l][ll] != 'B'){
//                                    countW++;
//                                }
//
//                            }
//                        }
//                    }
//                }
//                result = Math.min(result, Math.min(countB, countW);
//            }
//        }
//        System.out.println(result);
//    }
//}



// 로직에 대한 사고

// 1. 체스판을 고르고
// 2. 다시 칠해야 되는 최소 개수
// 다 계산 가능

// 50 50

// 1 ~ 42
// 1 ~ 42

// 1600 * 2 * 8 * 8 = 140 * 1600 = 1500 150 = 225000

// 바둑판 판단 기준
// 1. 0번째 B일 떄

// 2. 0번쨰 W일 떄

// 구분선
// 1. 문제 조건 max, min -> 오류가 났을 때 점검 태도도 일관되게 정리
// 2.
// (x + y) % 2 == 0 → 시작색
//
//(x + y) % 2 == 1 → 반대색
// 잘못된 규칙을 기준으로 조건문을 만든 것