--�жϱ��Ƿ���ڣ����������ɾ��
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_PRODUCT_MAIN_TYPE'; 
	if   num>0   then 
	    execute immediate 'drop table PMS_PRODUCT_MAIN_TYPE cascade constraints';
	end if; 
end;
/
create table PMS_PRODUCT_MAIN_TYPE
(
  id_product_main_type varchar2(32) default sys_guid() not null,
  business_owner varchar2(10) not null,
  business_line varchar2(20) not null,
  product_type varchar2(32) not null,
  product_no varchar2(32) not null,
  product_name varchar2(100) not null,
  parent_product_no varchar2(32),
  dept_code varchar2(32),
  remark varchar2(100),
  created_by varchar2(100) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp not null
) monitoring;
-- Add comments to the table 
comment on table PMS_PRODUCT_MAIN_TYPE is '��Ʒ�����';
-- Add comments to the columns 
comment on column PMS_PRODUCT_MAIN_TYPE.id_product_main_type is '����';
comment on column PMS_PRODUCT_MAIN_TYPE.business_owner is 'ҵ��˾';
comment on column PMS_PRODUCT_MAIN_TYPE.business_line is 'ҵ������';
comment on column PMS_PRODUCT_MAIN_TYPE.product_type is '��Ʒ����';
comment on column PMS_PRODUCT_MAIN_TYPE.product_no is '��Ʒ���';
comment on column PMS_PRODUCT_MAIN_TYPE.product_name is '��Ʒ����';
comment on column PMS_PRODUCT_MAIN_TYPE.parent_product_no is '�ϼ���Ʒ����';
comment on column PMS_PRODUCT_MAIN_TYPE.dept_code is '���ű���';
comment on column PMS_PRODUCT_MAIN_TYPE.remark is '��ע';
comment on column PMS_PRODUCT_MAIN_TYPE.created_by is '������';
comment on column PMS_PRODUCT_MAIN_TYPE.date_created is '����ʱ��';
comment on column PMS_PRODUCT_MAIN_TYPE.updated_by is '�޸���';
comment on column PMS_PRODUCT_MAIN_TYPE.date_updated is '�޸�ʱ��';
-- Create/Recreate primary, unique and foreign key constraints
create unique index IDX_ID_PRODUCT_MAIN_TYPE ON PMS_PRODUCT_MAIN_TYPE(id_product_main_type);
alter table PMS_PRODUCT_MAIN_TYPE add constraint PK_ID_PRODUCT_MAIN_TYPE primary key (id_product_main_type) using index IDX_ID_PRODUCT_MAIN_TYPE;
-- Create unique index
create unique index IDX_ID_PRODUCT_NO ON PMS_PRODUCT_MAIN_TYPE(product_no);
-- Grant object privileges
--grant select,insert,update,delete on PMS_PRODUCT_MAIN_TYPE to pmsopr;
--Create trigger on insert
create or replace trigger TR_PMS_PRODUCT_MAIN_TYPE_BI
	before insert on PMS_PRODUCT_MAIN_TYPE
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_created := trigger_date;
	:new.date_updated := trigger_date;
end;
/
--Create trigger on update
create or replace trigger TR_PMS_PRODUCT_MAIN_TYPE_BU
	before update on PMS_PRODUCT_MAIN_TYPE
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_updated := trigger_date;
end;
/