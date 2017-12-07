--判断表是否存在，如果存在则删除
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_UM_INFO'; 
	if   num=1   then 
		execute immediate 'alter table PMS_UM_INFO drop constraint PK_ID_UM_INFO cascade';
	    execute immediate 'drop table PMS_UM_INFO cascade constraints';
	end if; 
end;
/
create table PMS_UM_INFO
(
  id_um_info varchar2(32) default sys_guid() not null,
  um_id varchar2(50) not null,
  user_name varchar2(100) not null,
  status varchar2(1) default 'Y' not null,
  company_code varchar2(50),
  dept_code varchar2(50),
  org_code varchar2(50),
  org_business_type varchar2(32) default 'COMMON',
  pass_word varchar2(32) not null,
  created_by varchar2(100) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp not null
);
-- Add comments to the table 
comment on table PMS_UM_INFO is 'UM信息';
-- Add comments to the columns 
comment on column PMS_UM_INFO.id_um_info is '主键';
comment on column PMS_UM_INFO.um_id is 'UM账号';
comment on column PMS_UM_INFO.user_name is '用户名称';
comment on column PMS_UM_INFO.status is '用户状态(Y:有效,N:无效)';
comment on column PMS_UM_INFO.company_code is '公司代码';
comment on column PMS_UM_INFO.dept_code is '部门代码';
comment on column PMS_UM_INFO.org_code is '机构代码';
comment on column PMS_UM_INFO.org_business_type is '业务类型';
comment on column PMS_UM_INFO.pass_word is '口令';
comment on column PMS_UM_INFO.created_by is '创建人';
comment on column PMS_UM_INFO.date_created is '创建时间';
comment on column PMS_UM_INFO.updated_by is '修改人';
comment on column PMS_UM_INFO.date_updated is '修改时间';
-- Create/Recreate primary, unique and foreign key constraints 
create unique index IDX_ID_UM_INFO ON PMS_UM_INFO(id_um_info);
alter table PMS_UM_INFO add constraint PK_ID_UM_INFO primary key (id_um_info) using index IDX_ID_UM_INFO;
-- Create unique index
create unique index IDX_UM_ID ON PMS_UM_INFO(um_id);
-- Grant object privileges
grant select,insert,update,delete on PMS_UM_INFO to pmsopr;
--Create trigger on insert
create or replace trigger TR_PMS_UM_INFO_BI
	before insert on PMS_UM_INFO
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_created := trigger_date;
	:new.date_updated := trigger_date;
end;
/
--Create trigger on update
create or replace trigger TR_PMS_UM_INFO_BU
	before update on PMS_UM_INFO
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_updated := trigger_date;
end;
/