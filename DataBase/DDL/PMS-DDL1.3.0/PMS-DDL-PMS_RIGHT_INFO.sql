drop table if exists PMS_RIGHT_INFO;

CREATE TABLE PMS_RIGHT_INFO (
id_right_info  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
right_code  varchar(50) NOT NULL COMMENT '权限编码' ,
right_name  varchar(100) NOT NULL COMMENT '权限名' ,
parent_code  varchar(50) NOT NULL DEFAULT 'Y' COMMENT '上级权限编码' ,
right_type  varchar(50) COMMENT '权限类型' ,
right_action  varchar(100) COMMENT '权限动作' ,
status  varchar(1) NOT NULL DEFAULT 'Y' COMMENT '用户状态(Y:有效,N:无效)' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_right_info),
UNIQUE INDEX IDX_RIGHT_CODE (right_code) 
)
COMMENT='权限信息表'
;
