package solved.stringparsing.boj_1431;

import java.util.*;

public class boj_1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        List<Alpha> arr = new ArrayList<>();
        for(int i = 0; i < a; i++){
            String value = sc.next();
            int length = value.length();
            int total = logic(value);
            arr.add(new Alpha(length,total,value));
        }
        Collections.sort(arr);
        for(Alpha now : arr){
            System.out.println(now.value);
        }
    }

    private static int logic(String value){
        int total = 0;
        for(int i = 0; i < value.length(); i++){
            char a = value.charAt(i);
            if(a == '0'){
                total += 0;
            }
            if(a == '1'){
                total += 1;
            }
            if(a == '2'){
                total += 2;
            }
            if(a == '3'){
                total += 3;
            }
            if(a == '4'){
                total += 4;
            }
            if(a == '5'){
                total += 5;
            }
            if(a == '6'){
                total += 6;
            }
            if(a == '7'){
                total += 7;
            }
            if(a == '8'){
                total += 8;
            }
            if(a == '9'){
                total += 9;
            }
        }
        return total;
    }

}

class Alpha implements Comparable<Alpha>{
    int length;
    int total;
    String value;

    Alpha(int length, int total, String value){
        this.length = length;
        this.total = total;
        this.value = value;
    }

    @Override
    public int compareTo(Alpha a){
        if(this.length == a.length){
            if(this.total == a.total){
                return this.value.compareTo(a.value);
            }
            return this.total - a.total;
        }
        return this.length - a.length;
    }
}


// A