package wrong.backtracking.boj_15651;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_15651 {
    public static int N;
    public static int M;
    public static int arr[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        dfs(0);
        bw.flush();   // 출력 누락 → 오답
    }

    // 깊이에 따라 1 ~ N 중 하나를 선택하는 함수
    private static void dfs(int depth) throws IOException{
        if(depth == M){
            for(int i = 0; i < M; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}


