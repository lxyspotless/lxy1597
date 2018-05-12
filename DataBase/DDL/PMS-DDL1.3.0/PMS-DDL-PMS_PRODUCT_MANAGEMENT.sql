drop table if exists PMS_PRODUCT_MANAGEMENT;

CREATE TABLE PMS_PRODUCT_MANAGEMENT (
id_product_management  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
product_no  varchar(32) NOT NULL COMMENT '��Ʒ����' ,
version_no  int NOT NULL COMMENT '�汾��' ,
effective_date  varchar(10) NOT NULL COMMENT '��Чʱ��' ,
publish_date  timestamp COMMENT '����ʱ��' ,
approved_by  varchar(32) COMMENT '������' ,
approve_date  timestamp COMMENT '����ʱ��' ,
approve_comment  varchar(200) COMMENT '�������' ,
status  varchar(20) NOT NULL COMMENT '״̬' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_product_management),
UNIQUE INDEX IDX_PRODUCT_NO (product_no) 
)
COMMENT='��Ʒ���Ʊ�'
;
