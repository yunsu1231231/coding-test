package solved.datastructure.boj_10773;

import java.util.*;

public class boj_10773 {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for(int i = 0; i < K; i++){
            int a = sc.nextInt();
            if(a == 0){
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        int result = 0;

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        System.out.println(result);
    }
}


