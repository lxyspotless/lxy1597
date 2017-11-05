drop table PMS_UM_INFO cascade constraints;
alter table PMS_UM_INFO drop constraint ID_UM_PK_KEY cascade

create table PMS_UM_INFO
(
  id_um_pk varchar2(32) default sys_guid() not null,
  um_id varchar2(50) not null,
  user_name varchar2(100) not null,
  status varchar2(1) default 'Y' not null,
  company_code varchar2(50),
  dept_code varchar2(50),
  org_code varchar2(50),
  org_business_type varchar2(32) default 'COMMON',
  pass_word varchar2(32) not null,
  created_by varchar2(150) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(150) default 'system' not null,
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
comment on table PMS_UM_INFO is 'UM��Ϣ';
-- Add comments to the columns 
comment on column PMS_UM_INFO.id_um_pk is '����';
comment on column PMS_UM_INFO.um_id is 'UM�˺�';
comment on column PMS_UM_INFO.user_name is '�û�����';
comment on column PMS_UM_INFO.status is '�û�״̬(Y:��Ч,N:��Ч)';
comment on column PMS_UM_INFO.company_code is '��˾����';
comment on column PMS_UM_INFO.dept_code is '���Ŵ���';
comment on column PMS_UM_INFO.org_code is '��������';
comment on column PMS_UM_INFO.org_business_type is 'ҵ������';
comment on column PMS_UM_INFO.pass_word is '����';
comment on column PMS_UM_INFO.created_by is '������';
comment on column PMS_UM_INFO.date_created is '����ʱ��';
comment on column PMS_UM_INFO.updated_by is '�޸���';
comment on column PMS_UM_INFO.date_updated is '�޸�ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_UM_INFO add constraint ID_UM_PK_KEY primary key (ID_UM_PK);
-- Create index
create unique index UM_ID_IDX ON PMS_UM_INFO(um_id);