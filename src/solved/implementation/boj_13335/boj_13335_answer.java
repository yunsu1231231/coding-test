package solved.implementation.boj_13335;

import java.util.*;

public class boj_13335_answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();

        int[] trucks = new int[n];
        for(int i = 0; i < n; i++){
            trucks[i] = sc.nextInt();
        }
        Queue<Integer> b = new ArrayDeque<>();
        int time = 0;
        int bridgeWeight = 0;
        int idx = 0; // 대기 중인 트럭 인덱스

        while(idx < n){
            time++;

            if(b.size() == w){
                bridgeWeight -= b.poll();
            }

            if(bridgeWeight + trucks[idx] <= L){
                b.add(trucks[idx]);
                bridgeWeight += trucks[idx];
                idx++;
            } else {
                b.add(0);
            }
        }

        time += w;
        System.out.println(time);
    }
}


// 1. 아직 다리에 올라가지 않은 트럭
// 2. 다리가 꽉 찾는지 확인
// 3. 트럭을 올릴 수 있는지
