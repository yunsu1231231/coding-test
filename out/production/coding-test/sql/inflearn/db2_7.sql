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