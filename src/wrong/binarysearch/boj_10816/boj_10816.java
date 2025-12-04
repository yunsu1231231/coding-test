package wrong.binarysearch.boj_10816;

import java.util.*;

public class boj_10816 {
    public static int[] arrN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arrN = new int[N];
        for(int i = 0; i < N; i++){
            arrN[i] = sc.nextInt();
        }
        Arrays.sort(arrN);

        // -10 -10 2 3 3 6 7 10 10 10

        int M = sc.nextInt();
        int[] arrM = new int[M];
        for(int i = 0; i < M; i++){
            arrM[i] = sc.nextInt();
        }

        for(int target: arrM){
            int c = ubinary(target) - lbinary(target);
            System.out.print(c + " ");
        }
        // int[] -> String 가장 손쉬운 방법?
    }

    private static int ubinary(int target){
        int result = arrN.length;
        int start = 0;
        int end = arrN.length - 1;

        while(start <= end){
            int mid = (end + start) / 2;

            if(arrN[mid] > target) {
                result = Math.min(result,mid);
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int lbinary(int target){
        int result = arrN.length; // 타겟이 없을 때 -> 배열 끝이 첫 번째 위치
        int start = 0;
        int end = arrN.length - 1;

        while(start <= end){
            int mid = (end + start) / 2;

            if(arrN[mid] >= target) {
                result = Math.min(result,mid);
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}

// int[] -> String 가장 손쉬운 방법?
// int[] arr = {1,2,3,4};
// String s = Arrays.toString(arr);
// String s = Strings.valueOf(arr);

// 입력 떄문에 시간초과 -> 이후 수정
