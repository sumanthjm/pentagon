-- ✅ What are Single Row Functions?
-- They operate on one row at a time and return one result per row.

-- Types:
-- String functions
-- Number functions
-- Date functions
-- Conversion functions


-- 1. String Functions
-- 🔸 UPPER() and LOWER() — 
SELECT name, UPPER(name) AS name_upper
FROM zomato.customers
LIMIT 5;

SELECT CONCAT(fname, ' ', lname) AS full_name
FROM zomato.emps
LIMIT 5;

----------------------------------------------------- Substrings FUNCTION--------------------------------------


-- 1. 🔍 Get first 5 characters of each menu item name
SELECT name, SUBSTRING(name, 1, 5) AS short_name
FROM zomato.menu_items
LIMIT 5;

-- 2. 🔍 Show city code (first 3 letters) from restaurant's city
SELECT restaurant_name, city, SUBSTRING(city, 1, 3) AS city_code
FROM zomato.restaurants
LIMIT 5;

-- 3. 🔍 Extract last 4 digits of a customer's phone number (if stored)
SELECT customer_name, phone,
       SUBSTRING(phone, -4) AS last_4_digits
FROM zomato.customers
LIMIT 5;

-- 4. 🔍 Extract year from order_date (if date is stored as a string
SELECT order_id, order_date,
       SUBSTRING(order_date, 1, 4) AS order_year
FROM zomato.orders
LIMIT 5;



------- -------------------------------REPLACE FUNCTION--------------- 

-- 1. 🧾 Replace "Pizza" with "Burger" in menu item names
SELECT name,
       REPLACE(name, 'MASALA DOSA', 'Burger') AS updated_name
FROM zomato.menu_items
WHERE name LIKE '%MASALA DOSA%'
LIMIT 5;

-- 2. 🧾 Replace spaces with hyphens in restaurant names
SELECT name,
       REPLACE(name, ' ', '-') AS url_friendly_name
FROM zomato.restaurants
LIMIT 5;

-- 3. 🧾 Replace "@gmail.com" with "@zmail.com" in customer emails
SELECT name,email,
       REPLACE(email, '@gmail.com', '@zmail.com') AS updated_email
FROM zomato.customers
WHERE email LIKE '%@gmail.com'
LIMIT 5;

-- 4 to display count of  A character in malayalam
select length('malayalam')-length(replace('malayalam','a','')) as Leangth;

-- 5 display even employee id  
  select eid as even_emp_id
  from emps
  where mod(eid,2)=0;

-- 6🔸 Example: Last 4 digits of phone number
SELECT phone,
       SUBSTRING(phone, LENGTH(phone) - 3, 4) AS last_4_digits
FROM zomato.restaurants
LIMIT 5;

-- 7 Extract domain from email:
SELECT email,
       SUBSTRING(email, INSTR(email, '@') + 1) AS domain
FROM zomato.customers
LIMIT 5;
-- INSTR(email, '@') → Finds the position of '@' in the email.
-- SUBSTRING(email, INSTR(email, '@') + 1) → Extracts everything after the '@' symbol.
-- The result is the email domain (like gmail.com, yahoo.in, etc.).











-- ------------------------------ROUND FUNCTION-----------------------
-- 1 round upmexample
select round(123.45);
select round(123.456,2);
select round(123.45645,3); 


-- 2 
select job,round(avg(sal),2) as avg
from emps 
group by job;





















