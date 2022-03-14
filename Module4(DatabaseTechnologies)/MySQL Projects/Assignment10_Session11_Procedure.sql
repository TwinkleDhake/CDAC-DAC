-- Procedure
-- ==========

use scott;
select * from emp;

-- 1. Prepare a program which can perform following operation
--    Lookout for tables which has constraints
--    Display list of those tables
	
	DELIMITER /
		CREATE PROCEDURE `constraints`(IN s_name varchar(15))
		BEGIN
			IF (s_name IS not NULL) THEN
				select distinct table_name from information_schema.table_constraints where constraint_schema = s_name;
			END IF;
	END/
    
	call constraints('scott');
------------------------------------------------------------------------------------------------------------------------------
-- 2. Prepare a program to delete the data from emp. It will receive two inputs employee number and employee name. 
-- If employee number is passed as null then delete the data based on employee name.
-- Backup the deleted data to employee_backup table.
CREATE TABLE IF NOT EXISTS employee_backup LIKE emp;
drop procedure delete_emp;
		DELIMITER #
		CREATE PROCEDURE `delete_emp`(IN e_id int(10), IN e_name varchar(15))
		BEGIN
			IF e_id IS NOT NULL THEN
				-- Backup date
				INSERT INTO employee_backup 
				SELECT * FROM emp WHERE ename= e_name;
				DELETE FROM emp WHERE ename= e_name;			
			END IF;
		END#

call delete_emp(7911,'SHUBH');
select * from employee_backup;
select * from emp;


--------------------------------------------------------------------------------------------------------------------------------
-- 3. Prepare a program to insert new record in employee table. it will take the input of employee data.
-- If salary is provided as null then consider the salary as highest salary earned by any employee in same department. 
-- If comm is not provided then assume it as 200$
		drop procedure insert_emp;
        DELIMITER $
		CREATE PROCEDURE `insert_emp`(IN e_no int(10), IN e_name varchar(20), IN e_job varchar(10), IN e_mgr int(10), 
									  IN e_hiredate date, IN e_sal int(10), IN e_comm int(10), IN e_deptno int(10))
		BEGIN
			DECLARE  h_sal INT(20);
            set h_sal = (SELECT MAX(sal) FROM emp WHERE deptno = e_deptno);
			INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES(e_no, upper(e_name), upper(e_job), e_mgr, e_hiredate, ifnull(e_sal,h_sal), ifnull(e_comm,200), e_deptno);
       	END$
        
call insert_emp (7911, 'SHUBH', 'CLERK', 7902, '1980-09-25', null, null, 10);
-- delete from emp where sal = null;
select * from emp;

---------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------
-- 4. Prepare a program to receive the input as table name and column name. Add primary key constraint on provided table's column. : Dynamic Queries
	-- ALTER TABLE table_name
    --     ADD ( PRIMARY KEY(column_name)); // Apply primary key 
    drop procedure pK_contraint;
    DELIMITER %
    CREATE PROCEDURE `pK_contraint`(tname varchar(30), cname varchar(20))
    BEGIN
                -- ALTER TABLE t_name
				-- ADD (PRIMARY KEY (c_name));
                
                SET @v_sql = CONCAT('ALTER TABLE ',tname, 'ADD (PRIMARY KEY (',cname,'))'); -- Prepare the query as a string and store it in a variable
				PREPARE STMT FROM @v_sql; -- Mysql way to prepare the query at RUNTIME
				EXECUTE STMT;             -- It will run the query which we have attached to STMT in previous line
				DEALLOCATE PREPARE STMT;
	END%
    
    call pK_contraint('employee_backup','empno');
-------------------------------------------------------------------------------------------------------------------------------------    
-- 5. Prepare a program to list those employee who are earning less then avg of there deparment. This program may take input as (p_salary_fix BOOLEAN). 
-- If the input is given as true then these employees salary must be set to AVG Salary + 100$.
	
		DELIMITER @
			CREATE PROCEDURE `avg_sal`(IN p_salary_fix BOOLEAN)
			BEGIN
				IF (p_salary_fix IS true) THEN
					UPDATE emp t
					SET sal = (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = t.DEPTNO) + 100
					WHERE sal < (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = t.DEPTNO);
						
				END IF;
		END@