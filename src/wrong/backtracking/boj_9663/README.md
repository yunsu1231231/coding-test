```declarative
    static int[] arr;
    public static void main(String[] args) {
        for(int i = 1; i < 3; i++){
            for(int j = 1; j < 3; j++){
                System.out.println(i + " " + j);
            }
        }

        // same 로직 
        arr = new int[2];
        dfs(0);
    }
    private static void dfs(int depth){
        if(depth == 2){
            StringBuilder sb = new StringBuilder();
            for(int i : arr){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 1; i < 3; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
```
-> 그냥 for문이랑도 비교 // 꼭 해보기 