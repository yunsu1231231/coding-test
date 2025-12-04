### 1. 틀린이유
```declarative
// 1. Input 속도 개선  // input i / o 작업을 줄이기 
BufferdReader rb = new BufferedReader(new InputStreamReader(System.in));

int a = Integer.parseInt(rb.readLine());

StringTokenizer st = new StringTokenizer(rb.readLine()); // String을 인자로 받음, 파싱 -> 토큰 단위로 저장 // 그래서 readLine이랑 같이 자주 사용 
int[] a = new int[N];
for(int i = 0; i < N; i++){
    a[i] = Integer.parseInt(st.nextToken());
}

// 2. 출력 속도 개선
for(int i : result){
    sb.append(i).append(' '); // sb.append는 모든 타입을 지원, char[] 을 제외한 나머지 기본형 배열은 직접 Arrays.toString(arr)로 문자열로 넣어야 됨만 주의. 나머지는 다 문자열로 내부에서 toString() 호출해서 변환  
}
sout(sb);

```