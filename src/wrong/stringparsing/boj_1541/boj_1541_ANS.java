package wrong.stringparsing.boj_1541;

import java.util.*;

public class boj_1541_ANS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // '-' 기준 분리
        String[] minusGroups = input.split("-");

        int result = 0;

        String[] firstGroup = minusGroups[0].split("\\+");

        for(String num : firstGroup){
            result += Integer.parseInt(num);
        }

        for(int i = 1; i < minusGroups.length; i++){
            String[] nums = minusGroups[i].split("\\+");
            for(String num : nums){
                result -= Integer.parseInt(num);
            }
        }
        System.out.println(result);
    }
}


// split()에서 정규표현식 특수문자를 문자 그대로 사용하려면 \\를 앞에 붙이기

// 정규표현식 = 문자열 패턴을 찾는 도구
// 특수문자 = 정규표현식에서 특별한 의미가 있는 문자 (., +, * 등)

// 1. 특수문자
// . + * ? | ( ) [ ] { } ^ $ \

// 2. -은 일반문자
