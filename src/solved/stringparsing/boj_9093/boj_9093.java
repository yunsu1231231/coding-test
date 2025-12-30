package solved.stringparsing.boj_9093;

import java.util.*;

public class boj_9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < a; i++){
            StringBuilder sb = new StringBuilder();
            Deque<Character> stack = new ArrayDeque<>();
            String now = sc.nextLine();
            String[] arr = now.split(" ");
            for(String n : arr){
                char[] b = n.toCharArray();
                for(char nn : b){
                    stack.push(nn);
                }
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}



