drop table if exists PMS_UM_INFO;

CREATE TABLE PMS_UM_INFO (
id_um_info  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
um_id  varchar(50) NOT NULL COMMENT 'UM�˺�' ,
user_name  varchar(100) NOT NULL COMMENT '�û���' ,
status  varchar(1) NOT NULL DEFAULT 'Y' COMMENT '�û�״̬(Y:��Ч,N:��Ч)' ,
company_code  varchar(50) COMMENT '��˾����' ,
dept_code  varchar(50) COMMENT '���Ŵ���' ,
org_code  varchar(50) DEFAULT 'Y' COMMENT '��������' ,
org_business_type  varchar(32) NOT NULL DEFAULT 'COMMON' COMMENT 'ҵ������' ,
pass_word  varchar(32) NOT NULL COMMENT '����' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_um_info),
UNIQUE INDEX IDX_UM_ID (um_id) 
)
COMMENT='UM��Ϣ'
;
