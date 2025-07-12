select * from emps inner join customers 
on emp.cid=customers.cid;
select * FROM locations L CROSS JOIN emps E ON L.LID=E.LId;
select * FROM locations L inner join emps E 
on l.lid=e.lid;
-- avarage rating for each restaurant??
select avg(r.rating) from reviews r inner join restaurants re 
on r.restaurant_id=re.restaurant_id
group by re.restaurant_id;


SELECT avg(RR.RESTAURANT_ID),rr.name
FROM REVIEWS R INNER JOIN RESTAURANTS RR 
ON R.RESTAURANT_ID=RR.RESTAURANT_ID
group by rr.RESTAURANT_ID;

select * from emps e left outer join  locations l
on e.lid=l.lid;

-- WQTD EMPLOYEE FNAME AND HIS MANAGER FNAME FROM EMPS TABLE??? 
select e2.*   from emps e1 join emps e2
where e2.eid=e1.mgr; 
select * FROM emps e1 join emps e2 
on e1.mgr=e2.eid;


 