package resolved.stringparsing.boj_1316;

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

