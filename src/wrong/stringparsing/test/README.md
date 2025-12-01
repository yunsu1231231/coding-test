### 1. 실패원인
API: public String(char[] value)  
new String(char): char 한 글자는 컴파일 에러  
  
문자열 생성자는 char 배열만 받고 단일 char을 받는 생성자는 존재하지 않는다.

### 2. 핵심 아이디어
char 하나를 -> String 변환 
```
String b = String.valueOf(a[0]);

String b = Character.toString(a[0]);

String b = new String(new char[]{a[0]});
```

### 3. 실수 유형

### 4. 정답 로직 
```
// 생성자 오버로딩
String.valueOf(char c)
String.valueOf(char[] data)
String valueOf(char[] data, int offset, int count)
long, double, boolean...

// null-safe
Object o = null;
String s = String.valueOf(o);  
System.out.println(s);  // "null"

// primitive → String 변환 안전하게 처리
String s = String.valueOf(123);
String x = String.valueOf(true);
String c = String.valueOf('A');

// 단일 char -> String 변환의 표준
char ch = 'Z';
String s = String.valueOf(ch);
```
- 모든 타입(기본형 + 참조형)을 문자열(String)으로 변환하는 static 메서드  
- 숫자, 문자, boolean, 객체, 배열 등 무엇이든
String으로 바꿀 때 사용하는 표준 API

### 5. 대원칙
1. String.valueOf()는 내부적으로 obj.toString()만 호출한다. 즉, 그 자료구조가 어떤 toString()을 갖고 있는지에 따라 결과가 달라짐.
2. 배열(array)은 toString()이 주소값이므로 절대 valueOf로 문자열화하면 안 된다.
```
// 배열 도구를 사용 
Arrays.toString(arr)
Arrays.deepToString(arr)
```
3. Collection (List, Set, Map)은 valueOf를 써도 괜찮다.
```
List → [1,2,3]
Set → [1,3,2] 같은 형태
Map → {key=value} 형태
```
4. valueOf는 결국 toString() 호출 래퍼, valueOf가 toString()을 호출해서 문자열을 만든 것

### 6. toString vs valueOf
```
// 1. NPE 
Object obj = null;
obj.toString(); // npe 발생

String s = String.valueOf(obj); // "null" 문자열 반환

// 2. valueOf는 형변환이 필요 x
// toString()은 Object 타입의 메서드이므로 참조형에서 사용 불가능  
int x = 10;
x.toString(); // 컴파일 오류 

// valueOf는 오버로딩해서 모든 타입 처리
String.valueOf(true);

// 3. toString() 기본 형태
@Override
public String toString() {
    return ...;
}
```

