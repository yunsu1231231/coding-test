package solved.implementation.boj_15686;

import java.util.*;

public class boj_15686 {
    static List<Point> chicken;
    static List<Point> house;
    static boolean[] selected;
    static int N;
    static int M;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Point> chicken = new ArrayList<>();
        List<Point> house = new ArrayList<>();
        boolean[] selected = new boolean[M];
        int result = 0;

        // 입력 받는 대원칙
        // 1 based
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int a = sc.nextInt();
                if(a == 1){
                    house.add(new Point(i,j));
                } else if(a == 2){
                    chicken.add(new Point(i,j));
                }
            }
        }

        dfs(0,0);
    }
    // idx: 현재 탐색중인 치킨집 index
    // depth: 이제까지 선택한 치킨집 조합 수
    public static void dfs(int idx, int depth){
        if(depth == M){
            result = Math.min(result, calcul());
            return;
        }
        // 부등호 여부 혼돈
        if(idx > M){
            return;
        }

        selected[idx] = true;
        dfs(idx + 1, depth + 1);

        selected[idx] = false;
        dfs(idx + 1, depth);
    }

    public static int calcul(){
        for(int i = 0; i < chicken.size(); i++){
            if(selected[i]){
                for(Point h : house){
                    Point p = chicken.get(i);
                    result = Math.abs(h.x - p.x) + Math.abs(h.y - p.y);
                }
            }
        }
        return result;
    }
}

class Point{
    int x;
    int y;

    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

// T T T F F // 0 based
// 바깥 for문 기준: 확인

