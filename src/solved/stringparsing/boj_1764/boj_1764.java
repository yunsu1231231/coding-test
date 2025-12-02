package solved.stringparsing.boj_1764;

import java.util.*;

public class boj_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 3
        int M = sc.nextInt(); // 4
//        List<String> arr = new ArrayList<>();
        HashSet<String> arr = new HashSet<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String a = sc.next();
            arr.add(a);
        }
        for(int i = N + 2; i <= N + M; i++){
            String b = sc.next();
            if(arr.contains(b)){
                result.add(b);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(String name : result){
            System.out.println(name);
        }
    }
}


