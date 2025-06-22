 -- 1. View first 5 customers
 -- 2. First 10 restaurants in Mumbai
 -- 3. Top 5 costliest items
 -- 4 display last 3 record of emp table 
 -- 5. Top 10 reviewed restaurants
 -- 6. Latest 5 orders (if order_date exists)
SELECT * FROM zomato.customers
LIMIT 5;


SELECT * FROM zomato.restaurants
WHERE city = 'Mumbai'
LIMIT 10;


SELECT name, price 
FROM zomato.menu_items
ORDER BY price DESC
LIMIT 5;


select * from emps
order by eid desc
limit 3;


select restaurant_id, COUNT(*) AS review
FROM zomato.reviews
GROUP BY restaurant_id
ORDER BY review DESC
LIMIT 10;


SELECT * FROM zomato.orders
ORDER BY order_date DESC
LIMIT 5;


 -- 6. Top 5 employees by number of orders handled
SELECT eid, COUNT(*) AS total_orders
FROM zomato.orders
GROUP BY eid
ORDER BY total_orders DESC
LIMIT 5;


-- -------------------------------------OFFSET --------------------------------
-- 1. Get customers from 6th to 10th row
SELECT * FROM zomato.customers
LIMIT 5 OFFSET 5;
-- OR in MySQL shortcut format
SELECT * FROM zomato.customers
LIMIT 5, 5;  -- Skip 5, show next 5

 -- 2. View next 5 menu items after top 5 costliest
SELECT name, price
FROM zomato.menu_items
ORDER BY price DESC
LIMIT 5 OFFSET 5;

-- 3. Show restaurants 11 to 20 in Hyderabad
SELECT * FROM zomato.restaurants
WHERE city = 'Hyderabad'
LIMIT 10 OFFSET 10;

-- 4 wqrd 2nd logest city as well as their respective lengrh from location table 
--    if there  is more than 1 longest city chopse the one which comes first when we ordered 
select city,length(city) as len from locations
 order by len  desc,city asc
 limit 1;
 
-- 5. Paginate reviews — show 6th to 10th review for a specific restaurant
SELECT * FROM zomato.reviews
WHERE restaurant_id = 101
ORDER BY review_id DESC
LIMIT 5 OFFSET 5;






