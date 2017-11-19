--�жϱ��Ƿ���ڣ����������ɾ��
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_PRODUCT_MAIN_TYPE'; 
	if   num=1   then 
		execute immediate 'alter table PMS_PRODUCT_MAIN_TYPE drop constraint ID_PRODUCT_MAIN_TYPE_PK_KEY cascade';
	    execute immediate 'drop table PMS_PRODUCT_MAIN_TYPE cascade constraints';
	end if; 
end;
/
create table PMS_PRODUCT_MAIN_TYPE
(
  id_product_main_type_pk varchar2(32) default sys_guid() not null,
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
);
-- Add comments to the table 
comment on table PMS_PRODUCT_MAIN_TYPE is '��Ʒ�����';
-- Add comments to the columns 
comment on column PMS_PRODUCT_MAIN_TYPE.id_product_main_type_pk is '����';
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
alter table PMS_PRODUCT_MAIN_TYPE add constraint ID_PRODUCT_MAIN_TYPE_PK_KEY primary key (ID_PRODUCT_MAIN_TYPE_PK);
-- Create index
create unique index ID_PRODUCT_MAIN_TYPE_IDX ON PMS_PRODUCT_MAIN_TYPE(PRODUCT_NO);