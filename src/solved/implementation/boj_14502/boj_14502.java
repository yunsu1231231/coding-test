//package cheatsheets.chp2.divideandconquer;
//
//import java.util.*;
//
//public class Main {
//    static int a;
//    static int b;
//    static int[][] arr;
//    static List<Point> blank = new ArrayList<>();
//    static List<Point> wall = new ArrayList<>();
//    static List<Point> biras = new ArrayList<>();
//    static List<List<Integer>> result = new ArrayList<>();
//    static int[] aaa = new int[3];
//    static int[] dx = {0,1,0,-1};
//    static int[] dy = {1,0,-1,0};
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        a = sc.nextInt();
//        b = sc.nextInt();
//        arr = new int[a][b];
//
//        for(int i = 0; i < a; i++){
//            for(int j = 0; j < b; j++){
//                arr[i][j] = sc.nextInt();
//                if(arr[i][j] == 0){
//                    blank.add(new Point(i,j));
//                }
//                if(arr[i][j] == 1){
//                    wall.add(new Point(i,j));
//                }
//                if(arr[i][j] == 2){
//                    biras.add(new Point(i,j));
//                }
//            }
//        }
//        // 1. 빈칸 중 3개 선택
//        getWall(0,0);
//
//        int rr = Integer.MAX_VALUE; // 최소값 초기화
//        for(List<Integer> a : result){
//            int total = 0;
//            for(int b : a){
//                Point p = blank.get(b);
//                arr[p.row][p.col] = 1;
//            }
//            total += bfs();
//            for(int b : a){
//                Point p = blank.get(b);
//                arr[p.row][p.col] = 0;
//            }
//            rr = Math.min(total,rr);
//        }
//        System.out.println(blank.size() - 3 - rr);
//    }
//
//    // 시작: 2를 기준으로 bfs 한 번에 탐색
//    private static int bfs(){
//        int count = 0;
//        boolean[][] visited = new boolean[a][b]; // 초기 0
//        Queue<Point> queue = new ArrayDeque<>();
//
//        for(Point p : biras){
//            queue.add(p);
//            visited[p.row][p.col] = true;
//        }
//
//        // 1,2 차이 => 큐에 들어가는 선수와 내용은 완전히 동일
//        // 큐에 뽑으면: 초기 입력값도 포함 / 큐에 넣으면: 초기 입력값은 제외
//        while(!queue.isEmpty()){
//            Point p = queue.remove();
////            count++; // 1. 큐에 뽑을 때
//            for(int i = 0; i < 4; i++){
//                int nextRow = p.row + dx[i];
//                int nextCol = p.col + dy[i];
//                // 앞 조건이 false면 뒤는 아예 실행 x => index out of range bound 방지 조건문이 앞에 와야됨!
//                if(nextRow >= 0 && nextRow < a && nextCol >= 0 && nextCol < b && !visited[nextRow][nextCol] ){
//                    if(arr[nextRow][nextCol] == 0){
//                        queue.add(new Point(nextRow,nextCol));
//                        visited[nextRow][nextCol] = true;
//                        count++; // 2. 큐에 넣을 때
//                    }
//                }
//            }
//        }
//        return count;
//
//    }
//    private static void getWall(int depth, int start){
//        if(depth == 3){
//            List<Integer> now = new ArrayList<>();
//            for(int i : aaa){
//                now.add(i);
//            }
//            result.add(now);
//            return;
//        }
//        for(int i = start; i < blank.size(); i++){
//            aaa[depth] = i;
//            getWall(depth + 1, i + 1);
//        }
//    }
//}
//
//class Point{
//    int row;
//    int col;
//
//    Point(int row, int col){
//        this.row = row;
//        this.col = col;
//    }
//}


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