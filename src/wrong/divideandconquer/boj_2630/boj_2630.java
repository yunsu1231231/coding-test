package wrong.divideandconquer.boj_2630;

import java.util.*;

public class boj_2630 {
    public static int[][] arr;
    public static int a;
    public static int bb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        go(N,0,0);
        System.out.println(a);
        System.out.println(bb);
    }
    // size = 한 변
    private static void go(int size, int x, int y){
        if(isSame(size,x,y)){
            if(arr[x][y] == 1){
                bb++;
            } else {
                a++;
            }
            return;
        }

        int newSize = size / 2;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                go(newSize,x + newSize * i, y + newSize * j);
            }
        }
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


//go에 대한 정의: 판단하는 함수, 크기, 시작점을 가지고
//
//go가 판단하는 대상 -> 그 매개변수 순간의 스냅샷
//
//-> 호출간의 관계는 x
//
//-> 근데 애초에 이 구조로 설계한 이유가
//
//전체랑 세부랑 로직이 똑같기 때문에
//
//-> 그래서 하나의 상태만 생각하고, 나머지는 게으르게 생각
//
//-> 끝에서 n번째일 때 사고하고 n-1일 때는 따라온다고 생각하면 유리



