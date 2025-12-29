-- 1번 o
select
    o.order_id,
    p.name,
    o.quantity
from orders o
join products p on o.product_id = p.product_id
order by o.order_id;

-- 2번 o
select
    o.order_id,
    u.name,
    p.name,
    o.order_date
from orders o
join products p on o.product_id = p.product_id
join users u on u.user_id = o.user_id
where o.status = "SHIPPED"

-- 문제 3 x
select
    u.name as user_name, -- 행 단위 값 -- 이렇게 되면 여러 행을 합한 하나의 값 중 임의의 하나의 u.name을 가져온다
    SUM(o.quantity * p.price) as total_purchase_amount -- 여러 행 -> 하나의 값
from users u
join orders o on u.user_id = o.user_id
join products p on o.product_id = p.product_id
group by u.name -- 이 부분 누락
order by total_purchase_amount desc;

-- 사용자별 -> group by에 대한 근거

