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