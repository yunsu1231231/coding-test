-- db2, 2장

-- 1번 x
--SELECT *
--FROM orders as o
--INNER JOIN products as p where o.product_id = p.product_id
--ORDER BY order_id asc;

SELECT
    o.order_id,
    p.name,
    o.quantity
 FROM
    orders o
 JOIN
    products p ON o.product_id = p.product_id
 ORDER BY
    o.order_id

-- 2번 x
--SELECT order_id, user_name, product_name, order_date
--FROM orders o
--JOIN users u ON o.user_id = u.user_id
--JOIN products p ON p.product_id = o.product_id;

SELECT order_id, user_name, product_name, order_date
FROM orders o
JOIN users u ON o.user_id = u.user_id
JOIN products p ON p.product_id = o.product_id;
WHERE o.status = 'SHIPPED';

-- 언제 SELECT 절에 ALIS 지정해줘야 하는지?
-- 1. 컬럼명이 두 테이블에서 중복될 때 / SELECT o.user_id, u.user_id
-- 2. 표현식이나 계산식이 있을 때 / SELECT price * quantity as total_price

-- 3번 x
--SELECT u.name as user_name, SUM(p.price * p.quantity) as total_purchase_amount
--FROM users u
--JOIN orders o ON u.user_id = o.order_id
--JOIN products p ON o.order_id= p.product_id;
--ORDER BY total_purchase_amount desc;

SELECT u.name as user_name, SUM(p.price * o.quantity) as total_purchase_amount
FROM users u
JOIN orders o ON u.user_id = o.order_id
JOIN products p ON o.order_id= p.product_id;
GROUP BY u.name
ORDER BY total_purchase_amount desc;

-- 고객별 지금까지 주문한 총 구매금액을 계산
-- 고객별: 그룹 기준이 고객
-- 총 구매액: SUM() 사용