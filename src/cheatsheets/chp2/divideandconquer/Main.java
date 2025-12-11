package cheatsheets.chp2.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 결과 디버깅 내일 한 번 더 해복;

public class Main {
    // 하나르 관리하는게 편하네
    static List<Deque<Integer>> arr = new ArrayList<>(); // 전체 deque 관리 배열

    public static void main(String[] args) throws IOException {
//        Deque<Integer>[] arr = new Deque<Integer>[4];
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(b.readLine());
        // 멈칫 이유, 1. 뭔가 초기화가 비효율적으로 보이는데 2.대원칙 -> 안에 것 생성 -> 바깥 추가
        Deque<Integer> fffff = new ArrayDeque<>();
        arr.add(fffff); // 1 based 더미


        Deque<Integer> a = new ArrayDeque<>();
        for(int i = 0; i < 8; i++){ // 가변일 때 !while 형태 문법 한 번 확인
            a.offer(Integer.parseInt(st.nextToken()));
        }
        arr.add(a);
        st = new StringTokenizer(b.readLine());
        Deque<Integer> aa = new ArrayDeque<>();
        for(int i = 0; i < 8; i++){
            aa.offer(Integer.parseInt(st.nextToken()));
        }
        arr.add(aa);
        st = new StringTokenizer(b.readLine());
        Deque<Integer> aaa = new ArrayDeque<>();
        for(int i = 0; i < 8; i++){
            aaa.offer(Integer.parseInt(st.nextToken()));
        }
        arr.add(aaa);
        st = new StringTokenizer(b.readLine());
        Deque<Integer> aaaa = new ArrayDeque<>();
        for(int i = 0; i < 8; i++){
            aaaa.offer(Integer.parseInt(st.nextToken()));
        }
        arr.add(aaaa);
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for(int i = 0; i < K; i++){
            int dd = sc.nextInt();
            int cc = sc.nextInt();
            boolean[] abc = change(dd,cc); // 최종 순회 가능한 배열, 근데 이렇게 인자를 받으면 크기 선언은 우항에 필요없는건가?
            realChange(abc);
        }
        // 최종
        int result = 0;
        for(int i = 1; i <= 4; i++){
            int p = arr.get(i).peek(); // npe 경고 -> 확인
            if(p == 1){
                result += Math.pow(2,i);
            }
        }
        System.out.println(result);
    }
    private static void realChange(boolean[] abc){
        for(int i = 1; i <= 4; i++){
            Deque<Integer> now = arr.get(i);
            if(abc[i] == true){
                for(int j = 0; i < 8; j++){
//                    now.poll().offer(); 왜?
                    int a = now.poll();
                    now.offer(a);
                }
                // iterator을 사용하면?
//                Iterator<Integer> it = now.iterator();
//                while(it.hasNext()){
////                    it.next().remove();
//                    int a = it.next();
//                    it.remove();
//                }
            }
        }
    }


    private static boolean[] change(int start, int b){
        // 안에서 loop -> 그 값을 위해서는 바깥에 배열로 관리: 이게 최선인가?
        // 안에서 바로 어떻게 못하나: 대원칙

        List<List<Integer>> v = new ArrayList<>(); // 1 based
        v.add(new ArrayList<>());

        for(int i = 1; i <= 4; i++){
            if(i == 1 || i == 3){
                Deque<Integer> f = arr.get(i);
                Iterator<Integer> it = f.iterator();
                int count = 0;
                while(it.hasNext()){
                    it.next();
                    count++;
                    if(count == 2){
                        if(i == 1){
                            // 앞에 0 추가 -> 어떤 문법?
//                            v.add(new ArrayList<>(it.next()));
                            List<Integer> ff = new ArrayList<>();
                            ff.add(0);
                            ff.add(it.next());
                            v.add(ff);
                            break;
                        } else {
                            List<Integer> fff = new ArrayList<>();
                            fff.add(it.next());                            fff.add(0);
                            fff.add(0);
                            v.add(fff);
                            break;
                        }

                    }
                }
            } else {
                Deque<Integer> ff = arr.get(i);
                Iterator<Integer> it = ff.iterator();
                int count1 = 0;
                while(it.hasNext()){
                    it.next();
                    count1++;
                    if(count1 == 2){
                        v.add(new ArrayList<>(it.next()));
                    }
                    if(count1 == 6){
                        v.add(new ArrayList<>(it.next()));
                        break;
                    }
                }
            }
        }

        // 2. 판단
        // 하나의 수동 경우가 아닌 + 양옆 자동 -> 어떻게?
        // 핵심 사고: 로직은 돌면서 이동이지만 -> 코드로 구현할때는 결국 하나의 스냅샷에서 판단

        boolean[] ca = new boolean[4]; // 1 based, 시작 배열 기준

        // 직전하고 비교 -> 코드 대원칙
        for(int i = 1; i <= 4; i++){
            int sec = v.get(i-1).get(1);
            int nextFirst = v.get(i).get(0);

            if(sec == nextFirst){
                ca[i] = false;
            } else {
                ca[i] = true;
            }
        }
        // 1. 배열 오른쪽 쭉
        int k = 0; // 걸린 인덱스
        for(int i = start; i <= 4; i++){
            if(ca[i] = false){
                k = i;
                break;
            }
        }
        // 2. 배열 왼쪽 쭉
        int g = 0;
        for(int i = start; i >= 1; i--){
            if(ca[i] == false){
                g = i;
                break;
            }
        }
        for(int i = k; i <=4; i++){
            ca[i] = false;
        }
        for(int i = g; i >= 1; g--){
            ca[i] = false;
        }

        return ca;
    }
}

// 0 1 0
// 근데 전파 로직은 어떻게 구현하지? =>
// 0: 같아서 회전 x, 1: 다르다

// x 0 1 0 -> 하고 로직에 맞게 보정

// 1. 시작 인덱스 기준
// 2.

// 1. 사이하고 / index 위치 자체하고 너무 혼돈이 오는데

// 1. 배열 양옆 탐색이 하나의 for문에 가능한가?
// 2. 0을 하나라도 만나면 다 뒤에 0으로 덮기
// 3. 최종 배열 기준으로 돌리기

// 미리 설계의 중요성 + 분할 기반 구현능력




// 설계부터 다시
// 1. 회전시킬 톱니바튀를 먼저 다 고르고
// 3,-1 이면 ->

// 2. 그 다음 일괄 회전

// 1. Deque<Integer>[] arr = new Deque<Integer>[4];
// 2. it.next() 할 때 현재인지 다음인지 혼돈 -> 대원칙

// 가독성 있게 펼치고 -> 이후 좁히는것도 하나의 방법


