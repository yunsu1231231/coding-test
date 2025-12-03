package wrong.divideandconquer.boj_4779;

import java.util.*;

public class boj_4779 {
    public static char[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 여러개일 때
        while (sc.hasNextInt()) {
            int N = sc.nextInt();

            int size = (int)Math.pow(3, N);
            a = new char[size];
            Arrays.fill(a, '-');

            go(size, 0);

            System.out.println(new String(a));
        }
//        int N = sc.nextInt();
//        int size = (int)Math.pow(3,N);
//        a = new char[size];
//        Arrays.fill(a,'-');
//        go(size,0);
//        StringBuilder sb = new StringBuilder();
//        for(char now : a){
//            sb.append(now);
//        }
//        System.out.println(sb);
    }

    private static void go(int size, int x){
        if(size == 1) {
            return;
        }
        int newSize = size / 3;
        go(newSize,x);
        erase(newSize, x + newSize);
        go(newSize,x + newSize * 2);
    }

    private static void erase(int size, int x){
        for(int i = x; i < x + size; i++){
            a[i] = ' ';
        }
    }
}


// 1. 다 돌면 터지고 + 구간에 대한 제외 찾기
// 2. 리스트 Arrays.fill 처럼 초기화

// 함수 정의: 3등분 중 중간을 없애는 함수
// 인자:

// 1. 1이면 반환
// 2. 1이 아니면 -> 3으로 나눠서 // 2번째 구간은 제거 -> 1, 3번째 구간을 다시 탐색

// 1. hasNext(): 다음 토큰이 있기만 하면 true
// 2. hasNextInt(): 다음 토큰이 int로 읽을 수 있으면 true
// 3. hasNextDouble(): double이 가능할 때 true

