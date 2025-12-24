package wrong.implementation.boj_20006;

import java.util.*;

// 주석 복기 이후
public class boj_20006 {
//    static List<Player[]> arr; + 다음 것 추가할 떄 오히려 불편한데 이 부분 복기
    static List<List<Player>> arr;
    static int p;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. m, p 사용할 때 계속 혼돈 -> 주석, 주의
        p = sc.nextInt(); // 플레이어 수
        m = sc.nextInt(); // 방의 정원
        arr = new ArrayList<>();

        for(int i = 0; i < p; i++){
            int I = sc.nextInt();
            String n = sc.next();
            logic(I,n);
        }


        for(List<Player> now : arr){
            Collections.sort(now);
            if(now.size() == m){
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            for(Player p : now){
                System.out.print(p.level + " " + p.nickname);
                System.out.println();
            }
        }
    }
    private static void logic(int level, String nickname){
        // 1. 추가
        boolean flag = false;
        for(int i = 0; i < arr.size(); i++){
            List<Player> now = arr.get(i);
            // 2. 최대값 제한은 >=
            // 경계값 대입해서 사고: m부터 넘기기
            if(now.size() >= m){
                continue;
            }
            if((now.get(0).level - 10 <= level) && (level <= now.get(0).level + 10)){
                now.add(new Player(level,nickname));
                flag = true;
                break;
            }
        }
        // 2. 추가 못하면 생성 후 추가
        if(!flag){
            List<Player> now = new ArrayList<>();
            now.add(new Player(level, nickname));
            arr.add(now);
        }

    }
}

// 3. Array, Collections 동일하게 적용
class Player implements Comparable<Player>{
    int level;
    String nickname;

    Player(int level, String nickname){
        this.level = level;
        this.nickname = nickname;
    }

    @Override
    public int compareTo(Player p){
        return this.nickname.compareTo(p.nickname);
    }
}



// 1.
//    static List<Player[]> arr; + 다음 것 추가할 떄 오히려 불편한데 이 부분 복기
// arr.add 하면 바로 뒤에 추가 가능한데 배열일 때 구체적 인덱스 없이 바로 뒤에 추가 이 부분 복기

// 2.
// 범위 조건 -> 둘 다 만족해야 되므로 and, or 연산 아님 주의
