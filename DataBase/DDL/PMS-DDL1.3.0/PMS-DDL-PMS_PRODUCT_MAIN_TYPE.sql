drop table if exists PMS_PRODUCT_MAIN_TYPE;

CREATE TABLE PMS_PRODUCT_MAIN_TYPE (
id_product_main_type  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
business_owner  varchar(20) NOT NULL COMMENT '业务公司' ,
business_line  varchar(20) NOT NULL COMMENT '业务条线' ,
product_type  varchar(20) NOT NULL COMMENT '产品类型' ,
product_no  varchar(32) NOT NULL COMMENT '产品编码' ,
product_name  varchar(100) NOT NULL COMMENT '产品名称' ,
parent_product_no  varchar(32) COMMENT '上级产品编码' ,
dept_code  varchar(100) COMMENT '部门编码' ,
remark  varchar(50) COMMENT '备注' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_product_main_type),
UNIQUE INDEX IDX_PRODUCT_NO (product_no) 
)
COMMENT='产品主关联表'
;
