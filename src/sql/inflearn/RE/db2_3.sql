-- 1번 o
select
    p.name as name,
    p.price as price
form orders o
left join products p on p.product_id = o.product_id
where p.category = "전자기기" and o.order_id IS NULL;
