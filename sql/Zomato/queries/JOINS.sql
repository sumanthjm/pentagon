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


-- SELF JOIN
-- ------------------------------------------------------------------------
-- IT IS USED TO OBTAIN MATCHED RECORDS FROM DSAME TABLES

-- -- SYNTAX
-- SELECT COLUMN_NAME/EXPRESSION 
-- FROM TABLE_NAME T1 JOIN TABLE_NAME T2
-- ON JOIN_CONDITION;
  -- WHEN TO USE
  -- >> WHEN EVER DATA AND OUTPUT PRESENT IN THE SAME TABLE BUT IN DIFF ROWS WE USE SELF JOIN
-- 1]fname his manager fname from emps table 
select e1.fname,e2.fname FROM emps e1 join emps e2 
on e1.mgr=e2.eid;

-- 2]* from emp manager details from emps table 
select * FROM emps e1 join emps e2 
on e1.mgr=e2.eid;

-- 3]  select column where emp getting sal more than 3500 and manager is getting sal less than 500000
select e1.fname Ename,e1.sal Esal,e2.fname Mname,e2.sal Msal FROM emps e1 join emps e2 
on e1.mgr=e2.eid
where e1.sal>35000 and e2.sal<500000;

-- 4] to desplay emp fname ,job ,manager fname , mag job alonge with there city name 
-- if (emp is working as delivery or chife or employee city is eithir delhi or jaipur and mgr working as waiter 
select e1.fname,e1.job,e2.fname,e2.job from emps e1 join emps e2 inner join locations l1 inner join locations l2
on e1.mgr=e2.eid and e1.lid=l1.LID and e2.LID=l2.LID
where e1.job in('DELIVERY','CHEF') AND l1.CITY in('DELHI','JAIPUR') AND e2.job='WAITER';
  
-- 5]fname of amans managers managers 
select e3.fname from emps e1 join emps e2 join emps e3
 on (e1.mgr=e2.eid)=e3.eid
where e1.fname in('AMAN');
-- or--- 
select e3.fname from emps e1 join emps e2 join emps e3
 on e1.mgr=e2.eid and e2.mgr=e3.eid
where e1.fname in('AMAN');

-- 6] details of emp who are gettig sal mrethan kiran
select * from emps e1 join emps e2
on e1.sal>e2.sal
where e2.fname='KIRAN';


-- 7] employye details alone with their city name who are reporting to priya if priya 
--  is getting salary more than kirans??
-- E1: FOR EMPLOYEE
-- E2: FOR PRIYA
-- L1:FOR EMPLOYEE CITY
-- E3: FOR KIRAN

select e1.*,l1.CITY
from emps e1 join emps e2  inner join locations l1 join emps e3
on e1.mgr=e2.eid and e1.lid=l1.lid and e2.sal>e3.sal
where e2.fname='PRIYA' and e2.fname='KIRAN';



--                 NATURAL JOINS 


-- << EXAMPLE >>
-- SELECT * FROM EMPS E NATURAL JOIN LOCATIONS L;O/P  MATCHED RECORDS

-- SELECT * FROM EMPS E1 NATURAL JOIN EMPS E2;O/P MATCHED RECORDS

-- SELECT * FROM EMPS E NATURAL JOIN MENU_ITEMS M;O/P MERGED RECORDS(NO COMMEN ATTRIBUTE)

-- SET OPERATORS
-- --------------
-- 1.UNION
-- 2.UNION ALL
-- 3.INTERSECTION
-- A:{1,2,3,4,5}   B:{5,6,7}
-- > A UNION B:{1,2,3,4,5,6,7}
-- > A UNION ALL B:{1,2,3,4,5,5,6,7,}
-- > A INTERSECTION B:{5}

-- UNION:
-- --------
-- IT IS USED TO RETRIVE THE DATA FROM MULTIPLE TABLES {{VERTICALLY}}
-- > IT WILL AVOID THE DUPLICATE DATA FROM THE O/P

-- UNION ALL:
-- ------------
-- IT IS ALSO USED TO RETRIVE THE DATA FROM MULTIPLE TABLES {{VERTICALLY}}
-- >IT WILL INCLUDE THE DUPLICATE VALUES INTHE OUTPUT

-- RULES TO BE FALLLOW 
-- >	we should USE ; FOR THE LAST QR
-- > WE SHOULD WRITE QR INSIDE ROUND PARANTHESIS (NOT MANDATORY)
-- > NO OF COLUMN USING INSIDE SELECT CLAUSH MUST BE SAME



-- select fname from emps
-- union all
-- select fname from emps;// 10FNAME

-- select fname from emps
-- union all
-- select fname from emps;// 20 FNAME

-- select fname from emps
-- union all
-- select fname,job from emps;-- error-- error no of column  must same in both select

-- select fname from emps
-- union all
-- select job from emps;-- gives always first select column name only 


-- 1]wqtd job,fname in lower case if emps are working as manager else print job,fname in reverse format???
select  job,lower(fname) as name from emps 
where job='MANAGER'
union
select  job,reverse(fname) from emps 
where job!='MANAGER';

-- 2]mathced and unmatched records 
select * from customers left outer join locations
on customers.LID=locations.LID
union
select * from customers right outer join locations 
on customers.LID=locations.LID;

-- 3rd and 5th records  
(select * from emps
limit 2 , 1)
union 
(select * from emps
limit 4 , 1);






 
