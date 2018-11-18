/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/24/2018 9:50:41 PM                        */
/*==============================================================*/


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
   EM_ID                national varchar(7) not null,
   PO_ID                national varchar(255) not null,
   AP_DATESTART         date,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (EM_ID, PO_ID)
);

/*==============================================================*/
/* Table: BILL                                                  */
/*==============================================================*/
create table BILL
(
   BI_ID                int not null,
   BT_ID                national varchar(7),
   DN_ID                int,
   CU_ID                national varchar(7),
   EM_ID                national varchar(7),
   PS_ID                national varchar(7),
   VO_ID                national varchar(7),
   BI_DATETIME_START    datetime,
   BI_DATEIME_FINISH    datetime,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (BI_ID)
);

/*==============================================================*/
/* Table: BILLDETAIL                                            */
/*==============================================================*/
create table BILLDETAIL
(
   P_ID                 national varchar(7) not null,
   BI_ID                int not null,
   BD_QUANTITY          int,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (P_ID, BI_ID)
);

/*==============================================================*/
/* Table: BILLSTATUS                                            */
/*==============================================================*/
create table BILLSTATUS
(
   BT_ID                national varchar(7) not null,
   BT_NAME              national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (BT_ID)
);

/*==============================================================*/
/* Table: BOOKTABLE                                             */
/*==============================================================*/
create table BOOKTABLE
(
   CU_ID                national varchar(7) not null,
   DN_ID                int not null,
   EM_ID                national varchar(7) not null,
   BT_TIMESTART         time,
   BT_STATUS            bool,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (CU_ID, DN_ID, EM_ID)
);

/*==============================================================*/
/* Table: CATEGORYPRODUCT                                       */
/*==============================================================*/
create table CATEGORYPRODUCT
(
   CG_PRD_ID            national varchar(7) not null,
   CG_PRD_NAME          national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (CG_PRD_ID)
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER
(
   CU_ID                national varchar(7) not null,
   CU_NAME              national varchar(255),
   CU_ADDRESS           national varchar(255),
   CU_PHONE_NUMBER      numeric(8,0),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (CU_ID)
);

/*==============================================================*/
/* Table: DINNERTABLE                                           */
/*==============================================================*/
create table DINNERTABLE
(
   DN_ID                int not null,
   DN_NAME              national varchar(255),
   DN_COUNTCHAIR        int,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (DN_ID)
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE
(
   EM_ID                national varchar(7) not null,
   SA_ID                national varchar(7),
   EM_NAME              national varchar(255),
   EM_SEX               bool,
   EM_PHONENUMBER       numeric(8,0),
   EM_ADDRESS           national varchar(255),
   EM_USERNAME          national varchar(255),
   EM_PASSWORD          national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (EM_ID)
);

/*==============================================================*/
/* Table: EXPORTBILL                                            */
/*==============================================================*/
create table EXPORTBILL
(
   EB_ID                national varchar(7) not null,
   P_ID                 national varchar(7),
   MD_ID                int,
   EM_ID                national varchar(7),
   EB_DATE_TIME         datetime,
   EB_QUANTITY          int,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (EB_ID)
);

/*==============================================================*/
/* Table: IMAGE                                                 */
/*==============================================================*/
create table IMAGE
(
   IMG_ID               int not null,
   IMG_NAME             national varchar(255),
   primary key (IMG_ID)
);

/*==============================================================*/
/* Table: IMAGEOFDINNERTABLE                                    */
/*==============================================================*/
create table IMAGEOFDINNERTABLE
(
   IMG_ID               int not null,
   DN_ID                int not null,
   primary key (IMG_ID, DN_ID)
);

/*==============================================================*/
/* Table: IMAGEOFEMPLOYEE                                       */
/*==============================================================*/
create table IMAGEOFEMPLOYEE
(
   IMG_ID               int not null,
   EM_ID                national varchar(7) not null,
   primary key (IMG_ID, EM_ID)
);

/*==============================================================*/
/* Table: IMAGEOFMATERIAL                                       */
/*==============================================================*/
create table IMAGEOFMATERIAL
(
   MA_ID                national varchar(7) not null,
   IMG_ID               int not null,
   primary key (MA_ID, IMG_ID)
);

/*==============================================================*/
/* Table: IMAGEOFPRODUCT                                        */
/*==============================================================*/
create table IMAGEOFPRODUCT
(
   P_ID                 national varchar(7) not null,
   IMG_ID               int not null,
   primary key (P_ID, IMG_ID)
);

/*==============================================================*/
/* Table: IMPORTBILL                                            */
/*==============================================================*/
create table IMPORTBILL
(
   IB_ID                int not null,
   SU_ID                national varchar(7),
   IB_DATE_TIME         datetime,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (IB_ID)
);

/*==============================================================*/
/* Table: MATERIAL                                              */
/*==============================================================*/
create table MATERIAL
(
   MA_ID                national varchar(7) not null,
   UN_ID                national varchar(3),
   MA_NAME              national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (MA_ID)
);

/*==============================================================*/
/* Table: MATERIALDETAIL                                        */
/*==============================================================*/
create table MATERIALDETAIL
(
   MD_ID                int not null,
   IB_ID                int,
   MA_ID                national varchar(7),
   MD_DATE_OF_MANUFACTURE date,
   MD_EXPIRATION_DATE   date,
   MD_QUANTITY          int,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (MD_ID)
);

/*==============================================================*/
/* Table: POSITION                                              */
/*==============================================================*/
create table POSITION
(
   PO_ID                national varchar(255) not null,
   PO_NAME              national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (PO_ID)
);

/*==============================================================*/
/* Table: PRICE                                                 */
/*==============================================================*/
create table PRICE
(
   PR_ID                int not null,
   P_ID                 national varchar(7),
   PR_DATESTART         date,
   PR_PRICE             int,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (PR_ID)
);

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT
(
   P_ID                 national varchar(7) not null,
   CG_PRD_ID            national varchar(7),
   P_NAME               national varchar(255),
   P_DESCRIPTION        national varchar(255),
   P_NUMBER_INVENTORY   char(10),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (P_ID)
);

/*==============================================================*/
/* Table: PRODUCTSTATUS                                         */
/*==============================================================*/
create table PRODUCTSTATUS
(
   PS_ID                national varchar(7) not null,
   PS_NAME              national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (PS_ID)
);

/*==============================================================*/
/* Table: REGISTER                                              */
/*==============================================================*/
create table REGISTER
(
   EM_ID                national varchar(7) not null,
   SC_ID                national varchar(7) not null,
   RE_DATE              date,
   RE_RESULT            bool,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (EM_ID, SC_ID)
);

/*==============================================================*/
/* Table: SALARY                                                */
/*==============================================================*/
create table SALARY
(
   SA_ID                national varchar(7) not null,
   SA_SALARYS_ON_HOUR   int,
   SA_DATESTART         date,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (SA_ID)
);

/*==============================================================*/
/* Table: SCHEDULE                                              */
/*==============================================================*/
create table SCHEDULE
(
   SC_ID                national varchar(7) not null,
   SC_TIMESTART         time,
   SC_TIMEFINISH        time,
   SC_PAYRATE           float,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (SC_ID)
);

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER
(
   SU_ID                national varchar(7) not null,
   SU_NAME              national varchar(255),
   SU_ADDRESS           national varchar(255),
   SU_PHONE_NUMBER      numeric(8,0),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (SU_ID)
);

/*==============================================================*/
/* Table: TABLESTATUS                                           */
/*==============================================================*/
create table TABLESTATUS
(
   TS_ID                national varchar(255) not null,
   TS_NAME              national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (TS_ID)
);

/*==============================================================*/
/* Table: TABLESTATUSDETAIL                                     */
/*==============================================================*/
create table TABLESTATUSDETAIL
(
   DN_ID                int not null,
   TS_ID                national varchar(255) not null,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (DN_ID, TS_ID)
);

/*==============================================================*/
/* Table: UNIT                                                  */
/*==============================================================*/
create table UNIT
(
   UN_ID                national varchar(3) not null,
   UN_NAME              national varchar(255),
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (UN_ID)
);

/*==============================================================*/
/* Table: VOUCHER                                               */
/*==============================================================*/
create table VOUCHER
(
   VO_ID                national varchar(7) not null,
   VO_NAME              national varchar(255),
   VO_DATESTART         date,
   VO_DATEFINISH        date,
   VO_SALEOFF           int,
   CREATE_BY            national varchar(7),
   CREATE_AT            datetime,
   UPDATE_BY            national varchar(7),
   UPDATE_AT            datetime,
   IS_DELETE            bool,
   DELETE_BY            national varchar(7),
   DELETE_AT            datetime,
   primary key (VO_ID)
);

alter table ATPOSITION add constraint FK_ATPOSITION foreign key (EM_ID)
      references EMPLOYEE (EM_ID) on delete restrict on update restrict;

alter table ATPOSITION add constraint FK_ATPOSITION2 foreign key (PO_ID)
      references POSITION (PO_ID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_3 foreign key (VO_ID)
      references VOUCHER (VO_ID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_4 foreign key (PS_ID)
      references PRODUCTSTATUS (PS_ID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_5 foreign key (BT_ID)
      references BILLSTATUS (BT_ID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_6 foreign key (CU_ID)
      references CUSTOMER (CU_ID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_7 foreign key (DN_ID)
      references DINNERTABLE (DN_ID) on delete restrict on update restrict;

alter table BILL add constraint FK_RELATIONSHIP_8 foreign key (EM_ID)
      references EMPLOYEE (EM_ID) on delete restrict on update restrict;

alter table BILLDETAIL add constraint FK_BILLDETAIL foreign key (P_ID)
      references PRODUCT (P_ID) on delete restrict on update restrict;

alter table BILLDETAIL add constraint FK_BILLDETAIL2 foreign key (BI_ID)
      references BILL (BI_ID) on delete restrict on update restrict;

alter table BOOKTABLE add constraint FK_BOOKTABLE foreign key (CU_ID)
      references CUSTOMER (CU_ID) on delete restrict on update restrict;

alter table BOOKTABLE add constraint FK_BOOKTABLE2 foreign key (DN_ID)
      references DINNERTABLE (DN_ID) on delete restrict on update restrict;

alter table BOOKTABLE add constraint FK_BOOKTABLE3 foreign key (EM_ID)
      references EMPLOYEE (EM_ID) on delete restrict on update restrict;

alter table EMPLOYEE add constraint FK_RELATIONSHIP_9 foreign key (SA_ID)
      references SALARY (SA_ID) on delete restrict on update restrict;

alter table EXPORTBILL add constraint FK_RELATIONSHIP_15 foreign key (MD_ID)
      references MATERIALDETAIL (MD_ID) on delete restrict on update restrict;

alter table EXPORTBILL add constraint FK_RELATIONSHIP_16 foreign key (P_ID)
      references PRODUCT (P_ID) on delete restrict on update restrict;

alter table EXPORTBILL add constraint FK_RELATIONSHIP_17 foreign key (EM_ID)
      references EMPLOYEE (EM_ID) on delete restrict on update restrict;

alter table IMAGEOFDINNERTABLE add constraint FK_IMAGEOFDINNERTABLE foreign key (IMG_ID)
      references IMAGE (IMG_ID) on delete restrict on update restrict;

alter table IMAGEOFDINNERTABLE add constraint FK_IMAGEOFDINNERTABLE2 foreign key (DN_ID)
      references DINNERTABLE (DN_ID) on delete restrict on update restrict;

alter table IMAGEOFEMPLOYEE add constraint FK_IMAGEOFEMPLOYEE foreign key (IMG_ID)
      references IMAGE (IMG_ID) on delete restrict on update restrict;

alter table IMAGEOFEMPLOYEE add constraint FK_IMAGEOFEMPLOYEE2 foreign key (EM_ID)
      references EMPLOYEE (EM_ID) on delete restrict on update restrict;

alter table IMAGEOFMATERIAL add constraint FK_IMAGEOFMATERIAL foreign key (MA_ID)
      references MATERIAL (MA_ID) on delete restrict on update restrict;

alter table IMAGEOFMATERIAL add constraint FK_IMAGEOFMATERIAL2 foreign key (IMG_ID)
      references IMAGE (IMG_ID) on delete restrict on update restrict;

alter table IMAGEOFPRODUCT add constraint FK_IMAGEOFPRODUCT foreign key (P_ID)
      references PRODUCT (P_ID) on delete restrict on update restrict;

alter table IMAGEOFPRODUCT add constraint FK_IMAGEOFPRODUCT2 foreign key (IMG_ID)
      references IMAGE (IMG_ID) on delete restrict on update restrict;

alter table IMPORTBILL add constraint FK_RELATIONSHIP_13 foreign key (SU_ID)
      references SUPPLIER (SU_ID) on delete restrict on update restrict;

alter table MATERIAL add constraint FK_RELATIONSHIP_12 foreign key (UN_ID)
      references UNIT (UN_ID) on delete restrict on update restrict;

alter table MATERIALDETAIL add constraint FK_RELATIONSHIP_11 foreign key (MA_ID)
      references MATERIAL (MA_ID) on delete restrict on update restrict;

alter table MATERIALDETAIL add constraint FK_RELATIONSHIP_14 foreign key (IB_ID)
      references IMPORTBILL (IB_ID) on delete restrict on update restrict;

alter table PRICE add constraint FK_RELATIONSHIP_1 foreign key (P_ID)
      references PRODUCT (P_ID) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_RELATIONSHIP_2 foreign key (CG_PRD_ID)
      references CATEGORYPRODUCT (CG_PRD_ID) on delete restrict on update restrict;

alter table REGISTER add constraint FK_REGISTER foreign key (EM_ID)
      references EMPLOYEE (EM_ID) on delete restrict on update restrict;

alter table REGISTER add constraint FK_REGISTER2 foreign key (SC_ID)
      references SCHEDULE (SC_ID) on delete restrict on update restrict;

alter table TABLESTATUSDETAIL add constraint FK_TABLESTATUSDETAIL foreign key (DN_ID)
      references DINNERTABLE (DN_ID) on delete restrict on update restrict;

alter table TABLESTATUSDETAIL add constraint FK_TABLESTATUSDETAIL2 foreign key (TS_ID)
      references TABLESTATUS (TS_ID) on delete restrict on update restrict;

