--------------------------------------------------------
--  File created - Tuesday-August-11-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ACADAMIC_DETAILS
--------------------------------------------------------

CREATE USER tpo IDENTIFIED BY tpo;
GRANT CONNECT, RESOURCE, DBA TO TPO;
GRANT CREATE SESSION TO TPO;


  CREATE TABLE "ACADAMIC_DETAILS" 
   (	"LOGINNAME" VARCHAR2(20 BYTE), 
	"SSCYOP" NUMBER, 
	"SSCPERCENTAGE" NUMBER, 
	"UGYOP" NUMBER, 
	"UGPERCENTAGE" NUMBER, 
	"GYOP" NUMBER, 
	"GPERCENTAGE" NUMBER, 
	"ROLLNO" VARCHAR2(20 BYTE), 
	"YEAROFJOINING" NUMBER, 
	"COURSE" VARCHAR2(20 BYTE), 
	"DISCIPLINE" VARCHAR2(20 BYTE), 
	"SEMISTER" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table COMPANY_DETAILS
--------------------------------------------------------

  CREATE TABLE "COMPANY_DETAILS" 
   (	"COMPANYID" NUMBER, 
	"COMPANYNAME" VARCHAR2(20 BYTE), 
	"PROFILE" VARCHAR2(20 BYTE), 
	"STREET" VARCHAR2(20 BYTE), 
	"CITY" VARCHAR2(20 BYTE), 
	"STATE" VARCHAR2(20 BYTE), 
	"COUNTRY" VARCHAR2(20 BYTE), 
	"PHONE" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table LOGIN_AUDIT
--------------------------------------------------------

  CREATE TABLE "LOGIN_AUDIT" 
   (	"LOGINID" VARCHAR2(20 BYTE), 
	"LOGINDATE" DATE, 
	"LOGINDESC" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table LOGIN_DETAILS
--------------------------------------------------------

  CREATE TABLE "LOGIN_DETAILS" 
   (	"LOGINNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"LOGINTYPE" VARCHAR2(20 BYTE), 
	"LOGINSTATUS" NUMBER, 
	"REGDATE" DATE, 
	"SQUESTIONID" NUMBER, 
	"SANSWER" VARCHAR2(20 BYTE), 
	"FIRSTLOGIN" NUMBER, 
	"PASSMODIFIEDDATE" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table LOGIN_PROFILE
--------------------------------------------------------

  CREATE TABLE "LOGIN_PROFILE" 
   (	"LOGINID" VARCHAR2(35 BYTE), 
	"BIRTHDATE" DATE, 
	"HNO" VARCHAR2(20 BYTE), 
	"STREET" VARCHAR2(20 BYTE), 
	"CITY" VARCHAR2(20 BYTE), 
	"STATE" VARCHAR2(20 BYTE), 
	"COUNTRY" VARCHAR2(20 BYTE), 
	"PINCODE" VARCHAR2(20 BYTE), 
	"CONTACTNO" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(35 BYTE), 
	"LOCALE" VARCHAR2(20 BYTE), 
	"PROFILEMODIFIEDDATE" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table NOTIFICATION_INFORMATION
--------------------------------------------------------

  CREATE TABLE "NOTIFICATION_INFORMATION" 
   (	"NOTIFICATIONID" NUMBER, 
	"COMPANYID" NUMBER, 
	"NOOFVAC" VARCHAR2(20 BYTE), 
	"CATEGORY" VARCHAR2(50 BYTE), 
	"LOCATION" VARCHAR2(20 BYTE), 
	"JOBDESC" VARCHAR2(20 BYTE), 
	"SKILLS" VARCHAR2(20 BYTE), 
	"CREATEDDATE" DATE, 
	"EXPIRYDATE" DATE, 
	"DESIGNATION" VARCHAR2(20 BYTE), 
	"STATUS" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table PLACEMENT_DETAILS
--------------------------------------------------------

  CREATE TABLE "PLACEMENT_DETAILS" 
   (	"NOTIFICATIONID" NUMBER, 
	"ROLLNO" VARCHAR2(20 BYTE), 
	"LOGINNAME" VARCHAR2(20 BYTE), 
	"STATUS" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table QUESTION_BASE
--------------------------------------------------------

  CREATE TABLE "QUESTION_BASE" 
   (	"QUESTIONID" NUMBER, 
	"QUESTIONDETAIL" VARCHAR2(80 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table SEM_PERCENTAGES
--------------------------------------------------------

  CREATE TABLE "SEM_PERCENTAGES" 
   (	"LOGINNAME" VARCHAR2(20 BYTE), 
	"SEMISTER" NUMBER, 
	"YEAROFPASS" NUMBER, 
	"AGGREGATE" NUMBER
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table STUDENT_AGGREGATES
--------------------------------------------------------

  CREATE TABLE "STUDENT_AGGREGATES" 
   (	"LOGINNAME" VARCHAR2(20 BYTE), 
	"AGGREGATE" NUMBER
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table STUDENT_SKILLS
--------------------------------------------------------

  CREATE TABLE "STUDENT_SKILLS" 
   (	"LOGINNAME" VARCHAR2(20 BYTE), 
	"SKILLNAME" VARCHAR2(20 BYTE), 
	"DESCRIPTION" VARCHAR2(20 BYTE), 
	"LEVELDESC" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table TPO_APPLICANT
--------------------------------------------------------

  CREATE TABLE "TPO_APPLICANT" 
   (	"APPLICANTID" NUMBER, 
	"VACANCYID" NUMBER, 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"LASTNAME" VARCHAR2(30 BYTE), 
	"AGE" NUMBER, 
	"SEX" VARCHAR2(30 BYTE), 
	"HOUSENO" VARCHAR2(30 BYTE), 
	"STREET" VARCHAR2(30 BYTE), 
	"CITY" VARCHAR2(30 BYTE), 
	"STATE" VARCHAR2(30 BYTE), 
	"COUNTRY" VARCHAR2(30 BYTE), 
	"EMAIL" VARCHAR2(30 BYTE), 
	"WORKPHONE" VARCHAR2(30 BYTE), 
	"HOMEPHONE" VARCHAR2(30 BYTE), 
	"PASSPORTNO" VARCHAR2(30 BYTE), 
	"EXPIRYDATE" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table TPO_INTERVIEW
--------------------------------------------------------

  CREATE TABLE "TPO_INTERVIEW" 
   (	"INTERVIEWID" NUMBER, 
	"VACCANCYID" VARCHAR2(40 BYTE), 
	"STAFF" VARCHAR2(40 BYTE), 
	"APPLIED" NUMBER, 
	"SELECTED" NUMBER, 
	"RECRUITED" NUMBER, 
	"OPENINGDATE" DATE, 
	"CLOSINGDATE" DATE, 
	"INTERVIEWTIME" VARCHAR2(20 BYTE), 
	"STATUS" VARCHAR2(20 BYTE), 
	"COMMENTS" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table TPO_ROUNDS
--------------------------------------------------------

  CREATE TABLE "TPO_ROUNDS" 
   (	"ROUNDID" NUMBER, 
	"ROUNDNAME" VARCHAR2(20 BYTE), 
	"DESCRIPTION" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table TPO_VACANCY
--------------------------------------------------------

  CREATE TABLE "TPO_VACANCY" 
   (	"VACANCYID" VARCHAR2(50 BYTE), 
	"DESIGID" VARCHAR2(50 BYTE), 
	"SKILLS" VARCHAR2(50 BYTE), 
	"NOOFVACANCIES" VARCHAR2(40 BYTE), 
	"DESCRIPTION" VARCHAR2(40 BYTE), 
	"STATUS" VARCHAR2(20 BYTE), 
	"USERLOGIN" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Table TRAINING_DETAILS
--------------------------------------------------------

  CREATE TABLE "TRAINING_DETAILS" 
   (	"TRAININGID" NUMBER, 
	"TRAININGNAME" VARCHAR2(20 BYTE), 
	"START_DATE" DATE, 
	"START_TIME" VARCHAR2(20 BYTE), 
	"TRAININGDESC" VARCHAR2(20 BYTE), 
	"STATUS" VARCHAR2(20 BYTE), 
	"END_DATE" DATE, 
	"END_TIME" VARCHAR2(4000 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
REM INSERTING into ACADAMIC_DETAILS
SET DEFINE OFF;
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('Saaketh',1991,50,1993,85,1996,95,'109094337',1996,'1','1','1');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('pranith',2006,72,2008,86,2008,90,'109094337',1980,'1','1','1');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('aa',2004,75,2006,87,0,0,'3422',1980,'BTech','Electronics','First');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('vara',2002,80,2007,75,2010,74,'0235689',2007,'Mca','computers','First');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('sandeep',2004,80,2007,75,2008,85,'456789',2007,'BTech','Electronics','First');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('anitha',2002,75,2007,72,0,0,'0560890',2007,'MCA','Computers','First');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('praveen',2000,80,2005,82,2007,79,'789789',2005,'MCA','Computers','Third');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('Ranga',1990,90,1992,90,1994,92,'9493',1995,'B.TECH','Computers','2');
Insert into ACADAMIC_DETAILS (LOGINNAME,SSCYOP,SSCPERCENTAGE,UGYOP,UGPERCENTAGE,GYOP,GPERCENTAGE,ROLLNO,YEAROFJOINING,COURSE,DISCIPLINE,SEMISTER) values ('harsha',1988,85,1990,90,1993,95,'800127',1993,'1','1','1');
REM INSERTING into COMPANY_DETAILS
SET DEFINE OFF;
Insert into COMPANY_DETAILS (COMPANYID,COMPANYNAME,PROFILE,STREET,CITY,STATE,COUNTRY,PHONE,EMAIL) values (1,'Infosys','student','main','Hyd','AP','IND','040526398','infosys@yahoo.com');
Insert into COMPANY_DETAILS (COMPANYID,COMPANYNAME,PROFILE,STREET,CITY,STATE,COUNTRY,PHONE,EMAIL) values (2,'Wipro','MNC','Main','HYD','AP','IND','040556677','wipro@info.com');
Insert into COMPANY_DETAILS (COMPANYID,COMPANYNAME,PROFILE,STREET,CITY,STATE,COUNTRY,PHONE,EMAIL) values (4,'HCL','No1 MNC Company','main','hyd','ap','india','040568989','hcl@gmail.com');
Insert into COMPANY_DETAILS (COMPANYID,COMPANYNAME,PROFILE,STREET,CITY,STATE,COUNTRY,PHONE,EMAIL) values (3,'TCS','asdf','dasf','dasf','dasf','sdfasdf','7897897898','fasdf@gmail.com');
Insert into COMPANY_DETAILS (COMPANYID,COMPANYNAME,PROFILE,STREET,CITY,STATE,COUNTRY,PHONE,EMAIL) values (5,'MGM','Good','mujjugudem','Hyderabad','AP','India','9493011497','info@mgm.com');
REM INSERTING into LOGIN_AUDIT
SET DEFINE OFF;
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('17-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('18-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('18-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('18-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Saaketh',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praneeth',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('vara',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Rani',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Rani',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Rani',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Rani',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praneeth',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Ravi',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Ravi',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praneeth',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Ravi',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praneeth',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('17-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('17-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('17-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('sanjay',to_date('18-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('18-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praneeth',to_date('15-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('vara',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Rani',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Rani',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praneeth',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Ravi',to_date('16-APR-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('17-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('17-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('20-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('pranith',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('vara',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('sanjay',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('sandeep',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('21-MAR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('27-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('21-MAR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('21-MAR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('sandeep',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('21-MAR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('21-MAR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('vara',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('27-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('07-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('praveen',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('10-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('anitha',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('nikita',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('sanjay',to_date('23-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('28-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('30-APR-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('03-MAY-12','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('sanjay',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('aa',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('19-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Ranga',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('21-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Saaketh',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('harsha',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('harsha',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Tanay',to_date('22-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('23-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('25-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('25-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('25-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('25-MAY-14','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('07-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('09-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('11-MAR-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Sai',to_date('31-JUL-15','DD-MON-RR'),'Login Success');
Insert into LOGIN_AUDIT (LOGINID,LOGINDATE,LOGINDESC) values ('Admin',to_date('11-AUG-15','DD-MON-RR'),'Login Success');
REM INSERTING into LOGIN_DETAILS
SET DEFINE OFF;
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Saaketh','Saaketh','Saaketh','Gnana','student',1,to_date('21-MAY-14','DD-MON-RR'),null,'Jr.Ntr',1,to_date('21-MAY-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Rani','Rani','Rani','R','student',1,to_date('16-APR-14','DD-MON-RR'),null,'ntr',0,to_date('16-APR-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Ravi','Ravi','Ravi','R','student',1,to_date('16-APR-14','DD-MON-RR'),null,'chinna',1,to_date('16-APR-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('praneeth','praneeth02','k','j','student',1,to_date('15-APR-14','DD-MON-RR'),null,'praneeth',1,to_date('15-APR-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('pranith','pranith','pranith','ch','student',1,to_date('21-MAY-14','DD-MON-RR'),null,'Jr.Ntr',1,to_date('21-MAY-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Admin','Admin','rajan','kumar','tpo',1,to_date('11-MAR-11','DD-MON-RR'),1,'hai',2,to_date('11-MAR-11','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('aa','aa','as','as','student',1,to_date('11-MAR-11','DD-MON-RR'),1,'aa',1,to_date('11-MAR-11','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('vara','vara','vara','vara','student',1,to_date('21-MAR-12','DD-MON-RR'),1,'hello',2,to_date('22-MAR-12','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('nikita','nikita','nikita','reddy','student',1,to_date('21-MAR-12','DD-MON-RR'),2,'nikita',0,to_date('21-MAR-12','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('praveen','praveen','praveen','reddy','student',1,to_date('21-MAR-12','DD-MON-RR'),null,'prav',1,to_date('21-MAR-12','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('sandeep','sandeep','sandeep','sandeep','student',1,to_date('07-APR-12','DD-MON-RR'),1,'dfasdfasfd',1,to_date('07-APR-12','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('anitha','anitha','anitha','anitha','student',1,to_date('21-MAR-12','DD-MON-RR'),null,'anu',1,to_date('21-MAR-12','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('sanjay','sanjay','sanjay','sanjay','student',1,to_date('23-APR-12','DD-MON-RR'),null,'sdaad',0,to_date('23-APR-12','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Ranga','Randa','Ranga','Nath','student',1,to_date('22-MAY-14','DD-MON-RR'),null,'mujjugudem',1,to_date('22-MAY-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Tanay','Tanay','Tanay','Sai','student',1,to_date('21-MAY-14','DD-MON-RR'),null,'Jr.Ntr',1,to_date('21-MAY-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('harsha','harsha','Harsha','t','student',1,to_date('22-MAY-14','DD-MON-RR'),null,'Jr.Ntr',1,to_date('22-MAY-14','DD-MON-RR'));
Insert into LOGIN_DETAILS (LOGINNAME,PASSWORD,FIRSTNAME,LASTNAME,LOGINTYPE,LOGINSTATUS,REGDATE,SQUESTIONID,SANSWER,FIRSTLOGIN,PASSMODIFIEDDATE) values ('Sai','Sai','Sai','Kruthik','student',1,to_date('22-MAY-14','DD-MON-RR'),null,'mujjugudem',1,to_date('22-MAY-14','DD-MON-RR'));
REM INSERTING into LOGIN_PROFILE
SET DEFINE OFF;
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('Rani',to_date('02-JAN-91','DD-MON-RR'),'132511','kvldks','Hyderabad','Andhra pradesh','India','1552',null,'ch.wd@gmail.com','en_IN',to_date('16-APR-14','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('Ravi',to_date('02-APR-13','DD-MON-RR'),'123','kmm','Hyderabad','Andhra pradesh','India','507162',null,'ch.pr@gmail.com','en_IN',to_date('16-APR-14','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('praneeth',to_date('16-MAY-14','DD-MON-RR'),'24','fgfd','Hyderabad','Andhra pradesh','India','575',null,'ch@gmail.com','en_US',to_date('15-APR-14','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('pranith',to_date('09-APR-91','DD-MON-RR'),'2-57/1','Gandhi street','Hyderabad','Andhra pradesh','India','507160',null,'ch.praneeth37@gmail.com`','en_US',to_date('21-MAY-14','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('Admin',to_date('01-MAR-86','DD-MON-RR'),'22','ameerpet','hyd','AP','India','500004','86765476754','admin,admn@gmail,com','EN',to_date('11-MAR-11','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('aa',to_date('16-JAN-80','DD-MON-RR'),'22','as','Hyderabad','Andhra pradesh','India','43',null,'asa','en',to_date('11-MAR-11','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('vara',to_date('14-MAR-90','DD-MON-RR'),'17-135','main','hyd','ap','india','534123','0405689789','vara@gmail.com','telugu',to_date('21-MAR-12','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('praveen',to_date('21-MAR-12','DD-MON-RR'),'17-135','Main','Hyderabad','Andhra pradesh','India','534123',null,'praveen@gmail.com','en_US',to_date('21-MAR-12','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('sandeep',to_date('11-APR-12','DD-MON-RR'),'5689','Main','Hyderabad','Andhra pradesh','India','538987',null,'sandeep@gmail.com','en_US',to_date('07-APR-12','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('anitha',to_date('17-JAN-86','DD-MON-RR'),'17-185','street','Hyderabad','Andhra pradesh','India','534123','null','anitha@gmail.com','en_US',to_date('23-APR-12','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('sanjay',to_date('02-APR-12','DD-MON-RR'),'123','sanjay','Hyderabad','Andhra pradesh','India','43234',null,'s@gmail.com','en_US',to_date('23-APR-12','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('harsha',to_date('13-NOV-82','DD-MON-RR'),'2-57/1','Gandhi street','Hyderabad','Andhra pradesh','India','507160','9394774958','ch.praneeth37@gmail.com','en_US',to_date('22-MAY-14','DD-MON-RR'));
Insert into LOGIN_PROFILE (LOGINID,BIRTHDATE,HNO,STREET,CITY,STATE,COUNTRY,PINCODE,CONTACTNO,EMAIL,LOCALE,PROFILEMODIFIEDDATE) values ('Ranga',to_date('13-JAN-89','DD-MON-RR'),'2-57/1','mujjugudem','Mumbai','Maharashtra','India','507160','8099127215','ch.praneeth37@gmail.com','en_US',to_date('22-MAY-14','DD-MON-RR'));
REM INSERTING into NOTIFICATION_INFORMATION
SET DEFINE OFF;
Insert into NOTIFICATION_INFORMATION (NOTIFICATIONID,COMPANYID,NOOFVAC,CATEGORY,LOCATION,JOBDESC,SKILLS,CREATEDDATE,EXPIRYDATE,DESIGNATION,STATUS) values (2,2,'30','Networking','Bangalore','Web developer','Web desinging',to_date('22-MAR-12','DD-MON-RR'),to_date('26-DEC-12','DD-MON-RR'),'web developer','Process');
Insert into NOTIFICATION_INFORMATION (NOTIFICATIONID,COMPANYID,NOOFVAC,CATEGORY,LOCATION,JOBDESC,SKILLS,CREATEDDATE,EXPIRYDATE,DESIGNATION,STATUS) values (4,3,'50','System Programming','dsfsdf','dsfds','dfsaf',to_date('02-MAY-12','DD-MON-RR'),to_date('02-JUN-12','DD-MON-RR'),'fasf','Process');
Insert into NOTIFICATION_INFORMATION (NOTIFICATIONID,COMPANYID,NOOFVAC,CATEGORY,LOCATION,JOBDESC,SKILLS,CREATEDDATE,EXPIRYDATE,DESIGNATION,STATUS) values (5,4,'80','System Programming','sdff','dsfsdf','sfd',to_date('29-MAY-12','DD-MON-RR'),to_date('31-MAY-12','DD-MON-RR'),'dfsf','Process');
Insert into NOTIFICATION_INFORMATION (NOTIFICATIONID,COMPANYID,NOOFVAC,CATEGORY,LOCATION,JOBDESC,SKILLS,CREATEDDATE,EXPIRYDATE,DESIGNATION,STATUS) values (1,1,'15','System Programming','Hyd','JAVA DEVELOPER','JAVA',to_date('20-MAR-12','DD-MON-RR'),to_date('20-APR-12','DD-MON-RR'),'JAVA DEVELPOER','Process');
Insert into NOTIFICATION_INFORMATION (NOTIFICATIONID,COMPANYID,NOOFVAC,CATEGORY,LOCATION,JOBDESC,SKILLS,CREATEDDATE,EXPIRYDATE,DESIGNATION,STATUS) values (6,5,'111','DBA, Datawarehousing','Hyderabad','Good','Oracle',to_date('25-MAY-14','DD-MON-RR'),to_date('14-JUN-14','DD-MON-RR'),'SQL','Process');
REM INSERTING into PLACEMENT_DETAILS
SET DEFINE OFF;
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (1,'1358','anitha','Recruited');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (1,'2356','vara','Recruited');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (1,'123','aa','Rejected');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (2,'3422','aa','Rejected');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (1,'123','aa','process');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (5,'9493','Ranga','Process');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (5,'789789','praveen','Process');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (5,'9493','Ranga','Process');
Insert into PLACEMENT_DETAILS (NOTIFICATIONID,ROLLNO,LOGINNAME,STATUS) values (5,'789789','praveen','Process');
REM INSERTING into QUESTION_BASE
SET DEFINE OFF;
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (1,'What is your favorite pastime?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (2,'Who was your childhood hero?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (3,'What was the name of your first school?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (4,'Where did you meet your spouse?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (5,'What is your favorite sports team?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (6,'What is your father middle name?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (7,'What was your high school mascot?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (8,'What make was your first car or bike?');
Insert into QUESTION_BASE (QUESTIONID,QUESTIONDETAIL) values (9,'What is your pets name?');
REM INSERTING into SEM_PERCENTAGES
SET DEFINE OFF;
Insert into SEM_PERCENTAGES (LOGINNAME,SEMISTER,YEAROFPASS,AGGREGATE) values ('anitha',1,2001,75);
Insert into SEM_PERCENTAGES (LOGINNAME,SEMISTER,YEAROFPASS,AGGREGATE) values ('vara',2,2007,76);
Insert into SEM_PERCENTAGES (LOGINNAME,SEMISTER,YEAROFPASS,AGGREGATE) values ('anitha',6,2004,78);
REM INSERTING into STUDENT_AGGREGATES
SET DEFINE OFF;
Insert into STUDENT_AGGREGATES (LOGINNAME,AGGREGATE) values ('anitha',79);
Insert into STUDENT_AGGREGATES (LOGINNAME,AGGREGATE) values ('aa',75);
REM INSERTING into STUDENT_SKILLS
SET DEFINE OFF;
Insert into STUDENT_SKILLS (LOGINNAME,SKILLNAME,DESCRIPTION,LEVELDESC) values ('vara','Web Developer','Good at web develop','Intermediate');
Insert into STUDENT_SKILLS (LOGINNAME,SKILLNAME,DESCRIPTION,LEVELDESC) values ('praveen','Servlets','Good at Servlets','Intermediate');
Insert into STUDENT_SKILLS (LOGINNAME,SKILLNAME,DESCRIPTION,LEVELDESC) values ('anitha','Java','Good at java','Expert');
REM INSERTING into TPO_APPLICANT
SET DEFINE OFF;
REM INSERTING into TPO_INTERVIEW
SET DEFINE OFF;
Insert into TPO_INTERVIEW (INTERVIEWID,VACCANCYID,STAFF,APPLIED,SELECTED,RECRUITED,OPENINGDATE,CLOSINGDATE,INTERVIEWTIME,STATUS,COMMENTS) values (1,'1','5',50,25,15,to_date('02-APR-12','DD-MON-RR'),to_date('02-MAY-12','DD-MON-RR'),'5:00PM','Completed','come and join');
REM INSERTING into TPO_ROUNDS
SET DEFINE OFF;
Insert into TPO_ROUNDS (ROUNDID,ROUNDNAME,DESCRIPTION) values (1,'GD','Good communication skills...');
Insert into TPO_ROUNDS (ROUNDID,ROUNDNAME,DESCRIPTION) values (2,'HR','HUMAN RESOURCE');
Insert into TPO_ROUNDS (ROUNDID,ROUNDNAME,DESCRIPTION) values (3,'WRITTEN TEST','ANALYTICAL');
REM INSERTING into TPO_VACANCY
SET DEFINE OFF;
Insert into TPO_VACANCY (VACANCYID,DESIGID,SKILLS,NOOFVACANCIES,DESCRIPTION,STATUS,USERLOGIN) values ('1','1','C ,C++ and JAVA','60','excellent','Process','aa');
Insert into TPO_VACANCY (VACANCYID,DESIGID,SKILLS,NOOFVACANCIES,DESCRIPTION,STATUS,USERLOGIN) values ('2','2','Web Development','50','Average','Rejected','satya');
REM INSERTING into TRAINING_DETAILS
SET DEFINE OFF;
Insert into TRAINING_DETAILS (TRAININGID,TRAININGNAME,START_DATE,START_TIME,TRAININGDESC,STATUS,END_DATE,END_TIME) values (3,'Php',to_date('31-MAY-14','DD-MON-RR'),'8AM','As per industory','Process',to_date('27-JUL-14','DD-MON-RR'),'10AM');
Insert into TRAINING_DETAILS (TRAININGID,TRAININGNAME,START_DATE,START_TIME,TRAININGDESC,STATUS,END_DATE,END_TIME) values (2,'CRT',to_date('21-MAR-12','DD-MON-RR'),'8AM','Campus recruitment ','Process',to_date('29-APR-12','DD-MON-RR'),'10am');
Insert into TRAINING_DETAILS (TRAININGID,TRAININGNAME,START_DATE,START_TIME,TRAININGDESC,STATUS,END_DATE,END_TIME) values (1,'1',to_date('20-MAR-12','DD-MON-RR'),'8AM','Java ','Process',to_date('30-APR-12','DD-MON-RR'),'10am');
--------------------------------------------------------
--  DDL for Index COMPANYID_COMPANY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "COMPANYID_COMPANY_PK" ON "COMPANY_DETAILS" ("COMPANYID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Index LOGINNAME_LOGINDETAILS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LOGINNAME_LOGINDETAILS_PK" ON "LOGIN_DETAILS" ("LOGINNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Index NOTIFICATIONID_NOTIFICATION
--------------------------------------------------------

  CREATE UNIQUE INDEX "NOTIFICATIONID_NOTIFICATION" ON "NOTIFICATION_INFORMATION" ("NOTIFICATIONID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Index QID_QUESTION_BASE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "QID_QUESTION_BASE_PK" ON "QUESTION_BASE" ("QUESTIONID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Index TPO_ROUNDS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TPO_ROUNDS_PK" ON "TPO_ROUNDS" ("ROUNDID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Index TPO_VACANCY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TPO_VACANCY_PK" ON "TPO_VACANCY" ("VACANCYID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  DDL for Index TID_TRAINING
--------------------------------------------------------

  CREATE UNIQUE INDEX "TID_TRAINING" ON "TRAINING_DETAILS" ("TRAININGID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  ;
--------------------------------------------------------
--  Constraints for Table COMPANY_DETAILS
--------------------------------------------------------

  ALTER TABLE "COMPANY_DETAILS" ADD CONSTRAINT "COMPANYID_COMPANY_PK" PRIMARY KEY ("COMPANYID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
--------------------------------------------------------
--  Constraints for Table LOGIN_DETAILS
--------------------------------------------------------

  ALTER TABLE "LOGIN_DETAILS" ADD CONSTRAINT "LOGINNAME_LOGINDETAILS_PK" PRIMARY KEY ("LOGINNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
--------------------------------------------------------
--  Constraints for Table LOGIN_PROFILE
--------------------------------------------------------

  ALTER TABLE "LOGIN_PROFILE" MODIFY ("LOGINID" NOT NULL ENABLE);
 
  ALTER TABLE "LOGIN_PROFILE" MODIFY ("EMAIL" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table NOTIFICATION_INFORMATION
--------------------------------------------------------

  ALTER TABLE "NOTIFICATION_INFORMATION" ADD CONSTRAINT "NOTIFICATIONID_NOTIFICATION" PRIMARY KEY ("NOTIFICATIONID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
 
  ALTER TABLE "NOTIFICATION_INFORMATION" MODIFY ("CATEGORY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table QUESTION_BASE
--------------------------------------------------------

  ALTER TABLE "QUESTION_BASE" ADD CONSTRAINT "QID_QUESTION_BASE_PK" PRIMARY KEY ("QUESTIONID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
--------------------------------------------------------
--  Constraints for Table TPO_ROUNDS
--------------------------------------------------------

  ALTER TABLE "TPO_ROUNDS" ADD CONSTRAINT "TPO_ROUNDS_PK" PRIMARY KEY ("ROUNDID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
--------------------------------------------------------
--  Constraints for Table TPO_VACANCY
--------------------------------------------------------

  ALTER TABLE "TPO_VACANCY" ADD CONSTRAINT "TPO_VACANCY_PK" PRIMARY KEY ("VACANCYID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
--------------------------------------------------------
--  Constraints for Table TRAINING_DETAILS
--------------------------------------------------------

  ALTER TABLE "TRAINING_DETAILS" ADD CONSTRAINT "TID_TRAINING" PRIMARY KEY ("TRAININGID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
   ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ACADAMIC_DETAILS
--------------------------------------------------------

  ALTER TABLE "ACADAMIC_DETAILS" ADD CONSTRAINT "LOGINID_ACADAMICDETAILS_FK" FOREIGN KEY ("LOGINNAME")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOGIN_AUDIT
--------------------------------------------------------

  ALTER TABLE "LOGIN_AUDIT" ADD CONSTRAINT "LOGINID_LOGINAUDIT_FK" FOREIGN KEY ("LOGINID")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOGIN_DETAILS
--------------------------------------------------------

  ALTER TABLE "LOGIN_DETAILS" ADD CONSTRAINT "QID_LOGINDETAILS_FK" FOREIGN KEY ("SQUESTIONID")
	  REFERENCES "QUESTION_BASE" ("QUESTIONID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOGIN_PROFILE
--------------------------------------------------------

  ALTER TABLE "LOGIN_PROFILE" ADD CONSTRAINT "LOGINID_LOGINPROFILE_FK" FOREIGN KEY ("LOGINID")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PLACEMENT_DETAILS
--------------------------------------------------------

  ALTER TABLE "PLACEMENT_DETAILS" ADD CONSTRAINT "LOGINNAME_PLACEMENTS_FK" FOREIGN KEY ("LOGINNAME")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
 
  ALTER TABLE "PLACEMENT_DETAILS" ADD CONSTRAINT "NOTIFICATIONID_PLACEMENTS" FOREIGN KEY ("NOTIFICATIONID")
	  REFERENCES "NOTIFICATION_INFORMATION" ("NOTIFICATIONID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SEM_PERCENTAGES
--------------------------------------------------------

  ALTER TABLE "SEM_PERCENTAGES" ADD CONSTRAINT "LOGINNAME_SEMPERCENTAGES_FK" FOREIGN KEY ("LOGINNAME")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STUDENT_AGGREGATES
--------------------------------------------------------

  ALTER TABLE "STUDENT_AGGREGATES" ADD CONSTRAINT "LOGINID_AGGREGATES_FK" FOREIGN KEY ("LOGINNAME")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STUDENT_SKILLS
--------------------------------------------------------

  ALTER TABLE "STUDENT_SKILLS" ADD CONSTRAINT "LOGINNAME_STUDENTSKILLS_FK" FOREIGN KEY ("LOGINNAME")
	  REFERENCES "LOGIN_DETAILS" ("LOGINNAME") ENABLE;
