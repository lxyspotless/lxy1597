--判断表是否存在，如果存在则删除
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
comment on table PMS_PRODUCT_MAIN_TYPE is '产品主体表';
-- Add comments to the columns 
comment on column PMS_PRODUCT_MAIN_TYPE.id_product_main_type_pk is '主键';
comment on column PMS_PRODUCT_MAIN_TYPE.business_owner is '业务公司';
comment on column PMS_PRODUCT_MAIN_TYPE.business_line is '业务条线';
comment on column PMS_PRODUCT_MAIN_TYPE.product_type is '产品类型';
comment on column PMS_PRODUCT_MAIN_TYPE.product_no is '产品编号';
comment on column PMS_PRODUCT_MAIN_TYPE.product_name is '产品名称';
comment on column PMS_PRODUCT_MAIN_TYPE.parent_product_no is '上级产品编码';
comment on column PMS_PRODUCT_MAIN_TYPE.dept_code is '部门编码';
comment on column PMS_PRODUCT_MAIN_TYPE.remark is '备注';
comment on column PMS_PRODUCT_MAIN_TYPE.created_by is '创建人';
comment on column PMS_PRODUCT_MAIN_TYPE.date_created is '创建时间';
comment on column PMS_PRODUCT_MAIN_TYPE.updated_by is '修改人';
comment on column PMS_PRODUCT_MAIN_TYPE.date_updated is '修改时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_PRODUCT_MAIN_TYPE add constraint ID_PRODUCT_MAIN_TYPE_PK_KEY primary key (ID_PRODUCT_MAIN_TYPE_PK);
-- Create index
create unique index ID_PRODUCT_MAIN_TYPE_IDX ON PMS_PRODUCT_MAIN_TYPE(PRODUCT_NO);