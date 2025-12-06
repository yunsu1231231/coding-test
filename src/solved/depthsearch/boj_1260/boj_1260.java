package solved.depthsearch.boj_1260;

import java.util.*;

public class boj_1260 {
    public static List<List<Integer>> graph;
    public static StringBuilder sb;
    public static StringBuilder sb2;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점 수
        int M = sc.nextInt(); // 간선 수
        int V = sc.nextInt(); // 탐색 시작 번호
        graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 0; i < N + 1; i++){
            Collections.sort(graph.get(i));
        }

        sb = new StringBuilder();
        sb2 = new StringBuilder();


        Set<Integer> visited = new HashSet<>();
        dfs(V,visited);
        bfs(V);

        System.out.println(sb);
        System.out.println(sb2);
    }

    // 현재 노드로부터 방문할 수 있는 모든 노드는 다 방문하고 돌아온다
    private static void dfs(int cur, Set<Integer>visited){
        visited.add(cur);
        sb.append(cur).append(" ");

//        if(!visited.contains(cur)){
//            for(int next : graph.get(cur)){
//                dfs(next,visited);
//            }
//        }

        for(int next : graph.get(cur)){
            if(!visited.contains(next)){
                dfs(next,visited);
            }
        }
    }

    private static void bfs(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        visited.add(start);
        sb2.append(start).append(" ");
        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.remove(); // 1. 큐에서 꺼내고
            for(int next : graph.get(cur)){ // 2. 인접 노드를 전부 다 탐색
                if(!visited.contains(next)){ // 3. 방문하지 않았으면 -> 전부 다 한 번에 큐에 추가 + 한 번에 방문 처리
                    visited.add(next);
                    sb2.append(next).append(" ");
                    queue.add(next);
                }
            }
        }
    }
}

// 1. dfs는 방문 처리가 노드 하나씩 이뤄지고
// 2. bfs는 한 노드의 모든 인접 노드를 한 번에 방문처리