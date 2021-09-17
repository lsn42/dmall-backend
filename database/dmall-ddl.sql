set foreign_key_checks = 0;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for admin
-- ----------------------------
drop table if exists `admin`;
create table `admin` (
  `id` int not null primary key auto_increment,
  `name` varchar(64) unique not null,
  `status` int default null,
  `nickname` varchar(64) not null default '',
  `password` varchar(255) not null,
  `profile_picture_src` varchar(255) default null,
  `del` int default null
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for role
-- ----------------------------
drop table if exists `role`;
create table `role` (
  `id` int not null primary key auto_increment,
  `name` varchar(64) default null
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for admin_role
-- ----------------------------
drop table if exists `admin_role`;
create table `admin_role` (
  `admin_id` int default null,
  `role_id` int default null,
  foreign key (`admin_id`) references `admin` (`id`),
  foreign key (`role_id`) references `role` (`id`),
  index (`admin_id`),
  index (`role_id`)
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for permission
-- ----------------------------
drop table if exists `permission`;
create table `permission` (
  `id` int not null primary key auto_increment,
  `title` varchar(255) default null,
  `icon` text,
  `link` varchar(255) default null,
  `type` varchar(255) default null,
  `code` varchar(255) default null
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for role_permission
-- ----------------------------
drop table if exists `role_permission`;
create table `role_permission` (
  `role_id` int default null,
  `permission_id` int default null,
  foreign key (`role_id`) references `role` (`id`),
  foreign key (`permission_id`) references `permission` (`id`),
  index (`role_id`),
  index (`permission_id`)
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for first_level_category
-- ----------------------------
drop table if exists `first_level_category`;
create table `first_level_category` (
  `id` int not null primary key auto_increment,
  `name` varchar(64) unique not null,
  `image_src` varchar(255) default null
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for second_level_category
-- ----------------------------
drop table if exists `second_level_category`;
create table `second_level_category` (
  `id` int not null primary key auto_increment,
  `parent_id` int,
  `name` varchar(64) not null,
  `image_src` varchar(255) default null,
  foreign key (`parent_id`) references `first_level_category`(`id`)
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for third_level_category
-- ----------------------------
drop table if exists `third_level_category`;
create table `third_level_category` (
  `id` int not null primary key auto_increment,
  `parent_id` int,
  `name` varchar(64) not null,
  `image_src` varchar(255) default null,
  foreign key (`parent_id`) references `second_level_category`(`id`)
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for product
-- ----------------------------
drop table if exists `product`;
create table `product` (
  `id` int not null primary key auto_increment,
  `name` varchar(255) not null,
  `title` varchar(255) default null,
  `count` int default null,
  `price` decimal(10, 2) default null,
  `sale_price` decimal(10, 2) not null,
  `create_date` datetime not null,
  `category_id` int not null,
  `is_enabled` tinyint(1) not null default '0',
  `score` int default null,
  `del` int default null,
  foreign key (`category_id`) references `third_level_category`(`id`)
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for property
-- ----------------------------
drop table if exists `property`;
create table `property` (
  `id` int not null primary key auto_increment,
  `name` varchar(64) not null,
  `category_id` int not null,
  foreign key (`category_id`) references `first_level_category`(`id`)
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for product_image
-- ----------------------------
drop table if exists `product_image`;
create table `product_image` (
  `id` int not null primary key auto_increment,
  `type` tinyint(1) unsigned not null,
  `src` varchar(255) not null,
  `product_id` int not null,
  index (`product_id`),
  foreign key (`product_id`) references `product` (`id`) on delete cascade
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for property_value
-- ----------------------------
drop table if exists `property_value`;
create table `property_value` (
  `product_id` int not null,
  `property_id` int not null,
  `value` varchar(255) not null,
  index (`product_id`),
  index (`property_id`),
  foreign key (`product_id`) references `product` (`id`) on delete cascade,
  foreign key (`property_id`) references `property` (`id`) on delete cascade
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for address
-- ----------------------------
drop table if exists `address`;
create table `address` (
  `area_id` char(6) primary key not null,
  `name` varchar(64) not null,
  `region_id` char(6) not null,
  foreign key (`region_id`) references `address` (`area_id`)
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for user
-- ----------------------------
drop table if exists `user`;
create table `user` (
  `id` int not null primary key auto_increment,
  `name` varchar(64) unique not null,
  `nickname` varchar(64) not null,
  `password` varchar(255) not null,
  `status` int default null,
  `realname` varchar(64) default null,
  `gender` tinyint(1) not null,
  `birthday` date not null,
  `address` char(6) not null,
  `homeplace` char(6) not null,
  `profile_picture_src` varchar(255) default null,
  `phone` varchar(32) default null,
  index (`address`),
  index (`homeplace`),
  foreign key (`address`) references `address` (`area_id`),
  foreign key (`homeplace`) references `address` (`area_id`)
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for user_address
-- ----------------------------
drop table if exists `user_address`;
create table `user_address` (
  `user_id` int not null,
  `area_id` char(6) not null,
  `detail_address` varchar(255) not null,
  index (`user_id`),
  index (`area_id`),
  foreign key (`user_id`) references `user` (`id`),
  foreign key (`area_id`) references `address` (`area_id`)
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for advertisement_category
-- ----------------------------
drop table if exists `advertisement_category`;
create table `advertisement_category` (
  `id` int not null primary key auto_increment comment '类目id',
  `name` varchar(64) default null comment '分类名称',
  `del` int default null
) engine = innodb default charset = utf8mb4 comment = '内容分类';
-- ----------------------------
-- table structure for advertisement
-- ----------------------------
drop table if exists `advertisement`;
create table `advertisement` (
  `id` int not null primary key auto_increment,
  `category_id` int not null comment '内容类目id',
  `title` varchar(200) default null comment '内容标题',
  `url` varchar(255) default null comment '链接',
  `pic` varchar(255) default null comment '图片绝对路径',
  `status` varchar(1) default null comment '状态',
  `order` int default null comment '排序',
  `del` int default null,
  index (`category_id`),
  foreign key (`category_id`) references `advertisement_category`(`id`)
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------
-- ----------------------------
-- table structure for product_order
-- ----------------------------
drop table if exists `product_order`;
create table `product_order` (
  `id` int not null primary key auto_increment,
  `code` varchar(32) unique not null,
  `address` char(6) not null,
  `detail_address` varchar(255) not null,
  `post` char(6) default null,
  `receiver` varchar(20) not null,
  `phone` varchar(32) not null,
  `create_date` datetime default null,
  `pay_date` datetime default null,
  `delivery_date` datetime default null,
  `confirm_date` datetime default null,
  `status` tinyint(1) not null,
  `user_id` int not null,
  index (`address`),
  index (`id`),
  foreign key (`address`) references `address` (`area_id`),
  foreign key (`user_id`) references `user` (`id`) on delete cascade
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for product_order_item
-- ----------------------------
drop table if exists `product_order_item`;
create table `product_order_item` (
  `id` int not null primary key auto_increment,
  `count` int unsigned not null,
  `price` decimal(10, 2) not null,
  `product_id` int not null,
  `order_id` int default null,
  `user_id` int not null,
  `message` varchar(255) default null,
  index (`product_id`),
  index (`order_id`),
  index (`id`),
  foreign key (`product_id`) references `product` (`id`),
  foreign key (`order_id`) references `product_order` (`id`) on delete cascade,
  foreign key (`user_id`) references `user` (`id`)
) engine = innodb default charset = utf8mb4;
-- ----------------------------
-- table structure for review
-- ----------------------------
drop table if exists `review`;
create table `review` (
  `id` int not null primary key auto_increment,
  `content` text not null,
  `create_date` datetime not null,
  `user_id` int not null,
  `product_id` int not null,
  `order_item_id` int not null,
  index (`id`),
  index (`product_id`),
  index (`order_item_id`),
  foreign key (`user_id`) references `user` (`id`),
  foreign key (`product_id`) references `product` (`id`),
  foreign key (`order_item_id`) references `product_order_item` (`id`)
) engine = innodb default charset = utf8mb4;
-- -----------------------------------------------------------------------------