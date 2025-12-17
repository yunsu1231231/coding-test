package wrong.implementation.boj_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14891 {
    static int[][] arr = new int[4][8];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++){
            String s = br.readLine();
            for(int ii = 0; ii < 8; ii++){
                arr[i][ii] = s.charAt(ii) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; // 2
            int dir = Integer.parseInt(st.nextToken()); // -1
            int[] direction = new int[4];
            direction[num] = dir; // 0 1 -1 1
            // 왼쪽 전파
            for(int j = num; j > 0; j--){
                if(arr[j][6] != arr[j - 1][2]){
                    direction[j - 1] = -direction[j];
                } else {
                    break;
                }
            }
            // 오른쪽
            for(int j = num; j < 3; j++){
                if(arr[j][2] != arr[j + 1][6]){
                    direction[j + 1] = -direction[j];
                } else {
                    break;
                }
            }
            // 실제 회전
            for(int j = 0; j < 4; j++){
                if(direction[j] == 1){
                    rotateRight(j);
                } else if (direction[j] == -1){
                    rotateLeft(j);
                }
            }
        }
        // 총 합
        System.out.println(arr[0][0] + arr[1][0] * 2 + arr[2][0] * 4 + arr[3][0] * 8);

    }
    // 채워넣는 순서도 -> 끝에서부터
    static void rotateRight(int cur){
        int[] now = arr[cur];
        int temp = now[7];
//        for(int i = 1; i <= 7; i++){
//            now[i] = now[i-1];
//        }
        for(int i = 7; i >= 1; i--){
            now[i] = now[i-1];
        }
        now[0] = temp;

        arr[cur] = now;
    }

    static void rotateLeft(int cur){
        int[] now = arr[cur];
        int temp = now[0];
//        for(int i = 7; i >= 1; i--){
//            now[i - 1] = now[i];
//        }
        for(int i = 0; i < 7; i++){
            now[i] = now[i + 1];
        }
        now[7] = temp;

        arr[cur] = now;
    }
}

// 톱니 숫자 = 1 based
// 각 방향 = 0 based

// 2 ,  6 2,  6 2, 6 -> 고정인데 항마다 크기가 달라도 list인가? 배열로 안되나?
//             int[] List<Integer> watch = new int[4]; 불가능?

// 예시로 흐름 파악 / 사고

// 3 - 1 이면
// 0. 시작 기준으로 전파를 하다가
// 1. 맞닿아있는 index 값 비교 서로끼리
// -> 하나라도 끊기면 -> index 비교하지 않고 그냥 움직임 x
// 2. 다르면 이동 -> 근데 이동 관점에서는 queue지만 이게 index 비교 위해서는 배욜로 관리
// 배점으로

// 파생될 때 큰 흐름이 머리에 안그려지네
// 회전하면 -> 크기가 또 바뀌고
// 이게 사고가 전체가 안짜여짐

// 정확한 순서와 분기
// 1. 3번째면 -> 6,2 판단 / 회전이 아니므로 if 크기 제한
// 2. 변화가 있으면 -> 그 다음 변화 기준 그 다음 것 또 탐색 / 끊기면 더 탐색 x => 이걸 어떻게 하지

// 음..

