-- 문제 2 o
select
    CONCAT_WS(' - ',name,address) as customer_info
from customers;

-- 문제 3 o
select
    name,
    COALESCE(description,name) as product_display_info
from products;

-- 문제 5 x
--select
--    email,
--    SUBSTRING_INDEX(email,@,1) as user_id,
--    CHAR_LENGTH(user_id) as id_length
--from customers

-- select 절에서 만든 별칭은 같은 select절의 다른 컬럼에서 참조할 수 없다.
-- FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY
-- select 절은 왼쪽부터 순차 실행이 아닌
-- select 절 전체가 한 덩어리로 평가된 후 + 별칭은 select가 끝난 후에 이름이 붙는다.

-- 따라서 같은 단계에서 재사용 하고 싶으면 -> 단계를 하나 더 만들기 = 서브쿼리, CTE

select
    email,
    SUBSTRING_INDEX(email,'@',1) as user_id,
    CHAR_LENGTH(user_id) as id_length
from customers;