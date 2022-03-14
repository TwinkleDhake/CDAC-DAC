-- Introduce following constraint on tables in Bank schema.
USE bank;
SELECT * FROM customer;
SELECT * FROM branch;
SELECT * FROM account;
SELECT * FROM tran_detail;
SELECT * FROM loan;
-- Customer table
-- Q1 Customer id in customer table must be unique and does not allow null values
SELECT * FROM customer;
DESC customer;
ALTER TABLE customer ADD(PRIMARY KEY(custid)), ADD(UNIQUE(custid)), MODIFY custid VARCHAR(6) NOT NULL;
-- Q2 Column fname must not allow space in it
ALTER TABLE customer ADD(CHECK(FNAME NOT LIKE '% %'));
-- Q3 First name, middle name and last name must not be same
ALTER TABLE customer ADD(CHECK((FNAME <> MNAME AND FNAME<>LTNAME) AND MNAME <> LTNAME));
-- Q4 Age of customer (based on date of birth) must be more then 10 years old.
SELECT * FROM customer;
DESC customer;
ALTER TABLE customer DROP COLUMN AGE;
ALTER TABLE customer ADD(CHECK(DATEDIFF(SYDATE(), dob)/365 > 4));

-- Branch Table
-- Q1 Branch name must not be null
SELECT * FROM branch;
DESC branch;
ALTER TABLE branch MODIFY bname VARCHAR(30) NOT NULL;
-- Q2 Branch id must be unique and not null
ALTER TABLE branch ADD(UNIQUE (bid)), MODIFY bid VARCHAR(30) NOT NULL;

-- Account Table
-- Q1 Account number for each record must be unique
SELECT * FROM account;
ALTER TABLE account ADD(UNIQUE(acnumber));
-- Q2 Customer Id must be of valid customer and must not be left as blank
ALTER TABLE account ADD FOREIGN KEY(custid) REFERENCES customer(custid), MODIFY custid VARCHAR(6) NOT NULL;
-- Q3 opening balance must be more then 10000
SELECT * FROM account;
DESC account;
ALTER TABLE account ADD(CHECK(opening_balance >= 10000));
-- Q4 Acount opening date must not be of past dates
ALTER TABLE account add(CHECK(aod >= sysdate()));
-- Q5 Branch id (bid) must be of valid branch 
SELECT * FROM account;
DESC account;
ALTER TABLE account ADD FOREIGN KEY (bid) REFERENCES branch (bid), MODIFY bid VARCHAR(30) NOT NULL;

-- Tran_detail Table

-- Q1 Transaction number must be unique for each transaction
SELECT * FROM tran_detail;
ALTER TABLE tran_detail ADD(UNIQUE(tnumber));
-- Q2 Account number must refer to valid account
SELECT * FROM tran_detail;
ALTER TABLE tran_detail ADD FOREIGN KEY (acnumber) REFERENCES account (acnumber), MODIFY acnumber VARCHAR(6) NOT NULL;

-- Loan Table

-- Q1 Customer Id must be of valid customer and must not be left as blank
SELECT * FROM loan;
DESC loan;
ALTER TABLE loan ADD FOREIGN KEY (custid) REFERENCES customer (custid), MODIFY custid VARCHAR(6) NOT NULL;
-- Q2 Branch id (bid) must be of valid branch 
ALTER TABLE loan ADD FOREIGN KEY (bid) REFERENCES branch (bid), MODIFY bid VARCHAR(30) NOT NULL;
-- Q3 One customer can take only one loan for each loan type
DESC loan; 
ALTER TABLE loan ADD(PRIMARY KEY(custid, loan_type));