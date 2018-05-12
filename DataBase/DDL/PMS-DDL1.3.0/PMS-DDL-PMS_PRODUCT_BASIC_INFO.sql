drop table if exists PMS_PRODUCT_BASIC_INFO;

CREATE TABLE PMS_PRODUCT_BASIC_INFO (
id_product_basic_info  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
product_no  varchar(32) NOT NULL COMMENT '��Ʒ����' ,
version_no  int NOT NULL COMMENT '�汾��' ,
fund_source  varchar(100) COMMENT '�ʽ���Դ' ,
loan_subject  varchar(100) COMMENT '�ſ�����' ,
guarantee_type  varchar(50) COMMENT '��������' ,
credit_type  varchar(50) COMMENT '��������' ,
min_amt  DOUBLE(20,4) COMMENT '��С������' ,
max_amt  DOUBLE(20,4) COMMENT '��������' ,
loan_term_list  varchar(100) COMMENT '�����ڴ�' ,
loan_term_unit  varchar(20) COMMENT '�����ڴε�λ' ,
int_standard_date  varchar(20) COMMENT '��Ϣ��ʽ' ,
extend_days  int COMMENT '��Ϣ��������' ,
extend_day_type  varchar(20) COMMENT '��Ϣ���ڷ�ʽ' ,
check_list_no  varchar(50) COMMENT '����嵥' ,
repay_type  varchar(20) COMMENT '���ʽ' ,
settlement_date_rule  varchar(20) COMMENT '������Լ��' ,
first_term_rule  varchar(20) COMMENT '���ڻ������' ,
repay_base_date  varchar(20) COMMENT '�����׼����' ,
max_credit_period  varchar(20) COMMENT '�������ʱ��' ,
min_credit_amt  DOUBLE(20,4) COMMENT '��С���Ž��' ,
max_credit_amt  DOUBLE(20,4) COMMENT '������Ž��' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_product_basic_info),
UNIQUE INDEX IDX_PRODUCT_NO (product_no) 
)
COMMENT='��Ʒ������Ϣ��'
;
