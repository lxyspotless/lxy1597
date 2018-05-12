--�жϱ��Ƿ���ڣ����������ɾ��
declare 
	num number; 
begin 
	select count(1) into num from all_tables where TABLE_NAME = 'PMS_PRODUCT_BASIC_INFO'; 
	if   num>0   then 
	    execute immediate 'drop table PMS_PRODUCT_BASIC_INFO cascade constraints';
	end if; 
end;
/
create table PMS_PRODUCT_BASIC_INFO
(
  id_product_basic_info varchar2(32) default sys_guid() not null,
  product_no varchar2(32) not null,
  version_no integer not null,
  fund_source varchar2(100),
  guarantee_type varchar2(20),
  credit_type varchar2(20),
  min_amt number(20,7),
  max_amt number(20,7),
  loan_term_list varchar2(200),
  loan_term_unit varchar2(20),
  int_standard_date varchar2(20),
  extend_days integer,
  extend_day_type varchar2(20),
  check_list_no varchar2(32),
  repay_type varchar2(20),
  settlement_date_rule varchar2(20),
  first_term_rule varchar2(20),
  repay_base_date varchar2(20),
  max_credit_period integer,
  min_credit_amt number(20,7),
  max_credit_amt number(20,7),
  created_by varchar2(100) default 'system' not null,
  date_created timestamp not null,
  updated_by varchar2(100) default 'system' not null,
  date_updated timestamp not null
) monitoring;
-- Add comments to the table 
comment on table PMS_PRODUCT_BASIC_INFO is '��Ʒ������Ϣ��';
-- Add comments to the columns 
comment on column PMS_PRODUCT_BASIC_INFO.id_product_basic_info is '����';
comment on column PMS_PRODUCT_BASIC_INFO.product_no is '��Ʒ���';
comment on column PMS_PRODUCT_BASIC_INFO.version_no is '�汾��';
comment on column PMS_PRODUCT_BASIC_INFO.fund_source is '�ʽ���Դcode:FundSource';
comment on column PMS_PRODUCT_BASIC_INFO.guarantee_type is '������������code:GuaranteeType';
comment on column PMS_PRODUCT_BASIC_INFO.credit_type is '��������code:CreditType';
comment on column PMS_PRODUCT_BASIC_INFO.min_amt is '��Ʒ��Ͷ��';
comment on column PMS_PRODUCT_BASIC_INFO.max_amt is '��Ʒ��߶��';
comment on column PMS_PRODUCT_BASIC_INFO.loan_term_list is '��������code:LoanTerm';
comment on column PMS_PRODUCT_BASIC_INFO.loan_term_unit is '�������ڵ�λcode:LoanTermUnit';
comment on column PMS_PRODUCT_BASIC_INFO.int_standard_date is '��Ϣ��׼����code:IntStandardDate';
comment on column PMS_PRODUCT_BASIC_INFO.extend_days is '��Ϣ���ӳ�����';
comment on column PMS_PRODUCT_BASIC_INFO.extend_day_type is '�ӳ��������㷽ʽcode:ExtendDayType';
comment on column PMS_PRODUCT_BASIC_INFO.check_list_no is '��������';
comment on column PMS_PRODUCT_BASIC_INFO.repay_type is '���ʽcode:RepayType';
comment on column PMS_PRODUCT_BASIC_INFO.settlement_date_rule is '��Ϣ�չ���code:SettlementDateRule';
comment on column PMS_PRODUCT_BASIC_INFO.first_term_rule is '���ڻ���Լ��';
comment on column PMS_PRODUCT_BASIC_INFO.repay_base_date is '������code:RepayBaseDate';
comment on column PMS_PRODUCT_BASIC_INFO.max_credit_period is '���������';
comment on column PMS_PRODUCT_BASIC_INFO.min_credit_amt is '������Ŷ��';
comment on column PMS_PRODUCT_BASIC_INFO.max_credit_amt is '������Ŷ��';
comment on column PMS_PRODUCT_BASIC_INFO.created_by is '������';
comment on column PMS_PRODUCT_BASIC_INFO.date_created is '����ʱ��';
comment on column PMS_PRODUCT_BASIC_INFO.updated_by is '�޸���';
comment on column PMS_PRODUCT_BASIC_INFO.date_updated is '�޸�ʱ��';
-- Create/Recreate primary, unique and foreign key constraints
create unique index IDX_ID_PRODUCT_BASIC_INFO ON PMS_PRODUCT_BASIC_INFO(id_product_basic_info);
alter table PMS_PRODUCT_BASIC_INFO add constraint PK_ID_PRODUCT_BASIC_INFO primary key (id_product_basic_info) using index IDX_ID_PRODUCT_BASIC_INFO;
-- Create unique index
create unique index IDX_ID_PRODUCT_NO_BASIC_INFO ON PMS_PRODUCT_BASIC_INFO(product_no,version_no);
-- Grant object privileges
--grant select,insert,update,delete on PMS_PRODUCT_BASIC_INFO to pmsopr;
--Create trigger on insert
create or replace trigger TR_PMS_PRODUCT_BASIC_INFO_BI
	before insert on PMS_PRODUCT_BASIC_INFO
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_created := trigger_date;
	:new.date_updated := trigger_date;
end;
/
--Create trigger on update
create or replace trigger TR_PMS_PRODUCT_BASIC_INFO_BU
	before update on PMS_PRODUCT_BASIC_INFO
	for each row
declare
	trigger_date DATE := sysdate;
begin
	:new.date_updated := trigger_date;
end;
/