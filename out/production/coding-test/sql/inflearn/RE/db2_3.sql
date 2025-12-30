-- 1번 o
select
    p.name as name,
    p.price as price
form orders o
left join products p on p.product_id = o.product_id
where p.category = "전자기기" and o.order_id IS NULL;

-- 2번 x
select
    u.name,
    count(o.order_id) as order_count
from users u
left join orders o on u.user_id = o.user_id
group by u.user_id, u.name -- 두번째 기준 간과
order by u.name;

-- group by에 select 컬럼을 다 써야 한다
-- 당연: group by가 기준인데 group by로 묶은것에서 임의로 하나의 속성을 꺼낼 수 없으므로