package wrong.stringparsing.boj_11478;

import java.util.*;

// 1) 1 ~ 5 1개씩, 1 ~ 4, 2개씩, 1 ~ 3 3개씩.. 순회 로직 최적화
// 2) 중복처리
// 3) -> 뭘 사고하지 못했는지,, 이 부분 다시 한 번 복기

public class boj_11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        Set<String> s = new HashSet<>();
        int l = arr.length; // 5
        int j = 0;
        int k = 0;
        while(l >= 1){
            for(int i = 0; i < l; i++){
                int m = j;
                StringBuilder sb = new StringBuilder();
                while(j >= 0){
                    for(int p = 0; p <= j; p++){
                        sb.append(arr[i + p]);
                    }
                    j--;
                }
                s.add(new String(sb));
                j = m;
//                System.out.println("추적:" + sb);
            }
            k++;
            l--;
            j = k;
        }
        System.out.println(s.size());
    }
}





// 로직
// n * 2

// 직접 다 순회
// => 여기서 사고


