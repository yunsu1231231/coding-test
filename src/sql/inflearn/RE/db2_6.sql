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

