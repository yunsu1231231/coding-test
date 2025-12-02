### 틀린 이유
1. nextInt(), nextDouble(), next() 뒤에는 줄바꿈이 남는다.  
공백 / 엔터는 남긴다. 

```declarative
nextLine()을 섞어 쓰는 순간,
그 전에 나온 nextInt(), nextDouble(), next()가 남긴 엔터(\n)를
sc.nextLine() 한 번 호출해서 반드시 제거
```

2. 시간초과  
BufferReader = 입력 (I / O) 반복 갑소  
StringBuilder = 출력(I / O) 반복 감소
```declarative
// 1. bufferdReader로 입력 받기
BufferedReader br = new BufferedReader(new InputStreamReade(System.in)); 

// 2. 줄 단위 읽기
String line = br.readLine();

// 3. StrinBuilder로 출력 모아두기
StrinbBuilder sb = new StringBuidler();
sb.append(값).append(' ');
sout(sb.toString());
```

### Tip
1. 입력을 문자열로 처리 가능하면 nextLine() 사용  
ex. 명령 + 값, 공백 포함 문자열, 정형화된 입력이 아닐 때, 여러 형태의 혼합 입력 

2. String[] b = a.split(" ") 사용

### 문법
```declarative
// Integer.parseInt()는 "정수" 모양의 문자열만 받는다
int num = Integer.parseInt("123");
```

