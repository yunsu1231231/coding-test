package solved.stringparsing.boj_2002;

import java.util.*;
import java.io.*;

// 핵심 로직: 추월: 입구에서 뒤에 있던 차가 출구에서 앞에 나온 경우
public class boj_2002_ANS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> entry = new ArrayList<>();
        for(int i = 0; i < N; i++){
            entry.add(br.readLine());
        }
        int count = 0;

        for(int i = 0; i < N; i++){
            String exitCar = br.readLine();

            int idx = entry.indexOf(exitCar);

            if(idx > 0){
                count++;
            }

            entry.remove(idx);
        }

        System.out.println(count);
    }
}

// A + 하나를 읽어도
// 이후
