drop table if exists PMS_UM_INFO;

CREATE TABLE PMS_UM_INFO (
id_um_info  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
um_id  varchar(50) NOT NULL COMMENT 'UM账号' ,
user_name  varchar(100) NOT NULL COMMENT '用户名' ,
status  varchar(1) NOT NULL DEFAULT 'Y' COMMENT '用户状态(Y:有效,N:无效)' ,
company_code  varchar(50) COMMENT '公司代码' ,
dept_code  varchar(50) COMMENT '部门代码' ,
org_code  varchar(50) DEFAULT 'Y' COMMENT '机构代码' ,
org_business_type  varchar(32) NOT NULL DEFAULT 'COMMON' COMMENT '业务类型' ,
pass_word  varchar(32) NOT NULL COMMENT '口令' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_um_info),
UNIQUE INDEX IDX_UM_ID (um_id) 
)
COMMENT='UM信息'
;
