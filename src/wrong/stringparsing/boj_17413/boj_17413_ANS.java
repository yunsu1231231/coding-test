package wrong.stringparsing.boj_17413;

import java.io.*;
import java.util.*;

public class boj_17413_ANS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // 단어 뒤집기용
        boolean inTag = false; // 태그 안 여부

        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);

            // 1. 태그 시작
            if(c == '<'){
                // 기존 단어 정리
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
                inTag = true;
                result.append(c);
            } else if (c == '>') {
                // 2. 태그 끝
                inTag = false;
                result.append(c);
            } else if (inTag){
                // 3. 태그 안
                result.append(c);
            } else {
                // 4. 태그 밖
                // 5. 공백이면 단어 종료
                if(c == ' '){
                    while(!stack.isEmpty()){
                        result.append(stack.pop());
                    }
                    result.append(c);
                } else {
                    // 6. 단어 문자
                    stack.push(c);
                }
            }
        }
        // 마지막 단어 처리: 루프 안에서 상태를 완결시키는 조건 -> 루프 종료 시 그 트리거를 못 만난 경우에 대한 점검 인지
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }
}

// 순서 기준: "지금 문자"를 어떻게 해석해야 되는지에 대한 우선권
// 상태를 바꾸는 조건이 상태에 의존적인 조건보다 우선
