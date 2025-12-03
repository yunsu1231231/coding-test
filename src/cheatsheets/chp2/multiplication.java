package cheatsheets.chp2;

import java.util.*;

public class multiplication {
    public static void main(String[] args) {
        String x = "12345678";
        String y = "98765432";

        String result = multiply(x,y);
        System.out.println(result);

    }
    public static String multiply(String x, String y){
        x = trimLeadingZeroes(x);
        y = trimLeadingZeroes(y);

        // base case
        if(x.length() == 1 && y.length() == 1){
            int value = (x.charAt(0) - '0') * (y.charAt(0) - '0'); // 문자형 -> 숫자
            return Integer.toString(value);
        }

        // 길이 맞추기
        int n = Math.max(x.length(), y.length());
        x = padLeft(x,n);
        y = padLeft(y,n);

        int mid = n / 2;

        // 분할
        String xL = x.substring(0, n - mid);
        String xR = x.substring(n - mid);
        String yL = y.substring(0, n - mid);
        String yR = y.substring(n - mid);

        // 4개의 하위 문제 -> 사고방식
        String p1 = multiply(xL, yL);
        String p2 = multiply(xL, yR);
        String p3 = multiply(xR, yL);
        String p4 = multiply(xR, yR);

        // 자리수 조절
        String term1 = p1 + "0".repeat(mid * 2);
        String term2 = p2 + "0".repeat(mid);
        String term3 = p3 + "0".repeat(mid);

        String result = add(add(term1, term2), add(term3,p4));

        return trimLeadingZeroes(result);
    }

    // 두 10진수 문자열 더하기
    public static String add(String a, String b){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length()- 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    // 숫자 앞의 0 제거
    // i < s.length() - 1: 최소 한자리는 남기기
    public static String trimLeadingZeroes(String s){
        int i = 0;
        while(i < s.length() - 1 && s.charAt(i) == '0'){
            i++;
        }
        return s.substring(i);
    }

    public static String padLeft(String s, int n){
        while(s.length() < n){
            s = "0" + s;
        }
        return s;
    }

}



// char c = "Hello".charAt(1); // 'e'