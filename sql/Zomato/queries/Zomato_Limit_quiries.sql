 -- 1. View first 5 customers
SELECT * FROM zomato.customers
LIMIT 5;

-- 2. First 10 restaurants in Mumbai
SELECT * FROM zomato.restaurants
WHERE city = 'Mumbai'
LIMIT 10;

-- 3. Top 5 costliest items
SELECT name, price 
FROM zomato.menu_items
ORDER BY price DESC
LIMIT 5;

-- 4 display last 3 record of emp table 
select * from emps
order by eid desc
limit 3

-- 5. Top 10 reviewed restaurants
-- select restaurant_id, COUNT(*) AS review
-- FROM zomato.reviews
-- GROUP BY restaurant_id
-- ORDER BY review DESC
-- LIMIT 10;

 -- 6. Latest 5 orders (if order_date exists)
SELECT * FROM zomato.orders
ORDER BY order_date DESC
LIMIT 5;






