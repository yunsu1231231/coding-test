package wrong.implementation.boj_1966;

import java.util.*;

public class boj_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int ii = 0; ii < N; ii++){
            int a = sc.nextInt();
            int b = sc.nextInt(); // b번째 궁금
            int[] arr = new int[a];

            Queue<Num> q = new ArrayDeque<>();
            for(int j = 0; j < a; j++){
                arr[j] = sc.nextInt();
                q.add(new Num(arr[j],j));
            }

            // 1. 암기 + 연습
            // 2. if + else / if, else
            Arrays.sort(arr);
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }


            int f = 0;
            int count = 1;
            while(!q.isEmpty()){
                if(q.peek().value == arr[f]){
                    Num aaa = q.remove();
                    if(aaa.index == b){
                        System.out.println(count);
                    }
                    f++;
                    count++;
                } else {
                    Num aaa = q.remove();
                    q.offer(aaa);
                }
            }
        }
    }
}

class Num{
    int value;
    int index;

    Num(int value, int index){
        this.value = value;
        this.index = index;
    }
}

// 로직
// 1. 내림차순 정렬 / 4 3 2 1
// 2. 만족 x -> 뒤로 + count 중가 / 만족 -> pop
// 3. 순회


// int[] arr = {3,1,2};
// Arrays.sort(arr, Collections.reverseOrder());  // 컴파일 에러