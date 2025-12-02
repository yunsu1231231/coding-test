package solved.datastructure.boj_1920;

import java.util.*;

public class boj_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            int b = sc.nextInt();
            set.add(b);
        }

        int M = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            arr.add(a);
        }


        for(int i = 0; i < M; i ++){
            if(set.contains(arr.get(i))){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}


// 1. 뒤에 것 정렬
// 4 1 5 2 3

// 1 2 3 4 5
// 1 3 5 7 9

// dict
//

// 리스트 값 조회 -> N / 인덱스 -> 1


// 사고를 해보고 -> 거기서 문제점이 뭔지도 판단하기, 그냥 넘어가는게 아닌
// 1. 순서, index 하나로 묶기 -> 순서가 필요하니깐
// 2. 뒤에 것 정렬

// 3. 정렬 vs dict

