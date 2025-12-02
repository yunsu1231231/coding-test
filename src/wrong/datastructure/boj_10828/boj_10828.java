package wrong.datastructure.boj_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String d = sc.readLine();
        int N = Integer.parseInt(d);
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String a = sc.readLine();
            String[] b = a.split(" ");
            String fw = b[0];
            if(fw.equals("push")){
                stack.push(b[1]);
            } else if(fw.equals("pop")){
                if(stack.isEmpty()){
                    sb.append("-1").append("\n");
//                    System.out.println("-1");
                    continue;
                }
                sb.append(stack.pop()).append("\n");
//                System.out.println(stack.pop());
            } else if(fw.equals("size")){
                sb.append(stack.size()).append("\n");
//                System.out.println(stack.size());
            } else if(fw.equals("empty")){
                if(stack.isEmpty()){
                    sb.append("1").append("\n");
//                    System.out.println("1");
                } else {
                    sb.append("0").append("\n");
//                    System.out.println(("0"));
                }
            } else if(fw.equals("top")){
                if(stack.isEmpty()){
                    sb.append("-1").append("\n");
//                    System.out.println("-1");
                    continue;
                }
                sb.append(stack.peek()).append("\n");
//                System.out.println(stack.peek());
            }
        }
        System.out.println(sb);


//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sc.nextLine(); // 버퍼 지우기
//        Deque<String> stack = new ArrayDeque<>();
//        for(int i = 0; i < N; i++){
//            String a = sc.nextLine();
//            String[] b = a.split(" ");
//            String fw = b[0];
//            if(fw.equals("push")){
//                stack.push(b[1]);
//            } else if(fw.equals("pop")){
//                if(stack.isEmpty()){
//                    System.out.println("-1");
//                    continue;
//                }
//                System.out.println(stack.pop());
//            } else if(fw.equals("size")){
//                System.out.println(stack.size());
//            } else if(fw.equals("empty")){
//                if(stack.isEmpty()){
//                    System.out.println("1");
//                } else {
//                    System.out.println(("0"));
//                }
//            } else if(fw.equals("top")){
//                if(stack.isEmpty()){
//                    System.out.println("-1");
//                    continue;
//                }
//                System.out.println(stack.peek());
//            }
//        }
    }
}


