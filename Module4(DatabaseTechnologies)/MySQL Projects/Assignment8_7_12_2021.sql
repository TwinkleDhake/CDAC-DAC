-- Q1 Update all Branch_id where referred as BR in place of B
-- eg: B00001 will become BR_00001
ALTER TABLE branch 
MODIFY bid VARCHAR(10);
DESC branch;
ALTER TABLE account MODIFY bid VARCHAR(10);

ALTER TABLE loan DROP CONSTRAINT loan_ibfk_2;
    
alter table loan ADD(FOREIGN KEY(bid) REFERENCES  branch(bid) ON UPDATE CASCADE);
SHOW CREATE TABLE loan;
UPDATE branch SET bid = REPLACE(bid,'B','BR_');
SELECT * FROM branch;
    
SELECT * FROM account;
UPDATE account SET bid = REPLACE(bid,'B','BR_');
    
SELECT * FROM loan;
UPDATE loan SET bid = REPLACE(bid,'B','BR_');
 
ALTER TABLE loan ADD(FOREIGN KEY(bid) REFERENCES  branch(bid) ON UPDATE CASCADE);
DESC loan;
ALTER TABLE account ADD(FOREIGN KEY(bid) REFERENCES  branch(bid) ON UPDATE CASCADE);
DESC account;
ALTER TABLE loan MODIFY bid VARCHAR(10);                         
UPDATE branch SET bid = REPLACE(bid,'B','br_');
SELECT * FROM loan;
-- Q2 For testing purpose create a copy of tran_detail table and use bulk insert to load 50,000 records to it. Please make necessary arrangement to generate new TRAN_ID for each record
SELECT * FROM tran_detail;
CREATE TABLE tran_copy1 LIKE tran_detail;
DESC tran_copy1;
SELECT * FROM tran_copy1;
-- Q3 Update Transaction type and medium of transaction values to upper case for all records of transaction table.
UPDATE tran_detail SET medium_of_transaction = UPPER(medium_of_transaction), transaction_type = UPPER(transaction_type);
SELECT * FROM tran_detail;
-- Q4 Update phone number and base location of customer Abhishek (C00009) to 8976523191 and Pune
UPDATE customer SET mobileno = 8976523191, city = 'Pune' WHERE fname = 'Abhishek';
-- Q5 Add a new column customer_cnt to Branch table and update it's value based on count of customer that branch has.
SELECT * FROM branch;
SELECT * FROM customer;
SELECT * FROM account;
ALTER TABLE branch ADD (customer_cnt  INT UNSIGNED);
     
SELECT bid , count(*) FROM account a WHERE bid =a.bid;
--  group by bid;
    
UPDATE branch a set customer_cnt = (SELECT count(*) FROM account WHERE bid =a.bid);
-- Q6 Create a new table account_bak and copy all records of account table to account_bak
CREATE TEMPORARY TABLE account_temp1 AS SELECT * -- acnumber,custid,bid,opening_balance,aod,atype,astatus 
FROM account;
SELECT * FROM account_temp1;
-- drop table account_bak;
-- Q7 Update the account status as Inavtive for account of customer 'Amit Kumar Borkar'
 UPDATE account SET astatus= 'Inactive' WHERE custid = (SELECT custid FROM customer WHERE fname='Amit' AND mname='Kumar' AND lname='Borkar');
-- Q8 Add a new transaction to account for all loan account customers as one time charge of 1000 Rs for current month.
ALTER TABLE account ADD(loan_charge INT(8) UNSIGNED);
UPDATE account a SET loan_charge =  1000 WHERE custid IN  (SELECT custid FROM loan WHERE custid = a.custid);
-- Q9 Add Index on tnumber column on copy of tran_detail table and observe execution plan of following queries
SELECT * FROM tran_detail;
CREATE TABLE tran_detail_copy1 LIKE tran_detail;
DESC tran_detail_copy1;
SELECT * FROM tran_detail_copy1;
    
INSERT INTO tran_detail_copy1 SELECT * FROM tran_detail;
-- 1 -- 
SELECT count(tnumber) FROM  tran_detail_copy1;	
-- 2 --
SELECT * FROM tran_detail_copy1 WHERE dot > '2021-02-01';	  
-- 3 --
SELECT * FROM tran_detail_copy1 ORDER BY tnumber;
-- select count(tnumber) from  tran_detail_copy;	
-- select * from tran_details_copy where dot > '2021-02-01';	  
-- select * from tran_detail_copy order by tnumber;