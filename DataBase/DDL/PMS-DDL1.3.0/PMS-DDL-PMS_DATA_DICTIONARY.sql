drop table if exists PMS_DATA_DICTIONARY;

CREATE TABLE PMS_DATA_DICTIONARY (
id_data_dictionary  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
business_owner  varchar(10) COMMENT '业务公司' ,
use_system  varchar(20) NOT NULL COMMENT '使用系统' ,
code_no  varchar(32) NOT NULL DEFAULT 'Y' COMMENT '代码类型编码' ,
code_name  varchar(100) NOT NULL COMMENT '代码类型名称' ,
item_no  varchar(50) NOT NULL COMMENT '代码项编码' ,
item_name  varchar(100) NOT NULL COMMENT '代码项名称' ,
sort_no  int NOT NULL DEFAULT 1 COMMENT '序号' ,
is_effective  varchar(1) COMMENT '是否有效(Y:是，N:否)' ,
attribute1  varchar(20) COMMENT '属性1' ,
attribute2  varchar(1) COMMENT '属性2' ,
attribute3  varchar(1) COMMENT '属性3' ,
attribute4  varchar(1) COMMENT '属性4' ,
attribute5  varchar(1) COMMENT '属性5' ,
remark  varchar(100) COMMENT '备注' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_data_dictionary),
UNIQUE INDEX IDX_CODE_ITEM (code_no,item_no) 
)
COMMENT='数据字典表'
;
