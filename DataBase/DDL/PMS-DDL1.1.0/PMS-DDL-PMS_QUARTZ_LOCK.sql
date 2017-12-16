--�жϱ��Ƿ���ڣ����������ɾ��
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_QUARTZ_JOB_LOCK'; 
	if   num>0   then 
		execute immediate 'alter table PMS_QUARTZ_JOB_LOCK drop constraint PK_ID_QUARTZ_JOB_LOCK cascade';
	    execute immediate 'drop table PMS_QUARTZ_JOB_LOCK cascade constraints';
	end if; 
end;
/
create table PMS_QUARTZ_JOB_LOCK
(
  id_quartz_job_lock varchar2(32) default sys_guid() not null,
  business_type varchar2(32) default 'COMMON' not null,
  target_id varchar2(100) not null,
  target_type varchar2(100) not null,
  locked_date timestamp,
  expired_date timestamp,
  is_effective varchar2(32) default 'Y' not null,
  created_by varchar2(100) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp not null
);
-- Add comments to the table 
comment on table PMS_QUARTZ_JOB_LOCK is 'QUARTZ JOB������Ϣ';
-- Add comments to the columns 
comment on column PMS_QUARTZ_JOB_LOCK.id_quartz_job_lock is '����';
comment on column PMS_QUARTZ_JOB_LOCK.business_type is 'ҵ������';
comment on column PMS_QUARTZ_JOB_LOCK.target_id is '��Ŀ��ID';
comment on column PMS_QUARTZ_JOB_LOCK.target_type is '������';
comment on column PMS_QUARTZ_JOB_LOCK.locked_date is '����ʱ��';
comment on column PMS_QUARTZ_JOB_LOCK.expired_date is 'ʧЧʱ��';
comment on column PMS_QUARTZ_JOB_LOCK.is_effective is '�Ƿ���Ч(Y:��Ч,N:��Ч)';
comment on column PMS_QUARTZ_JOB_LOCK.created_by is '������';
comment on column PMS_QUARTZ_JOB_LOCK.date_created is '����ʱ��';
comment on column PMS_QUARTZ_JOB_LOCK.updated_by is '�޸���';
comment on column PMS_QUARTZ_JOB_LOCK.date_updated is '�޸�ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
create unique index IDX_ID_QUARTZ_JOB_LOCK ON PMS_QUARTZ_JOB_LOCK(id_quartz_job_lock);
alter table PMS_QUARTZ_JOB_LOCK add constraint PK_ID_QUARTZ_JOB_LOCK primary key (id_quartz_job_lock) using index IDX_ID_QUARTZ_JOB_LOCK;
-- Create unique index
create unique index IDX_TARGET_ID ON PMS_QUARTZ_JOB_LOCK(target_id,target_type);
-- Grant object privileges
--grant select,insert,update,delete on PMS_QUARTZ_JOB_LOCK to pmsopr;
--Create trigger on insert
create or replace trigger TR_PMS_QUARTZ_JOB_LOCK_BI
	before insert on PMS_QUARTZ_JOB_LOCK
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_created := trigger_date;
	:new.date_updated := trigger_date;
end;
/
--Create trigger on update
create or replace trigger TR_PMS_QUARTZ_JOB_LOCK_BU
	before update on PMS_QUARTZ_JOB_LOCK
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_updated := trigger_date;
end;
/