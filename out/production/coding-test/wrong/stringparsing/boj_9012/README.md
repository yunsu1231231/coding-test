### 1. 실패요인 
1. 코드 구현 전 설계 부족 
조건에 따라 코드 흐름이 달라지는 지점을 먼저 파악 + 흐름을 구현하기 위한 구조까지 설계 후 + 코드 진입 
= 문제에 대한 이해 
```
[조건 단위 1] cur == '(' ?
→ push

[조건 단위 2] cur == ')' ?
→ 아래 조건으로 분기

    [조건 단위 3] stack.isEmpty() ?
        → 실패 후 종료

    [조건 단위 4] (empty가 아님)
        → pop

[조건 단위 5] 모든 반복 종료 후 stack.isEmpty() ?
    → YES
    → NO
```
2. 자료형의 선택 + 그 자료형의 특징에 대한 온전한 잏 ㅐ
3. String vs char 혼선 
```
Deque<Chracter> stac // Character 사용 
```
### 선택 대원칙  

3.1) 문자를 하나씩 처리하는 문제는 char 기반으로 하고  
```
char[] arr = s.toCharArray();
for(char c : arr)
```
3.2) 문자열을 덩어리로 처리하는 문제는 String 기반으로 하기
```
split() 
replace(), replaceAll() // 문자열 치환
substring() // 부분 문자열 처리
contains(), indexOf() // 특정 단어 찾기
List<String> // 여러 개의 문자열을 하나로 묶어서 처리
"Hello I am Yunsu" // 자연어 단위로 처리할 때 
```

