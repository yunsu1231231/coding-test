package solved.divideandconquer.boj_2447;

import java.util.*;

public class boj_2447 {
    public static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];

        // 시간초과 -> 먼저 채우기
        for(int i = 0; i < N; i++){
            Arrays.fill(arr[i], '*');
        }

        go(N,0,0);
//        System.out.println(Arrays.deepToString(arr));
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(arr[i]);
            sb.append('\n');
        }

        System.out.print(sb);

    }
    // size: 한 변의 길이, x, y
    public static void go(int size,int x, int y){
        if(size == 1){
            return; // O(N² × 재귀 depth)
        }

        int newSize = size / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j ==1){
                    blank(newSize,x + i * newSize,y + j * newSize);
                } else {
                    go(newSize,x + i * newSize,y + j * newSize);
                }
            }
        }
    }

    public static void blank(int size, int x, int y){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                arr[i][j] = ' ';
            }
        }
    }
}

//import java.util.*;
//
//public class Main {
//    public static char[][] arr;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int size = (int)Math.pow(3,N);
//        arr = new char[size][size]; // 배열을 만들면 -> 기하급수적으로 증가 + 메모리 초과
//        for(int i = 0; i< arr.length; i++){
//            Arrays.fill(arr[i],'*');
//        }
//        StringBuilder sb = new StringBuilder();
//
//        go(size,0,0);
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j < arr[0].length; j++){
//                sb.append(arr[i][j]);
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);
////        StringBuilder sb = new StringBuilder();
////        sb.append(Arrays.deepToString(arr));
////        System.out.println(sb);
//
//    }
//    private static void go(int size, int x, int y){
//        if(size == 1){
//            return;
//        }
//        int newSize = size / 3;
//        for(int i = 0; i < 3; i++){
//            for(int j = 0; j < 3; j++){
//                if(i == 1 && j == 1){
//                    blank(newSize,x + newSize,y + newSize);
//                } else {
//                    go(newSize,x + newSize * i, y + newSize * j);
//                }
//            }
//        }
//    }
//
//    private static void blank(int size, int x, int y){
//        for(int i = x; i < x + size; i++){
//            for(int j = y; j < y + size; j++){
//                arr[i][j] = ' ';
//            }
//        }
//    }
//}

// 2문제 -> 백지 review -> 이후

// 크기가 고정이면 무조건 배열? 아니면 arr vs list 각 장단점
// 그냥 고정: 배열 / 가변: 리스트

// 배열 String vs char 선언 // 문자일 때
// char: 2바이트 // String: 동적


// 기저 조건
// 문제를 계속 쪼개다가, 더 이상 쪼개지지 않는 가장 작은 문제에서 정답을 직접 계산