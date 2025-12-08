char[0] == null 은 컴파일 오류
```declarative
char[] a = new char[5];
int[] b = new int[5]; // default 0

System.out.println(a.length);
if(a[0] == '\u0000'){
    System.out.println("yes");
}
```

```declarative
// String 변환
String.valueOf() 사용
```