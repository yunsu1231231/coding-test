-- 5장
-- 문제 1
SELECT name as `상품명`, price as `가격`
FROM products;

-- 문제 2
SELECT * FROM customers WHERE name = '장영실';

-- 문제 3
SELECT *
FROM products
where price >= 10000 AND stock_quantity < 50;

-- 문제 4
SELECT name, price
FROM products
WHERE product_id IN (2,3,4);

-- 문제 5
SELECT name, address
FROM customers
where address like '서울특별시%';
-- 문자 = ''
-- 컬럼명, 테이블명 = 백틱(``)

-- 문제 6
SELECT *
FROM products
WHERE description is null; -- 아직 입력 x = null

-- 문제 7 x
--SELECT *
--FROM products
--desc price;

SELECT *
FROM products
ORDER BY price desc;

-- 문제 8
SELECT *
FROM products
ORDER BY price ASC, stock_quantity desc;

-- 문제 9
SELECT *
FROM customers
ORDER BY join_date desc
LIMIT 0,2; -- 0부터 2개

-- 문제 10 x
--SELECT customer_id, product_id
--FROM orders
--where customer_id not null

SELECT DISTINCT customer_id, product_id -- 중복제거 -> DISTINCT
FROM orders
where customer_id not null

-- 문제 11
SELECT price_name as `상품이름`, stock_quantity as `남은 수량`
FROM products
where price > 3000 AND stock_quantity <= 100
ORDER BY stock_quantity desc
LIMIT 3;