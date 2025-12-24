### 1. 최대 3개까지 초기화 방식
```declarative
int initCount = Math.min(3,M);
for(int i = 0; i < initCount; i++){
    int a = sc.nextInt();
    arr[i] = new Pic(i,1,a);
    count++;
}
// 나머지 처리
for(int i = initCount; i < M; i++){
    int a = sc.nextInt();
    logic(a, i);
}
```
=> 목표 횟수와 실제 가능 횟수 중 작은 값만큼만 실행. // 3 이상일 떄는 3으로, 이하일 떄는 유동적 