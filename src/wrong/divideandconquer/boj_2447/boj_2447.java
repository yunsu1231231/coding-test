package wrong.divideandconquer.boj_2447;

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

// 1. https://chatgpt.com/c/692f9a32-a5c0-8323-845b-3d7219625691
// 2. 오늘 commit 전 다시 풀고 + 복기