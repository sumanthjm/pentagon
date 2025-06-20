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

