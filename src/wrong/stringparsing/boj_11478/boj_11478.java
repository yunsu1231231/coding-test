package wrong.stringparsing.boj_11478;

import java.util.*;

public class boj_11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        Set<String> s = new HashSet<>();
        int l = a.length(); // length() api를 순간 망각

        // 시작
        for(int i = 0; i < l; i++){
            for(int j = 1; j <= l - i ; j++){
                String now = a.substring(i, i + j);
                s.add(now);
            }
        }

        System.out.println(s.size());


//        // indexoutofbound -> 근본 사고의 문제점:
//        // 각 for문의 변수의 의미를 어떻게 해석할지 유무: 짤라서
//        for(int i = 0; i < l; i++){
//            for(int j = 1; j <= l; j++){
//                a.substring(i,i + j);
//            }
//        }



//        int j = 0;
//        int k = 0;
//        while(l >= 1){
//            for(int i = 0; i < l; i++){
//                int m = j;
//                StringBuilder sb = new StringBuilder();
//                while(j >= 0){
//                    for(int p = 0; p <= j; p++){
//                        sb.append(arr[i + p]);
//                    }
//                    j--;
//                }
//                s.add(new String(sb));
//                j = m;
////                System.out.println("추적:" + sb);
//            }
//            k++;
//            l--;
//            j = k;
//        }
//        System.out.println(s.size());
    }
}

// 문자열 분리
// 1. 인덱스 기준 -> substring()
// 2. 구분자 기준 -> split()

