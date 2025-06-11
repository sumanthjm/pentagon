select max(sal),min(comm) from emp 
where job='SALESMAN'
group by deptno;

select max(sal),avg(sal) from emp 
where job in ('ANALYST' ,'CLERK')
group by deptno;

select count(*) from emp
where sal>1250
group by job;

select max(sal),sum(sal) from emp
where ename not like '%S%' AND ename not like '%M%' 
AND comm is null
group by deptno;

select max(sal) from emp
where sal>1250 
group by deptno;

select max(sal) from emp
where sal>2000 
group by deptno;

select max(sal) 
from emp
group by deptno
having max(sal)>300;

select max(sal),min(sal) 
from emp 
where job='MANAGER'
group by deptno
having min(sal)>2000;

select min(sal) ,avg(sal) from emp
where job in('ANALYST' ,'MANAGER')
group by deptno
having avg(sal)>1000 AND avg(sal)<3500;

select deptno,count(*) from emp 
group by deptno
having count(*)>=3 AND count(*)<=5;

select job,count(*) from emp 
group by job
having count(*)>=3 AND count(*)<=5;

select min(sal),max(sal) from emp
where job not in('PRESIDENT')
group by deptno
having min(sal)>800;	

select count(*),sal from emp
group by sal
having count(*)>1;

select count(*),sal,deptno from emp
group by sal,deptno
having count(*)>1;