### 1. 틀린 이유
dp[i] 까지의 최대값 만으로 LIS 판단 불가
```declarative
// 이전 코드
import java.util.*;

public class boj_12015 {
public static void main(String[] args) {
// 0 based
// 1. dp[i] 번째 까지의 가장 긴 수열
// 2. dp[i-1] 까지의 최대값과 dp[i]를 비교
// 2. dp[i] = dp[i-1] + 1 or dp[i-1] = dp[i-1]
// 초기화 -> dp[0], dp[1]
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    P[] dp = new P[N];
    int[] arr = new int[N];
    for(int i = 0; i < N; i++){
        arr[i] = sc.nextInt();
    }
    dp[0] = new P(0,arr[0]);
    // dp 초기화
    for(int i = 1; i < N; i++){
    dp[i] = new P(0,0);
    if(dp[i-1].mmm < arr[i]){
        dp[i].length = dp[i-1].length + 1;
        } else {
        dp[i].length = dp[i-1].length;
        }
        dp[i].mmm = Math.max(dp[i-1].mmm,arr[i]);
        }
        System.out.println(dp[N-1].length + 1); // 시작 1
    }
}

class P{
    int length; // dp까지 최대 길이
    int mmm; // dp 까지 최대값

    P(int length, int mmm){
        this.length = length;
        this.mmm = mmm;
    }
}

```
LIS 로직:  
이전에 있던 여러 값 중에서 적절한 값을 선택해서 증가하는 수열을 만드는 문제 != 최대값과 비교하는 문제가 아니다.  

연속된 값이 아닌 중간 값들을 뛰어넘어서 선택할 수 있는게 핵심
