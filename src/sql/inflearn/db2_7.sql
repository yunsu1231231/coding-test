-- 문제 1 x
-- view 생성
-- create view [view 이름] as [select 쿼리~]

-- 뷰 생성
create view v_customer_email_list as
select
    user_id,
    name,
    email
from users

-- 뷰 조회
select * from v_customer_email_list;


-- 문제 2
create view v_order_summary as
select order_id,
       u.name,
       p.name,
       o.quantity,
       o.status
from orders o
join users u on u.user_id = o.user_id
join products p on o.product_id = p.product_id;

select * from v_order_summary;

-- 문제 3 x
create view v_electronics_status as
select
    category,
    count(o.order_id) as total_orders,
    sum(o.quantity * p.price) as total_sales
from orders o
join products p on p.product_id = o.product_id
where p.category == '전자기기'
group by
    p.category;

-- 집계함수 + 단일컬럼조합 = group by가 필요


-- 문제 4
alter view v_electronics_status as
select
    category,
    count(o.order_id) as total_orders,
    sum(o.quantity * p.price) as total_sales,
    avg(o.quantity * p.price) as average_order_value
from orders o
join products p on o.product_id = p.product_id
where category = '전자기기'
group by category;




-- 대원칙
-- 1. view는 데이터, 스냅샷을 저장하지 않고 select 정의만 저장된다.
-- 2. 따라서 select가 매번 다시 실행되는 가상의 테이블
-- 3. 뷰를 수정한다 = select 정의를 바꾼다.
-- DROP VIEW
-- CREATE VIEW [이름] as select ~
-- ALTER VIEW [이름] as
-- 4. 뷰는 반드시 하나의 select