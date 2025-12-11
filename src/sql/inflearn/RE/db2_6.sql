-- 문제 4
--
--select
--    u.name as user_name,
--    count(order_id) as total_orders,
--    case when category = '전자기기' then count(*) end as electronic_orders,
--    case when category = '도서' then count(*) end as book_orders
--from users u
--join orders o on u.user_id = o.user_id
--join products p on p.product_id = o.product_id
--group by category

-- 구하고자 하는 결과: user_name 기준의 단일행 // 그래서 category로 묶으면 안됨.

-- CASE WHEN category = '전자기기' THEN COUNT(*) END

-- CASE는 Row 단위에서 실행
-- 1. 각 행마다 CASE의 조건이 TRUE인지 FALSE인지 결정

-- COUNT(*), SUM(), MAX() 같은 집계 함수는 모두 그룹 전체의 행을 모아서 그중 몇 개가 있는지 세는 것

-- 문제 4

select
    u.name as user_name,
    count(o.order_id) as total_orders,
    SUM(case when category = '전지기기' then 1 else 0 end) as electronic_orders,
    SUM(case when category = '도서' then 1 else 0 end) as book_orders
from users u
left join orders o on u.user_id = o.user_id
left join products p on p.product_id = u.product_id
group by u.name;

-- 문제 1
select
    name,
    category
    case category
        when '전자기기' then 'Electronics'
        when '도서' then 'Books'
        when '패션' then 'Fashion'
        Else 'etc'
    end as category_english
from products p


-- case 문 크게 두가지
-- 1. case when [조건] then end as
-- 2. case [특정 컬럼] when [값만, 조건식 x] then else end as


-- 문제 3 x
--select
--    case stock_quantity
--        when stock_quantity >= 50 then '재고 충분'
--        when stock_quantity >= 20 and stock_quantity < 50 then '재고 보통'
--        when stock_quantity < 20 then '재고 부족'
--    end as stock_level,
--    count(product_id) as product_count
--from products
--group by stock_quantity --

-- sub

-- 문제 1
select
    name,
    case job_code
        when 'A' then 'manager'
        when 'B' then 'Engineer'
        when 'C' then 'Designer'
        else 'Others'
    end as job_title
from employees;

-- 문제 2
select
    price,
    case
        when price >= 100000 then '고가'
        when price >= 50000 then '중가'
        when price < 50000 then '저가'
    end as price_level
from products;

-- 문제 3 -- 문제 확인은 이후 https://chatgpt.com/c/693a85e8-7080-8322-b38f-2a0fcdb79746

select
    case category
        when electronic then 'ELEC'
        when fashion then 'FASH'
        when book then 'BOOK'
    else "OTHERS"
    end as category_group
from products
order by
    case when price >= 100000 then desc
    else asc;


-- 하나를 읽어도 제대로 + 사고 연습 / 이게 이제 선행






