package solved.stringparsing.boj_2002;

import java.util.*;
import java.io.*;

public class boj_2002 {
    static String[] arr;
    static Deque<String> queue;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        arr = new String[a];
        for(int i = 0; i < a; i++){
            arr[i] = br.readLine();
        }
        queue = new ArrayDeque<>();
        for(int i = 0; i < a; i++){
            queue.add(br.readLine());
        }
        count = 0;
        dfs();
        if(count == 1){
            System.out.println(1);
        } else {
            System.out.println(count - 1); // 끝은 판단 불가능
        }
//        while(!queue.isEmpty()){
//            dfs();
//            for(String now : arr){
//                String aaa = queue.remove();
//                if(aaa.equals(now)){
//                    continue;
//                } else {
//                    count++;
//                    // 다시 코드블록 처음.. for 배열을 넘어가지 않은 상태에서 -> 이게 어떻게 되지..?
//                }
//            }
//        }
    }
    private static void dfs(){
        if(queue.isEmpty()){
            return;
        }

        for(String now : arr){
            if(!queue.isEmpty()){
                String aaa = queue.remove();
                if(aaa.equals(now)){
                    continue;
                } else {
                    count++;
                    dfs();
                    // 다시 코드블록 처음.. for 배열을 넘어가지 않은 상태에서 -> 이게 어떻게 되지..?
                }
            }
        }
    }
}

// 재귀..?  // A

// ->
// 입구   출구
// 대근   영식

// 로직 / 조건에 따른 분기
// 1 2 3 4

// A 하나를 해도 + 오늘 더 x
// 인지 + 이후 + 일단 다 A aaa A
// A
// A a a
// A

// 1. 대근 기준 비어있을 때 까지
// 4 1 2 3
// 2. 다르면 추가
// 3. 같으면 빼고 -> 다음

// 1. 종속성 -> 메타인지

//ZG508OK
//PU305A
//RI604B
//ZG206A
//ZG232ZF

//PU305A 1
//ZG232ZF 2
//ZG206A 3
//ZG508OK
//RI604B