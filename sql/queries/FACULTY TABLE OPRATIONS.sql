SELECT * FROM company.faculty;

-- adding new column to table 
ALTER TABLE faculty
ADD age INT NOT NULL;

-- i want to add new record in 4th row in faculty table
UPDATE faculty
SET name = 'Dr. Shalini Nair',
    department = 'Zoology',
    email = 'shalini.nair@college.edu',
    hire_date = '2017-08-19',
    age = 38
WHERE faculty_id = 4;

-- i want to add new record in bottom row in faculty table
INSERT INTO faculty (name, department, email, hire_date, age)
VALUES ('Dr. Ayesha Khan', 'Environmental Science', 'ayesha.khan@college.edu', '2023-07-01', 41);


-- ✅ 1. Drop a Column with a CHECK Constraint (MySQL 8+)
-- If you added a column like this:

-- sql
-- Copy
-- Edit
-- ALTER TABLE faculty
-- ADD age INT NOT NULL CHECK (age >= 21 AND age <= 70);
-- You can drop it like this:

-- sql
-- Copy
-- Edit
-- ALTER TABLE faculty
-- DROP COLUMN age;
-- ✅ This will also automatically remove the CHECK constraint associated with the column.


-- ✅ 2. Rename a Column with a CHECK Constraint
-- In MySQL 8+, use:

-- sql
-- Copy
-- Edit
-- ALTER TABLE faculty
-- RENAME COLUMN age TO faculty_age;
-- The CHECK constraint will remain on the renamed column.


-- IN MYSQL IT IS AVALABLE BUT IN ORACLE PLUSS NOT


-- change datatype of colum in faculty table
ALTER TABLE faculty
MODIFY COLUMN age TINYINT NOT NULL;

-- Change email from VARCHAR(100) to VARCHAR(150)
ALTER TABLE faculty
MODIFY COLUMN email VARCHAR(150) NOT NULL;

DESCRIBE faculty;


-- Add UNIQUE to name Column
select * from customer;


ALTER TABLE faculty
ADD COLUMN customer_id INT;
ALTER TABLE faculty
ADD CONSTRAINT fk_faculty_customer
FOREIGN KEY (customer_id)
REFERENCES customer(customer_id);







