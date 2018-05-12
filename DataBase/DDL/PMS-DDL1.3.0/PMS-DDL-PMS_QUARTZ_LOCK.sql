drop table if exists PMS_QUARTZ_JOB_LOCK;

CREATE TABLE PMS_QUARTZ_JOB_LOCK (
id_quartz_job_lock  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
business_type  varchar(32) NOT NULL DEFAULT 'COMMON' COMMENT '业务主体' ,
target_id  varchar(100) NOT NULL COMMENT '锁目标ID' ,
target_type  varchar(100) NOT NULL COMMENT '锁类型' ,
locked_date  timestamp NOT NULL COMMENT '锁定时间' ,
expired_date  timestamp NOT NULL COMMENT '失效时间' ,
is_effective  varchar(1) NOT NULL DEFAULT 'Y' COMMENT '是否有效(Y:是,N:否)' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '修改人' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (id_quartz_job_lock),
UNIQUE INDEX IDX_TARGET_ID (target_id, target_type) 
)
COMMENT='QUARTZ JOB锁定信息'
;
