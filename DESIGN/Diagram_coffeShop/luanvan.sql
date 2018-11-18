drop table if exists ATPOSITION;

drop table if exists BILL;

drop table if exists BILLDETAIL;

drop table if exists BILLSTATUS;

drop table if exists BOOKTABLE;

drop table if exists CATEGORYPRODUCT;

drop table if exists CUSTOMER;

drop table if exists DINNERTABLE;

drop table if exists EMPLOYEE;

drop table if exists EXPORTBILL;

drop table if exists IMAGE;

drop table if exists IMAGEOFDINNERTABLE;

drop table if exists IMAGEOFEMPLOYEE;

drop table if exists IMAGEOFMATERIAL;

drop table if exists IMAGEOFPRODUCT;

drop table if exists IMPORTBILL;

drop table if exists MATERIAL;

drop table if exists MATERIALDETAIL;

drop table if exists POSITION;

drop table if exists PRICE;

drop table if exists PRODUCT;

drop table if exists PRODUCTSTATUS;

drop table if exists REGISTER;

drop table if exists SALARY;

drop table if exists SCHEDULE;

drop table if exists SUPPLIER;

drop table if exists TABLESTATUS;

drop table if exists TABLESTATUSDETAIL;

drop table if exists UNIT;

drop table if exists VOUCHER;

/*==============================================================*/
/* Table: ATPOSITION                                            */
/*==============================================================*/
create table ATPOSITION
(
   EMPLOYEEID           national varchar(7) not null,
   POSITIONID           national varchar(255) not null,
   STARTDATE            date,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (EMPLOYEEID, POSITIONID)
);

/*==============================================================*/
/* Table: BILL                                                  */
/*==============================================================*/
create table BILL
(
   BILLID               int not null,
   BILLSTATUSID         national varchar(7),
   DINNERTABLEID        int,
   CUSTOMERID           int,
   EMPLOYEEID           national varchar(7),
   PRODUCTSTATUSID      int,
   VOUCHERID            int,
   STARTDATETIME        datetime,
   ENDDATE              date,
   NOTICE               national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (BILLID)
);

/*==============================================================*/
/* Table: BILLDETAIL                                            */
/*==============================================================*/
create table BILLDETAIL
(
   PRODUCTID            national varchar(7) not null,
   BILLID               int not null,
   QUANTITY             int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (PRODUCTID, BILLID)
);

/*==============================================================*/
/* Table: BILLSTATUS                                            */
/*==============================================================*/
create table BILLSTATUS
(
   BILLSTATUSID         national varchar(7) not null,
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (BILLSTATUSID)
);

/*==============================================================*/
/* Table: BOOKTABLE                                             */
/*==============================================================*/
create table BOOKTABLE
(
   CUSTOMERID           int not null,
   DINNERTABLEID        int not null,
   EMPLOYEEID           national varchar(7) not null,
   STARTDATETIME        datetime,
   STATUS               bool,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (CUSTOMERID, DINNERTABLEID, EMPLOYEEID)
);

/*==============================================================*/
/* Table: CATEGORYPRODUCT                                       */
/*==============================================================*/
create table CATEGORYPRODUCT
(
   CATEGORYPRODUCTID    national varchar(7) not null,
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (CATEGORYPRODUCTID)
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER
(
   CUSTOMERID           int not null,
   NAME                 national varchar(255),
   ADDRESS              national varchar(255),
   PHONE                numeric(8,0),
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (CUSTOMERID)
);

/*==============================================================*/
/* Table: DINNERTABLE                                           */
/*==============================================================*/
create table DINNERTABLE
(
   DINNERTABLEID        int not null,
   NAME                 national varchar(255),
   COUNTCHAIR           int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (DINNERTABLEID)
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE
(
   EMPLOYEEID           national varchar(7) not null,
   SALARYID             int,
   NAME                 national varchar(255),
   SEX                  bool,
   PHONE                numeric(8,0),
   ADDRESS              national varchar(255),
   USENAME              national varchar(255),
   PASSWORD             national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (EMPLOYEEID)
);

/*==============================================================*/
/* Table: EXPORTBILL                                            */
/*==============================================================*/
create table EXPORTBILL
(
   EXPORTBILLID         int not null,
   PRODUCTID            national varchar(7),
   MATERIALDETAILID     int,
   EMPLOYEEID           national varchar(7),
   QUANTITY             int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (EXPORTBILLID)
);

/*==============================================================*/
/* Table: IMAGE                                                 */
/*==============================================================*/
create table IMAGE
(
   IMAGEID              int not null,
   NAME                 national varchar(255),
   primary key (IMAGEID)
);

/*==============================================================*/
/* Table: IMAGEOFDINNERTABLE                                    */
/*==============================================================*/
create table IMAGEOFDINNERTABLE
(
   IMAGEID              int not null,
   DINNERTABLEID        int not null,
   primary key (IMAGEID, DINNERTABLEID)
);

/*==============================================================*/
/* Table: IMAGEOFEMPLOYEE                                       */
/*==============================================================*/
create table IMAGEOFEMPLOYEE
(
   IMAGEID              int not null,
   EMPLOYEEID           national varchar(7) not null,
   primary key (IMAGEID, EMPLOYEEID)
);

/*==============================================================*/
/* Table: IMAGEOFMATERIAL                                       */
/*==============================================================*/
create table IMAGEOFMATERIAL
(
   MATERIALID           int not null,
   IMAGEID              int not null,
   primary key (MATERIALID, IMAGEID)
);

/*==============================================================*/
/* Table: IMAGEOFPRODUCT                                        */
/*==============================================================*/
create table IMAGEOFPRODUCT
(
   PRODUCTID            national varchar(7) not null,
   IMAGEID              int not null,
   primary key (PRODUCTID, IMAGEID)
);

/*==============================================================*/
/* Table: IMPORTBILL                                            */
/*==============================================================*/
create table IMPORTBILL
(
   IMPORTBILLID         int not null,
   SUPPLIERID           int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (IMPORTBILLID)
);

/*==============================================================*/
/* Table: MATERIAL                                              */
/*==============================================================*/
create table MATERIAL
(
   MATERIALID           int not null,
   UNITID               national varchar(3),
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (MATERIALID)
);

/*==============================================================*/
/* Table: MATERIALDETAIL                                        */
/*==============================================================*/
create table MATERIALDETAIL
(
   MATERIALDETAILID     int not null,
   IMPORTBILLID         int,
   MATERIALID           int,
   DATEOFMANUFACTURE    date,
   EXPIRATIONDATE       date,
   QUANTITY             int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (MATERIALDETAILID)
);

/*==============================================================*/
/* Table: POSITION                                              */
/*==============================================================*/
create table POSITION
(
   POSITIONID           national varchar(255) not null,
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (POSITIONID)
);

/*==============================================================*/
/* Table: PRICE                                                 */
/*==============================================================*/
create table PRICE
(
   PRICEID              int not null,
   PRODUCTID            national varchar(7),
   STARTDATETIME        datetime,
   PRICE                int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (PRICEID)
);

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT
(
   PRODUCTID            national varchar(7) not null,
   CATEGORYPRODUCTID    national varchar(7),
   NAME                 national varchar(255),
   DESCRIPTION          national varchar(255),
   NUMBERINVENTORY      char(10),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (PRODUCTID)
);

/*==============================================================*/
/* Table: PRODUCTSTATUS                                         */
/*==============================================================*/
create table PRODUCTSTATUS
(
   PRODUCTSTATUSID      int not null,
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (PRODUCTSTATUSID)
);

/*==============================================================*/
/* Table: REGISTER                                              */
/*==============================================================*/
create table REGISTER
(
   EMPLOYEEID           national varchar(7) not null,
   SCHEDULEID           national varchar(7) not null,
   REGISTERID           date,
   RESULT               numeric(3,0),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (EMPLOYEEID, SCHEDULEID)
);

/*==============================================================*/
/* Table: SALARY                                                */
/*==============================================================*/
create table SALARY
(
   SALARYID             int not null,
   SALARYONHOUR         int,
   STARTDATE            date,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (SALARYID)
);

/*==============================================================*/
/* Table: SCHEDULE                                              */
/*==============================================================*/
create table SCHEDULE
(
   SCHEDULEID           national varchar(7) not null,
   STARTTIME            time,
   ENDTIME              time,
   PAYRATE              float,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (SCHEDULEID)
);

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER
(
   SUPPLIERID           int not null,
   NAME                 national varchar(255),
   ADDRESS              national varchar(255),
   PHONE                numeric(8,0),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (SUPPLIERID)
);

/*==============================================================*/
/* Table: TABLESTATUS                                           */
/*==============================================================*/
create table TABLESTATUS
(
   TABLESTATUSID        int not null,
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (TABLESTATUSID)
);

/*==============================================================*/
/* Table: TABLESTATUSDETAIL                                     */
/*==============================================================*/
create table TABLESTATUSDETAIL
(
   DINNERTABLEID        int not null,
   TABLESTATUSID        int not null,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (DINNERTABLEID, TABLESTATUSID)
);

/*==============================================================*/
/* Table: UNIT                                                  */
/*==============================================================*/
create table UNIT
(
   UNITID               national varchar(3) not null,
   NAME                 national varchar(255),
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (UNITID)
);

/*==============================================================*/
/* Table: VOUCHER                                               */
/*==============================================================*/
create table VOUCHER
(
   VOUCHERID            int not null,
   NAME                 national varchar(255),
   STARTDATETIME        datetime,
   ENDDATE              date,
   NUMBER               int,
   COUNT                int,
   SALEOF               int,
   CREATEBY             national varchar(7),
   CREATEAT             datetime,
   UPDATEBY             national varchar(7),
   UPDATEAT             datetime,
   ISDELETE             bool,
   DELETEBY             national varchar(7),
   DELETEAT             datetime,
   primary key (VOUCHERID)
);

alter table ATPOSITION add constraint FK_ATPOSITION foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID) on delete restrict on update restrict;

alter table ATPOSITION add constraint FK_ATPOSITION2 foreign key (POSITIONID)
      references POSITION (POSITIONID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_3 foreign key (VOUCHERID)
      references VOUCHER (VOUCHERID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_4 foreign key (PRODUCTSTATUSID)
      references PRODUCTSTATUS (PRODUCTSTATUSID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_5 foreign key (BILLSTATUSID)
      references BILLSTATUS (BILLSTATUSID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_6 foreign key (CUSTOMERID)
      references CUSTOMER (CUSTOMERID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_7 foreign key (DINNERTABLEID)
      references DINNERTABLE (DINNERTABLEID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_8 foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID) on delete restrict on update restrict;

alter table BILLDETAIL add constraint FK_BILLDETAIL foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID) on delete restrict on update restrict;

alter table BILLDETAIL add constraint FK_BILLDETAIL2 foreign key (BILLID)
      references BILL (BILLID) on delete restrict on update restrict;

alter table BOOKTABLE add constraint FK_BOOKTABLE foreign key (CUSTOMERID)
      references CUSTOMER (CUSTOMERID) on delete restrict on update restrict;

alter table BOOKTABLE add constraint FK_BOOKTABLE2 foreign key (DINNERTABLEID)
      references DINNERTABLE (DINNERTABLEID) on delete restrict on update restrict;

alter table BOOKTABLE add constraint FK_BOOKTABLE3 foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID) on delete restrict on update restrict;

alter table EMPLOYEE add constraint FK_RELATIONSHIP_9 foreign key (SALARYID)
      references SALARY (SALARYID) on delete restrict on update restrict;

alter table EXPORTBILL add constraint FK_RELATIONSHIP_15 foreign key (MATERIALDETAILID)
      references MATERIALDETAIL (MATERIALDETAILID) on delete restrict on update restrict;

alter table EXPORTBILL add constraint FK_RELATIONSHIP_16 foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID) on delete restrict on update restrict;

alter table EXPORTBILL add constraint FK_RELATIONSHIP_17 foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID) on delete restrict on update restrict;

alter table IMAGEOFDINNERTABLE add constraint FK_IMAGEOFDINNERTABLE foreign key (IMAGEID)
      references IMAGE (IMAGEID) on delete restrict on update restrict;

alter table IMAGEOFDINNERTABLE add constraint FK_IMAGEOFDINNERTABLE2 foreign key (DINNERTABLEID)
      references DINNERTABLE (DINNERTABLEID) on delete restrict on update restrict;

alter table IMAGEOFEMPLOYEE add constraint FK_IMAGEOFEMPLOYEE foreign key (IMAGEID)
      references IMAGE (IMAGEID) on delete restrict on update restrict;

alter table IMAGEOFEMPLOYEE add constraint FK_IMAGEOFEMPLOYEE2 foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID) on delete restrict on update restrict;

alter table IMAGEOFMATERIAL add constraint FK_IMAGEOFMATERIAL foreign key (MATERIALID)
      references MATERIAL (MATERIALID) on delete restrict on update restrict;

alter table IMAGEOFMATERIAL add constraint FK_IMAGEOFMATERIAL2 foreign key (IMAGEID)
      references IMAGE (IMAGEID) on delete restrict on update restrict;

alter table IMAGEOFPRODUCT add constraint FK_IMAGEOFPRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID) on delete restrict on update restrict;

alter table IMAGEOFPRODUCT add constraint FK_IMAGEOFPRODUCT2 foreign key (IMAGEID)
      references IMAGE (IMAGEID) on delete restrict on update restrict;

alter table IMPORTBILL add constraint FK_RELATIONSHIP_13 foreign key (SUPPLIERID)
      references SUPPLIER (SUPPLIERID) on delete restrict on update restrict;

alter table MATERIAL add constraint FK_RELATIONSHIP_12 foreign key (UNITID)
      references UNIT (UNITID) on delete restrict on update restrict;

alter table MATERIALDETAIL add constraint FK_RELATIONSHIP_11 foreign key (MATERIALID)
      references MATERIAL (MATERIALID) on delete restrict on update restrict;

alter table MATERIALDETAIL add constraint FK_RELATIONSHIP_14 foreign key (IMPORTBILLID)
      references IMPORTBILL (IMPORTBILLID) on delete restrict on update restrict;

alter table PRICE add constraint FK_RELATIONSHIP_1 foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_RELATIONSHIP_2 foreign key (CATEGORYPRODUCTID)
      references CATEGORYPRODUCT (CATEGORYPRODUCTID) on delete restrict on update restrict;

alter table REGISTER add constraint FK_REGISTER foreign key (EMPLOYEEID)
      references EMPLOYEE (EMPLOYEEID) on delete restrict on update restrict;

alter table REGISTER add constraint FK_REGISTER2 foreign key (SCHEDULEID)
      references SCHEDULE (SCHEDULEID) on delete restrict on update restrict;

alter table TABLESTATUSDETAIL add constraint FK_TABLESTATUSDETAIL foreign key (DINNERTABLEID)
      references DINNERTABLE (DINNERTABLEID) on delete restrict on update restrict;

alter table TABLESTATUSDETAIL add constraint FK_TABLESTATUSDETAIL2 foreign key (TABLESTATUSID)
      references TABLESTATUS (TABLESTATUSID) on delete restrict on update restrict;
