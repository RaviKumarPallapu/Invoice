CREATE TABLE invoice_details ( id smallint unsigned not null auto_increment, Vendor_Name varchar(20) not null,Suplier_Number varchar(20) not null,Customer_Po varchar(20) not null,Total_Amount varchar(20) not null,Invoice_Number varchar(20) not null,Invoice_Date varchar(20) not null,File_Path varchar(50) not null, File_Format varchar(20) not null,File_Name varchar(20) not null, constraint pk_example primary key (id))