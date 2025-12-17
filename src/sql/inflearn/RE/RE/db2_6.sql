-- 문제 1

select
    name,
    category,
    case category
        when '전자기기' then 'Electronics'
        when '도서' then 'Books'
        when '패션' then 'Fashion'
        else 'etc'
    end as category_english
from products

-- 문제 3

select
    count(*) as product_count,
    case
        when stock_quantity >= 50 then '재고 충분'
        when stock_quantity >= 20 then '재고 보통'
        else '재고 부족'
    end as stock_level
from products
group by stock_level;


-- 문제 4

select
    u.name as user_name,
    count(*) as total_orders,
    case when p.category = '전자기기' then count(*) end as electronics_orders,
    case when p.category = '도서' then count(*) end as book_orders
from users u
left join orders o on u.user_id = o.user_id
left join products p on o.product_id = p.product_id;

select
    u.name as user_name,
    count(o.order_id) as total_orders,
    sum(case when p.category = '전자기기' then 1 else 0 end) as electronics_orders,
    sum(case when p.category = '도서' then 1 else 0 end) as fashion_orders
from users u
left join orders o on u.user_id = o.user_id
left join products p on o.product_id = p.product_id
group by
    u.name;

