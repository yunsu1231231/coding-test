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