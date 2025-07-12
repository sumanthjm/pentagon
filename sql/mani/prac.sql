SELECT * FROM zomato.emps;

select fname first_name,sal morethan_50 ,gender sex
from emps 
where sal>50000;

select distinct job from emps;

sELECT FNAME,JOB,SAL,dense_rank() OVER( ORDER BY SAL desc) AS 'RANK' 
FROM EMPS;

select * from emps
where fname not in('MURALI','KIRAN','MEENA');

USE INFORMATION_SCHEMA; 
SELECT * 
FROM TABLE_CONSTRAINTS; 

select * from emps
limit 3 offset 4;

select * from emps
where eid between 5 and 7;


select * from emps
where fname like "%/%%"escape"/";
select * from emps
where fname like "%%";

select * from emps
where fname regexp "^a.*n$";


select * from emps
order by sal desc,fname asc;

select * from emps
order by 7 DESC;

select * from emps
order by COMM IS NOT NULL,FNAME ;
select * from emps
order by COMM IS NULL ;

select concat(fname,lname) from emps;
select length(fname) from emps;

select * from emps
where substring(fname,1,1)='A';
select instr(fname,"a") from emps;
select substr(fname,3,5-3+1) from emps;


select trim(leading "m" from "madam") as trim;
select trim(trailing "m" from "madam") as trim;
select round(1234.3421,2);
select round(6264.3451,-10);
select floor(12.99);
select curdate();
select now();
select month(dob) from emps;
select datediff(doj,dob) from emps;
select date_add('2025-07-07',interval 1 month);
select last_month(year('1994-02-07'));
select isnull(mgr) from emps;
select coalesce(comm,7) as nn from emps;

select fname,sal,case 
when sal < 50000 then "noob"
when sal < 100000 and sal >=50000 then "pro"
else "legend" 
end as salary_report from emps; 
select fname,sal, if(sal>=100000,"legend","noob|gandu") as status from emps;                

select ifnull(comm,null) as nn from emps;
select * from emps;
select job from emps 
group by job;

select job,max(sal) from emps 
group by job;

select avg(sal) avgg from emps
group by job
having avgg>50000;

-- 12.WQTD NUMBER OF CUSTOMERS WHO ARE LIVING IN MUMBAI CITY??
select count(*) from customers
where lid in(select lid from locations
				where city in('mumbai','DELHI'));


select count(*) from customers 
where lid=(select lid from locations
			where city='MUMBAI');




