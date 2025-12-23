package wrong.implementation.boj_1713;

import java.util.*;

public class boj_1713 {
    static Pic[] arr;
    static int N;
    static int M;
    static int count = 0; // 따라서 count 도입
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new Pic[N];
        // 초기 => 문제점: 3보다 작은 입력에서 문제점
//        for(int i = 0; i <= 2; i++){
//            int a = sc.nextInt();
//            arr[i] = new Pic(i,1,a);
//        }
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            logic(a,i);
        }
        Arrays.sort(arr,0,count, new PicNum());
        for(int i = 0; i < count; i++){
            System.out.print(arr[i].number + " ");
        }
    }

    private static void logic(int a, int index){
        // 1. 이미 있는지 확인
//        // 2. for - each: arr에 null이 있으면 순회 중 접근 시 문제
//        for(Pic now : arr){
//            if(now.number == a){
//                now.vote++; // # 중간에 상태 변화
//                return;
//            }
//        }

        // 1. 이미 있는지 확인
        for(int i = 0; i < count; i++){  // ← 범위 지정!
            if(arr[i].number == a){
                arr[i].vote++;
                return;
            }
        }
        // 2. 빈 틀이 있으면 추가
        if(count < N){
            arr[count++] = new Pic(index, 1, a);
            return;
        }
        // 3. 정렬
        Arrays.sort(arr,0,count);

        // 4. 교체
        arr[N - 1] = new Pic(index,1,a);
    }
}

class Pic implements Comparable<Pic>{
    int index;
    int vote;
    int number;

    Pic(int index, int vote, int number){
        this.index = index;
        this.vote = vote;
        this.number = number;
    }

    @Override
    public int compareTo(Pic p){
        // 내림차순 -> 끝 제거 성능
        if(this.vote == p.vote){
            return p.index - this.index; // 9 7
        }
        return p.vote - this.vote;
    }
}

// 틀 암기
// 1. Comparator<Pic> => 제네릭 타입의 두 개의 인자 오버라이딩
// 2. compare 함수명, 앞이 this, 뒤가 other 역할
class PicNum implements Comparator<Pic> {
    @Override
    public int compare(Pic o1, Pic o2){
        return o1.number - o2.number;
    }
}


// 1. 읽기만 하면 -> 언제 정렬해도 상관 없지만
// 2. 쓰기가 있는 연산은 -> 정렬 후 쓰기하면 순서가 깨진다.

// 1. Arrays.sort(arr) → null 포함해서 정렬 시도
// 2. Arrays.sort(arr,0,count) -> 범위 지정



