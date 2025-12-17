### 오답
1. case는 행 단위, count / sum은 그룹 단위  
```declarative
case when p.category = '전자기기' then count(*) ..
```
지금 이 한 행이 전자기기라면, 전체 그룹의 row 개수를 세어라

2. count(*) 의미
left join이면 주문이 없는 행도 1이 나올 수 있으므로  
```declarative
count(o.order_id) -- 실제 주문이 존재하는 행만 세기
```

3. select절 집계함수
반드시 -> group by가 필요하다
```declarative
group by u.name
```

4. 조건부 집계
```declarative
SUM(case when ... then 1 else 0 end)
```

CASE는 각 행에 대해 조건을 판단해
임시 값(파생 컬럼)을 만들고,
그 임시 값을 기반으로
집계 함수(SUM, COUNT 등)가 이후에 적용된다.  

![img.png](img.png)