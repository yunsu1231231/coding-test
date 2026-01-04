-- 1번 o
select
    p.name as name,
    p.price as price
form orders o
left join products p on p.product_id = o.product_id
where p.category = "전자기기" and o.order_id IS NULL;

-- 2번 x
select
    u.name,
    count(o.order_id) as order_count
from users u
left join orders o on u.user_id = o.user_id
group by u.user_id, u.name -- 두번째 기준 간과
order by u.name;

-- group by에 select 컬럼을 다 써야 한다
-- 당연: group by가 기준인데 group by로 묶은것에서 임의로 하나의 속성을 꺼낼 수 없으므로

-- 4번 o
select
    u.name as user_name,
    p.name as product_name
from users u
left join on u.user_id = o.user_id
left join on o.product_id = p.product_id
order by user_name, product_name;

-- 2
-- 1번 x
select
    y.employee_id,
    y.name,
    y.manage_id,
    e.name as manager_name
from employees e
join employees y on e.employee_id = y.manger_id; -- 상사의 employee_id, 직원의 manager_id가 같은 행끼리 붙인다. 상사 - 부하 관계의 새로운 합쳐진 행을 만드는 것
where e.name = '최과장';

-- self join: 하나의 테이블을 역할만 다르게 두개처럼 보고, 공통된 키로 행들을 이어 붙여 하나의 행으로 만드는 것!