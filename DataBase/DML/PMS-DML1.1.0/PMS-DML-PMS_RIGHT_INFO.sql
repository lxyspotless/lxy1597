delete from PMS_RIGHT_INFO;
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS10001', '产品配置', '', 'MENU', '', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100010001', '产品大类管理', 'PMS10001', 'MENU', 'view=saleProductList', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100010002', '产品子类管理', 'PMS10001', 'MENU', 'view=subProductList', 'Y', sysdate, sysdate);

insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS10002', '版本管理', '', 'MENU', '', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020001', '产品复制', 'PMS10002', 'MENU', 'view=productCopy', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020002', '产品复核', 'PMS10002', 'MENU', 'view=productCheck', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020003', '产品审核', 'PMS10002', 'MENU', 'view=productApprove', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100020004', '产品发布', 'PMS10002', 'MENU', 'view=productRelease', 'Y', sysdate, sysdate);

insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS10003', '系统配置', '', 'MENU', '', 'Y', sysdate, sysdate);
insert into PMS_RIGHT_INFO (right_code, right_name, parent_code, right_type, right_action, status, date_created, date_updated)
values ('PMS100030001', '数据字典配置', 'PMS10003', 'MENU', 'view=dataDictionaryConfig', 'Y', sysdate, sysdate);