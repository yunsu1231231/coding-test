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

-- 문제와 풀이2

-- 문제 1 x
--SELECT *
--from employees e -- 부하
--join employees y ON e.employee_id = y.employee_id;
--WHERE e.name = '최과장';

SELECT *
from employees e -- 상사
join employees y ON e.employee_id = y.manager_id;
WHERE e.name = '최과장';

-- 문제 2 x
--SELECT *
--from sizes s
--CROSS JOIN;

SELECT
    CONCAT('기본티셔츠-', c.color, '-', s.size, '-',m.material) AS product_full_name,
    s.size,
    c.color,
    m.material
FROM sizes s
CROSS JOIN
    colors c
CROSS JOIN
    materials m
ORDER BY
    s.size, c.color, m.material;

-- 문제 3 x
--SELECT
--    u.name as customer_name,
--    p.name as product_name,
--    o.order_date as order_date,
--    p.stock_quantity as quantity
--from products p;
--left join orders o on o.product_id = p.product_id
--left join users u on u.user_id = o.user_id
--group by u.name
--HAVING u.name = '네이트'
--order by o.order_date desc;

-- 절의 특징
-- INNER JOIN = 테이블에서 매칭되는 데이터만 출력
-- where 절: 모든 행에 대한 조건 / group by x: 모든 주문 레코드가 그대로 출력

from products p;
left join orders o on o.product_id = p.product_id

-- 상품을 기준으로 주문이 없어도 상품은 전부 포함된다.
-- 대원칙: join하면 컬럼 종류는 그대로 다 합쳐지고 / 행에 대한 교집합, 합집합

SELECT *
FROM users u
JOIN orders o ON u.user_id = o.user_id
JOIN products p ON o.product_id = p.product_id
WHERE u.name = '네이트'
ORDER BY o.order_date DESC;

-- 문제 4 x
-- 1. 기준 테이블 설정: 내가 보고 싶은 전체 행이 어디에 있는지: 그 테이블이 기준: left join
-- 2. 매칭되는 데이터를 버려도 되는지 유무 yes: inner, no: left (null 결과)

SELECT
    u.name as customer_name,
    SUM(p.price * o.quantity) as `총 주문 금액`
from users u
join orders o on u.user_id = o.order_id
join products p on o.product_id = p.product_id;
where u.address LIKE '서울%' -- 서울 조건 누락, 서울 조건은 모든 행을 대상으로 해야 되어서 where 조건절
group by u.name
order by `총 주문 금액` desc;

-- 결국 join은 행을 대상으로, 기준 행이 무엇인지 = 내가 원하는 모든 행, 결과 행: 기준
-- 속성은 join은 다 이어붙이기!
