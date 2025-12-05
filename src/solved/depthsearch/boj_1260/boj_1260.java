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
            int cur = queue.remove();
            for(int next : graph.get(cur)){
                if(!visited.contains(next)){
                    visited.add(next);
                    sb2.append(next).append(" ");
                    queue.add(next);
                }
            }
        }
    }
}
