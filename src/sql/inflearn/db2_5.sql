-- db2 5장 -- 1 3

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

-- 문제 3 x
--select order_date as `이벤트 날짜`,
--from orders
--union all
--select created_at as `이벤트 날짜`,  ,
--from users

select
    created_at as 이벤트날짜,
    `고객 가입` as 이벤트종류, -- select 절에서 상수는 모든 행에 그 값 그대로 들어간다.
    name as 상세내용
from users

union all
select
    o.order_date as 이벤트날짜,
    '상품 주문' as 이벤트종류, -- 출력될 실제 데이터이므로 문자열
    p.name as 상세내용
from orders o
inner join products p on o.product_id = p.product_id

-- 사고의 순서
-- 1. 상품 이름 표시 -> 상품 테이블이 필요, 기준은 주문
-- 그래서 join을 하고 이 집합에서 데이터 조회

-- 문제 4
select
    name as 이름,
    '고객' as 역할,
    email as 이메일
from users

union all

select
    name as 이름,
    '직원' as 역할,
    CONCAT(name,'@my-shop.com') as 이메일
from employess

order by 이름;

-- union
-- order by, limit만 한 번 사용
