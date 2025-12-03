### 1. 틀린 이유
```declarative
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    draw(N,1);
}

private static void draw(int size, int count){
    if(size == 3){
    realDraw();
    return;
}
    draw(size / 3, count * 3);
}

private static void realDraw(){
    System.out.println("*"+"*"+"*");
    System.out.println("*" + " " + "*");
    System.out.println("*"+"*"+"*");
}
```