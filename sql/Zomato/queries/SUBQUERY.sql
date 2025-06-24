-- it is a qyery inside another query or nested query
-- principles 
-- 1 always inner query is execute firest written si=ome output
-- 2 out put of inner query will be given as input for the outer query
-- 3 outer query execute cmpletely by taki=ing input from the innr query and return final output
-- 4 outer query depends on inner query
 
 
 
 -- when ever we comw across some anknown values we use sub query
 
 -- 1 the column_name both inner and outer should be same datatype
	-- where sal int>(select fname varchar(10))   invalid
	-- where sal int>(select fname int)			   valid
-- 2 we can slect only one column inside inner qr
	-- where sal>(select sal,comm)              invalid
	-- where sal>(select sal)                   valid
    
    
    
    
    
-- 1 details of emp who are getting sal more than kiran
    select * from emps
    where sal>(select sal from emps
				where fname='KIRAN');
                
-- 2 fname , lname,jon,sal if the emp working as muruli job role
    select fname,lname,job,sal
    from emps
    where fname !='MURALI' AND job=(select job from emps
				where fname='MURALI');
                
-- 3  2nd character of first and last name should be A and sal more than jahnavi 
select * from emps
where SUBSTRING(fname, 2, 1)='A' AND SUBSTRING(fname, length(fname)-1, 1)='A'
AND sal<(select sal from emps where fname='JAHNAVI');
-- or
 select * from emps
where fname like '_A%' AND fname like '%A_'
AND sal<(select sal from emps where fname='JAHNAVI');
                
-- to display details of an emp if the emps are acting as coustomer for theire company and hired after ajun but as famale 
select * from emps
where cid is not null and doj>(select doj from emps 
								where fname='ARJUN') and gender!='F';

-- to display fname and lname as full name alonge with salary ,job and lid if the emp 
-- is working in location same as suresh location and getting more than priya  
select CONCAT(fname, ' ', lname) AS full_name,sal,job,lid 
from emps
where LID=(SELECT LID FROM EMPS
			WHERE fname='SURESH') and sal>(select sal 
											from emps where fname='PRIYA');
                
-- details of an emp who are getting 3rd maximum salary

select * from emps
where sal=(select distinct sal
from emps 
order by sal desc
limit 2,1);

-- TO DAISPLAY EMPS ARE ELDER THAN PRIYAS
select * from emps
where dob<(select dob 
		from emps where fname='PRIYA');
	
-- CASE 2
-- when ever data to be display from one table and condition given for another table we use subquery 
-- 	



-- 1] to display kiran city 
select city from locations
where lid=(select lid from emps 
			where fname='KIRAN');

-- 2]  details of empyoyee those living in state ranjastan
select * from emps
where lid=(select lid from locations where state='RAJASTHAN');
                
-- 3] CITY AND STATE OF COUSTOMER ROHITH SHARMA
select city ,state from locations
where lid=(select lid from customers
			where name='ROHIT SHARMA'); 