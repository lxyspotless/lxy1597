--�жϱ��Ƿ���ڣ����������ɾ��
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_DATA_DICTIONARY'; 
	if   num=1   then 
		execute immediate 'alter table PMS_DATA_DICTIONARY drop constraint PK_ID_DATA_DICTIONARY cascade';
	    execute immediate 'drop table PMS_DATA_DICTIONARY cascade constraints';
	end if;
end;
/
create table PMS_DATA_DICTIONARY
(
  id_data_dictionary varchar2(32) default sys_guid() not null,
  business_owner varchar2(10),
  use_system varchar2(20) not null,
  code_no varchar2(32) not null,
  code_name varchar2(100) not null,
  item_no varchar2(50) not null,
  item_name varchar2(100) not null,
  sort_no integer,
  is_effective varchar2(1),
  attribute1 varchar2(20),
  attribute2 varchar2(20),
  attribute3 varchar2(20),
  attribute4 varchar2(20),
  attribute5 varchar2(20),
  remark varchar2(100),
  created_by varchar2(100) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp not null
) monitoring;
-- Add comments to the table 
comment on table PMS_DATA_DICTIONARY is '�����ֵ��';
-- Add comments to the columns 
comment on column PMS_DATA_DICTIONARY.id_data_dictionary is '����';
comment on column PMS_DATA_DICTIONARY.business_owner is 'ҵ��˾';
comment on column PMS_DATA_DICTIONARY.use_system is 'ʹ��ϵͳ';
comment on column PMS_DATA_DICTIONARY.code_no is '�������ͱ���';
comment on column PMS_DATA_DICTIONARY.code_name is '������������';
comment on column PMS_DATA_DICTIONARY.item_no is '���������';
comment on column PMS_DATA_DICTIONARY.item_name is '����������';
comment on column PMS_DATA_DICTIONARY.sort_no is '���';
comment on column PMS_DATA_DICTIONARY.is_effective is '�Ƿ���Ч(Y:�ǣ�N:��)';
comment on column PMS_DATA_DICTIONARY.attribute1 is '����1';
comment on column PMS_DATA_DICTIONARY.attribute2 is '����2';
comment on column PMS_DATA_DICTIONARY.attribute3 is '����3';
comment on column PMS_DATA_DICTIONARY.attribute4 is '����4';
comment on column PMS_DATA_DICTIONARY.attribute5 is '����5';
comment on column PMS_DATA_DICTIONARY.remark is '��ע';
comment on column PMS_DATA_DICTIONARY.created_by is '������';
comment on column PMS_DATA_DICTIONARY.date_created is '����ʱ��';
comment on column PMS_DATA_DICTIONARY.updated_by is '�޸���';
comment on column PMS_DATA_DICTIONARY.date_updated is '�޸�ʱ��';
-- Create/Recreate primary, unique and foreign key constraints
create unique index IDX_ID_DATA_DICTIONARY ON PMS_DATA_DICTIONARY(id_data_dictionary) initrans 16;
alter table PMS_DATA_DICTIONARY add constraint PK_ID_DATA_DICTIONARY primary key (id_data_dictionary) using index IDX_ID_DATA_DICTIONARY;
-- Create index
create index IDX_ID_CODE_NO ON PMS_DATA_DICTIONARY(code_no);
-- Grant object privileges
grant select,insert,update,delete on PMS_DATA_DICTIONARY to pmsopr;
--Create trigger on insert
create or replace trigger TR_PMS_DATA_DICTIONARY_BI
	before insert on PMS_DATA_DICTIONARY
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_created := trigger_date;
	:new.date_updated := trigger_date;
end;
/
--Create trigger on update
create or replace trigger TR_PMS_DATA_DICTIONARY_BU
	before update on PMS_DATA_DICTIONARY
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_updated := trigger_date;
end;
/