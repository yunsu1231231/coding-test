package wrong.tree.boj_11725;

import java.util.*;

// 다시 풀 때는 Linkedlist로 구현해보기

public class boj_11725 {
    public static Node[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new Node[N + 1]; // 1 based
        for(int i = 0; i < N + 1; i++){
            arr[i] = new Node(i);
        }

        for(int i = 0; i < N -1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].child.add(arr[b]);
            arr[b].child.add(arr[a]);
        }

        dfs(arr[1],null);

        for(int i = 2; i <= N; i++){
            System.out.println(arr[i].parent.name);
        }
    }


    // dfs는 현재 노드만 알고 -> 부모는 넘겨받은 인자
    private static void dfs(Node cur, Node parent){
        cur.parent = parent;

        for(Node next : cur.child){ // arr[cur.name].child
            if(next != parent){
                dfs(next,cur);
            }
        }
    }
}

class Node{
    int name;
    Node parent;
    List<Node> child = new ArrayList<>();

    Node(int name){
        this.name = name;
    }
}


// 1. 트리 구성


// List.add() 메서드
// boolean add(E e) 반환
