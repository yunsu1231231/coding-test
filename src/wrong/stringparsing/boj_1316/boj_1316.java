package wrong.stringparsing.boj_1316;

import java.util.*;

public class boj_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int count = a;
        for(int i = 0; i < a; i++){
            String b = sc.next();
            char[] aaa = b.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            System.out.println(map);
            for(int j = 0; j < aaa.length; j++){
                if (!map.containsKey(aaa[j])) {
                    map.put(aaa[j], j);
                    continue;
                }
                int cur = map.get(aaa[j]);
                if (j != cur + 1){
                    count--;
                    break;
                }
//                map.putIfAbsent(aaa[j],j);
                map.put(aaa[j],j);
            }
        }
        System.out.println(count);
    }
}

// 사고 / A => 이게 안되면 A / 일단 다 배제 / 인지 / 이후 / 일단 다 배제
// 앞뒤넘기ㅗㄱ 누수 감수

// 설계부터

// 딕셔너리로 관리 -> set으로 가능? 바로 중복이 제거되어서 안되나?

// 1. 이전값을 저장 -> 어떻게? => 이 방식대로 진행해보면

// 1. 각각 for loop 돌면서
// 2. 딕셔너리에 index 값 추가
// 3. 추가될 때 기존 값이랑 추가된 index 값이랑 1차이가 아니면 -> 바로 예외 // putifAbsent
// 4. 끝까지 도달하면 count 추가

// 사고 -> 이게 안되면 / A / 같은 실수 반복 x
//