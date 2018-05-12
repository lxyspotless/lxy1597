drop table if exists PMS_RIGHT_INFO;

CREATE TABLE PMS_RIGHT_INFO (
id_right_info  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
right_code  varchar(50) NOT NULL COMMENT 'Ȩ�ޱ���' ,
right_name  varchar(100) NOT NULL COMMENT 'Ȩ����' ,
parent_code  varchar(50) NOT NULL DEFAULT 'Y' COMMENT '�ϼ�Ȩ�ޱ���' ,
right_type  varchar(50) COMMENT 'Ȩ������' ,
right_action  varchar(100) COMMENT 'Ȩ�޶���' ,
status  varchar(1) NOT NULL DEFAULT 'Y' COMMENT '�û�״̬(Y:��Ч,N:��Ч)' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_right_info),
UNIQUE INDEX IDX_RIGHT_CODE (right_code) 
)
COMMENT='Ȩ����Ϣ��'
;
