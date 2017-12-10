--判断表是否存在，如果存在则删除
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_PRODUCT_MANAGEMENT'; 
	if   num=1   then 
		execute immediate 'alter table PMS_PRODUCT_MANAGEMENT drop constraint PK_ID_PRODUCT_MANAGEMENT cascade';
	    execute immediate 'drop table PMS_PRODUCT_MANAGEMENT cascade constraints';
	end if; 
end;
/
create table PMS_PRODUCT_MANAGEMENT
(
  id_product_management varchar2(32) default sys_guid() not null,
  product_no varchar2(32) not null,
  version_no integer not null,
  effective_date varchar2(10),
  publish_date timestamp,
  approved_by varchar2(32),
  approve_date timestamp,
  approve_comment varchar2(200),
  status varchar2(20),
  created_by varchar2(100) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp not null
) monitoring;
-- Add comments to the table 
comment on table PMS_PRODUCT_MANAGEMENT is '产品控制表';
-- Add comments to the columns 
comment on column PMS_PRODUCT_MANAGEMENT.id_product_management is '主键';
comment on column PMS_PRODUCT_MANAGEMENT.product_no is '产品编号';
comment on column PMS_PRODUCT_MANAGEMENT.version_no is '版本号';
comment on column PMS_PRODUCT_MANAGEMENT.effective_date is '生效日期';
comment on column PMS_PRODUCT_MANAGEMENT.publish_date is '发布时间';
comment on column PMS_PRODUCT_MANAGEMENT.approved_by is '审批人';
comment on column PMS_PRODUCT_MANAGEMENT.approve_date is '审批时间';
comment on column PMS_PRODUCT_MANAGEMENT.approve_comment is '审批意见';
comment on column PMS_PRODUCT_MANAGEMENT.status is '状态 code:ApproveStatus';
comment on column PMS_PRODUCT_MANAGEMENT.created_by is '创建人';
comment on column PMS_PRODUCT_MANAGEMENT.date_created is '创建时间';
comment on column PMS_PRODUCT_MANAGEMENT.updated_by is '修改人';
comment on column PMS_PRODUCT_MANAGEMENT.date_updated is '修改时间';
-- Create/Recreate primary, unique and foreign key constraints
create unique index IDX_ID_PRODUCT_MANAGEMENT ON PMS_PRODUCT_MANAGEMENT(id_product_management);
alter table PMS_PRODUCT_MANAGEMENT add constraint PK_ID_PRODUCT_MANAGEMENT primary key (id_product_management) using index IDX_ID_PRODUCT_MANAGEMENT;
-- Create unique index
create unique index IDX_ID_PRODUCT_NO_MANAGEMENT ON PMS_PRODUCT_MANAGEMENT(product_no,version_no);
-- Grant object privileges
grant select,insert,update,delete on PMS_PRODUCT_MANAGEMENT to pmsopr;
--Create trigger on insert
create or replace trigger TR_PMS_PRODUCT_MANAGEMENT_BI
	before insert on PMS_PRODUCT_MANAGEMENT
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_created := trigger_date;
	:new.date_updated := trigger_date;
end;
/
--Create trigger on update
create or replace trigger TR_PMS_PRODUCT_MANAGEMENT_BU
	before update on PMS_PRODUCT_MANAGEMENT
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_updated := trigger_date;
end;
/