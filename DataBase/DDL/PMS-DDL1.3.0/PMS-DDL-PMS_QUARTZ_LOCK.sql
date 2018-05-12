drop table if exists PMS_QUARTZ_JOB_LOCK;

CREATE TABLE PMS_QUARTZ_JOB_LOCK (
id_quartz_job_lock  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
business_type  varchar(32) NOT NULL DEFAULT 'COMMON' COMMENT 'ҵ������' ,
target_id  varchar(100) NOT NULL COMMENT '��Ŀ��ID' ,
target_type  varchar(100) NOT NULL COMMENT '������' ,
locked_date  timestamp NOT NULL COMMENT '����ʱ��' ,
expired_date  timestamp NOT NULL COMMENT 'ʧЧʱ��' ,
is_effective  varchar(1) NOT NULL DEFAULT 'Y' COMMENT '�Ƿ���Ч(Y:��,N:��)' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_quartz_job_lock),
UNIQUE INDEX IDX_TARGET_ID (target_id, target_type) 
)
COMMENT='QUARTZ JOB������Ϣ'
;
