### 1. 실패요인 
1. sort(T[] a, Comparator<? super T> c)
제네릭은 기본형을 제공하지 않으므로 char[] 사용하지 못한다.

### 2. 해결책
```declarative
Arrays.sort(arr); // 오름차순

// 정렬 후 뒤집기 
StringBuilder sb = new StringBuilder(new String(arr));
sout(sb.reverse());
```

### 3. 언제 StringBuilder 사용하는지
문자열을 반복문 안에서 이어붙일 때 + **문자열을 뒤집을 때** 

문자열을 한 번만 합칠때는 그냥 연산하기

```declarative
String result = "";
for (int i = 0; i < 10000; i++){
    // result = new StringBuilder(result).append(i).toString();
    result += i; // 매 반복마다 새로운 객체가 생성 
}

// 하나의 버퍼에서 수정
StringBuilder sb = new StringBuilder();
for(int i = 0; i < 10000; i++){
    sb.append(i); // 같은 객체에서 추가 
}
```

### 4. StringBuilder 핵심 API 
```declarative
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder("hello");

sb.append("abc");
sb.reverse();
sb.toString();
sb.length();
sb.charAt();

sb.insert(0,"a"); // i 위치에 삽입 
sb.delete(start,end) // 범위 삭제
setCharAt(0, 'x') // i번째 문자 변경

// sout()은 객체를 받으면 자동으로 toString()을 호출한다. 
StringBuilder sb = new StringBuilder("hello");

System.out.println(sb);            // 자동으로 toString() 호출
System.out.println(sb.toString()); // 위와 동일
```