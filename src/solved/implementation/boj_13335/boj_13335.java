package solved.implementation.boj_13335;

import java.util.*;

public class boj_13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int w = sc.nextInt(); int L = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int add = 0;
        int i = 0;
        while(true){
            // 5. 종료 조건: 모든 트럭이 다리에 올라갔다.
            // 실제 조건: 모든 트럭이 다리에 건넜다 + 순서 변경
            if(i >= n){
                break;
            }

            // 2. 분기문에 대한 명확한 인지: 다리가 아직 꽉 차거나, 차지 않으면 동작
            if(q.size() != w){ // 1. 예시로 사고 -> 하드코딩 실수

                // 트럭이 남아있으면 올리고 + 다 올렸으면 끝내기 -> 트럭이 남아있는지 조건 검증이 필요
                // 종료 조건은 아래에서 한 번 보자 -> 코드의 실행순서는 위에서 아래
                if((add + arr[i]) <= L){
                    add += arr[i];
                    q.add(arr[i++]);
                } else {
                    q.add(0);
                }
            }
            if(q.size() == w){
                int out = q.remove();
                add -= out; // 4. 다리 빼는것을 간과
            }

//            q.poll(); // 3. 무조건 제거
            count++;

        }
        System.out.println(count + w); // 마지막 올라간 것 + w
    }
}


// n = 트럭 수
// w = 다리의 길이
// L = 최대 하중

// 하나를 해도 제대로 사고

