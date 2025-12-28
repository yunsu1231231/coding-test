-- 4번 x
--select
--    customer_name,
--    COUNT(order_id) as "총 주문 횟수",
--    COUNT(quantity) as "총 구매 수량"
--from order_stat
--group by customer_id
--order by "총 주문 횟수" desc, "총 구매 수량" desc;

-- 집계 함수의 선택
-- COUNT vs SUM
-- COUNT => "행"의 개수 ex. 주문 횟수 = 데이터 행의 개수
-- SUM => "합계"를 계산 ex. 총 구매 수량 = 각 행의 합계

select
    customer_name,
    COUNT(*) as `총 주문 횟수`,
    SUM(quantity) as `총 구매 수량`
from order_stat
group by customer_name
order by `총 주문 횟수`` desc, `총 구매 수량`` desc;