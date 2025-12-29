package wrong.stringparsing.boj_1541;

import java.util.*;

public class boj_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] arr = a.split("-");
        List<Integer> minus = new ArrayList<>();
        int total = 0;

        if(arr.length == 1){
            String[] now = arr[0].split("\\+");
            for(String aa : now){
                minus.add(Integer.parseInt(aa));
            }
            for(int aaa : minus){
                total += aaa;
            }
            System.out.println(total);
            return;
        }

        // 첫 항도 안에 +가 존재할 수 있음을 간과
        int first = 0;
        String[] firstArr = arr[0].split("\\+");
        for (String s : firstArr) {
            first += Integer.parseInt(s);
        }

//        int first = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i++){
            String[] now = arr[i].split("\\+");
            for(String aa : now){
                minus.add(Integer.parseInt(aa));
            }
        }
        for(int aaa : minus){
            total += aaa;
        }
        System.out.println(first - total);
    }
}
// 1. - 기준으로 split
// 2. 각 내부를 + 기준으로 split
// 3. 첫번쨰만 더하고 + 나머지 다 -
// 추출만 -> substring / stringbuilder ㅌ


// 1 -
// 3 + 4 + 5
// - 3
// - 4



//        char[] arr = sc.next().toCharArray();
//        List<Integer> addArr = new ArrayList<>();
//        List<Integer> minusArr = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        boolean flag = true;
//        boolean first = true;
//        for(char now : arr){
//            // 처음처리
//            if(first){
//                if(now == '-' || now == '+'){
//                    int a = Integer.parseInt(String.valueOf(sb));
//                    addArr.add(a);
//                    sb = new StringBuilder(); // sb = " "; 이 문법 찾아보기
//                    if(now == '-'){
//                        flag = false;
//                    }
////                    System.out.println("처음 추가: " + a);
//                    first = false;
//                    continue;
//                }
//                sb.append(now);
//                continue;
//            }
//
//            if(now == '-'){
//                flag = false;
//                int a = Integer.parseInt(String.valueOf(sb));
////                System.out.println("- 들어옴: " + a);
//                minusArr.add(a);
//                sb = new StringBuilder();
////                System.out.println(sb);
//                continue;
//            }
//            if (now == '+') {
//                if(!flag){
//                    int a = Integer.parseInt(String.valueOf(sb));
//                    minusArr.add(a);
//                    sb = new StringBuilder();
////                    System.out.println(sb);
//                    continue;
//                }
//                int a = Integer.parseInt(String.valueOf(sb));
//                addArr.add(a);
//                sb = new StringBuilder(); // sb = " "; 이 문법 찾아보기
//                continue;
//            }
//            sb.append(now);
//        }
//        // 마지막 처리
//        if(!flag){
//            int a = Integer.parseInt(String.valueOf(sb));
//            minusArr.add(a);
//        } else {
//            int a = Integer.parseInt(String.valueOf(sb));
//            addArr.add(a);
//        }
//        int total = 0;
//        for(int a : addArr){
//            total += a;
//        }
//        for(int a : minusArr){
//            total -= a;
//        }
//        System.out.println(total);


// 문자 파싱 문제에서 반복문이 끝난 뒤 마지막 토큰 처리를 간과

// 1. NumberFormatException
// 문자열을 숫자로 변환할 수 없다

// 2.


// 괄호의 재해석
// 55 + 55 + 40
// 55 - 50 + 40


// 55 - 50 + 40 - 50
// - + -
// - - +
// - - -
// 대원칙: -가 하나 있으면 -> 뒤에는 다 뺼샘 처리가 가능

// 로직, divide
// 정석 풀이 확인
// 1. String 입력
// 2. charAt 순회 -> - or + 면
// 3. 더하기 배열에 저장, 뺴기 배열에 저장 / 한 번에 계산
// 4. 각 순회마다 -> 새로운 String -> int 변환

// 코드 비효율
// 문자 단위 파싱 vs char 단위 파싱

// char 배열 + StringBuilder (Low-level, 복잡)
// String.split() (High-level, 간단)

// 대원칙
// 문자열 파싱은 split()부터 고려
// 1. 구분자가 명확한가? (-, +, 쉼표, 공백 등)
//  ↓ YES
// split() 사용
//
//  ↓ NO (복잡한 규칙)
// 문자 단위 파싱

// NumberFormatException → 숫자 형식이 올바르지 않아 변환할 수 없다는 예외