package solved.datastructure.boj_2164;

import java.util.*;

public class boj_2164 {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 1 based
        for(int i = 1; i <= N; i++){
            q.offer(i);
        }
        boolean i = false;
        while(q.size() != 1){
            if(!i){
                q.remove();
            }
            if(i){
                q.offer(q.remove());
            }
            i = !i;
        }

        System.out.println(q.remove());
    }
}



//1
//2
//3
//N

// peek 시간복잡도

//        while(q.size() == 1){
//        if(i == 0){
//        q.remove();
//i = 1;
//        }
//        }