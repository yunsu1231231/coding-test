package wrong.stringparsing.boj_9012;

import java.util.*;

public class boj_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String a = sc.next();
            char[] arr = a.toCharArray();
            findTest(arr);
        }
    }
    // 여기서 계속 String <-> char 혼선
    public static void findTest(char[] arr){
        Deque<String> stack = new ArrayDeque<>();
        for(char cur : arr){
            if(cur == '('){
                stack.push(String.valueOf(cur));
                // 실패 조건 재정의: 비어 있는데 pop 하려고 할 때
            } else if (cur == ')') { // 1. ) 가 들어왔다
                if(!stack.isEmpty()){
                    if(stack.peek().equals("(")){ // 2. 스택이 비어 있지 않으면 pop
                        stack.remove();
                    }
                } else {
                    System.out.println("NO");
                    return;
                }
//                if(stack.isEmpty()){ // 3. 그리고 pop 이후 스택이 비어있는지를 검사 => 이 순서면 정상 문자열도 스택이 비기 때문에 실패 판정
//                    System.out.println("NO");
//                    return;
//                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

//public class boj_9012 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for(int i = 0; i < T; i++){
//            String a = sc.next();
//            char[] arr = a.toCharArray();
//            findTest(arr);
//        }
//    }
//    // 여기서 계속 String <-> char 혼선
//    public static void findTest(char[] arr){
//        Queue<String> queue = new ArrayDeque<>();
//        for(char cur : arr){
//            if(cur == '('){
//                queue.offer(String.valueOf(cur));
//            } else if (cur == ')') {
//                if(!queue.isEmpty()){
//                    if(queue.peek().equals("(")){
//                        queue.remove();
//                    }
//                }
//            }
//        }
//        if(!queue.isEmpty()){
//            System.out.println("NO");
//        } else {
//            System.out.println("YES");
//        }
//    }
//}



// 로직
// 1. 입력, ( 이면 push, ) 이면 pekk 했을 때 pop, 근데 그 때 비어있으면 즉시 fail, 다 끝나고 이후 남아있으면 fail = (( 상황
