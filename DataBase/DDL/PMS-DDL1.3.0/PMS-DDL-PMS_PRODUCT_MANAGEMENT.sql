drop table if exists PMS_PRODUCT_MANAGEMENT;

CREATE TABLE PMS_PRODUCT_MANAGEMENT (
id_product_management  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
product_no  varchar(32) NOT NULL COMMENT '产品编码' ,
version_no  int NOT NULL COMMENT '版本号' ,
effective_date  varchar(10) NOT NULL COMMENT '生效时间' ,
publish_date  timestamp COMMENT '发布时间' ,
approved_by  varchar(32) COMMENT '审批人' ,
approve_date  timestamp COMMENT '审批时间' ,
approve_comment  varchar(200) COMMENT '审批意见' ,
status  varchar(20) NOT NULL COMMENT '状态' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_product_management),
UNIQUE INDEX IDX_PRODUCT_NO (product_no) 
)
COMMENT='产品控制表'
;
