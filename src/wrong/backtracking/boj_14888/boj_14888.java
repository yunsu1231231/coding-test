package wrong.backtracking.boj_14888;

import java.util.*;

import java.io.*;

// 이후 다시 풀어보기
public class boj_14888 {
    static int total;
    static Point[] b;
    static int[] a;
    static char[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rb.readLine());
        StringTokenizer st = new StringTokenizer(rb.readLine());
        a = new int[N];
        b = new Point[4]; // index 0 = +, 1 = -, 2 = *, 3 = /
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(rb.readLine());
        total = 0;
        // 가변일 때 찾아보기
        for(int i = 0; i < 4; i++){
            int num = Integer.parseInt(st.nextToken());
            total += num;
            if(i == 0){
                b[i] = new Point('+',num);
            }
            if(i == 1){
                b[i] = new Point('-',num);
            }
            if(i == 2){
                b[i] = new Point('*',num);
            }
            if(i == 3){
                b[i] = new Point('/',num);
            }
        }
        result = new char[total];

        comb(0);

        // 조합
        // + + - * / 있을 때 -> 순서
        // for문 vs 탐색
        // 글로 써보기 = for 문으로 하나를 고르면 = 그 다음것을 못고르게는 구현을 못하나, 다음 indxt만 되고?
    }
    // 각 단계별로 하나씩 고르고 -> 그 다음에는 그게 못고르게 차감
    private static void comb(int depth) {
        if(depth == total){
            // 2 + 3 + 3 + 4 * 5 -> 이 하나의 경우를 어떻게 만들지?

            // 2 3 3 4 5
            for(int b : a){
                // + + * /
                for(char i : result){

                }
            }
        }
        for(int i = 0; i < 4; i++){
            if(b[i].remain != 0){
                result[depth] = b[i].name;
                b[i].remain = b[i].remain - 1;
            }
            comb(depth + 1);
        }
    }
}

class Point{
    char name;
    int remain;

    Point(char name, int remain){
        this.name = name;
        this.remain = remain;
    }
}





