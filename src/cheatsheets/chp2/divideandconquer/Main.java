package cheatsheets.chp2.divideandconquer;

import java.util.*;

public class Main {
    public static List<Integer> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            go(a);
        }
        System.out.println(arr.size());
    }

    public static void go(int a){
        int now = Collections.binarySearch(arr,a);
        if(now < 0){
            now = -(now) -1;
        }
        // target보다 한 칸 위
        if(now < arr.size()){
            arr.set(now,a);
        } else {
            arr.add(a);
        }
    }
}


