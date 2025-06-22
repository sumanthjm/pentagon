select curdate(); -- only date 
select sysdate();-- both date and time 
select year();-- to extract year in guven date expressiom 

select dob,year(dob) as year
from emps;

select dob,month(dob) as month
from emps;

select dob,day(dob) as date
from emps;

select dob,dayname(dob) as dayname
from emps;

select dayname(curdate()) as dayname;

select dayname('1947-08-15') as dayname;

select now();
 
 select dob,dayname(dob) as dayname,weekday(dob) as weekday
from emps;

-- 1 to display hired empid count /year
select count(*) as total_emp,year(doj) as year
from emps
group by year 
order by total_emp desc;

-- hired in leap year 
select * from emps
where mod(year(doj),4)=0;
 
 -- to diaplay current experience
 select fname ,(year(curdate()))-(year(doj)) as experience_year
 from emps
 order by experience_year desc;

-- datediff
select eid,datediff(curdate(),doj) as date_ago 
from emps;

-- dateadd 
SELECT ADDDATE('2020-10-12', INTERVAL 6*365 DAY) AS adddate;
SELECT ADDDATE('2020-10-12', INTERVAL 6 year) AS adddate;
SELECT ADDDATE('2020-10-12', INTERVAL 6 month) AS adddate;

SELECT SUBDATE('2020-10-12', INTERVAL 6*365 DAY) AS adddate;
SELECT SUBDATE('2020-10-12', INTERVAL 6 year) AS adddate;
SELECT SUBDATE('2020-10-12', INTERVAL 6 month) AS adddate;

select eid,subdate(min(doj),interval 2 year)as subyear
from emps
group by eid
order by subyear asc
limit 0,1;






