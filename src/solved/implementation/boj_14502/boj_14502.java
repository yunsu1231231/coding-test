package solved.implementation.boj_14502;

import java.util.*;
public class boj_14502 {
    static List<Point> biras = new ArrayList<>();
    static List<Point> wall = new ArrayList<>();
    static List<Point> blank = new ArrayList<>();
    static int[] cur = new int[3];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static int N, M;
    static List<List<Integer>> choosen = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2){
                    biras.add(new Point(i,j));
                }
                if(arr[i][j] == 1){
                    wall.add(new Point(i,j));
                }
                if(arr[i][j] == 0){
                    blank.add(new Point(i,j));
                }
            }
        }
        wallChoose(0,0); // 0 3 7
        int result = Integer.MAX_VALUE;
        for(List<Integer> a : choosen){
            for(int i : a){
                int row = blank.get(i).row;
                int col = blank.get(i).col;
                arr[row][col] = 1; // 직접 변환
            }
            int virusCount = bfs();
//            for(Point p : biras){
//                total += bfs(p); // 바깥에서도 한 번 더 더함
//            }
            for(int i : a) {
                int row = blank.get(i).row;
                int col = blank.get(i).col;
                arr[row][col] = 0; // 복원
            }
            result = Math.min(virusCount,result); // 이 부분도 항시 혼돈
        }
        System.out.println(blank.size() - 3 - result);
    }

    private static int bfs(Point start){
        int count = 0;
        Set<Point> visited = new HashSet<>();
        Queue<Point> queue = new ArrayDeque<>();

        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()){
            Point cur = queue.remove();
            count++; // 안에도 더하고 있는데
            int row = cur.row;
            int col = cur.col;
            for(int i = 0; i < 4; i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                // 1. 범위 체크 x + 0인지 체크
                if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
                if(visited[nextRow][nextCol] || arr[nextRow][nextCol] != 0) continue;



                Point nextPoint = new Point(nextRow,nextCol);
                // 생성해도 값 비교가 되나 -> 참조값으로 다른 값 비교가 아니라
                if(!visited.contains(nextPoint)){
                    visited.add(nextPoint);
                    queue.add(nextPoint);
                }
            }
        }
        return count;
    }

    // 조합, blank 중 3개 선택
    private static void wallChoose(int depth, int start){
        if(depth == 3){
            List<Integer> arr = new ArrayList<>();
            for(int i : cur){
                arr.add(i);
            }
            choosen.add(arr);
            return;
        }
        // wall.size() -> blank.size()
        for(int i = start; i < blank.size(); i++){
            cur[depth] = i;
            wallChoose(depth + 1, i + 1);
        }
    }
}

class Point{
    int row;
    int col;
    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}



// 1. 사고 -> 루프를 어디에
// 2. 전역으로 공유되는것으 이렇게 반환해도 되나? vs 복사해서 반환 // 그 차이


// 0. 구분해서 설계
// 1. 함수는 독립적으로 설계하기, 입력 -> 결과 반환
// 2. 누적은 바깥 호출자에서
// 3. 바깥에 종속적으로 설계 x

// 0. 한 번에 큐에 넣기 -> 동시 진행 / 전체가 하나의 시스템, 서로 영향
// 1. 서료 영향 없이 개별 탐색 -> 별도의 bfs

// 0. 격자 문제의 특성
// 1. 이차원 배열이 자연스럽다
// 2. HashSet -> hashCode, equasl 오버라이딩 안하면 값 비교를 해야 되는데 참조값으로 비교 / visited 처리 불가능