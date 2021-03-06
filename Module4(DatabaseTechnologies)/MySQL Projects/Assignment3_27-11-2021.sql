show databases;
use scott;
show tables;
use mysql;
DROP DATABASE scott;
Create Database scott;

-- ORDER BY

-- Q1
SELECT * FROM emp ORDER BY SAL desc;
-- Q2
SELECT * FROM emp ORDER BY DEPTNO asc, SAL desc;
-- Q3
SELECT * FROM emp ORDER BY HIREDATE asc;
-- Q4
SELECT * FROM emp ORDER BY COMM desc LIMIT 1;

-- MISCELLANEOUS

-- Q1
SELECT * FROM emp WHERE HIREDATE BETWEEN '1981-10-31' AND '1981-12-31';
-- Q2
SELECT DISTINCT JOB FROM emp;
-- Q3
SELECT * FROM emp WHERE HIREDATE BETWEEN '1981-09-28' AND '1981-11-03';
-- Q4
SELECT * FROM emp WHERE ename NOT LIKE 'T%';
-- Q5
SELECT EMPNO, ENAME, SAL ACTUAL_SAL, (SAL*15/100) AS INCREASED_SAL FROM emp;
-- Q6
SELECT * FROM emp GROUP BY ENAME LIKE 'J%' AND ENAME LIKE 'S%';
-- Q7
SELECT * FROM emp WHERE JOB NOT IN ('PRESIDENT','MANAGER');
-- Q8
SELECT * FROM emp WHERE SAL>=100 AND SAL<=999;
-- Q9
SELECT * FROM emp WHERE ENAME LIKE 'L%';

-- GROUP BY AND GROUP FUNCTIONS

-- Q1
SELECT MAX(SAL) FROM emp;
-- Q2
SELECT AVG(SAL) FROM emp GROUP BY 'SALESMAN';
-- Q3
SELECT DEPTNO, MIN(SAL), MAX(SAL) FROM emp GROUP BY DEPTNO;
-- Q4
SELECT JOB, DEPTNO, MIN(SAL), MAX(SAL) FROM emp GROUP BY JOB;
-- Q5
SELECT JOB, DEPTNO, COUNT(*) FROM emp GROUP BY DEPTNO ORDER BY COUNT(*)>3;
-- Q6
SELECT JOB, COUNT(*) FROM emp WHERE JOB = 'SALESMAN';
-- Q7
SELECT COUNT(*) FROM emp WHERE HIREDATE BETWEEN '1981-01-01' AND '1981-12-31';