-- 1, 3, 4

-- 문제 1 x
-- sql case문
-- case when then end
select
    name,
    category,
    CASE category
        WHEN '전자기기' THEN 'Electronics'
        WHEN '도서' THEN 'Books'
        WHEN '패션' THEN 'Fashion'
        ELSE 'Etc'
    END AS category_english
from products

-- 문제 2

select
    order_id,
    CASE
        WHEN quantity >= 2 THEN '다량 주문'
        WHEN quantity = 1 THEN '단일 주문'
    END AS order_type
from orders
order by -- 조건 기반 정렬
    case
        when quantity >= 2 then 1
        else 2
    end asc;


-- 문제 3 x
--select
--    case
--        when count(*) >= 50 then '재고 충분'
--        when count(*) >= 20 and count(*) < 50 then '재고 보통'
--        when count(*) < 20 then '재고 부족 '
--    end as stock_level
--    count(*) as product_count
--from products
--group by stock_quantity;

-- sql 실행 순서
-- from where group by having select order

select
    case
        when stock_quantity >= 50 then '재고 충분'
        when stock_quantity >= 20 and stock_quantity < 50 then '재고 보통'
        when stock_quantity < 20 then '재고 부족'
    end as stock_level
    count(*) as product_count
from products
group by stock_level; -- select 절의 결과값을 쓰는게 아니라 case 구문 그 자체를 사용
-- CASE는 두 번 계산되는 셈:
-- 1. 한 번은 GROUP BY에서 그룹 나누기 위해
-- 2. 한 번은 SELECT에서 결과 컬럼 출력하기 위해

-- 문제 4 x
-- 피벗: 행 -> 열로 바꾸는 표

select
    u.name as user_name,
    count(o.order_id) as total_orders, -- pk 기반
    sum(case when p.category = '전자기기' then 1 else 0 end) as electronics_orders,
    sum(case when p.category = '도서' then 1 else 0 end) as book_orders,
    sum(case when p.category = '패션' then 1 else 0 end) as fashion_orders
from users u
left join
    orders o on u.user_id = o.user_id
left join
    products p on o.product_id = p.product_id
group by
    u.name;


-- 1. 어떤 테이블들이 필요한지: 조건에 따른
-- 2. 피벗은 결국 행 -> 열 / 열에 대해 재정의가 필요 / 각 열을 이제 어느 테이블에서 뭘 기준으로 select 할지 생각