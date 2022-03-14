-- SQL Questions

-- Q1. Display Movie Names of all movies which are screening today.
select Movie_name ,Show_Start_DateTime  from Movie m inner join Movie_Show s ON m.Movie_Id = s.Movie_Id
where Show_Start_DateTime = curdate();

-- Q2. Display Multiplex_id and maximum seat count for each multiplex.
select multiplex_id from multiplex
where multiplex_id in( select max(seat_count)from screen);

-- Q3. Display details of Movie for which bookings has occurred today.
select * from movie join movie_show on movie_id.movie = movie_id.movie_show 
                    join booking on show_id.movie_show = show_id.booking;

-- Q4. Display Multiplex_id which have atleast 3 screens.
select  Multiplex_id,SCREEN_NUMBER from SCREEN
where SCREEN_NUMBER >=3;

-- Q5. Display list of ‘English’ Language Movies which will release during current Month.
select distinct MOVIE_NAME, Show_Start_DateTime from MOVIE M inner join Movie_Show S on M.Movie_Id = S.Movie_Id
where MOVIE_LANGUAGE='ENGLISH';

-- Q6. Which movies has same name but released in Hindi and English Language
select * from movie;
select movie_name.a from movie as a join movie as m on movie_name.a = movie_name.m;

-- Q7. Display List of multiplexes where ‘Pune’ is mentioned somewhere in their Multiplex Address
 select * from multiplex
 where  MULTIPLEX_ADDRESS='pune';

-- Q8. Display movie name for which highest Booking Amount has been collected till date.
select Booking_id,Show_id,Show_Date, max(Booking_Amount_Paid) as MAX_AMT from booking;

-- Q9 Display movies which have Movie Cast including ‘Tom Hanks’.
select* from movie
where MOVIE_CAST='Tom Hanks';

-- Q10 Display list of movies for which rating is more than 3.
select* from movie
where MOVIE_RATING >=3;

-- PL/SQL Questions

-- Q1. Write a trigger to ensure that if any Multiplex record is deleted from Multiplex table 
then all dependent or related records are deleted from following tables:
a. Screen
b. Movie_Show
c. Booking
This must occur automatically on delete operation on Multiplex table.

DELIMITER $
		CREATE TRIGGER Question1
		before DELETE ON Multiplex
		FOR EACH ROW
		BEGIN
				DELETE FROM screen 
				WHERE screen. MULTIPLEX_ID= Multiplex.old.MULTIPLEX_ID;
                
                DELETE FROM Movie_Show 
				WHERE Movie_Show.MULTIPLEX_ID = Multiplex.old.MULTIPLEX_ID;
                
                DELETE FROM Booking 
				WHERE screen.show_id = (select MULTIPLEX_ID from movie_show where Movie_Show.MULTIPLEX_ID = Multiplex.old.MULTIPLEX_ID);
	END$
    
--  Q2. Write a program with following specification
-- a. It must accept DATE as an argument which must be first date of the month like
-- 01-AUG-2012 or 01-SEP-2012, etc.
-- b. Whenever invoked it must load relevant data in BOOKING_SUMMARY summary
-- table (new table). Structure of this table is as follows:
-- Column_Name Data Type
-- Multiplex_id INTEGER
-- Multiplex_Name VARCHAR(200)
-- Screen_id INTEGER
-- Movie_id INTEGER
-- Month_Of_Year DATE
-- Total_Collection INTEGER
-- For an example: If user has called this program with date 01-AUG-2012 then it
-- must pick total booking amount from BOOKING TABLE for all multiplex_id,
-- screen_id and movie_id for given month ’01-AUG-2012’ and insert record in
-- BOOKING_SUMMARY table.

drop procedure booking_firstdate;
		DELIMITER #
		CREATE PROCEDURE `booking_firstdate`(IN b_fdate date)
		BEGIN
        DECLARE  h_fdate  date ;
            set h_fdate = to_date(b_fdate, DD-MM-YYYY );
			IF b_fdate IS NOT NULL THEN
	END IF;
    END#
call booking_firstdate("01-FEB-2022");