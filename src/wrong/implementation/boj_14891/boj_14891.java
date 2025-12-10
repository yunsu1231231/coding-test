package wrong.implementation.boj_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14891 {
    private static int[] a; // 1
    private static int[] bb; // 2
    private static int[] ccc; // 3
    private static int[] dddd; // 4

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(b.readLine());
        a = new int[8];
        for(int i = 0; i < 8; i++){ // 가변일 때 !while 형태 문법 한 번 확인
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(b.readLine());
        bb = new int[8];
        for(int i = 0; i < 8; i++){
            bb[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(b.readLine());
        ccc= new int[8];
        for(int i = 0; i < 8; i++){
            ccc[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(b.readLine());
        dddd= new int[8];
        for(int i = 0; i < 8; i++){
            dddd[i] = Integer.parseInt(st.nextToken());
        }
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for(int i = 0; i < K; i++){
            List<List<Integer>> arr = new ArrayList<>(); // 1 based
            arr.add(new ArrayList<>()); // 빈 배열
            arr.add(new ArrayList<>(Arrays.asList(0,a[2])));
            arr.add(new ArrayList<>(Arrays.asList(bb[6],bb[2])));
            arr.add(new ArrayList<>(Arrays.asList(ccc[6],ccc[2])));
            arr.add(new ArrayList<>(Arrays.asList(dddd[2],0)));

            int number = sc.nextInt();
            int go = sc.nextInt();
            logicLeft(number,go,arr);
            logicRight(number,go,arr);
        }
    }

    // 현재 탐색 톱니바퀴에서 go 방향 회전시 전체 배열을 변경하는 함수, 한 번의 이동만
    private static void logicLeft(int start, int go,List<List<Integer>> arr){
        if(start -1 < 0){
            return;
        }
        int cur = arr.get(start).get(0);
        int next = arr.get(start - 1).get(1);
        if(cur != next){
            return;
        }
        // 1. 다음것만 바꾸고 // 근데 배열이여서 너무 변경이 어려운데...
        // 2. 다음 재귀에 맡기기

    }

    // 현재 탐색 톱니바퀴에서 go 방향 회전시 전체 배열을 변경하는 함수, 한 번의 이동만
    private static void logicRight(int start, int go,List<List<Integer>> arr){
        if(start + 1 > 4){
            return;
        }
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

