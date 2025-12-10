package wrong.implementation.boj_1018;

import java.util.*;

// 32 -> 31 나오는데,, 절대적 좌표로 한 번 더 풀고 + 상대적 좌표 어디가 잘못되었는지 확인
public class boj_1018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++){
            char[] a = sc.next().toCharArray();
            arr[i] = a;
        }

        // think

        // i,j 시작점 -> k,p 전체 좌표 // 시작 i부터 8만큼
        // 그래서 내부에서 판단 => i만큼 엮으로 이동
        int result = 10000;
        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                int count = 0;
                int count2 = 0;
                for(int k = i; k < i + 8; k++){
                    for(int p = j; p < j + 8; p++){
                        if(arr[i][j] == 'B'){
                            if((k - i + p - j) % 2 == 0){
                                if(arr[k][p] == 'W'){
                                    count++;
                                }
                            } else {
                                if(arr[k][p] == 'B'){
                                    count++;
                                }
                            }
                        } else {
                            if((k - i + p - j) % 2 == 0){
                                if(arr[k][p] == 'B'){
                                    count++;
                                }
                            } else {
                                if(arr[k][p] == 'W'){
                                    count++;
                                }
                            }
                        }

                        if(arr[i][j] == 'W'){
                            if((k - i + p - j) % 2 == 0){
                                if(arr[k][p] == 'B'){
                                    count2++;
                                }
                            } else {
                                if(arr[k][p] == 'W'){
                                    count2++;
                                }
                            }
                        } else {
                            if((k- i + p - j) % 2 == 0){
                                if(arr[k][p] == 'W'){
                                    count2++;
                                }
                            } else {
                                if(arr[k][p] == 'B'){
                                    count2++;
                                }
                            }
                        }
                    }
                }
                result = Math.min(result, Math.min(count,count2)); // 기존 result와 비교하지 않음, 마지막 count, count2 두개만 비교함
            }
        }
        System.out.println(result);
    }
}

// 여기서 사고

// 로직
// 다 탐색 가능
// 8*8
// 1. 시작 기준
// 0 1 2  // 10 - 8
// 0 1 2 3 4 5  // 13 - 8 까지,, 포함
// 2. 시작 W 일 때
// 홀, 짝 검사 -> 교체
// 3. 시작 B 일 때
//

// 0 0 / 0 2 / 0 4 0 6 0 8
// 1 1 / 1 3 / 1 5 1 7
// 2 0 / 2 2 / 2 4 2 6

// 0 1 / 0 3 / 0 5
// 1 0 / 1 2 / 1 4