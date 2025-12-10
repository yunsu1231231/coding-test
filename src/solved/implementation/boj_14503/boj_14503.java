package solved.implementation.boj_14503;

import java.util.*;

// 아직 확인 x

public class boj_14503 {
    static int[] dx = {0,-1,0,1}; // 북,서,남,동 0 1 2 3
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 방의 크기 N
        M = sc.nextInt(); // 방의 크기 M
        int r = sc.nextInt(); int c = sc.nextInt(); int d = sc.nextInt(); // 바라보는
        arr = new int[N][M]; // 0 based
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        bfs(r,c,d);
    }
    // x,y: 시작, d: 바라보는
    private static int bfs(int x, int y, int d){
        int count = 0;
        Set<int[]> visited = new HashSet<>(); // class vs [] 관리
        Queue<int[]> queue = new ArrayDeque<>();
        int[] cur = new int[]{x,y};
        visited.add(cur);
        queue.add(cur);
        while(!queue.isEmpty()){
            boolean flag = false;
            int[] now = queue.remove();
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[(d + i) % 4];
                int ny = now[1] + dy[(d + i) % 4];
                int[] next = new int[]{nx,ny};
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited.contains(next) && arr[nx][ny] == 0){
                        visited.add(next);
                        queue.add(next);
                        count++;
                        flag = true;
                    }
                }
            }
            if(!flag){
                int nxx = now[0] + dx[(d+2) % 4];
                int nyy = now[1] + dy[(d+2) % 4];
                if(arr[nxx][nyy] == 0){
                    int[] nnn = new int[]{nxx,nyy};
                    visited.add(nnn);
                    queue.add(nnn);
                } else {
                    break;
                }
            }
        }
        return count;
    }
}

// 디버깅도 메타인지하면서 끊어서 스스로 해보기 + 사고의 연습이 지금 시점에서 제일 중요
// 지식의 습득보다
// 물론 양치기와 병행




// 3 4 5 6
// 3 4 1 2

// 사고해보자 / 사고 / 이후



// 사고
// 줄글로

// 1. 시작 좌표 기준 bfs 탐색
// 분기문
// 1. 0 이면 청소 / 1 증가
// 2. 주변 네 좌표 다 돌면서 ->
// 3. 있으면
// 회전 -> 그 방향으로 탐색

// 4. 없으면
// 방향좌표 정 반대로 뒤로 갔을 때 -> 0이면 이동
// -> 1이면 탐색 멈추고
