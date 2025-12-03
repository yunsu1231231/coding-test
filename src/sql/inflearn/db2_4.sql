-- db 2, 4장

-- 문제 1 x
-- 스칼라 서브쿼리: 하나의 값 = 스칼라 값을 반환하는 서브쿼리 = 반드시 결과가 1행 1열
-- 값이 오는 모든절에 가능
-- 문법: 값이 들어가는 자리에 서브쿼리를 넣는 형태

--select product_id, name, price
--from products
--where price = (select price from products order by price desc limit 1);

select product_id, name, price
from products
where price = (select max(price) from products);

-- max 집계함수 숙지

-- 문제 2

select
    order_id,
    user_id,
    order_date
from orders
where product_id = (select product_id from orders where order_id =1) and order_id != 1;

select *
from orders o1
join orders o2 on o1.product_id = o2.product_id
where o1.order_id = 1 and o2.order_id != 1;

select *
from orders
where order_id != 1 and product_id in (select product_id from orders where order_id = 1);

-- 문제 3 x

--select SUM(select count(*) from users o left join on u.user_id = o.user_id;)
--from users u
--order by u.user_id asc;

select
    name as 고객명,
    (
        select count(*)
        from orders
        where o.user_id = u.user_id
    ) as 총주문횟수
from users u
order by u.user_id;


-- 일반 서브쿼리: 한 번 실행 → 결과를 바깥에서 사용
-- 상관 서브쿼리: 바깥 쿼리의 각 행마다 서브쿼리가 실행됨

-- 일반 쿼리는 행마다 조작하는게 아니라 sql 절마다 통으로 데이터 전체를 집합 단위로 조작!!
-- 상관 서브쿼리는 이제 행마다 서브쿼리가 실행되면서 하나식 결과 집합에 추가!!
