create database Company;

use Company;

create table Categories(
CategoryID bigint primary key auto_increment,
CategoryName varchar(40));


create table Brands(
BrandID bigint primary key auto_increment,
BrandName varchar(40));


create table Products(
ProductID bigint primary key auto_increment,
ProductName varchar(50),
Price decimal(15,2),
DateOfPurchase datetime,
AvailabilityStatus varchar(50),
CategoryID bigint, CONSTRAINT fk_category FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) on delete set null,
BrandID bigint, CONSTRAINT fk_brand FOREIGN KEY (BrandID) references Brands(BrandID) on delete set null,
Active bit default(1));


insert into Categories(CategoryName) values('Electronics');
insert into Categories(CategoryName)  values('Home Appliances');

Select * from Categories;

insert into Brands(BrandName) values('Samsung');
insert into Brands(BrandName) values('Apple');
insert into Brands(BrandName) values('Sony');
insert into Brands(BrandName) values('HP');

Select * from Brands;

insert into Products(ProductName,Price,DateOfPurchase,AvailabilityStatus,CategoryID,BrandID,Active) values('Samsung Galaxy S10', 84290, '2018-7-1', 'InStock', 1, 1, 1);
insert into Products(ProductName,Price,DateOfPurchase,AvailabilityStatus,CategoryID,BrandID,Active) values('Samsung Refrigerator', 27000, '2016-6-15', 'OutOfStock', 2, 1, 1);
insert into Products(ProductName,Price,DateOfPurchase,AvailabilityStatus,CategoryID,BrandID,Active) values('iPhone X', 99999, '2018-6-10', 'InStock', 1, 2, 1);
insert into Products(ProductName,Price,DateOfPurchase,AvailabilityStatus,CategoryID,BrandID,Active) values('HP Laptop', 34700, '2018-3-4', 'InStock', 1, 4, 1);
insert into Products(ProductName,Price,DateOfPurchase,AvailabilityStatus,CategoryID,BrandID,Active) values('Sony Home Theatre 5.1', 8700, '2017-5-18', 'InStock', 1, 3, 1);
insert into Products(ProductName,Price,DateOfPurchase,AvailabilityStatus,CategoryID,BrandID,Active) values('Sony Bravia 40 LED', 67000, '2018-7-19', 'InStock', 2, 3, 1);


select * from Products;
