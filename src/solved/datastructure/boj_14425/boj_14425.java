package solved.datastructure.boj_14425;

import java.util.*;

public class boj_14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            String a = sc.next();
            set.add(a);
        }
        int result = 0;

        for(int i = 0; i < M; i++){
            String b = sc.next();
            if(set.contains(b)){
                result++;
            }
        }
        System.out.println(result);
    }
}
