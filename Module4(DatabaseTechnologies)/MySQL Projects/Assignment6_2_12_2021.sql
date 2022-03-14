-- 1. INSERT following records in supplier, parts and supplier parts table.
-- Supplier

-- Suppid	Suppname	Status	City
-- 2001	Peel	14	London
-- 2002	Serres	16	San Jose
-- 2003	Motika	22	London
-- 2004	Rifkin	21	Barcelona
-- 2005	Axelrod	10	New York
-- 2006	Pierson	8	Lisbon
-- 2007	Smith	14	Barcelon
-- 2008	Aston	34	San Jose

USE inventory;
INSERT INTO supplier (S_No, SNAME, STATUS, CITY )
		VALUE (2001,'Peel',14,'London'),
         (2002	,'Serres'	,16,'San Jose'),
         (2003,	'Motika',22,'London'),
		 (2004	,'Rifkin',21,'Barcelona'),
		 (2005,'Axelrod',10	,'New York'),
         (2006	,'Pierson'	,8	,'Lisbon'),
         (2007,	'Smith'	,14	,'Barcelon'),
		 (2008	,'Aston',34	,'San Jose');

-- Parts

INSERT INTO Parts (P_no, Suppid, Partname,	PartDesc, PartWeight,Price)
VALUE (3001,	2008,	'Nut','RedColor',18.69	,1007),
(3003,	2001,	'Bolt',	'2.5 inch',	767.19	,1001),
(3002,	2007,	'Screw',	'1.5 inch',	1900.10,	1004),
(3005,	2003,	'Cam',	'2mm',	5160.45,	1002),
(3006,	2008,	'Cog',	'12mm',	1098.16,	1007),
(3009,	2002,	'Spanner',	'Point 7',	1713.23,	1003),
(3007,	2004,	'Nut'	,'1.5 inch',	75.75,	1002),
(3008,	2006,	'Nut'	,'1.8 inch'	,4723.00,	1001),
(3010,	2004,	'Screw'	,'12 inch',	'1309.95',	1002);

-- SupplierPart

INSERT INTO SupplierPart(S_No, P_No, Quantity)
VALUE(2001,	3001,	200),
(2001	,3003,	400),
(2002,	3003,	200),
(2002,	3009,	100),
(2003,	3003,	200),
(2003,	3006,	500),
(2004,	3010,	500),
(2005,	3002,	200),
(2005,	3009,	100),
(2005,	3010,	200),
(2005,	3001,	100),
(2005,	3003,	200),
(2005,	3006,	800),
(2005,	3009,	400),
(2005,	3010,	500);

-- 2. Update the price of part Nut by 50$
SELECT * FROM parts; UPDATE parts SET price=price+50 WHERE partname = 'Nut';

-- 3. Supplier 2001 is leaving the business hence remove the supplier data from supplier table.
DELETE FROM supplier WHERE s_no = 2001;

-- 4. Update Supplier Part Table and replace S_no 2001 with 2005
UPDATE SupplierPart SET s_no=2005 WHERE S_no=2001;

-- 5. Remove the part Screw which is 1.5 inch in length and also remove its data from Supplier part table.
DELETE FROM parts WHERE P_NO=3001;