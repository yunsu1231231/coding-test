-- 7장
-- 1번
SELECT COUNT(*) as `총 주문 건수`, COUNT(category) as `카테고리 보유 건수`
FROM order_stat;

-- 2번
SELECT
    SUM(price * quantity) as `총 매출액`,
    AVG(price * quantity) as `평균 주문 금액`,
    MAX(price) as `최고 단가`,
    MIN(price) as `최저단가`
FROM order_stat;

-- 3번
SELECT category, SUM(quantity), SUM(price  * quantity) as `1`
FROM order_stat
GROUP BY category
ORDER BY `1` desc;

-- 4번 x
--SELECT customer_name, COUNT(*) as `총 주문 횟수`, SUM(quantity) as `총 구매 수량`
--FROM order_stat
--GROUP BY customer_name
--ORDER BY `총 주문 횟수`, `총 구매 수량` desc;

SELECT customer_name, COUNT(*) as `총 주문 횟수`, SUM(quantity) as `총 구매 수량`
FROM order_stat
GROUP BY customer_name
ORDER BY `총 주문 횟수` desc , `총 구매 수량` desc;

-- 5번
SELECT customer_name, SUM(price * quantity) as `총 구매 금액`
FROM order_stat
GROUP BY customer_name
HAVING `총 구매 금액` >= 400000
ORDER BY `총 구매 금액` DESC;

-- 6번
SELECT customer_name, COUNT(*) as `주문 횟수`, SUM(price * quantity) as `총 사용 금액`
FROM order_stat
WHERE product_name != '도서' -- OR category is NULL 추가 -- null은 비교연산자로 비교 불가능하기 때문에 제외되므로 null을 포함시키고 싶으면 추가해야 된다.
GROUP BY customer_name
HAVING COUNT(*) >= 2
ORDER BY `총 사용 금액` desc;