package cheatsheets.chp2.test.kbc.q_1.RE;

import java.util.*;

// 추가 개녀 복기 + 문제 조건 추가해서 한 번 더 풀이는 이후

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,5}; // 0 based
        int k = 3;
        List<List<Integer>> a = comb(arr,k); // 1. 3 comb 구하기
        System.out.println(a);
        for(List<Integer> b : a){
            int[] leftover = leftOver(b, arr); // 1. 남은 배열
            List<List<Integer>> c = comb(leftover,2); // 2. 3 -> 2 comb 두개
            System.out.println(c);
            for(List<Integer> d : c){
                int[] leftover2 = leftOver(d,leftover);
                System.out.println(leftover2[0]);
            }
        }
    }
    // 배열에서 -> 조합을 고르고 -> 그걸 제외시킬 때 -> 어떻게 해야되지
    // 어느정도 치고 -> 돌려보는지 / 이후 복기

    private static int[] leftOver(List<Integer> b, int[] arr){
        List<Integer> temp = new ArrayList<>();

        // 3 하나만 제외 -> 다른 3을 남기기 위해서는 = 값이 아니라 index 단위로 원소를 제거
//        for(int i : arr){
//            if(!b.contains(i)){
//                temp.add(i);
//            }
//        }
        for(int i = 0; i< arr.length; i++){
            if(!b.contains(i)){
                temp.add(arr[i]);
            }
        }

        // 리스트 -> 배열 공식
        int[] newA = new int[temp.size()];
        int f = 0;
        for(int i : temp){
            newA[f] = i;
            f++;
        }
        return newA;
    }

    // 변수명 덜 헷갈리게 통일 대원칙
    private static List<List<Integer>> comb(int[] arr, int k){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result,temp,0,arr,k);
        return result;
    }

    // 6개 중 k개를 고르는 것
    private static void dfs(List<List<Integer>> result,List<Integer> temp, int start, int[] a, int k){
        if(temp.size() == k){
            // temp 그대로 넘겨주기 vs 복사해서 넘겨주기 => 그 차이
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < a.length; i++){
            temp.add(i);
            dfs(result,temp,i + 1,a,k);
            temp.remove(temp.size() - 1);
        }
    }
}

// 1. 3 / 2 /1


// 3, 6배열 -> 가변은 이후 한 번 더 판단하자,,
// 1. 3 comb = 3           / 2. 3 -> 2 comb 두개
// 나머지 3 => 2 // 2 comb에서 둘 중 하나 있는거만 선택
// 나머지 1 // 2 에서 둘 중 하나만 있는 경우

// 1. b에는 “arr의 인덱스(index)”가 저장