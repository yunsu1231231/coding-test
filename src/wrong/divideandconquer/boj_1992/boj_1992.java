package wrong.divideandconquer.boj_1992;

import java.util.*;

public class boj_1992 {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        // 입력 최적화
        for(int i = 0; i < N; i++){
            String[] a = sc.next().split("");
            for(int j = 0; j < a.length; j++){
                arr[i][j] = Integer.parseInt(a[j]);
            }
        }
        go(N,0,0);

        System.out.println(sb);
    }

    // 함수 정의: 나눌 필요가 없으면 -> 문자열에 append
    // 나눠야 되면 -> 4분할로 나눠서 -> 다시 로직을 수행
    private static void go(int size, int x, int y){
        if(isSame(size,x,y)){
            sb.append(arr[x][y]);
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        go(newSize,x,y);
        go(newSize,x,y + size / 2);
        go(newSize,x + size / 2, y);
        go(newSize,x + size / 2, y + size / 2);
        sb.append(")");
    }
    private static boolean isSame(int size, int x, int y){
        int a = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(a != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

// 추론 x / 사고
// 핵심은: 동작은 모든 함수가 다 독립적 -> 재귀는 따라오는 것: 재귀를 먼저 고려 x

// 함수 정의: 나눌 필요가 없으면 -> 문자열에 append
// 나눠야 되면 -> 4분할로 나눠서 -> 다시 로직을 수행
// 그 전체에서 닫기