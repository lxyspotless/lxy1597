drop table if exists PMS_PRODUCT_MAIN_TYPE;

CREATE TABLE PMS_PRODUCT_MAIN_TYPE (
id_product_main_type  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
business_owner  varchar(20) NOT NULL COMMENT 'ҵ��˾' ,
business_line  varchar(20) NOT NULL COMMENT 'ҵ������' ,
product_type  varchar(20) NOT NULL COMMENT '��Ʒ����' ,
product_no  varchar(32) NOT NULL COMMENT '��Ʒ����' ,
product_name  varchar(100) NOT NULL COMMENT '��Ʒ����' ,
parent_product_no  varchar(32) COMMENT '�ϼ���Ʒ����' ,
dept_code  varchar(100) COMMENT '���ű���' ,
remark  varchar(50) COMMENT '��ע' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_product_main_type),
UNIQUE INDEX IDX_PRODUCT_NO (product_no) 
)
COMMENT='��Ʒ��������'
;
