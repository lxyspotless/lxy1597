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
comment on table PMS_DATA_DICTIONARY is '数据字典表';
-- Add comments to the columns 
comment on column PMS_DATA_DICTIONARY.id_data_dictionary_pk is '主键';
comment on column PMS_DATA_DICTIONARY.business_owner is '业务公司';
comment on column PMS_DATA_DICTIONARY.use_system is '使用系统';
comment on column PMS_DATA_DICTIONARY.code_no is '代码类型编码';
comment on column PMS_DATA_DICTIONARY.code_name is '代码类型名称';
comment on column PMS_DATA_DICTIONARY.item_no is '代码项编码';
comment on column PMS_DATA_DICTIONARY.item_name is '代码项名称';
comment on column PMS_DATA_DICTIONARY.sort_no is '序号';
comment on column PMS_DATA_DICTIONARY.is_effective is '是否有效(Y:是，N:否)';
comment on column PMS_DATA_DICTIONARY.attribute1 is '属性1';
comment on column PMS_DATA_DICTIONARY.attribute2 is '属性2';
comment on column PMS_DATA_DICTIONARY.attribute3 is '属性3';
comment on column PMS_DATA_DICTIONARY.attribute4 is '属性4';
comment on column PMS_DATA_DICTIONARY.attribute5 is '属性5';
comment on column PMS_DATA_DICTIONARY.remark is '备注';
comment on column PMS_DATA_DICTIONARY.created_by is '创建人';
comment on column PMS_DATA_DICTIONARY.date_created is '创建时间';
comment on column PMS_DATA_DICTIONARY.updated_by is '修改人';
comment on column PMS_DATA_DICTIONARY.date_updated is '修改时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_DATA_DICTIONARY add constraint ID_DATA_DICTIONARY_PK_KEY primary key (ID_DATA_DICTIONARY_PK);
-- Create index
create index ID_DATA_DICTIONARY_IDX ON PMS_DATA_DICTIONARY(CODE_NO);