-- 문제 10 x

--select
--    DISTINCT user_id as customer_id,
--    DISTINCT product_id
--from orders

select
    DISTINCT user_id as customer_id,product_id
from orders;


-- 1.DISTINCT는 SELECT 절에서 한 번만 사용 가능
-- 2.DISTINCT는 SELECT 결과 전체(행 단위)에 적용 / (A, B)라는 하나의 튜플이 중복 판단
-- 3.행 단위 적용의 의미: SELECT에 적힌 컬럼들을 한 줄로 묶어서 이 줄이 전에 나왔으면 버린다.