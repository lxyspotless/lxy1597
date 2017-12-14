delete from PMS_PRODUCT_MAIN_TYPE;

insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10001', 'MAIN', 'PH100010001', 'O贷', '', 'DZ', 'O贷产品大类');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10001', 'SUB', 'PH1000100010001', 'O贷-P2P', 'PH100010001', 'DZ', 'O贷产品子类-P2P');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10001', 'SUB', 'PH1000100010002', 'O贷-联合放款', 'PH100010001', 'DZ', 'O贷产品子类-联合放款');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10001', 'MAIN', 'PH100010002', '车主贷', '', 'DZ', '车主贷产品大类');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10001', 'SUB', 'PH1000100020001', '车主贷-P2P', 'PH100010002', 'DZ', '车主贷产品子类-P2P');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10001', 'SUB', 'PH1000100020002', '车主贷-联合放款', 'PH100010002', 'DZ', '车主贷产品子类-联合放款');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10002', 'MAIN', 'PH100020001', '宅宜贷', '', 'YDY', '宅宜贷产品大类');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10002', 'SUB', 'PH1000200010001', '宅宜贷-小贷', 'PH100020001', 'YDY', '宅宜贷产品子类-P2P');
insert into PMS_PRODUCT_MAIN_TYPE (business_owner, business_line, product_type, product_no, product_name, parent_product_no, dept_code, remark)
values ('PH', '10002', 'SUB', 'PH1000200010002', '宅宜贷-联合放款', 'PH100020001', 'YDY', '宅宜贷产品子类-联合放款');
