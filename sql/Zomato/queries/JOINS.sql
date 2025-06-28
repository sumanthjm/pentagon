-- JOINS 
-- > USED TO RETRIVE THE DATA FEOM MULTIPLE TABLES SIMULTANEOUSLY

-- TYPES OF JOINS
-- -------------------
-- 1]CROSS JOINS/CARTESION JOINS
-- 2]INNER JOINS
-- 3]OUTER JOINS
-- 	 i]LEFT OUTER JOINS
-- 	ii]RIGHT OUTER JOINS
-- 4]SELF JOIN
-- 5]NATURAL JOIN

-- 1]CROSS JOINS/CARTESION JOINS
-- --------------------------------- ---------------------------------------------------------------------------
-- it is used to merge the record from one table with the records of another table
-- ANSI={AMERICAN NATIONAL STANDARD INSTITUTE } 

-- SYNTAX:
select COLUMN_NAME/EXPRESSION
FROM TABLE_NAME T1 CROSS JOIN TABLE_NAME T2;

-- BID | BNAME | GID
--------------------------
-- 1     CHINNA  2
-- 2     MUNNA   3
-- 3     SUNDRA  1

-- GID | GNAME  
---------------------
-- 1     SUNADRI 
-- 2     CHINNI  
-- 3     MUNNI   

-- 	  BID | BNAME | GID | GID | GNAME
--     1    CHINAA
--     1	CHINAA
--     1	CHINAA
--     2	MUNNA
--     2	MUNNA
--     2	MUNNA
--     3	SUNDRA
--     3	SUNDRA
--     3	SUNDRA

-- IF WE USE CROSS JOIN ,THE TOTAL NUMBER OF COLUMN IN RESULTED TABLE IS = (COLUMN)T1+T2(COLUMN)
-- IF WE USE CROSS JOIN ,THE TOTAL NUMBER OF ROWS IN RESULTED TABLE IS = (ROWS)T1*T2(ROWS)

-- 1]CARTITION PRODUCT FROM LOCATION AND EMPYOYEE TABLE
select * FROM locations L CROSS JOIN emps E;
select * FROM locations L CROSS JOIN emps E ON L.LID=E.LID;
select * FROM emps E cross join customers C;



-- 2] INNER JOIN
-- -------------------------------------------------------------------------------------------------------

-- IS USED TO OBTAIN MATCHED RECORDS FROM DIFFERENT TABLES

-- SYNTAX:
-- select COLUMN_NAME/EXPRESSION
-- FROM TABLE_NAME T1 INNER JOIN TABLE_NAME T2
-- ON JOIN_CONDITION;

-- ON=IT IS A KEYWORD USED TO PASS JOIN CONDITION
-- JOIN CONDITION : IT IS USED TO CONNECT DIFFERENT TABLES

-- T1.COLUMN_NAME=T2.COLUMN_NAME
 
-- SAME EXAMPLE ABOVE
select * FROM BOYS B INNER JOIN GIRLS ON B.GID=G.GID;
select * FROM locations L inner JOIN emps emps;

-- avarage rating for each restaurant??
select avg(r.rating) from reviews r inner join restaurants re 
on r.restaurant_id=re.restaurant_id
group by re.restaurant_id; 

-- top 2 restarunt name alonge with rating
 select r.rating as top_rating,re.restaurant_id as rid from reviews r inner join restaurants re 
on r.restaurant_id=re.restaurant_id
group by rid
order by top_rating desc
limit 0,2;



 select re.name as name,re.restaurant_id as rid,r.rating as top_rating from reviews r inner join restaurants re 
on r.restaurant_id=re.restaurant_id
order by top_rating desc
limit 0,2;

-- customer name who mad highest payment 
select name,pp.amount from customers c inner join payments pp
on c.ORDER_ID=pp.order_id
where c.ORDER_ID=(select o.order_id from payments p inner join orders o 
on o.order_id=p.order_id 
where p.STATUS='Completed'
order by p.amount desc
limit 1); 

(select o.order_id from payments p inner join orders o 
on o.order_id=p.order_id 
where p.STATUS='Completed'
order by p.amount desc
limit 1);

(select o.order_id from payments p inner join orders o 
on o.order_id=p.order_id 
where p.STATUS='Completed'
order by p.amount desc
limit 1);








