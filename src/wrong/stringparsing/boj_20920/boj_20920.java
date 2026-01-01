package wrong.stringparsing.boj_20920;

import java.util.*;

public class boj_20920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 1. S
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Alpha> arr = new ArrayList<>(); // 단어장


        for(int i = 0; i < N; i++){
            String a = sc.next();
            if(a.length() < M){
                continue;
            }
            // 직접 순회 말고 contains + index 조합으로는 못 구하나
            // => 특정 값에 대한 몇 번째 index = indexOf() API
            // 1. 첫 번째만 반환
            // 2. 없으면 -1
            // 3. 객체 비교 -> 값 비교는 equals 오버라이딩해서 설정 필요
            // 4. 여러 인덱스를 원하면: 직접 순회가 필요 / API 사용 불가능
            boolean flag = false;
            for(Alpha now : arr){
                if(now.value.equals(a)){
                    now.time++;
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            arr.add(new Alpha(1,a.length(),a));
        }
        Collections.sort(arr);
        for(Alpha n : arr){
            System.out.println(n.value);
        }
    }
}


class Alpha implements Comparable<Alpha>{
    int time; // 횟수
    int length;
    String value;

    Alpha(int time, int length, String value){
        this.time = time;
        this.length = length;
        this.value = value;
    }

    @Override
    public int compareTo(Alpha a){
        if(this.time == a.time){
            if(this.length == a.length){
                return this.value.compareTo(a.value);
            }
            return a.length - this.length;
        }
        return a.time - this.time;
    }
}