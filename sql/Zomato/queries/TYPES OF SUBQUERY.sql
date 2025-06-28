-- TYPES OF SUBQUERY 
-- 1]SINGLE ROW SUBQUERY
--   : IF INNER QR RETURN SINGLE VALUE THEN IS CALLED SINGLE ROW SUBQR
--   
--   EXAMPLE: select city from locations
-- 			where lid=(select lid from emps 
-- 			where fname='KIRAN');
-- 		   -- OUT// BANGALORE
--            
-- -> HERE WE CAN USE BOTH NORMAL OPERATOR(<,=,<=,>=) AND SPECIAL OPERATOR
-- ->
-- ->

-- 1]MULTI ROW SUBQUERY
-- : IF INNER QR RETURN MORE THAN ONE VALUE THEN IS CALLED MULTI ROW SUBQR
--   EXAMPLE : select * from customers
-- 			where lid in(select lid from locations 
-- 							where CITY in('CHENNAI','JAIPUR
                            
-- -> HERE WE CAN USE ONLY SPECIAL OPERATOR(IN,NOTIN,ALL,ANY)


-- 1] NUMBER OF CUSTOMER WHO ARE LIVING IN MUMBAI CITY
select count(*) as number_of_coustomer 
from customers 
where lid in(select lid from locations
				where city IN('MUMBAI'));

-- 2] DEATILS OF CUSTOMER WHO ORDERED SOME PRODUCTS
select * from customers
where  ORDER_ID>0;
--  OR -- 
select * from customers
where  ORDER_ID IS NOT NULL;

select * from customers
where  ORDER_ID IN(select ORDER_ID 
					FROM orders);
                    
-- DETAILS OF EMP WHO DELIVERED PRODUCT TO THE CUSTOMER WHO BELONGS TO KOLKATTA CITY
select * from emps
WHERE job='DELIVERY' and cid=(select cid from customers 
								where lid=(select lid from locations where city='KOLKATA'));
                                
select cid from customers 
where lid=(select lid from locations where city='KOLKATA');

select order_id from 
orders where city;



select *
from emps
where eid in(select eid 
from orders where STATUS='DELIVERED' AND order_id in(select order_id
														from customers
														where lid in(select lid 
                                                        from locations
                                                        where CITY='KOLKATA')));


-- 5] details of an employee who are getting salary less than all the waiters
select * from emps
where sal<(select min(sal) from emps
where job='WAITER'); 



-- -----------------ALL OPERATOR [AND CONDITION]
-- -> IT IS A MULTIVALUE OPERATOR WHIVH TAKES MULTIPLE VALUE AS THE RHS AND SINGLE VALUE WITH LHS ALONGE WITH RELATIONAL OPERATOR

-- EXAMPLE
-- 1] details of an employee who are getting salary less than all the waiters
select * from emps
where sal<ALL(select sal from emps
where job='WAITER');


-- -----------------ANY OPERATOR [OR CONDITION]
-- -> IT IS A MULTIVALUE OPERATOR WHIVH TAKES MULTIPLE VALUE AS THE RHS AND SINGLE VALUE WITH LHS ALONGE WITH RELATIONAL OPERATOR

-- EXAMPLE
-- 1] details of an employee who are getting salary less than all the waiters
select * from emps
where sal<ANY(select sal from emps
where job='WAITER');
-- OR
select * from emps
where sal<(select max(SAL) from emps
where job='WAITER');


-- 2]NAME OF AN ITEM WHICH IS ORDERED MORE THAN ONCE 



















 