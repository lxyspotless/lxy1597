drop table PMS_DATA_DICTIONARY cascade constraints;
alter table PMS_DATA_DICTIONARY drop constraint ID_DATA_DICTIONARY_PK_KEY cascade

create table PMS_DATA_DICTIONARY
(
  id_data_dictionary_pk varchar2(32) default sys_guid() not null,
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
)
tablespace PMSDATA
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table PMS_DATA_DICTIONARY is '�����ֵ��';
-- Add comments to the columns 
comment on column PMS_DATA_DICTIONARY.id_data_dictionary_pk is '����';
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
alter table PMS_DATA_DICTIONARY add constraint ID_DATA_DICTIONARY_PK_KEY primary key (ID_DATA_DICTIONARY_PK);
-- Create index
create index ID_DATA_DICTIONARY_IDX ON PMS_DATA_DICTIONARY(CODE_NO);