package wrong.stringparsing.boj_17413;

import java.util.*;

// 예외 케이스가 뭐지..? 다시 풀어보기
public class boj_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] arr = a.split("<");
//        System.out.println("arr: " + Arrays.toString(arr));
        if(arr.length == 1){
            // 둘 다 없으면 공백 구분
            String[] b = arr[0].split(" ");
//            System.out.println(Arrays.toString(b));
            for(String now : b){
                System.out.print(reverse(now) + " ");
            }
            return;
        }
        StringBuilder sb = new StringBuilder();


        // 2. > 왼쪽 기준 분해
        for(String now : arr){
            if(Objects.equals(now, "")){
                continue;
            }
            String[] nowArr = now.split(">"); // 1. <로 나눈 조각은
            // 2. 무조건 <> tag로 시작한다고 사고
            // 단어 <tag> 단어 고려 x
            sb.append("<");
            sb.append(nowArr[0]);
            sb.append(">");
            // 3. 0번째 tag, 길이가 1이 아니면
            if(nowArr.length != 1){
                String next = nowArr[1];
//                System.out.println("순서: " + next);
                // 4. 공백 한 번 더 slice
                String[] r = next.split(" ");
                for(int i = 0; i < r.length; i++){
                    if(i == r.length -1){
                        sb.append(reverse(r[i]));
                        break;
                    }
                    sb.append(reverse(r[i])).append(" ");
                }
            }
        }
        System.out.println(sb);

    }

    // 문자열 뒤짚기 -> 최적화 찾아보기
    private static String reverse(String a){
        char[] arr = a.toCharArray();
        char[] newArr = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            int j = arr.length - 1 - i;
            newArr[j] = arr[i];
        }
        // char -> String,, 정석 한 번 암기
        return String.valueOf(newArr);
    }
}

// 0 1 2 3 4 5
// o n l i n e
// e n i l n o
// 0 1 2 3 4 5

// 0 -> 5, 1 -> 4, 2 -> 3, 3 -> 2, 4 -> 1, 5 -> 0

// 로직
// 1. 공백 기준 분해
// 2.

// 1. < 왼쪽
// 2. > 오른쪽 -> 0번째 tag -> 1번째가 있으면 => 1. 공백 구분 2. 넣고 3. 뒤짚기
// 3. 둘 다 없으면 공백으로 구분

//
// open>tag
// close>

//
// int>
// max>2147483647
// long long>
// max>9223372036854775807


// 문자열을 읽으면서 -> 문자열에 따라 규칙이 바뀌는 문제: 분기문이 바뀐다
// 따라서 문자열 단위가 아닌 문자 단위로 처리해야 된다.

// 판단 대원칙:
// 해당 문자를 해석할 때 이전 문자를 봐야하는가 -> 아니면 split, 맞으면 char 단위

// 조건 분기가 고정된 구분자라면 문자열 단위가 편리하고,
// 분기가 상태에 따라 달라지면 문자 단위 처리가 필수다.