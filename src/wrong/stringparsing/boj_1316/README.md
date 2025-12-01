### 1. 실패요인 
1. map.putIfAbsent(aaa[j],j) vs map.put(aaa[j],j)  
map.putIfAbsent는 key가 없을 때만 값을 넣는다. 따라서 키가 있을 때 값을 덮어쓰기 위해서는 put을 사용하기 