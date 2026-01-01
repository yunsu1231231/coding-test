package wrong.stringparsing.boj_20920;

import java.util.*;
import java.io.*;

public class boj_20920_ANS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 리스트 중복 체크 -> HashMap 사용 / O(1)
        HashMap<String, Integer> wordCount = new HashMap<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();

            if(word.length() < M){
                continue;
            }

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(wordCount.keySet());

        Collections.sort(words, (w1, w2) -> {
           int count1 = wordCount.get(w1);
           int count2 = wordCount.get(w2);

           if(count1 != count2){
               return count2 - count1;
           }

           if(w1.length() != w2.length()){
               return w2.length() - w1.length();
           }

           return w1.compareTo(w2);
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String word : words){
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

// 1. HashMap + getOrdefaultValue = 중복 검사 O(1)
// 2. Scanner vs BufferdReader // 1000 줄 이상 권장, 100000부터 필수

// String line = "apple,banana,cherry";
// StringTokenizer st = new StringTokenizer(line, ",");  // 쉼표로 구분자 직접 지정가능
//
// st.nextToken();  // "apple"
// st.nextToken();  // "banana"
// st.nextToken();  // "cherry"