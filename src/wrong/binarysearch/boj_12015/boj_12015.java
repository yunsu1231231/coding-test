package wrong.binarysearch.boj_12015;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // LIS ‘길이’를 구하기 위한 최적 끝값 목록
        // 자료형에 대한 명확한 의미 <-> 조건과 대응
        ArrayList<Integer> lis = new ArrayList<>();

        for(int x : arr){
            int pos = Collections.binarySearch(lis,x); // List<T> 형태만 가능

            if(pos < 0){
                pos = -pos - 1; // -a - 1 형태로 반환되기 때문에
            }

            // 해당 위치에 값 갱신
            if(pos == lis.size()){
                lis.add(x);
            } else {
                lis.set(pos,x);
            }
        }
        System.out.println(lis.size());


    }
}




// int여도 언제 String으로 사용하는지 -> 그 부분 정리
// 데이터 묶을 때 tuple vs dict
