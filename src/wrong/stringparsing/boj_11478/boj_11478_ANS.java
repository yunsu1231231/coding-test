package wrong.stringparsing.boj_11478;

import java.util.*;

public class boj_11478_ANS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Set<String> set = new HashSet<>();

        int n = str.length();

        // 길이별로 문자열 생성
        for(int len = 1; len <= n; len++){
            for(int start = 0; start <= n - len; start++){
                String sub = str.substring(start, start + len);
                set.add(sub);
            }
        }

        System.out.println(set.size());
    }
}

// 문자열을 자르기만 하면 -> substring() 사용
// 문자열을 조립 및 변경 -> StringBuilder 사용 / 중간에 삽입, 삭제, 변경