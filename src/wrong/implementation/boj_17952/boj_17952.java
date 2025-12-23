package wrong.implementation.boj_17952;

import java.util.*;

public class boj_17952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        sc.nextLine();
        Deque<Job> stack = new ArrayDeque<>();
        int total = 0;
        while(time > 0){ // 등호 포함 여부, 대원칙
            time--;
            String a = sc.nextLine();
            if(a.charAt(0) == '1'){
                String[] parts = a.split(" ");
                int score = Integer.parseInt(parts[1]);
                int remainTime = Integer.parseInt(parts[2]);
                stack.push(new Job(score, remainTime));
                // 1. 새 과제가 들어올 때 작업 -> 이 부분 부재
            }
            // 기존 사고: 행위를 기준으로 분기
            // 필요 사고: 시간순서
            // 새 과제, 기존 과제 상관없이 -> 매 분마다 무조건 작업
            if(!stack.isEmpty()){
                Job current = stack.peek();
                current.remainTime--;

                if(current.remainTime == 0){
                    total += current.score;
                    stack.pop();
                }
            }
//            else {
//                Job now = stack.pop(); // 2. 스택이 비어있을 때 에러가 발생
//                if((now.remainTime - 1) == 0){
//                    total += now.score;
//                } else {
//                    now.remainTime--;
//                    stack.push(now);
//                }
//            }
        }
        System.out.println(total);
    }
}

// 분기문 기준 사고

class Job{
    int remainTime;
    int score;

    Job(int score, int remainTime){
        this.remainTime = remainTime;
        this.score = score;
    }
}


// 과제 = 점수, 남은시간
// 분기문

// while -> 시간이 0일때까지
// 0.
// 1. 스택에 넣고
// 2. 새 과제가 올 때까지 시간 감소
// 3. 다음 과제가 오면 -> 추가 / 시간 소모시 제거
