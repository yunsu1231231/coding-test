package resolved.implementation.boj_4673;

import java.util.*;

public class boj_4673 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < 10000; i++){
            String a = String.valueOf(i);
            makeD(a,set);
        }

        for(int i = 1; i < 10000; i++){
            if(!set.contains(i)){
                System.out.println(i);
            }
        }
    }

    public static void makeD(String a, Set<Integer> set){
        // 55
        int bb = Integer.parseInt(a); // 이전
        String[] b = a.split("");
        for(String now : b){
            bb += Integer.parseInt(now);
        }
        set.add(bb);
    }
}


// 로직
// 1. String으로 다 돌려서 + 모든 숫자 다 생성
// 2 set에 넣고
// 3. 10000부터 다시 loop 돌려서 없으면 -> 출력

// 1 ~ 10000 전부 다 검사 // 그럼 1 set만 해도 될 듯..?