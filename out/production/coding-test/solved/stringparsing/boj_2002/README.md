### 1. 잘못된 로직
입구 순서대로 비교하면 제대로 된 기준이 안됨.

추월: 입구에서 뒤에 있던 차가 출구에서 앞에 나온 경우 

종속 관계:  
출구 -> 입구  
출구 처리에 따라 입구 리스트가 변한다.

왜?  
출구 차량이 나올 때마다 입구 리스트가 변해야 한다. 아직 안 나온 차들만 추적하기 위해. 
```declarative
List<String> entry = [A, B, C, D];  // 입구 리스트

for(출구 차량){  // ← 출구
    int idx = entry.indexOf(차량);
    
    if(idx > 0) count++;
    
    entry.remove(idx);  // ← 입구 리스트 변경
}
```
### 2. 잘못된 로직 + 코드
```declarative
    private static void dfs(){
        if(queue.isEmpty()){
            return;
        }

        for(String now : arr){
            if(!queue.isEmpty()){
                String aaa = queue.remove();
                if(aaa.equals(now)){
                    continue;
                } else {
                    count++;
                    dfs();
                    // 다음 dfs는 다시 처음 now부터 순회
                }
            }
        }
    }
```

### 3. 해결책
```declarative
// 1. 인자 전달
private static void dfs(int idx){
    if(queue.isEmpty() || idx >= arr.length){
        return;
    }
    String exitCar = queue.remove();

    if(exitCar.equals(arr[idx)){
        dfs(idx + 1) // 다음 인덱스
    } else {
        count++;
        dfs(idx); // 같은 인덱스 
    }
}

private static void dfs(int startIdx){
    if(queue.isEmpty() || startIdx >= arr.length){
    return;
}

// startIdx부터 끝까지 순회
for(int i = startIdx; i < arr.length; i++){
    if(queue.isEmpty()) break;

    String exitCar = queue.remove();

    if(exitCar.equals(arr[i])){
    // 다음 인덱스부터 계속
    continue; 
    } else {
        count++;
        // 같은 인덱스부터 다시 시작
        dfs(i);
        return;  // 기저 조건이랑 별개로 다음 dfs 호출 후 더 이상 for문 탐색을 안해야 되므로
        }
    }
}

// 호출
dfs(0);  // 0번 인덱스부터 시작
// 2. 반복문 
int idx = 0;

while(!queue.isEmpty() && idx < arr.length){
    String exitCar = queue.poll();

    if(exitCar.equals(arr[idx])){
        idx++;  // 다음 인덱스
    } else {
        count++;
        // idx는 그대로 (같은 인덱스에서 재시도)
    }
}
```
코드 첫 줄로 돌아가기 -> 반복
같은 now 유지 -> 같은 스코프  
= 결국 이게 while: 조건이 참인 동안 계속 반복 

따라서 맞출 때까지 = 조건부 반복 = while 정의가 적합
1. 각 항목에 대해 조건 만족까지 반복