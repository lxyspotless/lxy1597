delete from PMS_RIGHT_INFO;
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS10001', '��Ʒ����', '', 'MENU', '', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100010001', '��Ʒ�������', 'PMS10001', 'MENU', 'view=saleProductList', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100010002', '��Ʒ�������', 'PMS10001', 'MENU', 'view=subProductList', 'Y', sysdate, sysdate);

insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS10002', '�汾����', '', 'MENU', '', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020001', '��Ʒ����', 'PMS10002', 'MENU', 'view=productCopy', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020002', '��Ʒ����', 'PMS10002', 'MENU', 'view=productCheck', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020003', '��Ʒ���', 'PMS10002', 'MENU', 'view=productApprove', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020004', '��Ʒ����', 'PMS10002', 'MENU', 'view=productRelease', 'Y', sysdate, sysdate);

insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS10003', 'ϵͳ����', '', 'MENU', '', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100030001', '�����ֵ�����', 'PMS10003', 'MENU', 'view=dataDictionaryConfig', 'Y', sysdate, sysdate);