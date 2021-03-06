show databases;
use scott;
show tables;
use mysql;
DROP DATABASE scott;
Create Database scott;
-- Q1
SELECT * FROM emp;
-- Q2
SELECT EMPNO, ENAME FROM emp;
-- Q3
DESCRIBE emp;
DESCRIBE dept;
DESCRIBE salgrade;
-- Q4
SELECT DISTICT JOB FROM emp;
-- Q5
SELECT CONCAT(ENAME, 'IS EARNING', SAL, 'DOLLARS') AS OUTPUT FROM emp;
-- Q6
SELECT ENAME, JOB FROM emp;
-- Q7
SELECT ENAME, ((SAL + IFNULL(COMM, 0) + 1000) * 12) AS AnnualSalary,1000 AS BONUS FROM emp;
-- Q8
SELECT DISTINCT EMPNO FROM emp WHERE JOB = 'MANAGER';
-- Q9
SELECT ENAME, SAL, ifnull(COMM,1500) FROM emp;

-- WHERE CLAUSE
-- Q1
SELECT ENAME,SAL,ifnull(COMM,1500) FROM emp WHERE dept=10;
-- Q2
SELECT ENAME,SAL FROM emp WHERE JOB = 'CLERK' OR 'SALESMAN';
-- Q3
SELECT ENAME FROM emp WHERE HIREDATE='1981-12-31' AND 1981-12-31;
-- Q4
SELECT ENAME FROM emp WHERE HIREDATE='1981-01-01' AND 1981-12-31;
-- Q5
SELECT ENAME FROM emp WHERE JOB='CLERK' AND SAL>1000;
-- Q6
SELECT ENAME FROM emp WHERE MGR IS NULL;
-- Q7
SELECT ENAME FROM emp WHERE COMM IS NULL;
-- Q8
SELECT ENAME, (SAL +ifnull(COMM,0)) AS AnnualSalary FROM emp WHERE (SAL +ifnull(COMM,0)) >2000;
-- Q9
SELECT ENAME FROM emp WHERE JOB='SALESMAN' and dept IN (10,30);
-- Q10
SELECT ENAME FROM emp WHERE JOB='SALESMAN' AND COMM IS NOT NULL;