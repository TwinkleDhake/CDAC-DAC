CREATE DATABASE inventory;

USE inventory;

CREATE TABLE supplier
(
S_No     VARCHAR(5),
SNAME    VARCHAR(20),
STATUS   INT,
CITY     VARCHAR(15)
);

CREATE TABLE Parts
(
   P_No        INT,
   suppid      INT,
   partname    VARCHAR(10),
   partdesc    VARCHAR(8),
   partweight  INT,
   price       INT
);

CREATE TABLE SupplierPart
(
S_No      VARCHAR(5),
P_No      VARCHAR(5),
QUANTITY  INT
);