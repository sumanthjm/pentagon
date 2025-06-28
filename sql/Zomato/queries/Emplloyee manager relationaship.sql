-- Emplloyee manager relationaship 

-- 1] MANAGER OF JANAVI 
select * from emps
where eid=(select mgr from emps
			where fname='JAHNAVI');
            
-- 2]CITY OF DIVYAS MANAGER
select city from locations
where LID=(select LID from emps
			where eid=(select mgr from emps
			where fname='JAHNAVI'));

-- 3]details of aman managers manager
select * from emps
where eid=(select mgr from emps
where eid=(select mgr from emps
			where fname='AMAN'));
            
 -- 4]emps details who are reporting to janavi
select * from emps
where mgr in(select eid from emps
			  where fname='JAHNAVI');

-- 5]details of enps who are reporting to amans manager
select * from emps 
where mgr in(select eid from emps
			where eid in(select mgr from emps
						    where fname='AMAN'));
                            
-- 6]locations details of emps who are reporting to faizan manager magers
SELECT * FROM locations WHERE LID IN(SELECT LID FROM 
EMPS WHERE MGR IN (select EID from emps
where eid=(select mgr from emps
where eid=(select mgr from emps
			where fname='FAIZAN'))));













