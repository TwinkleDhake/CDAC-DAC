use bank;
-- 1. Update all Branch_id where referred as BR in place of B
   --   eg: B00001 will become BR_00001
   alter table branch 
    modify bid varchar(10);
    desc branch;
     alter table account 
    modify bid varchar(10);
    
    
    ALTER TABLE loan
	DROP  CONSTRAINT loan_ibfk_2;
    
    
    
    alter table loan 
    add(foreign key(bid) REFERENCES  branch(bid) on update cascade);
    show create table loan;
    UPDATE branch
	SET bid = replace(bid,'B','BR_');
    select * from branch;
    
    select * from account;
    UPDATE account
	SET bid = replace(bid,'B','BR_');
    
    select * from loan;
    UPDATE loan
	SET bid = replace(bid,'B','BR_');
 
	alter table loan add(foreign key(bid) REFERENCES  branch(bid) on update cascade);
    desc loan;
    alter table account add(foreign key(bid) REFERENCES  branch(bid) on update cascade);
    desc account;
		   alter table loan 
		   modify bid varchar(10);                         
        update branch
        set bid = replace(bid,'B','br_');
        select * from loan;
        

 -- 2.For testing purpose create a copy of tran_detail table and use bulk insert to load 50,000 records to it.
 -- Please make necessary arrangement to generate new TRAN_ID for each record
 
 select * from tran_detail;
    CREATE TABLE tran_copy1 LIKE tran_detail;
    desc tran_copy1;
	select * from tran_copy1;

-- 3. Update Transaction type and medium of transaction values to upper case for all records of transaction table.

update tran_detail
    set medium_of_transaction = upper(medium_of_transaction),
		transaction_type = upper(transaction_type);
	select * from tran_detail;

-- 4. Update phone number and base location of customer Abhishek (C00009) to 8976523191 and Pune

UPDATE customer 
	SET mobileno = 8976523191, city = 'Pune' 
	where fname = 'Abhishek';

-- 5. Add a new column customer_cnt to Branch table and update its value based on count of customer that branch has.


	 select * from branch;
	 select * from customer;
     select * from account;
	 ALTER TABLE branch
	 ADD (customer_cnt  INT UNSIGNED);
     
     select bid , count(*) from account a
     where bid =a.bid;
   --  group by bid;
    
		update branch a
        set customer_cnt = (select count(*) from account where bid =a.bid);
        
-- 6. Create a new table account_bak and copy all records of account table to account_bak

CREATE TEMPORARY TABLE account_temp1
    AS select * -- acnumber,custid,bid,opening_balance,aod,atype,astatus 
    FROM account;
    
    select * from account_temp1;
   
   -- drop table account_bak;
   
-- 7. Update the account status as Inactive for account of customer 'Amit Kumar Borkar'
	
    update account
    Set astatus= 'Inactive'
    where custid = (select custid from customer where fname='Amit' and mname='Kumar' and lname='Borkar');


-- 8. Add a new transaction to account for all loan account customers as one time charge of 1000 Rs for current month.
	alter table account
    add(loan_charge int(8) unsigned);
    update account a
    set loan_charge =  1000
    where custid in  (select custid
    from loan
    where custid = a.custid);
    


-- 9. Add Index on tnumber column on copy of tran_detail table and observe execution plan of following queries
	
    select * from tran_detail;
    CREATE TABLE tran_detail_copy1 LIKE tran_detail;
    desc tran_detail_copy1;
	select * from tran_detail_copy1;
    
    insert into tran_detail_copy1
    select * from tran_detail;
	
	-- 1. -- 
	select count(tnumber) from  tran_detail_copy1;
	
	-- 2. --
    select * from tran_detail_copy1 
	where dot > '2021-02-01';
	  
	-- 3. --
    select * from tran_detail_copy1
	order by tnumber;
