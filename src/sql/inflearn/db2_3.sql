-- db 2, 3장

-- 1번 x
--SELECT p.name as name, p.price as price
--FROM products p
--LEFT JOIN orders o on p.product_id = o.product_id
--WHERE p.category = '전자기기' AND o.product_id is null;

SELECT p.name as name, p.price as price
FROM products p
LEFT JOIN orders o on p.product_id = o.product_id
WHERE p.category = '전자기기' AND o.order_id is null;

-- 미판매 상품을 찾을 때: pk로 찾는게 안전하다.

-- 2번 x
--SELECT name, COUNT(o.order_id) as order_count
--FROM users u
--LEFT JOIN orders o ON u.user_id = o.user_id
--GROUP BY u.user_id
--ORDER BY name asc;

SELECT name, COUNT(o.order_id) as order_count
FROM users u
LEFT JOIN orders o ON u.user_id = o.user_id
GROUP BY u.user_id, u.name
ORDER BY name asc;

-- 표준 SQL 규칙: SELECT 안에 있는 모든 비-집계 컬럼은 GROUP BY에 반드시 포함
-- COUNT(NULL)은 항상 0

-- 3번 / Right join 생략

-- 4번
--SELECT u.name as user_name, p.name as product_name
--FROM users u
--LEFT JOIN orders o ON u.user_id = o.user_id
--LEFT JOIN products p ON o.product_id = p.product_id
--GROUP BY u.name, p.name
--ORDER BY user_name, product_name;

SELECT u.name as user_name, p.name as product_name
FROM users u
LEFT JOIN orders o ON u.user_id = o.user_id
LEFT JOIN products p ON o.product_id = p.product_id
ORDER BY user_name, product_name;

-- 문제 조건: 한 고객이 여러 상품을 주문했다면 모든 상품명 나와야 한다.
-- 그대로 행이 다 나와야 하기 때문에 GROUP BY를 사용하면 안된다.
-- 고객 1 -> 상품 A, 고객 1 -> 상품 B, 고객1 -> 상품 C
