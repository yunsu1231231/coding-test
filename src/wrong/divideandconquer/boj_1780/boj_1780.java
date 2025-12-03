package wrong.divideandconquer.boj_1780;

import java.util.*;



public class boj_1780 {
    public static int[][] arr;

    // 이것도 static 선언?
    static int a = 0; // -1
    static int b = 0; // 0
    static int c = 0; // 1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        // 초기화 가정
        go(N,0,0);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    private static void go(int size,int x, int y){
        if(isSame(size,x,y)){
            if(arr[x][y] == -1){
                a++;
            }
            if(arr[x][y] == 0){
                b++;
            }
            if(arr[x][y] == 1){
                c++;
            }
            return;
        }

        int newSize = size / 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                go(newSize, x + (3 * i), y + (3 * j));
            }
        }
    }

    // 같은 수 판단
    private static boolean isSame(int size, int x, int y){
        int a = arr[x][y];
        // 등호 혼돈, 대원칙
        for(int i = x; i < size + x; i++){
            for(int j = y; j < size + y; j++){
                if(a != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}


