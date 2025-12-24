-- 문제 2 o
select
    CONCAT_WS(' - ',name,address) as customer_info
from customers;

-- 문제 3 o
select
    name,
    COALESCE(description,name) as product_display_info
from products;