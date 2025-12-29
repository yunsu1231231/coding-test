### 1. 문제점
```declarative
class Alpha {
    StringBuilder a;
    
    @Override
    public boolean equals(Object o) {
        Alpha alpha = (Alpha) o;
        return Objects.equals(a, alpha.a);  // ← 여기서 문제!
    }
}

// 1. Objects.equals() 내부
public static boolean equals(Object a, Object b) {
    return (a == b) || (a != null && a.equals(b));
    //                               ↑ 여기서 StringBuilder.equals() 호출
}

// 2. StringBuilder.equals()는 오버라이드 안 함
//    → Object.equals() 사용 → 참조 비교만!

// 3. 결과
StringBuilder sb1 = new StringBuilder("abc");
StringBuilder sb2 = new StringBuilder("abc");
Objects.equals(sb1, sb2);  // false! 다른 객체니까

Alpha.equals()는 내가 정의
하지만 그 안에서 sb1.equals()를 호출 ← 이건 StringBuilder가 정의

내가 오버라이딩하는 건 어떻게 비교할지(방법)이고, 실제 비교는 필드 객체가 가진 equals()가 하는데, 
그 객체(StringBuilder)에 equals()가 제대로 구현 안 되어 있으면 내가 오버라이딩해도 의미 x

=> String 사용 
```

### 2.
```declarative
        Set<String> s = new HashSet<>(); // String 바로 사용!
```

### 3. 2차 풀이
```declarative
substring() vs split()
인덱스 기반 vs 구분자
```
```declarative
각 for문 변수가 무엇을 대표하는지 -> 문자열 모델 기준으로 정의하지 않고 바로 코드로 들어감

i, j가 문자열의 어떤 개념을 의미하는지: 명확히 인지

1 ~ 5 1개씩, 1 ~ 4, 2개씩, 1 ~ 3 3개씩.. 순회 로직
-> 문자열에서 모든 시작 위치에서
가능한 모든 길이의 부분 문자열을 만들어라
```

단계별 사고  
1. 부분 문자열을 정의하려면 최소 정보가 뭘까?
시작 위치, 길이 
2. for문 변수를 명확히 인지
```declarative
i = 시작 인덱스
j = 부분 문자열의 길이
```

대원칙 사고  
문자열 + 이중 for문 
1. 내가 만들려는 결과 1개는 어떤 정보로 정의되는지
ex. 부분 문자열 -> 시작 + 길이
```declarative
결과 1개:
문제에서 요구하는 최소 단위의 출력 대상,, 문제에서 다루는 최소 단위
ex. 집합에 넣거나, 개수를 세거나, 비교하는 한 덩어리

```
2. for문 변수 하나당 하나의 역할
```declarative
i = 시작 위치
j = 길이
```