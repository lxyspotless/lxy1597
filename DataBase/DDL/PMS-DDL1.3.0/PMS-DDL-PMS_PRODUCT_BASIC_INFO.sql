drop table if exists PMS_PRODUCT_BASIC_INFO;

CREATE TABLE PMS_PRODUCT_BASIC_INFO (
id_product_basic_info  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
product_no  varchar(32) NOT NULL COMMENT '产品编码' ,
version_no  int NOT NULL COMMENT '版本号' ,
fund_source  varchar(100) COMMENT '资金来源' ,
loan_subject  varchar(100) COMMENT '放款主体' ,
guarantee_type  varchar(50) COMMENT '担保类型' ,
credit_type  varchar(50) COMMENT '增信类型' ,
min_amt  DOUBLE(20,4) COMMENT '最小贷款金额' ,
max_amt  DOUBLE(20,4) COMMENT '最大贷款金额' ,
loan_term_list  varchar(100) COMMENT '贷款期次' ,
loan_term_unit  varchar(20) COMMENT '贷款期次单位' ,
int_standard_date  varchar(20) COMMENT '计息方式' ,
extend_days  int COMMENT '计息延期天数' ,
extend_day_type  varchar(20) COMMENT '计息延期方式' ,
check_list_no  varchar(50) COMMENT '检查清单' ,
repay_type  varchar(20) COMMENT '还款方式' ,
settlement_date_rule  varchar(20) COMMENT '还款日约定' ,
first_term_rule  varchar(20) COMMENT '首期还款规则' ,
repay_base_date  varchar(20) COMMENT '还款基准日期' ,
max_credit_period  varchar(20) COMMENT '最大增信时间' ,
min_credit_amt  DOUBLE(20,4) COMMENT '最小增信金额' ,
max_credit_amt  DOUBLE(20,4) COMMENT '最大增信金额' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_product_basic_info),
UNIQUE INDEX IDX_PRODUCT_NO (product_no) 
)
COMMENT='产品基础信息表'
;
