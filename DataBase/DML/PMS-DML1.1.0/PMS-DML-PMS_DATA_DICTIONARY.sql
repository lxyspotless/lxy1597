delete from PMS_DATA_DICTIONARY;

insert into PMS_DATA_DICTIONARY (business_owner, use_system, code_no, code_name, item_no, item_name, sort_no, is_effective, date_created, date_updated)
values ('PH', 'COMMON', 'BusinessLine', '业务条线', '10001', '无抵押', '1', 'Y', sysdate, sysdate);
insert into PMS_DATA_DICTIONARY (business_owner, use_system, code_no, code_name, item_no, item_name, sort_no, is_effective, date_created, date_updated)
values ('PH', 'COMMON', 'BusinessLine', '业务条线', '10002', '有抵押', '2', 'Y', sysdate, sysdate);
