package cheatsheets.iterator;

import java.util.*;
public class Main {
    public static void main(String[] args) {
//        Deque<String> dq = new ArrayDeque<>();
//        dq.add("A");
//        dq.add("B");
//        dq.add("C");
//
//        Iterator<String> it = dq.iterator();
//        while(it.hasNext()){
//            String a = it.next();
//            System.out.println(a);
//        }

//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5)); // 불변 -> 가변
//        Iterator<Integer> it = list.iterator();
//        int i = 1;
//        while(it.hasNext()){
//            Integer a = it.next();
//            if(a % 2 == 0){
//                it.remove();
//            }
//        }
//        System.out.println(list);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(10);
        dq.addLast(20);
        dq.addLast(30);

        Iterator<Integer> it = dq.descendingIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // 1. next() -> remove() 는 무조건 1대1 관계
        // 2. hasNext() -> next() set로 무조건

    }
}
