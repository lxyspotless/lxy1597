--判断表是否存在，如果存在则删除
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_RIGHT_INFO'; 
	if   num=1   then 
		execute immediate 'alter table PMS_RIGHT_INFO drop constraint ID_RIGHT_PK_KEY cascade';
	    execute immediate 'drop table PMS_RIGHT_INFO cascade constraints';
	end if; 
end;
/
create table PMS_RIGHT_INFO
(
  id_right_pk varchar2(32) default sys_guid() not null,
  right_code varchar2(50) not null,
  right_name varchar2(100) not null,
  parent_code varchar2(100),
  right_type varchar2(100) not null,
  right_action varchar2(100),
  status varchar2(1) default 'Y' not null,
  created_by varchar2(100) default 'system' not null,
  date_created timestamp default sysdate not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp default sysdate not null
);
-- Add comments to the table 
comment on table PMS_RIGHT_INFO is '权限信息表';
-- Add comments to the columns 
comment on column PMS_RIGHT_INFO.id_right_pk is '主键';
comment on column PMS_RIGHT_INFO.right_code is '权限代码';
comment on column PMS_RIGHT_INFO.right_name is '权限名称';
comment on column PMS_RIGHT_INFO.parent_code is '父权限代码';
comment on column PMS_RIGHT_INFO.right_type is '权限类型';
comment on column PMS_RIGHT_INFO.right_action is '权限动作';
comment on column PMS_RIGHT_INFO.status is '权限状态(Y:有效,N:无效)';
comment on column PMS_RIGHT_INFO.created_by is '创建人';
comment on column PMS_RIGHT_INFO.date_created is '创建时间';
comment on column PMS_RIGHT_INFO.updated_by is '修改人';
comment on column PMS_RIGHT_INFO.date_updated is '修改时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_RIGHT_INFO add constraint ID_RIGHT_PK_KEY primary key (id_right_pk);
-- Create index
create unique index RIGHT_CODE_IDX ON PMS_RIGHT_INFO(right_code);