-- 6장
-- 문제 1
SELECT name, price, (price * 0.85) as `sale_price`
FROM products;

-- 문제 2 x
--SELECT CONTCAT_WS(name, address) as customer_info
--FROM customers;

SELECT CONCAT_WS(' - ', name, address) as customer_info
FROM customers;

-- 문제 3 x
--SELECT name, COALESCE(product_display_info,null)
--SELECT products;

SELECT name, COALESCE(description, name) as product_display_info
FROM products;

-- 문제 4
SELECT name, description, COALESCE(description, name, '정보없음') as display_text
FROM products;

-- 문제5 x
SELECT
    email,
       SUBSTRING_INDEX(email, '@', 1) as user_id,
       CHARACTER_LENGTH(SUBSTRING_INDEX(email, '@', 1)) as id_length
FROM customers;
