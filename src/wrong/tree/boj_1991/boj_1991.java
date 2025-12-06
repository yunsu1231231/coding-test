package wrong.tree.boj_1991;

import java.util.*;

public class boj_1991 {
    public static Node[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new Node[N]; // 0 based
        for(int i = 0; i < N; i++){
            arr[i] = new Node((char)('A' + i));
        }
        for(int i = 0; i < N; i++){
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            char c = sc.next().charAt(0);

            if(b != '.'){
                arr[a - 'A'].left = arr[b - 'A'];
            }
            if(c != '.'){
                arr[a - 'A'].right = arr[c - 'A'];
            }
        }
        b(arr[0]);
        System.out.println();
        m(arr[0]);
        System.out.println();
        a(arr[0]);
    }
    private static void b(Node start){
        if(start == null){
            return;
        }
        System.out.print(start.name);
        b(start.left);
        b(start.right);
    }

    private static void m(Node start){
        if(start == null){
            return;
        }
        m(start.left);
        System.out.print(start.name);
        m(start.right);
    }
    private static void a(Node start){
        if(start == null){
            return;
        }
        a(start.left);
        a(start.right);
        System.out.print(start.name);
    }

}

class Node{
    char name;
    Node left,right;

    Node(char name){
        this.name = name;
    }
}