/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     19/11/2018 19:41:51                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_ATPOSITI_ATPOSITIO_EMPLOYEE') then
    alter table ATPOSITION
       delete foreign key FK_ATPOSITI_ATPOSITIO_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ATPOSITI_ATPOSITIO_POSITION') then
    alter table ATPOSITION
       delete foreign key FK_ATPOSITI_ATPOSITIO_POSITION
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILL_RELATIONS_VOUCHER') then
    alter table BILL
       delete foreign key FK_BILL_RELATIONS_VOUCHER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILL_RELATIONS_BILLSTAT') then
    alter table BILL
       delete foreign key FK_BILL_RELATIONS_BILLSTAT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILL_RELATIONS_CUSTOMER') then
    alter table BILL
       delete foreign key FK_BILL_RELATIONS_CUSTOMER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILL_RELATIONS_DINNERTA') then
    alter table BILL
       delete foreign key FK_BILL_RELATIONS_DINNERTA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILL_RELATIONS_EMPLOYEE') then
    alter table BILL
       delete foreign key FK_BILL_RELATIONS_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILLDETA_BILLDETAI_PRODUCT') then
    alter table BILLDETAIL
       delete foreign key FK_BILLDETA_BILLDETAI_PRODUCT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BILLDETA_BILLDETAI_BILL') then
    alter table BILLDETAIL
       delete foreign key FK_BILLDETA_BILLDETAI_BILL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BOOKTABL_BOOKTABLE_CUSTOMER') then
    alter table BOOKTABLE
       delete foreign key FK_BOOKTABL_BOOKTABLE_CUSTOMER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BOOKTABL_BOOKTABLE_DINNERTA') then
    alter table BOOKTABLE
       delete foreign key FK_BOOKTABL_BOOKTABLE_DINNERTA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_BOOKTABL_BOOKTABLE_EMPLOYEE') then
    alter table BOOKTABLE
       delete foreign key FK_BOOKTABL_BOOKTABLE_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DINNERTA_RELATIONS_TABLESTA') then
    alter table DINNERTABLE
       delete foreign key FK_DINNERTA_RELATIONS_TABLESTA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EXPORTBI_RELATIONS_PRODUCT') then
    alter table EXPORTBILL
       delete foreign key FK_EXPORTBI_RELATIONS_PRODUCT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EXPORTBI_RELATIONS_EMPLOYEE') then
    alter table EXPORTBILL
       delete foreign key FK_EXPORTBI_RELATIONS_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EXPORTBI_EXPORTBIL_EXPORTBI') then
    alter table EXPORTBILLDETAIL
       delete foreign key FK_EXPORTBI_EXPORTBIL_EXPORTBI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EXPORTBI_EXPORTBIL_MATERIAL') then
    alter table EXPORTBILLDETAIL
       delete foreign key FK_EXPORTBI_EXPORTBIL_MATERIAL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMAGEOFE_IMAGEOFEM_IMAGE') then
    alter table IMAGEOFEMPLOYEE
       delete foreign key FK_IMAGEOFE_IMAGEOFEM_IMAGE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMAGEOFE_IMAGEOFEM_EMPLOYEE') then
    alter table IMAGEOFEMPLOYEE
       delete foreign key FK_IMAGEOFE_IMAGEOFEM_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMAGEOFP_IMAGEOFPR_PRODUCT') then
    alter table IMAGEOFPRODUCT
       delete foreign key FK_IMAGEOFP_IMAGEOFPR_PRODUCT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMAGEOFP_IMAGEOFPR_IMAGE') then
    alter table IMAGEOFPRODUCT
       delete foreign key FK_IMAGEOFP_IMAGEOFPR_IMAGE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMPORTBI_RELATIONS_SUPPLIER') then
    alter table IMPORTBILL
       delete foreign key FK_IMPORTBI_RELATIONS_SUPPLIER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMPORTBI_RELATIONS_EMPLOYEE') then
    alter table IMPORTBILL
       delete foreign key FK_IMPORTBI_RELATIONS_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMPORTBI_IMPORTBIL_MATERIAL') then
    alter table IMPORTBILLDETAIL
       delete foreign key FK_IMPORTBI_IMPORTBIL_MATERIAL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_IMPORTBI_IMPORTBIL_IMPORTBI') then
    alter table IMPORTBILLDETAIL
       delete foreign key FK_IMPORTBI_IMPORTBIL_IMPORTBI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MATERIAL_RELATIONS_MATERIAL') then
    alter table MATERIALDETAIL
       delete foreign key FK_MATERIAL_RELATIONS_MATERIAL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PRICE_RELATIONS_PRODUCT') then
    alter table PRICE
       delete foreign key FK_PRICE_RELATIONS_PRODUCT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PRODUCT_RELATIONS_CATEGORY') then
    alter table PRODUCT
       delete foreign key FK_PRODUCT_RELATIONS_CATEGORY
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_REGISTER_REGISTER_EMPLOYEE') then
    alter table REGISTER
       delete foreign key FK_REGISTER_REGISTER_EMPLOYEE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_REGISTER_REGISTER2_SCHEDULE') then
    alter table REGISTER
       delete foreign key FK_REGISTER_REGISTER2_SCHEDULE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SALARY_RELATIONS_EMPLOYEE') then
    alter table SALARY
       delete foreign key FK_SALARY_RELATIONS_EMPLOYEE
end if;

drop index if exists ATPOSITION.ATPOSITION2_FK;

drop index if exists ATPOSITION.ATPOSITION_FK;

drop index if exists ATPOSITION.ATPOSITION_PK;

drop table if exists ATPOSITION;

drop index if exists BILL.RELATIONSHIP_8_FK;

drop index if exists BILL.RELATIONSHIP_7_FK;

drop index if exists BILL.RELATIONSHIP_6_FK;

drop index if exists BILL.RELATIONSHIP_5_FK;

drop index if exists BILL.RELATIONSHIP_3_FK;

drop index if exists BILL.BILL_PK;

drop table if exists BILL;

drop index if exists BILLDETAIL.BILLDETAIL2_FK;

drop index if exists BILLDETAIL.BILLDETAIL_FK;

drop index if exists BILLDETAIL.BILLDETAIL_PK;

drop table if exists BILLDETAIL;

drop index if exists BILLSTATUS.BILLSTATUS_PK;

drop table if exists BILLSTATUS;

drop index if exists BOOKTABLE.BOOKTABLE3_FK;

drop index if exists BOOKTABLE.BOOKTABLE2_FK;

drop index if exists BOOKTABLE.BOOKTABLE_FK;

drop index if exists BOOKTABLE.BOOKTABLE_PK;

drop table if exists BOOKTABLE;

drop index if exists CATEGORYPRODUCT.CATEGORYPRODUCT_PK;

drop table if exists CATEGORYPRODUCT;

drop index if exists CUSTOMER.CUSTOMER_PK;

drop table if exists CUSTOMER;

drop index if exists DINNERTABLE.RELATIONSHIP_14_FK;

drop index if exists DINNERTABLE.DINNERTABLE_PK;

drop table if exists DINNERTABLE;

drop index if exists EMPLOYEE.EMPLOYEE_PK;

drop table if exists EMPLOYEE;

drop index if exists EXPORTBILL.RELATIONSHIP_17_FK;

drop index if exists EXPORTBILL.RELATIONSHIP_16_FK;

drop index if exists EXPORTBILL.EXPORTBILL_PK;

drop table if exists EXPORTBILL;

drop index if exists EXPORTBILLDETAIL.EXPORTBILLDETAIL2_FK;

drop index if exists EXPORTBILLDETAIL.EXPORTBILLDETAIL_FK;

drop index if exists EXPORTBILLDETAIL.EXPORTBILLDETAIL_PK;

drop table if exists EXPORTBILLDETAIL;

drop index if exists IMAGE.IMAGE_PK;

drop table if exists IMAGE;

drop index if exists IMAGEOFEMPLOYEE.IMAGEOFEMPLOYEE2_FK;

drop index if exists IMAGEOFEMPLOYEE.IMAGEOFEMPLOYEE_FK;

drop index if exists IMAGEOFEMPLOYEE.IMAGEOFEMPLOYEE_PK;

drop table if exists IMAGEOFEMPLOYEE;

drop index if exists IMAGEOFPRODUCT.IMAGEOFPRODUCT2_FK;

drop index if exists IMAGEOFPRODUCT.IMAGEOFPRODUCT_FK;

drop index if exists IMAGEOFPRODUCT.IMAGEOFPRODUCT_PK;

drop table if exists IMAGEOFPRODUCT;

drop index if exists IMPORTBILL.RELATIONSHIP_15_FK;

drop index if exists IMPORTBILL.RELATIONSHIP_13_FK;

drop index if exists IMPORTBILL.IMPORTBILL_PK;

drop table if exists IMPORTBILL;

drop index if exists IMPORTBILLDETAIL.IMPORTBILLDETAIL2_FK;

drop index if exists IMPORTBILLDETAIL.IMPORTBILLDETAIL_FK;

drop index if exists IMPORTBILLDETAIL.IMPORTBILLDETAIL_PK;

drop table if exists IMPORTBILLDETAIL;

drop index if exists MATERIAL.MATERIAL_PK;

drop table if exists MATERIAL;

drop index if exists MATERIALDETAIL.RELATIONSHIP_11_FK;

drop index if exists MATERIALDETAIL.MATERIALDETAIL_PK;

drop table if exists MATERIALDETAIL;

drop index if exists POSITION.POSITION_PK;

drop table if exists POSITION;

drop index if exists PRICE.RELATIONSHIP_1_FK;

drop index if exists PRICE.PRICE_PK;

drop table if exists PRICE;

drop index if exists PRODUCT.RELATIONSHIP_2_FK;

drop index if exists PRODUCT.PRODUCT_PK;

drop table if exists PRODUCT;

drop index if exists REGISTER.REGISTER2_FK;

drop index if exists REGISTER.REGISTER_FK;

drop index if exists REGISTER.REGISTER_PK;

drop table if exists REGISTER;

drop index if exists SALARY.RELATIONSHIP_18_FK;

drop index if exists SALARY.SALARY_PK;

drop table if exists SALARY;

drop index if exists SCHEDULE.SCHEDULE_PK;

drop table if exists SCHEDULE;

drop index if exists SUPPLIER.SUPPLIER_PK;

drop table if exists SUPPLIER;

drop index if exists TABLESTATUS.TABLESTATUS_PK;

drop table if exists TABLESTATUS;

drop index if exists VOUCHER.VOUCHER_PK;

drop table if exists VOUCHER;

/*==============================================================*/
/* Table: ATPOSITION                                            */
/*==============================================================*/
create table ATPOSITION 
(
   EMPLOYEEID           varchar(7)                     not null,
   POSITIONID           varchar(255)                   not null,
   STARTDATE            date                           null,
   ENDDATE              date                           null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_ATPOSITION primary key clustered (EMPLOYEEID, POSITIONID)
);

/*==============================================================*/
/* Index: ATPOSITION_PK                                         */
/*==============================================================*/
create unique clustered index ATPOSITION_PK on ATPOSITION (
EMPLOYEEID ASC,
POSITIONID ASC
);

/*==============================================================*/
/* Index: ATPOSITION_FK                                         */
/*==============================================================*/
create index ATPOSITION_FK on ATPOSITION (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Index: ATPOSITION2_FK                                        */
/*==============================================================*/
create index ATPOSITION2_FK on ATPOSITION (
POSITIONID ASC
);

/*==============================================================*/
/* Table: BILL                                                  */
/*==============================================================*/
create table BILL 
(
   BILLID               integer                        not null,
   BILLSTATUSID         varchar(7)                     null,
   DINNERTABLEID        integer                        null,
   CUSTOMERID           integer                        null,
   EMPLOYEEID           varchar(7)                     null,
   VOUCHERID            integer                        null,
   STARTDATETIME        timestamp                      null,
   ENDDATE              date                           null,
   NOTICE               varchar(255)                   null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_BILL primary key (BILLID)
);

/*==============================================================*/
/* Index: BILL_PK                                               */
/*==============================================================*/
create unique index BILL_PK on BILL (
BILLID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on BILL (
VOUCHERID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_5_FK on BILL (
BILLSTATUSID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_6_FK on BILL (
CUSTOMERID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on BILL (
DINNERTABLEID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on BILL (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: BILLDETAIL                                            */
/*==============================================================*/
create table BILLDETAIL 
(
   PRODUCTID            varchar(7)                     not null,
   BILLID               integer                        not null,
   QUANTITY             integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_BILLDETAIL primary key clustered (PRODUCTID, BILLID)
);

/*==============================================================*/
/* Index: BILLDETAIL_PK                                         */
/*==============================================================*/
create unique clustered index BILLDETAIL_PK on BILLDETAIL (
PRODUCTID ASC,
BILLID ASC
);

/*==============================================================*/
/* Index: BILLDETAIL_FK                                         */
/*==============================================================*/
create index BILLDETAIL_FK on BILLDETAIL (
PRODUCTID ASC
);

/*==============================================================*/
/* Index: BILLDETAIL2_FK                                        */
/*==============================================================*/
create index BILLDETAIL2_FK on BILLDETAIL (
BILLID ASC
);

/*==============================================================*/
/* Table: BILLSTATUS                                            */
/*==============================================================*/
create table BILLSTATUS 
(
   BILLSTATUSID         varchar(7)                     not null,
   NAME                 varchar(255)                   null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_BILLSTATUS primary key (BILLSTATUSID)
);

/*==============================================================*/
/* Index: BILLSTATUS_PK                                         */
/*==============================================================*/
create unique index BILLSTATUS_PK on BILLSTATUS (
BILLSTATUSID ASC
);

/*==============================================================*/
/* Table: BOOKTABLE                                             */
/*==============================================================*/
create table BOOKTABLE 
(
   CUSTOMERID           integer                        not null,
   DINNERTABLEID        integer                        not null,
   EMPLOYEEID           varchar(7)                     not null,
   STARTDATETIME        timestamp                      null,
   STATUS               smallint                       null,
   COUNTPEOPLE          integer                        null,
   NOTICE               varchar(255)                   null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_BOOKTABLE primary key clustered (CUSTOMERID, DINNERTABLEID, EMPLOYEEID)
);

/*==============================================================*/
/* Index: BOOKTABLE_PK                                          */
/*==============================================================*/
create unique clustered index BOOKTABLE_PK on BOOKTABLE (
CUSTOMERID ASC,
DINNERTABLEID ASC,
EMPLOYEEID ASC
);

/*==============================================================*/
/* Index: BOOKTABLE_FK                                          */
/*==============================================================*/
create index BOOKTABLE_FK on BOOKTABLE (
CUSTOMERID ASC
);

/*==============================================================*/
/* Index: BOOKTABLE2_FK                                         */
/*==============================================================*/
create index BOOKTABLE2_FK on BOOKTABLE (
DINNERTABLEID ASC
);

/*==============================================================*/
/* Index: BOOKTABLE3_FK                                         */
/*==============================================================*/
create index BOOKTABLE3_FK on BOOKTABLE (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: CATEGORYPRODUCT                                       */
/*==============================================================*/
create table CATEGORYPRODUCT 
(
   CATEGORYPRODUCTID    varchar(7)                     not null,
   NAME                 varchar(255)                   null,
   ISDELETE             smallint                       null,
   constraint PK_CATEGORYPRODUCT primary key (CATEGORYPRODUCTID)
);

/*==============================================================*/
/* Index: CATEGORYPRODUCT_PK                                    */
/*==============================================================*/
create unique index CATEGORYPRODUCT_PK on CATEGORYPRODUCT (
CATEGORYPRODUCTID ASC
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER 
(
   CUSTOMERID           integer                        not null,
   NAME                 varchar(255)                   null,
   ADDRESS              varchar(255)                   null,
   PHONE                numeric                        null,
   ISDELETE             smallint                       null,
   constraint PK_CUSTOMER primary key (CUSTOMERID)
);

/*==============================================================*/
/* Index: CUSTOMER_PK                                           */
/*==============================================================*/
create unique index CUSTOMER_PK on CUSTOMER (
CUSTOMERID ASC
);

/*==============================================================*/
/* Table: DINNERTABLE                                           */
/*==============================================================*/
create table DINNERTABLE 
(
   DINNERTABLEID        integer                        not null,
   TABLESTATUSID        integer                        null,
   NAME                 varchar(255)                   null,
   COUNTCHAIR           integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_DINNERTABLE primary key (DINNERTABLEID)
);

/*==============================================================*/
/* Index: DINNERTABLE_PK                                        */
/*==============================================================*/
create unique index DINNERTABLE_PK on DINNERTABLE (
DINNERTABLEID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_14_FK on DINNERTABLE (
TABLESTATUSID ASC
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE 
(
   EMPLOYEEID           varchar(7)                     not null,
   NAME                 varchar(255)                   null,
   SEX                  smallint                       null,
   PHONE                numeric                        null,
   ADDRESS              varchar(255)                   null,
   USENAME              varchar(255)                   null,
   PASSWORD             varchar(255)                   null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_EMPLOYEE primary key (EMPLOYEEID)
);

/*==============================================================*/
/* Index: EMPLOYEE_PK                                           */
/*==============================================================*/
create unique index EMPLOYEE_PK on EMPLOYEE (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: EXPORTBILL                                            */
/*==============================================================*/
create table EXPORTBILL 
(
   EXPORTBILLID         integer                        not null,
   PRODUCTID            varchar(7)                     null,
   EMPLOYEEID           varchar(7)                     null,
   QUANTITY             integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_EXPORTBILL primary key (EXPORTBILLID)
);

/*==============================================================*/
/* Index: EXPORTBILL_PK                                         */
/*==============================================================*/
create unique index EXPORTBILL_PK on EXPORTBILL (
EXPORTBILLID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_16_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_16_FK on EXPORTBILL (
PRODUCTID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_17_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_17_FK on EXPORTBILL (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: EXPORTBILLDETAIL                                      */
/*==============================================================*/
create table EXPORTBILLDETAIL 
(
   EXPORTBILLID         integer                        not null,
   MATERIALDETAILID     integer                        not null,
   QUANTITY             integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   ISDELTE              smallint                       null,
   constraint PK_EXPORTBILLDETAIL primary key clustered (EXPORTBILLID, MATERIALDETAILID)
);

/*==============================================================*/
/* Index: EXPORTBILLDETAIL_PK                                   */
/*==============================================================*/
create unique clustered index EXPORTBILLDETAIL_PK on EXPORTBILLDETAIL (
EXPORTBILLID ASC,
MATERIALDETAILID ASC
);

/*==============================================================*/
/* Index: EXPORTBILLDETAIL_FK                                   */
/*==============================================================*/
create index EXPORTBILLDETAIL_FK on EXPORTBILLDETAIL (
EXPORTBILLID ASC
);

/*==============================================================*/
/* Index: EXPORTBILLDETAIL2_FK                                  */
/*==============================================================*/
create index EXPORTBILLDETAIL2_FK on EXPORTBILLDETAIL (
MATERIALDETAILID ASC
);

/*==============================================================*/
/* Table: IMAGE                                                 */
/*==============================================================*/
create table IMAGE 
(
   IMAGEID              integer                        not null,
   NAME                 varchar(255)                   null,
   constraint PK_IMAGE primary key (IMAGEID)
);

/*==============================================================*/
/* Index: IMAGE_PK                                              */
/*==============================================================*/
create unique index IMAGE_PK on IMAGE (
IMAGEID ASC
);

/*==============================================================*/
/* Table: IMAGEOFEMPLOYEE                                       */
/*==============================================================*/
create table IMAGEOFEMPLOYEE 
(
   IMAGEID              integer                        not null,
   EMPLOYEEID           varchar(7)                     not null,
   constraint PK_IMAGEOFEMPLOYEE primary key clustered (IMAGEID, EMPLOYEEID)
);

/*==============================================================*/
/* Index: IMAGEOFEMPLOYEE_PK                                    */
/*==============================================================*/
create unique clustered index IMAGEOFEMPLOYEE_PK on IMAGEOFEMPLOYEE (
IMAGEID ASC,
EMPLOYEEID ASC
);

/*==============================================================*/
/* Index: IMAGEOFEMPLOYEE_FK                                    */
/*==============================================================*/
create index IMAGEOFEMPLOYEE_FK on IMAGEOFEMPLOYEE (
IMAGEID ASC
);

/*==============================================================*/
/* Index: IMAGEOFEMPLOYEE2_FK                                   */
/*==============================================================*/
create index IMAGEOFEMPLOYEE2_FK on IMAGEOFEMPLOYEE (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: IMAGEOFPRODUCT                                        */
/*==============================================================*/
create table IMAGEOFPRODUCT 
(
   PRODUCTID            varchar(7)                     not null,
   IMAGEID              integer                        not null,
   constraint PK_IMAGEOFPRODUCT primary key clustered (PRODUCTID, IMAGEID)
);

/*==============================================================*/
/* Index: IMAGEOFPRODUCT_PK                                     */
/*==============================================================*/
create unique clustered index IMAGEOFPRODUCT_PK on IMAGEOFPRODUCT (
PRODUCTID ASC,
IMAGEID ASC
);

/*==============================================================*/
/* Index: IMAGEOFPRODUCT_FK                                     */
/*==============================================================*/
create index IMAGEOFPRODUCT_FK on IMAGEOFPRODUCT (
PRODUCTID ASC
);

/*==============================================================*/
/* Index: IMAGEOFPRODUCT2_FK                                    */
/*==============================================================*/
create index IMAGEOFPRODUCT2_FK on IMAGEOFPRODUCT (
IMAGEID ASC
);

/*==============================================================*/
/* Table: IMPORTBILL                                            */
/*==============================================================*/
create table IMPORTBILL 
(
   IMPORTBILLID         integer                        not null,
   SUPPLIERID           integer                        null,
   EMPLOYEEID           varchar(7)                     null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_IMPORTBILL primary key (IMPORTBILLID)
);

/*==============================================================*/
/* Index: IMPORTBILL_PK                                         */
/*==============================================================*/
create unique index IMPORTBILL_PK on IMPORTBILL (
IMPORTBILLID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_13_FK on IMPORTBILL (
SUPPLIERID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_15_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_15_FK on IMPORTBILL (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: IMPORTBILLDETAIL                                      */
/*==============================================================*/
create table IMPORTBILLDETAIL 
(
   MATERIALDETAILID     integer                        not null,
   IMPORTBILLID         integer                        not null,
   QUANTITY             integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_IMPORTBILLDETAIL primary key clustered (MATERIALDETAILID, IMPORTBILLID)
);

/*==============================================================*/
/* Index: IMPORTBILLDETAIL_PK                                   */
/*==============================================================*/
create unique clustered index IMPORTBILLDETAIL_PK on IMPORTBILLDETAIL (
MATERIALDETAILID ASC,
IMPORTBILLID ASC
);

/*==============================================================*/
/* Index: IMPORTBILLDETAIL_FK                                   */
/*==============================================================*/
create index IMPORTBILLDETAIL_FK on IMPORTBILLDETAIL (
MATERIALDETAILID ASC
);

/*==============================================================*/
/* Index: IMPORTBILLDETAIL2_FK                                  */
/*==============================================================*/
create index IMPORTBILLDETAIL2_FK on IMPORTBILLDETAIL (
IMPORTBILLID ASC
);

/*==============================================================*/
/* Table: MATERIAL                                              */
/*==============================================================*/
create table MATERIAL 
(
   MATERIALID           integer                        not null,
   NAME                 varchar(255)                   null,
   UNIT                 varchar(50)                    null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_MATERIAL primary key (MATERIALID)
);

/*==============================================================*/
/* Index: MATERIAL_PK                                           */
/*==============================================================*/
create unique index MATERIAL_PK on MATERIAL (
MATERIALID ASC
);

/*==============================================================*/
/* Table: MATERIALDETAIL                                        */
/*==============================================================*/
create table MATERIALDETAIL 
(
   MATERIALDETAILID     integer                        not null,
   MATERIALID           integer                        null,
   DATEOFMANUFACTURE    date                           null,
   EXPIRATIONDATE       date                           null,
   QUANTITY             integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_MATERIALDETAIL primary key (MATERIALDETAILID)
);

/*==============================================================*/
/* Index: MATERIALDETAIL_PK                                     */
/*==============================================================*/
create unique index MATERIALDETAIL_PK on MATERIALDETAIL (
MATERIALDETAILID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_11_FK on MATERIALDETAIL (
MATERIALID ASC
);

/*==============================================================*/
/* Table: POSITION                                              */
/*==============================================================*/
create table POSITION 
(
   POSITIONID           varchar(255)                   not null,
   NAME                 varchar(255)                   null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_POSITION primary key (POSITIONID)
);

/*==============================================================*/
/* Index: POSITION_PK                                           */
/*==============================================================*/
create unique index POSITION_PK on POSITION (
POSITIONID ASC
);

/*==============================================================*/
/* Table: PRICE                                                 */
/*==============================================================*/
create table PRICE 
(
   PRICEID              integer                        not null,
   PRODUCTID            varchar(7)                     null,
   STARTDATETIME        timestamp                      null,
   ENDDATETIME          timestamp                      null,
   PRICE                integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_PRICE primary key (PRICEID)
);

/*==============================================================*/
/* Index: PRICE_PK                                              */
/*==============================================================*/
create unique index PRICE_PK on PRICE (
PRICEID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on PRICE (
PRODUCTID ASC
);

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT 
(
   PRODUCTID            varchar(7)                     not null,
   CATEGORYPRODUCTID    varchar(7)                     null,
   NAME                 varchar(255)                   null,
   DESCRIPTION          varchar(255)                   null,
   NUMBERINVENTORY      char(10)                       null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_PRODUCT primary key (PRODUCTID)
);

/*==============================================================*/
/* Index: PRODUCT_PK                                            */
/*==============================================================*/
create unique index PRODUCT_PK on PRODUCT (
PRODUCTID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on PRODUCT (
CATEGORYPRODUCTID ASC
);

/*==============================================================*/
/* Table: REGISTER                                              */
/*==============================================================*/
create table REGISTER 
(
   EMPLOYEEID           varchar(7)                     not null,
   SCHEDULEID           varchar(7)                     not null,
   REGISTERID           date                           null,
   RESULT               numeric(3)                     null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_REGISTER primary key clustered (EMPLOYEEID, SCHEDULEID)
);

/*==============================================================*/
/* Index: REGISTER_PK                                           */
/*==============================================================*/
create unique clustered index REGISTER_PK on REGISTER (
EMPLOYEEID ASC,
SCHEDULEID ASC
);

/*==============================================================*/
/* Index: REGISTER_FK                                           */
/*==============================================================*/
create index REGISTER_FK on REGISTER (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Index: REGISTER2_FK                                          */
/*==============================================================*/
create index REGISTER2_FK on REGISTER (
SCHEDULEID ASC
);

/*==============================================================*/
/* Table: SALARY                                                */
/*==============================================================*/
create table SALARY 
(
   SALARYID             integer                        not null,
   EMPLOYEEID           varchar(7)                     null,
   SALARYONHOUR         integer                        null,
   STARTDATE            date                           null,
   ENDDATE              date                           null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_SALARY primary key (SALARYID)
);

/*==============================================================*/
/* Index: SALARY_PK                                             */
/*==============================================================*/
create unique index SALARY_PK on SALARY (
SALARYID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_18_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_18_FK on SALARY (
EMPLOYEEID ASC
);

/*==============================================================*/
/* Table: SCHEDULE                                              */
/*==============================================================*/
create table SCHEDULE 
(
   SCHEDULEID           varchar(7)                     not null,
   STARTTIME            time                           null,
   ENDTIME              time                           null,
   PAYRATE              float                          null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_SCHEDULE primary key (SCHEDULEID)
);

/*==============================================================*/
/* Index: SCHEDULE_PK                                           */
/*==============================================================*/
create unique index SCHEDULE_PK on SCHEDULE (
SCHEDULEID ASC
);

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER 
(
   SUPPLIERID           integer                        not null,
   NAME                 varchar(255)                   null,
   ADDRESS              varchar(255)                   null,
   PHONE                numeric                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_SUPPLIER primary key (SUPPLIERID)
);

/*==============================================================*/
/* Index: SUPPLIER_PK                                           */
/*==============================================================*/
create unique index SUPPLIER_PK on SUPPLIER (
SUPPLIERID ASC
);

/*==============================================================*/
/* Table: TABLESTATUS                                           */
/*==============================================================*/
create table TABLESTATUS 
(
   TABLESTATUSID        integer                        not null,
   NAME                 varchar(255)                   null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_TABLESTATUS primary key (TABLESTATUSID)
);

/*==============================================================*/
/* Index: TABLESTATUS_PK                                        */
/*==============================================================*/
create unique index TABLESTATUS_PK on TABLESTATUS (
TABLESTATUSID ASC
);

/*==============================================================*/
/* Table: VOUCHER                                               */
/*==============================================================*/
create table VOUCHER 
(
   VOUCHERID            integer                        not null,
   NAME                 varchar(255)                   null,
   STARTDATETIME        timestamp                      null,
   ENDDATE              date                           null,
   NUMBER               integer                        null,
   COUNT                integer                        null,
   SALEOFF              integer                        null,
   UPDATEAT             timestamp                      null,
   ISDELETE             smallint                       null,
   constraint PK_VOUCHER primary key (VOUCHERID)
);

/*==============================================================*/
/* Index: VOUCHER_PK                                            */
/*==============================================================*/
create unique index VOUCHER_PK on VOUCHER (
VOUCHERID ASC
);

alter table ATPOSITION
   add constraint FK_ATPOSITI_ATPOSITIO_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table ATPOSITION
   add constraint FK_ATPOSITI_ATPOSITIO_POSITION foreign key (POSITIONID)
      references POSITION (POSITIONID)
      on update restrict
      on delete restrict;

alter table BILL
   add constraint FK_BILL_RELATIONS_VOUCHER foreign key (VOUCHERID)
      references VOUCHER (VOUCHERID)
      on update restrict
      on delete restrict;

alter table BILL
   add constraint FK_BILL_RELATIONS_BILLSTAT foreign key (BILLSTATUSID)
      references BILLSTATUS (BILLSTATUSID)
      on update restrict
      on delete restrict;

alter table BILL
   add constraint FK_BILL_RELATIONS_CUSTOMER foreign key (CUSTOMERID)
      references CUSTOMER (CUSTOMERID)
      on update restrict
      on delete restrict;

alter table BILL
   add constraint FK_BILL_RELATIONS_DINNERTA foreign key (DINNERTABLEID)
      references DINNERTABLE (DINNERTABLEID)
      on update restrict
      on delete restrict;

alter table BILL
   add constraint FK_BILL_RELATIONS_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table BILLDETAIL
   add constraint FK_BILLDETA_BILLDETAI_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
      on update restrict
      on delete restrict;

alter table BILLDETAIL
   add constraint FK_BILLDETA_BILLDETAI_BILL foreign key (BILLID)
      references BILL (BILLID)
      on update restrict
      on delete restrict;

alter table BOOKTABLE
   add constraint FK_BOOKTABL_BOOKTABLE_CUSTOMER foreign key (CUSTOMERID)
      references CUSTOMER (CUSTOMERID)
      on update restrict
      on delete restrict;

alter table BOOKTABLE
   add constraint FK_BOOKTABL_BOOKTABLE_DINNERTA foreign key (DINNERTABLEID)
      references DINNERTABLE (DINNERTABLEID)
      on update restrict
      on delete restrict;

alter table BOOKTABLE
   add constraint FK_BOOKTABL_BOOKTABLE_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table DINNERTABLE
   add constraint FK_DINNERTA_RELATIONS_TABLESTA foreign key (TABLESTATUSID)
      references TABLESTATUS (TABLESTATUSID)
      on update restrict
      on delete restrict;

alter table EXPORTBILL
   add constraint FK_EXPORTBI_RELATIONS_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
      on update restrict
      on delete restrict;

alter table EXPORTBILL
   add constraint FK_EXPORTBI_RELATIONS_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table EXPORTBILLDETAIL
   add constraint FK_EXPORTBI_EXPORTBIL_EXPORTBI foreign key (EXPORTBILLID)
      references EXPORTBILL (EXPORTBILLID)
      on update restrict
      on delete restrict;

alter table EXPORTBILLDETAIL
   add constraint FK_EXPORTBI_EXPORTBIL_MATERIAL foreign key (MATERIALDETAILID)
      references MATERIALDETAIL (MATERIALDETAILID)
      on update restrict
      on delete restrict;

alter table IMAGEOFEMPLOYEE
   add constraint FK_IMAGEOFE_IMAGEOFEM_IMAGE foreign key (IMAGEID)
      references IMAGE (IMAGEID)
      on update restrict
      on delete restrict;

alter table IMAGEOFEMPLOYEE
   add constraint FK_IMAGEOFE_IMAGEOFEM_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table IMAGEOFPRODUCT
   add constraint FK_IMAGEOFP_IMAGEOFPR_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
      on update restrict
      on delete restrict;

alter table IMAGEOFPRODUCT
   add constraint FK_IMAGEOFP_IMAGEOFPR_IMAGE foreign key (IMAGEID)
      references IMAGE (IMAGEID)
      on update restrict
      on delete restrict;

alter table IMPORTBILL
   add constraint FK_IMPORTBI_RELATIONS_SUPPLIER foreign key (SUPPLIERID)
      references SUPPLIER (SUPPLIERID)
      on update restrict
      on delete restrict;

alter table IMPORTBILL
   add constraint FK_IMPORTBI_RELATIONS_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table IMPORTBILLDETAIL
   add constraint FK_IMPORTBI_IMPORTBIL_MATERIAL foreign key (MATERIALDETAILID)
      references MATERIALDETAIL (MATERIALDETAILID)
      on update restrict
      on delete restrict;

alter table IMPORTBILLDETAIL
   add constraint FK_IMPORTBI_IMPORTBIL_IMPORTBI foreign key (IMPORTBILLID)
      references IMPORTBILL (IMPORTBILLID)
      on update restrict
      on delete restrict;

alter table MATERIALDETAIL
   add constraint FK_MATERIAL_RELATIONS_MATERIAL foreign key (MATERIALID)
      references MATERIAL (MATERIALID)
      on update restrict
      on delete restrict;

alter table PRICE
   add constraint FK_PRICE_RELATIONS_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
      on update restrict
      on delete restrict;

alter table PRODUCT
   add constraint FK_PRODUCT_RELATIONS_CATEGORY foreign key (CATEGORYPRODUCTID)
      references CATEGORYPRODUCT (CATEGORYPRODUCTID)
      on update restrict
      on delete restrict;

alter table REGISTER
   add constraint FK_REGISTER_REGISTER_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

alter table REGISTER
   add constraint FK_REGISTER_REGISTER2_SCHEDULE foreign key (SCHEDULEID)
      references SCHEDULE (SCHEDULEID)
      on update restrict
      on delete restrict;

alter table SALARY
   add constraint FK_SALARY_RELATIONS_EMPLOYEE foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID)
      on update restrict
      on delete restrict;

