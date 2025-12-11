1. 재귀로 회전 결과를 반영하면서 계속 전파시키는 방식  
= 전파 방향을 모두 결정하기 전에 회전을 수행하면 안 된다.

그래서 두 step으로 나누지 못한 것
1. 회전 방향만 결정
2. 결정된 방향을 기준으로 톱니 이동 

### 재귀의 대원칙
상태를 즉시 반영 + 반영된 그 상태로 다음 호출 

![img.png](img.png)
![img_1.png](img_1.png)

전파 판단 시점 + 회전을 혼용
실제 로직 순서는
1. 비교만 하고
2. 방향만 결정하고
3. 회전은 마지막에 일괄 적용

```declarative
Iterator<T> it = dq.iterator();
it.next();   // 0
it.next();   // 1 → 오른쪽 비교용

Iterator<T> it = dq.descendingIterator();
it.next();   // 7
it.next();   // 6 → 왼쪽 비교용

```