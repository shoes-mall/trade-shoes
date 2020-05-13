-- 非唯一索引必须按照“idx_字段名称_字段名称[_字段名]”进行命名
-- 唯一索引必须按照“uniq_字段名称_字段名称[_字段名]”进行命名

DROP TABLE IF EXISTS `s_goods_cats`;
CREATE TABLE `s_goods_cats`
(
    `id`                int(11) 							NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`cat_id`         	int(11)                        		NOT NULL COMMENT '类型ID',
    `parent_id`         int(11)                        		NOT NULL COMMENT '父级ID',
    `pic_url`           varchar(64)                         DEFAULT '' COMMENT '类型图片路径',
    `pic_name`   		varchar(32)                         DEFAULT '' COMMENT '类型标题',
    `is_show`  			int(2)                         		DEFAULT '1' COMMENT '是否显示  1(显示)  2(隐藏)',
    `cat_sort` 			int(4)                         		NOT NULL COMMENT '排序号',
    `into_user`         varchar(64)                         DEFAULT 'System' COMMENT '创建者',
    `into_time`         datetime                            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `upd_user`          varchar(64)                         DEFAULT '' COMMENT '更新者',
    `upd_time`          datetime                            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status`            int(2)                              DEFAULT '1' COMMENT '软删除状态：默认：1 （-1：已删除  1：正常）',
    `version`           int(4)                              DEFAULT '1' COMMENT '版本号',
    `remark`            varchar(255)                        DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='商品分类表';

-- 设置唯一索引
ALTER TABLE `s_goods_cats`
    ADD UNIQUE INDEX `uniq_cat_id` (`cat_id`);

DROP TABLE IF EXISTS `s_goods`;
CREATE TABLE `s_goods`
(
    `id`                int(11) 							NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`cat_id`         	int(11)                        		NOT NULL COMMENT '类型ID',
	`shop_id`         	int(11)                        		NOT NULL COMMENT '店铺ID',
	`ord_goods`         varchar(32)                        	NOT NULL DEFAULT '' COMMENT '商品编号（唯一）',
    `goods_name`        varchar(64)                         NOT NULL DEFAULT '' COMMENT '商品名称',
    `goods_img`   	    varchar(32)                         DEFAULT '' COMMENT '商品图片',
	`goods_type`  		int(2)                         		DEFAULT '1' COMMENT '商品类型  1(实物)  2(虚拟货物)',
	`goods_desc`        varchar(64)                         DEFAULT '' COMMENT '商品描述',
    `is_sale`  			int(2)                         		DEFAULT '1' COMMENT '是否上架  1(上架)  2(下架)',
	`is_new`  			int(2)                         		DEFAULT '0' COMMENT '是否新品  1(是)  2(否)',
	`sale_time`         datetime                            DEFAULT NULL COMMENT '发售时间',
    `into_user`         varchar(64)                         DEFAULT 'System' COMMENT '创建者',
    `into_time`         datetime                            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `upd_user`          varchar(64)                         DEFAULT '' COMMENT '更新者',
    `upd_time`          datetime                            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status`            int(2)                              DEFAULT '1' COMMENT '软删除状态：默认：1 （-1：已删除  1：正常）',
    `version`           int(4)                              DEFAULT '1' COMMENT '版本号',
    `remark`            varchar(255)                        DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='商品表';

-- 设置唯一索引
ALTER TABLE `s_goods`
    ADD UNIQUE INDEX `uniq_ord_goods` (`ord_goods`);

-- 添加普通索引
ALTER TABLE `s_goods`
    ADD INDEX `idx_goods_name` (`goods_name`);

DROP TABLE IF EXISTS `s_goods_audit`;
CREATE TABLE `s_goods_audit`
(
    `id`                int(11) 							NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`cat_id`         	int(11)                        		NOT NULL COMMENT '类型ID',
	`shop_id`         	int(11)                        		NOT NULL COMMENT '店铺ID',
	`ord_goods`         varchar(32)                        	NOT NULL DEFAULT '' COMMENT '商品编号',
	`audit_status`      int(2)                              DEFAULT '0' COMMENT '审核状态：0(待审核) 1(已通过) 2(拒绝)',
	`illegal_remarks`   varchar(255)                        DEFAULT NULL COMMENT '拒绝说明',
	`audit_user`        varchar(64)                         DEFAULT '' COMMENT '审核人',
    `audit_time`        datetime                            DEFAULT NULL COMMENT '审核时间',
    `into_user`         varchar(64)                         DEFAULT 'System' COMMENT '创建者',
    `into_time`         datetime                            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `upd_user`          varchar(64)                         DEFAULT '' COMMENT '更新者',
    `upd_time`          datetime                            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status`            int(2)                              DEFAULT '1' COMMENT '软删除状态：默认：1 （-1：已删除  1：正常）',
    `version`           int(4)                              DEFAULT '1' COMMENT '版本号',
    `remark`            varchar(255)                        DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='商品审核表';

-- 设置唯一索引
ALTER TABLE `s_goods_audit`
    ADD UNIQUE INDEX `uniq_ord_goods` (`ord_goods`);

-- 添加普通索引
ALTER TABLE `s_goods_audit`
    ADD INDEX `idx_audit_status` (`audit_status`);

DROP TABLE IF EXISTS `s_goods_attributes`;
CREATE TABLE `s_goods_attributes`
(
    `id`                int(11) 							NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`cat_id`         	int(11)                        		NOT NULL COMMENT '类型ID',
	`shop_id`         	int(11)                        		NOT NULL COMMENT '店铺ID',
	`ord_goods`         varchar(32)                         NOT NULL DEFAULT '' COMMENT '商品编号',
	`goods_amount`   	decimal(15,0) 						DEFAULT '0' COMMENT '市场价格',
	`goods_stock`       int(11)                        		NOT NULL COMMENT '总库存',
	`goods_sell`        int(11)                        		NOT NULL COMMENT '已出售数量',
	`goods_surplus`     int(11)                        		NOT NULL COMMENT '剩余库存',
	`goods_size`   		decimal(4,1) 						DEFAULT '0' COMMENT '商品尺码',
    `into_user`         varchar(64)                         DEFAULT 'System' COMMENT '创建者',
    `into_time`         datetime                            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `upd_user`          varchar(64)                         DEFAULT '' COMMENT '更新者',
    `upd_time`          datetime                            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status`            int(2)                              DEFAULT '1' COMMENT '软删除状态：默认：1 （-1：已删除  1：正常）',
    `version`           int(4)                              DEFAULT '1' COMMENT '版本号',
    `remark`            varchar(255)                        DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='商品属性表';

-- 设置唯一索引
ALTER TABLE `s_goods_attributes`
    ADD UNIQUE INDEX `uniq_ord_goods` (`ord_goods`);

-- 添加普通索引
ALTER TABLE `s_goods_attributes`
    ADD INDEX `idx_goods_size` (`goods_size`);

-- 添加组合索引
ALTER TABLE `s_goods_attributes`
        ADD INDEX `uniq_ord_size` (`ord_goods`,`goods_size`);