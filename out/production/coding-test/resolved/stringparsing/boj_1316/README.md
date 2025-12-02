### 1. 실패요인 
1. map.putIfAbsent(aaa[j],j) vs map.put(aaa[j],j)  
map.putIfAbsent는 key가 없을 때만 값을 넣는다. 따라서 키가 있을 때 값을 덮어쓰기 위해서는 put을 사용하기 

```declarative
// resolved

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for(int i = 0; i < N; i++){
            String a = sc.next();
            count += gp(a,count);
        }
        System.out.println(count);
    }

    public static int gp(String a, int count){
        Map<String, Integer> m = new HashMap<>();
        String[] arr = a.split("");
        for(int i = 0; i < arr.length; i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i],i);
            } else {
                int v = m.get(arr[i]);
                if((v+1) != i){
                    return 0;
                }
                m.put(arr[i],i);
            }
        }
        return 1;
    }
}

```