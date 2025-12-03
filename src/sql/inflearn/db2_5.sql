-- db2 5장

-- 문제 1 x
-- UNION: 두 개 이상의 select 결과 집합을: 위에서 아래로 합치는 집합연산 / 세로 방향으로
-- 합칠 때 특징
-- 1. 중복 제거
-- 2. 컬럼 수, 타입 일치
-- union all은 빠른 대신 중복 유지
-- 쿼리내에서 절 단위로 통째로 집합이 조작되어서 통으로 출력

select name, email
from users
union
select name, email
from retired_users;

-- 문제 2

select distinct name, email
from orders o
join users u on o.user_id = u.user_id
join products p on p.product_id = o.product_id
where p.category = '전자기기';
union all
select distinct name,email
from orders o
join users u on o.user_id = u.user_id
join products p on p.product_id = o.product_id
where o.quantity >= 2;

-- distinct 인지: 중복되는 행을 제거하고, 고유한 행만 남기는 기능
-- distinct는 select 절에서만 사용가능
