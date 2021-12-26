

CREATE TABLE USER_DETAILS
(USER_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
FIRST_NAME VARCHAR2(50) NOT NULL,
LAST_NAME VARCHAR2(50) NOT NULL,
USER_NAME VARCHAR2(100) NOT NULL,
PASSWORD VARCHAR2(50) NOT NULL,
ROLE VARCHAR2(15) DEFAULT 'TEAM MEMBER',
CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
UNIQUE(USER_NAME),
CONSTRAINT PK_USER_DETAILS PRIMARY KEY (USER_ID));

DESC USER_DETAILS;

--DROP TABLE USER_DETAILS cascade constraints;
--DROP TABLE USER_DETAILS;

INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,ROLE)VALUES('DHARSHAN','RAVI','dharshanravi@gmail.com','Dharshan03@','ADMIN');
INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,ROLE)VALUES('PRIYA','RAVI','priyaravi@gmail.com','Priya24#','ADMIN');

DELETE USER_DETAILS WHERE user_id=2;

SELECT * FROM USER_DETAILS order by user_id;


CREATE TABLE TASK_DETAILS(
TASK_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USER_ID NUMBER NOT NULL,
CONSTRAINT FK_TASK_DETAILS_USER_DETAILS FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID),
TASK_NAME VARCHAR2(50)NOT NULL,
ASSIGNED_TO_DATE DATE  NOT NULL,
END_DATE DATE  NOT NULL,
TASK_PRIORITY VARCHAR2(18)NOT NULL,
ASSIGNED_TO VARCHAR2(50)NOT NULL,
CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
CONSTRAINT PK_TASK_DETAILS PRIMARY KEY (TASK_ID));

select * from task_details;
DESC TASK_DETAILS;

--DROP TABLE TASK_DETAILS;

CREATE TABLE TIMESHEETS(
TIMESHEET_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USER_ID NUMBER NOT NULL,
CONSTRAINT FK_TIMESHEETS_USER_DETAILS FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID),
TASK_ID NUMBER NOT NULL,
CONSTRAINT FK_TIMESHEETS_TASK_DETAILS FOREIGN KEY(TASK_ID) REFERENCES TASK_DETAILS(TASK_ID),
SPEND_TIME_HRS NUMBER NOT NULL,
COMMENTS VARCHAR2(200) NOT NULL,
TIMESHEET_FOR_DATE DATE NOT NULL, 
TIMESHEET_UPDATE_DATE DATE DEFAULT SYSDATE NOT NULL,
CONSTRAINT PK_TIMESHEETS PRIMARY KEY (TIMESHEET_ID)
);
select * from timesheets;
DROP TABLE TIMESHEETS;
DESC TIMESHEETS;

CREATE TABLE STATUS(
STATUS_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USER_ID NUMBER NOT NULL,
CONSTRAINT FK_STATUS_USER_DETAILS FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID),
TIMESHEET_ID NUMBER NOT NULL,
CONSTRAINT FK_STATUS_TIMESHEETS FOREIGN KEY(TIMESHEET_ID) REFERENCES TIMESHEETS(TIMESHEET_ID),
STATUS VARCHAR2(50) DEFAULT ('NOT APPROVED') NOT NULL,
APPROVED_BY VARCHAR2(100),
STATUS_UPDATE_DATE  DATE DEFAULT SYSDATE NOT NULL,
CONSTRAINT PK_STATUS PRIMARY KEY(STATUS_ID)
);
select * from status;
select * from status where status='rejected';

select * from status inner join timesheets on status.timesheet_id=timesheets.timesheet_id where status='rejected';

select td.task_name,s.timesheet_id,ts.timesheet_for_date,ts.spend_time_hrs,ts.comments,s.status,s.approved_by from status s 
inner join timesheets ts on s.timesheet_id=ts.timesheet_id 
inner join task_details td on td.task_id=ts.task_id 
where status='rejected' and td.assigned_to='keerthanaguru@gmail.com';

select t.timesheet_id,t.task_id,t.timesheet_for_date,t.spend_time_hrs,t.comments,s.status
from status s inner join timesheets t
on s.timesheet_id=t.timesheet_id where status='rejected';

select * from user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id inner join status s on ts.timesheet_id=s.timesheet_id;  

select * from user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id inner join status s on ts.timesheet_id=s.timesheet_id where ts.timesheet_for_date='23-12-2021';

select u.user_name,u.role,td.task_name,ts.timesheet_id,ts.spend_time_hrs,ts.timesheet_for_date,s.status,s.approved_by,s.status_update_date 
from user_details u 
inner join task_details td on u.user_id=td.user_id 
inner join timesheets ts on td.task_id=ts.task_id 
inner join status s on ts.timesheet_id=s.timesheet_id where ts.timesheet_for_date=to_date('23-12-2021','dd-MM-yyyy') and u.user_name='keerthanaguru@gmail.com'; 

commit;
--drop table status;

select * from task_details;
delete from status where status_id=5;

DESC USER_DETAILS;
DESC task_details;
DESC TIMESHEETS;
DESC STATUS;

COMMIT; 