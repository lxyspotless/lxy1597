drop table if exists PMS_DATA_DICTIONARY;

CREATE TABLE PMS_DATA_DICTIONARY (
id_data_dictionary  int(10) NOT NULL AUTO_INCREMENT COMMENT '����' ,
business_owner  varchar(10) COMMENT 'ҵ��˾' ,
use_system  varchar(20) NOT NULL COMMENT 'ʹ��ϵͳ' ,
code_no  varchar(32) NOT NULL DEFAULT 'Y' COMMENT '�������ͱ���' ,
code_name  varchar(100) NOT NULL COMMENT '������������' ,
item_no  varchar(50) NOT NULL COMMENT '���������' ,
item_name  varchar(100) NOT NULL COMMENT '����������' ,
sort_no  int NOT NULL DEFAULT 1 COMMENT '���' ,
is_effective  varchar(1) COMMENT '�Ƿ���Ч(Y:�ǣ�N:��)' ,
attribute1  varchar(20) COMMENT '����1' ,
attribute2  varchar(1) COMMENT '����2' ,
attribute3  varchar(1) COMMENT '����3' ,
attribute4  varchar(1) COMMENT '����4' ,
attribute5  varchar(1) COMMENT '����5' ,
remark  varchar(100) COMMENT '��ע' ,
created_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '������' ,
date_created  timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '����ʱ��' ,
updated_by  varchar(100) NOT NULL DEFAULT 'system' COMMENT '�޸���' ,
date_updated  timestamp NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��' ,
PRIMARY KEY (id_data_dictionary),
UNIQUE INDEX IDX_CODE_ITEM (code_no,item_no) 
)
COMMENT='�����ֵ��'
;
