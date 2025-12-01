package wrong.stringparsing.boj_1427;

import java.util.*;

public class boj_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // String b = sc.next(); // 받는것을 String으로 받기
        String b = String.valueOf(a);
        char[] c = b.toCharArray();
        Arrays.sort(c);
        String d = new String(c); // char 배열 -> String // 1. 불필요한 변환 1
        StringBuilder e = new StringBuilder(d); // = new StringBuilder(new String(c);
        e.reverse(); // sout(e.reverse());
        String f = new String(e); // 2. 불필요한 변환 2
        System.out.println(Integer.parseInt(f));


//        String b = String.valueOf(a);
//        char[] arr = b.toCharArray();
//        Arrays.sort(arr,Collections.reverseOrder());
//        String c = new String(arr);
//        System.out.println(Integer.parseInt(c));
    }
}
