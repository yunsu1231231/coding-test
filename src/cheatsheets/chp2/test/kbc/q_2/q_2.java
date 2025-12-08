package cheatsheets.chp2.test.kbc.q_2;

public class q_2 {
    public static void main(String[] args) {
        char[] a = new char[5];
        int[] b = new int[5]; // default 0

        System.out.println(a.length);
        if(a[0] == '\u0000'){
            System.out.println("yes");
        }
    }
}
