### 1. 입력  
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 1  

```declarative
String a = sc.nextLine();

if(a.charAt(0) == '1'){
    String[] parts = a.split(" ");
    int score = Integer.parseInt(parts[1]);
    int remainTime = Integer.parseInt(parts[2]);
    stack.push(new Job(score, remainTime));
}

int type = sc.nextInt(); // 애초에 토큰 하나만 받고
if(type == 1){
    int score = sc.nextInt();
    int remainTime = sc.nextInt();
    stack.push(new Job(score, remainTime));
} else ... 
```
### 2. 분기, 예외처리
생각 (배타적)  
"과제가 들어오면 push"  
"과제가 안 들어오면 작업"  
→ 둘 중 하나만 일어난다고 생각

실제 (순차적)  
"과제가 들어오면 push하고, 그 분에 작업도 함"  
"과제가 안 들어와도 작업함"  
→ 매 분마다 작업은 무조건 일어남

연산 예외처리 = 전제 조건이 있는 연산은 검증  
1. 스택, 큐, 덱 -> 비어있는가
2. 배열, 리스트 -> 인덱스 범위 안인가
3. 문자열 -> 길이가 충분한가
4. 나눗셈 - 분모가 0인지 확인
5. 객체,참조 -> null 유무
6. 상태가 동적 변화



## 핵심
```
토큰 메서드 (nextInt, next, nextDouble 등):
- 개행을 남김
- 다음 토큰 읽을 때 개행 자동 스킵

nextLine():
- 개행까지 읽고 제거
- 토큰 메서드 후에는 개행 제거 필수!

charAt() // 한 글자만 가지고 온다 
따라서 여러 숫자에 대해서 한 번에 받을때는 split(), nextInt()로 가지고 오기 