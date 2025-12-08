package solved.divideandconquer.boj_1074;

import java.util.*;

public class boj_1074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int size = 1 << N; // 2^N
        System.out.println(z(size, r, c));
    }

    static int z(int size, int r, int c) {
        if (size == 1) return 0;

        int half = size / 2;

        // 1) 왼쪽 위
        if (r < half && c < half) {
            return z(half, r, c);
        }
        // 2) 오른쪽 위
        else if (r < half && c >= half) {
            return half * half + z(half, r, c - half);
        }
        // 3) 왼쪽 아래
        else if (r >= half && c < half) {
            return 2 * half * half + z(half, r - half, c);
        }
        // 4) 오른쪽 아래
        else {
            return 3 * half * half + z(half, r - half, c - half);
        }
    }
}


// 1. size × size 격자에서 (r,c)의 Z 순서를 반환하는 함수
// 2. 그래서 기저 조건과 값 / 절대 trace 추적 x
