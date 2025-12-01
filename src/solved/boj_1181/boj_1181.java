package solved.boj_1181;

import java.util.*;

public class boj_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        Set<Alpha> bbb = new HashSet<>();
        for(int i = 0; i < a; i++){
            String b = sc.next();
            int length = b.length();
            bbb.add(new Alpha(length,b));
        }
        List<Alpha> arr = new ArrayList<>(bbb);
        Collections.sort(arr);
        for(Alpha aaa : arr){
            System.out.println(aaa);
        }
    }
}

class Alpha implements Comparable<Alpha>{
    int dist;
    String value;

    Alpha(int d, String v){
        dist = d;
        value = v;
    }

    @Override
    public int compareTo(Alpha a){
        if(this.dist == a.dist){
            return this.value.compareTo(a.value);
//            return a.value.compareTo(this.value);
        }
        return this.dist - a.dist; // 오름
    }

    @Override
    public String toString(){
        return value;
    }

    // 이 두 부분 이후 한 번 더 암기
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alpha alpha = (Alpha) o;
        return dist == alpha.dist && Objects.equals(value, alpha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dist, value);
    }
}
