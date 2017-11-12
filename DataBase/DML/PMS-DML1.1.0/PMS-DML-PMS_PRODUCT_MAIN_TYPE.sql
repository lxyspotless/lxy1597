delete from PMS_PRODUCT_MAIN_TYPE;

insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark, date_created, date_updated)
values ('PH', '10001', 'COMMON', 'PH100010001', 'O贷', '', 'PH', 'O贷产品大类', sysdate, sysdate);
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark, date_created, date_updated)
values ('PH', '10001', 'COMMON', 'PH100010002', '车主贷', '', 'PH', '车主贷产品大类', sysdate, sysdate);
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark, date_created, date_updated)
values ('PH', '10002', 'COMMON', 'PH100020001', '宅宜贷', '', 'PH', '宅宜贷产品大类', sysdate, sysdate);
