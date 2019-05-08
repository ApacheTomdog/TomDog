create table basic_code
(
	basic_code_id bigint auto_increment
		primary key,
	code_catalog varchar(255) not null,
	code_key varchar(50) not null comment '字典表 key 建议使用表名+“.”+列名 表示',
	code_value varchar(200) not null comment '可选值',
	code_order int null comment '显示时的排序 从小往大排'
)
comment '数据字典表'
;

create index basic_code_basic_code_id_index
	on basic_code (basic_code_id)
;

INSERT INTO apptms.basic_code (basic_code_id, code_catalog, code_key, code_value, code_order) VALUES (1, 'goodsorderm.from_type', 'JK_U9', '立恒新大宗', 0);
INSERT INTO apptms.basic_code (basic_code_id, code_catalog, code_key, code_value, code_order) VALUES (2, 'goodsorderm.from_type', 'DS', '销售电商', 1);
INSERT INTO apptms.basic_code (basic_code_id, code_catalog, code_key, code_value, code_order) VALUES (3, 'goodsorderm.from_type', 'PT', '平台货源', 2);
INSERT INTO apptms.basic_code (basic_code_id, code_catalog, code_key, code_value, code_order) VALUES (4, 'goodsorderm.from_type', 'JK_U8', '大宗销售/大宗采购', 3);
INSERT INTO apptms.basic_code (basic_code_id, code_catalog, code_key, code_value, code_order) VALUES (5, 'global.yn', 'Y', '是', 0);
INSERT INTO apptms.basic_code (basic_code_id, code_catalog, code_key, code_value, code_order) VALUES (6, 'global.yn', 'N', '否', 1);