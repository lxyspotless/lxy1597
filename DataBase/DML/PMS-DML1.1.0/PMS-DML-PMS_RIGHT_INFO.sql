delete from PMS_RIGHT_INFO;
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS10001', '��Ʒ����', '', 'MENU', '', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS100010001', '��Ʒ�������', 'PMS10001', 'MENU', 'forwardView.do?view=product/saleProductList', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS100010002', '��Ʒ�������', 'PMS10001', 'MENU', 'forwardView.do?view=product/subProductList', 'Y');

insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS10002', '�汾����', '', 'MENU', '', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS100020001', '��Ʒ����', 'PMS10002', 'MENU', 'forwardView.do?view=product/productCopy', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS100020002', '��Ʒ����', 'PMS10002', 'MENU', 'forwardView.do?view=product/productCheck', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS100020003', '��Ʒ���', 'PMS10002', 'MENU', 'forwardView.do?view=product/productApprove', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS100020004', '��Ʒ����', 'PMS10002', 'MENU', 'forwardView.do?view=product/productRelease', 'Y');

insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status)
values ('PMS10003', 'ϵͳ����', '', 'MENU', '', 'Y');
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100030001', '�����ֵ�����', 'PMS10003', 'MENU', 'forwardView.do?view=system/dataDictionaryConfig', 'Y', sysdate, sysdate);