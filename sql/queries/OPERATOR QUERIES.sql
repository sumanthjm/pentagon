-- QUERIES OPARATOR
-- List all the employees whose commission is null.

-- List all the employees who don’t have a reporting manager.

-- List all the salesmen in dept 30.

-- List all the salesmen in dept number 30 and having salary greater than 1500.

-- List all the employees whose name starts with ‘S’ or ‘A’.

-- List all the employees except those who are working in dept 10 & 20.

-- List the employees whose name does not... (incomplete in image).

-- List all the employees who are having reporting managers in dept 10.

-- List all the employees whose commission is null and working as clerk.

-- List all the employees who don’t have a reporting manager in deptno 10 or 30.

-- List all the salesmen in dept 30 with salary more than 2450.

-- List all the analysts in dept number 20 and having salary greater than 2500.

-- List all the employees whose name starts with ‘M’ or ‘J’.

-- List all the employees with annual salary except those who are working in dept 30.

-- List the employees whose name does not end with ‘ES’ or ‘R’.

-- List all the employees who are having reporting managers in dept 10 along with 10% hike in salary.

-- Display all the employees who are salesmen having ‘E’ as the last but one character in ename and salary having exactly 4 characters.

-- Display all the employees who joined after year 81.

-- Display all the employees who joined in February.

-- List the employees who are not working as managers and clerks in dept 10 and 20 with a salary in the range of 1000 to 3000.

-- List the employees whose salary not in the range of 1000 to 2000 and working in dept 10, 20 or 30 except all salesmen.

-- List the department names which are having letter ‘O’ in their locations as well as their department names.

-- Display all the employees whose job has string ‘MAN’ in it.

-- List the employees who are hired after 82 and before 87.

-- Write a query to display all the details of employees hired in November and December.

-- List all the employee names and commission for those employees who earn commission more than their salary.

-- Write a query to display name and designation for all the employees having reporting managers and also their names starting with ‘S’.

-- Write a query to display name and salary of all the employees if their annual salary ends with ‘0’.

-- Write a query to display name of the employee having at least 2 L’s in his name.

-- Write a query to display name of the employees whose name starts with a vowel.
-- 1 
SELECT * FROM emp WHERE comm IS NULL;

-- 2
SELECT * FROM emp WHERE mgr IS NULL;

-- 3
SELECT * FROM emp WHERE job = 'SALESMAN' AND deptno = 30;

-- 4
SELECT * FROM emp WHERE job = 'SALESMAN' AND deptno = 30 AND sal > 1500;

-- 5
SELECT * FROM emp WHERE ename LIKE 'S%' OR ename LIKE 'A%';

-- 6
SELECT * FROM emp WHERE deptno NOT IN (10, 20);

-- 7
SELECT * FROM emp WHERE ename NOT LIKE '%A%';

-- 8
SELECT * 
FROM emp 
WHERE mgr IN (SELECT empno FROM emp WHERE deptno = 10);

-- 9
SELECT * 
FROM emp 
WHERE comm IS NULL AND job = 'CLERK';

-- 10
SELECT * 
FROM emp 
WHERE mgr IS NULL AND deptno IN (10, 30);

-- 11
SELECT * 
FROM emp 
WHERE job = 'SALESMAN' AND deptno = 30 AND sal > 2450;

-- 12
SELECT * 
FROM emp 
WHERE job = 'ANALYST' AND deptno = 20 AND sal > 2500;

-- 13
SELECT * FROM emp WHERE ename LIKE 'M%' OR ename LIKE 'J%';

-- 14
SELECT ename, sal * 12 AS annual_salary 
FROM emp 
WHERE deptno != 30;

-- 15
SELECT * 
FROM emp 
WHERE ename NOT LIKE '%ES' AND ename NOT LIKE '%R';

-- 16
SELECT e.ename, e.sal, e.sal * 1.10 AS hiked_salary 
FROM emp e 
WHERE e.mgr IN (SELECT empno FROM emp WHERE deptno = 10);

-- 17
SELECT * 
FROM emp 
WHERE job = 'SALESMAN' 
  AND LENGTH(sal) = 4 
  AND SUBSTRING(ename, -2, 1) = 'E';

-- 18
SELECT * 
FROM emp 
WHERE YEAR(hiredate) > 1981;

-- 19
SELECT * 
FROM emp 
WHERE MONTH(hiredate) = 2;

-- 20
SELECT * 
FROM emp 
WHERE job NOT IN ('MANAGER', 'CLERK') 
  AND deptno IN (10, 20) 
  AND sal BETWEEN 1000 AND 3000;

-- 21
SELECT * 
FROM emp 
WHERE sal NOT BETWEEN 1000 AND 2000 
  AND deptno IN (10, 20, 30) 
  AND job != 'SALESMAN';

-- 22
SELECT * 
FROM dept 
WHERE dname LIKE '%O%' AND loc LIKE '%O%';

-- 23
SELECT * 
FROM emp 
WHERE job LIKE '%MAN%';

-- 24
SELECT * 
FROM emp 
WHERE hiredate > '1982-12-31' AND hiredate < '1987-01-01';

-- 25
SELECT * 
FROM emp 
WHERE MONTH(hiredate) IN (11, 12);

-- 26
SELECT ename, comm 
FROM emp 
WHERE comm > sal;

-- 27
SELECT ename, job 
FROM emp 
WHERE mgr IS NOT NULL AND ename LIKE 'S%';

-- 28
SELECT ename, sal 
FROM emp 
WHERE (sal * 12) LIKE '%0';

-- 29
SELECT * 
FROM emp 
WHERE LENGTH(ename) - LENGTH(REPLACE(ename, 'L', '')) >= 2;

-- 30
SELECT * 
FROM emp 
WHERE ename REGEXP '^[AEIOU]';
