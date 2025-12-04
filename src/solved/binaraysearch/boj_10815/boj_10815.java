package solved.binaraysearch.boj_10815;

import java.util.*;

public class boj_10815 {
    public static int[] arrN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arrN = new int[N];
        for(int i = 0; i < N; i++){
            arrN[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arrM = new int[M];
        for(int i = 0; i < M; i++){
            arrM[i] = sc.nextInt();
        }
        Arrays.sort(arrN);

        // 1. 대상이 되는 것을 순회해야 되는데: 초반에 반대로 구현
        for(int target: arrM){
            binary(target);
        }
    }

    private static void binary(int target){
        int start = 0;
        int end = arrN.length - 1;

        while(start <= end){
            int mid = (end + start) / 2; // 2. mid 더하는 부분 1차 실수

            if(arrN[mid] == target){
                System.out.print("1" + " ");
                return;
            } else if(arrN[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.print("0" + " ");
        return;
    }
}


// 바깥 루프에 대한 안쪽 이분탐색 -> nlog(n)