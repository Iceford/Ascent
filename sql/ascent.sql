-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ascent
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `admin_shiro`
--
DROP DATABASE IF EXISTS ascent;
CREATE DATABASE ascent;
USE ascent;

DROP TABLE IF EXISTS `admin_shiro`;

/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_shiro`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `shiro_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名字',
    `shiro_cont` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限内容',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_shiro`
--

LOCK TABLES `admin_shiro` WRITE;
/*!40000 ALTER TABLE `admin_shiro`
    DISABLE KEYS */;
INSERT INTO `admin_shiro`
VALUES (1, '超级管理员', '增改删'),
       (2, '普通管理员', '增改');
/*!40000 ALTER TABLE `admin_shiro`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_users`
--

DROP TABLE IF EXISTS `admin_users`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_users`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `admin_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员昵称',
    `admin_user`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账户',
    `admin_pwd`   varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员密码',
    `admin_shiro` int                                                    DEFAULT NULL COMMENT '管理员权限',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `admin_shiro` (`admin_shiro`) USING BTREE,
    CONSTRAINT `admin_users_ibfk_1` FOREIGN KEY (`admin_shiro`) REFERENCES `admin_shiro` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_users`
--

LOCK TABLES `admin_users` WRITE;
/*!40000 ALTER TABLE `admin_users`
    DISABLE KEYS */;
INSERT INTO `admin_users`
VALUES (1, '超级管理员', 'SuperAdmin', 'SuperAdmin', 1),
       (2, '普通管理员', 'GeneralAdmin', 'GeneralAdmin', 2);
/*!40000 ALTER TABLE `admin_users`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `order_userid` int                                                    DEFAULT NULL COMMENT '用户id',
    `address`      text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '收货地址',
    `pay_type`     varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支付方式',
    `goods_name`   varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
    `goods_num`    int                                                    DEFAULT NULL COMMENT '数量',
    `goods_price`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品单价',
    `order_date`   varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下单时间',
    `order_succ`   int                                                    DEFAULT NULL COMMENT '是否成功付款',
    `order_counts` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总价',
    `order_code`   varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
    `order_state`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发货状态',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `users_id` (`order_userid`) USING BTREE,
    CONSTRAINT `users_id` FOREIGN KEY (`order_userid`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 123
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `orders`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rece_address`
--

DROP TABLE IF EXISTS `rece_address`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rece_address`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `recename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人姓名',
    `address`  varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细地址',
    `zipcode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮编',
    `iphone`   varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货手机号',
    `user_id`  int                                                    DEFAULT NULL COMMENT '该地址的所有者',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `address_id` (`user_id`) USING BTREE,
    CONSTRAINT `address_id` FOREIGN KEY (`user_id`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rece_address`
--

LOCK TABLES `rece_address` WRITE;
/*!40000 ALTER TABLE `rece_address`
    DISABLE KEYS */;
INSERT INTO `rece_address`
VALUES (11, NULL, NULL, NULL, NULL, 22);
/*!40000 ALTER TABLE `rece_address`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_cart`
--

DROP TABLE IF EXISTS `shop_cart`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_cart`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `goods_name`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
    `goods_unit`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品单位',
    `goods_price` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品单价',
    `goods_num`   int                                                    DEFAULT NULL COMMENT '商品数量',
    `users_id`    int                                                    DEFAULT NULL COMMENT '购物车用户id',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `usersid` (`users_id`) USING BTREE,
    CONSTRAINT `usersid` FOREIGN KEY (`users_id`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 72
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_cart`
--

LOCK TABLES `shop_cart` WRITE;
/*!40000 ALTER TABLE `shop_cart`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_cart`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_goods`
--

DROP TABLE IF EXISTS `shop_goods`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_goods`
(
    `id`            int                                                    NOT NULL AUTO_INCREMENT,
    `goods_name`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名字',
    `goods_unit`    varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单位',
    `goods_stock`   int                                                    DEFAULT NULL COMMENT '库存',
    `goods_price`   varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单价',
    `goods_present` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '商品简介',
    `goods_type`    int                                                    DEFAULT NULL COMMENT '种类',
    `goods_img`     varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `type_id` (`goods_type`) USING BTREE,
    CONSTRAINT `type_id` FOREIGN KEY (`goods_type`) REFERENCES `shop_type` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 68
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_goods`
--

LOCK TABLES `shop_goods` WRITE;
/*!40000 ALTER TABLE `shop_goods`
    DISABLE KEYS */;
INSERT INTO `shop_goods`
VALUES (1, '感康复方氨酚烷胺片', '12片/盒', 100, '16.00',
        '品牌名称:感康\n产品参数:\n\n产品名称:感康 复方氨酚烷胺片 12片...品牌: 感康批准文号: 国药准字H22026193套餐类型: 【感冒咳嗽 咽喉发炎】1盒本品+2盒蓝芩颗粒 【3盒常备装】感康复方氨酚烷胺片 12片/盒 【1盒标准装】感康复方氨酚烷胺片 12片/盒 1盒本品+可孚中号药箱 1盒本品+999口罩1只 1盒本品+鱼跃体温计YT306 【感冒咽痛】1盒本品+江中草珊瑚含片48片 【推荐装】本品1盒+美林退烧100ml 本品1盒 + 德众维C银翘片12片 【治感冒组合装】本品1盒+香雪板蓝根颗粒20袋 【感冒发热 咽喉肿痛】本品1盒 +丽珠抗病毒颗粒9g*20袋 【家庭常备】本品1盒+999感冒灵10g*9袋/盒*1盒装 【感冒发热 咽喉肿痛】本品1盒 +丽珠抗病毒颗粒9g*20袋 【家庭常备】本品1盒+以岭连花清瘟胶囊0.35g*24粒/盒*1盒生产企业: 吉林省吴太感康药业有限公司规格: 12片/盒类别: 复方制剂产品剂型: 片剂用法: 口服使用剂量: 成人一次1片,一日2次药品通用名: 复方氨酚烷胺片药品名称: 复方氨酚烷胺片有效期: 36个月药品分类: 非处方药非处方药类型: 甲类非处方药',
        1, '感康复方氨酚烷胺片.jpg'),
       (2, '汇仁肾宝片', '0.7g*63片*1瓶/盒', 125, '197.00',
        '品牌名称:汇仁\n产品参数:\n\n产品名称:汇仁 肾宝片 0.7g*63片*...品牌: 汇仁批准文号: 国药准字Z20080627套餐类型: 【轻度肾虚-气虚】肾宝片63片*2盒 约14天用量 精神不振 腰脚酸痛 【轻度肾虚 气虚】肾宝片63片*2盒 约14天用量 精神不振 腰脚酸痛 【重度肾虚-阳痿】63片*8盒 约56天用量 标本兼治 1盒【体验装】63片7天用量】药师推荐连服4盒起 4盒【中度肾虚】28天有效治疗恢复自信】 【搭配治疗】63片*4盒+汇仁六味地黄丸360丸*2盒 【阳痿早泄】63片*4盒+小奇灵五子衍宗丸30g*6盒 【轻度肾虚-气虚】肾宝片63片*2盒+多得同款肾宝片45片*1盒 【肾虚遗精】63片*4盒+太极锁阳固精丸10袋*6盒 【中度肾虚-早泄】63片*4盒 +汇仁肾宝合剂200ml*1盒 【轻度肾虚-气虚】肾宝片63片*2盒+多得复方鲜竹沥液*2盒 【中度肾虚-早泄】肾宝片63片*4盒 约28天用量 有效治疗 本品*4盒+龟鹿补肾丸12袋*5盒】补肾益气补血壮筋骨 【体验装】本品肾宝片63片*1盒 约7天用量生产企业: 江西汇仁药业股份有限公司规格: 0.7g*63片*1瓶/盒类别: 中药产品剂型: 片剂用法: 口服使用剂量: 一次3片,一日3次。药品通用名: 肾宝片药品名称: 肾宝片有效期: 36个月',
        1, '汇仁肾宝片.jpg'),
       (3, '太极藿香正气水藿香正气口服液', '10ml*18支/盒', 95, '49.80',
        '品牌名称:太极\n产品参数:\n\n产品名称:太极 藿香正气口服液 10ml...品牌: 太极批准文号: 国药准字Z50020409套餐类型: 1盒装10ml*18支/盒 【实惠大包装18支】1盒 【10盒共180支】团购优惠套装 【5盒共90支】家庭防暑实惠套装 【2盒共36支】个人防暑常备生产企业: 太极集团重庆涪陵制药厂有限公司规格: 10ml*18支/盒类别: 中药产品剂型: 口服液用法: 口服使用剂量: 一次5~10毫升,一日2次药品通用名: 藿香正气口服液药品名称: 藿香正气口服液有效期: 36个月 庞各庄镇四各庄村 ,每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓,草莓品种多样丰富,个大香甜。所有草莓均严格按照有机标准培育,不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘,也欢迎各大单位选购精品有机草莓礼盒,有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择',
        1, '藿香正气水.jpg'),
       (4, '京都念慈菴蜜炼川贝枇杷膏', '150ml/瓶', 124, '24.30 ',
        '品牌名称:京都念慈菴\n产品参数:\n\n产品名称:京都念慈菴 京都念慈菴蜜炼...品牌: 京都念慈菴批准文号: 医药产品注册证号ZC20160005套餐类型: 【1盒装】150ml 【3盒经济装】 【6盒特惠装】18天一个疗程 【清咽利喉】1盒原品+慢严舒柠清喉利咽颗粒45袋 【润喉搭配】1盒本品+京都念慈菴枇杷糖 2.5g/粒*18粒 【感冒止咳】3盒本品+999感冒灵颗粒9袋*3盒 【镇咳止痒】1盒本品+3盒慢严舒柠咽炎片30片 【1盒装150ml】 【感冒止咳 消炎化痰】1盒本品+葵花复方金银花颗粒10g*10袋*2生产企业: 京都念慈菴总厂有限公司规格: 150ml*1瓶/盒类别: 中药产品剂型: 口服液用法: 口服使用剂量: 成人每日三次,一次15ml药品通用名: 京都念慈菴蜜炼川贝枇杷膏药品名称: 京都念慈菴蜜炼川贝枇杷膏有效期: 36个月药品分类: 非处方药 庞各庄镇四各庄村 ,每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓,草莓品种多样丰富,个大香甜。所有草莓均严格按照有机标准培育,不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘,也欢迎各大单位选购精品有机草莓礼盒,有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择',
        1, '京都念慈庵蜜炼川贝枇杷膏.jpg'),
       (5, '美林布洛芬混悬液', '35ml/瓶', 123, '20.80',
        '品牌名称:美林\n产品参数:\n\n产品名称:美林 美林 布洛芬混悬液 3...品牌: 美林批准文号: 国药准字H20000359套餐类型: 【3盒疗程装】可用3天 1盒装生产企业: 上海强生制药有限公司规格: 35ml*1瓶/盒类别: 化学药产品剂型: 口服液用法: 口服使用剂量: 1-3岁一次4毫升;4-6岁一次5毫升药品通用名: 布洛芬混悬液药品商品名: 美林药品名称: 美林 布洛芬混悬液有效期: 暂定36个月药品分类: 非处方药非处方药类型: 甲类非处方药',
        1, '美林布洛芬混悬液.jpg'),
       (6, '仁和氧氟沙星滴耳液', '10ml*1支/盒', 110, '12.00',
        '品牌名称:仁和\n产品参数:\n\n产品名称:仁和 氧氟沙星滴耳液 10ml...品牌: 仁和批准文号: 国药准字H20083321套餐类型: 2盒装 4盒装 1盒装生产企业: 武汉诺安药业有限公司产品剂型: 滴耳剂用法: 滴耳使用剂量: 一次6~10滴,一日2次药品通用名: 氧氟沙星滴耳液药品名称: 氧氟沙星滴耳液有效期: 24个月适用人群: 不限药品类别: 化学药药品分类: 处方药疾病: 外耳炎 耳内炎症 中耳炎 外耳道炎 耳膜炎症状: 中耳炎 外耳道炎 耳肿疼痛药品规格: 10ml*1支/盒',
        1, '仁和氧氟沙星滴耳液.jpg'),
       (7, 'vc汤臣倍健维生素c咀嚼片', ' 600mg/片*120片*2瓶装', 110, '139.00',
        '品牌名称:BY-HEALTH/汤臣倍健\n产品参数:\n\n生产许可证编号:SC12744040400094厂名:汤臣倍健股份有限公司厂址:珠海市金湾区三灶科技工业园星汉路17、19号厂家联系方式:4006869797保质期:730 天品牌: BY-HEALTH/汤臣倍健系列: 维生素C省份: 广东城市: 广州产地: 中国大陆地区适用性别: 男女通用颜色分类: vc120片*2瓶 120片*2瓶 【买1送1共2瓶】2瓶装 【CE同补-礼袋装】维C120片+mini维E100粒 维生素C30片装【秒杀装】保质期: 24个月生产企业: 汤臣倍健股份有限公司产品剂型: 片剂规格(粒/袋/ml/g): 600mg/片*120片*2瓶套餐计价单位: 瓶适用人群: 成人保健食品批准证号: 国食健字G20160085是否保健食品(国食健字号): 是产品名称:维生素C片(橘子味)功能:补充维生素C功效成分/标志性成分含量:每片含:维生素C 100mg不适宜人群:婴幼儿、少年儿童、孕妇、乳母主要原料:维生素C(L-抗坏血酸)、抗坏血酸钠、白砂糖、淀粉、橘子果汁粉(橘子浓缩汁、糊精、β-胡萝卜素、橘子香料)、硬脂酸镁、甜橙香精、三氯蔗糖、薄膜包衣剂(羟丙基甲基纤维素、二氧化钛、滑石粉、三乙酸甘油酯、柠檬黄铝色淀、胭脂红铝色淀)批准文号:国食健字G20160085',
        2, 'vc汤臣倍健维生素c咀嚼片.jpg'),
       (8, '澳洲bio island孕妇专用dha海藻油备孕孕期哺乳期黄金营养品', '60粒/瓶', 25, '238.00',
        '品牌名称:bio island\n产品参数:\n\n厂名:JBX Pty Ltd厂址:22/252 New Line Road,Dural NSW 2158 Austrialia厂家联系方式:400保质期:1095 天品牌: bio island产地: 澳大利亚包装种类: 罐装货号: DHA储存条件: 常温',
        2, '澳洲孕妇专用dha海藻油.jpg'),
       (9, '蛋白粉营养中老年人乳清蛋白质', '400g/罐', 110, '69.00',
        '品牌名称:仁和\n产品参数:\n\n生产许可证编号:SC10636098210852厂名:江西金衡康生物科技有限公司厂址:江西省樟树市药都医药工业园泰欣大道1号厂家联系方式:400-881-8196保质期:730 天品牌: 仁和系列: 益生菌蛋白粉省份: 江西城市: 南昌产地: 中国大陆地区适用性别: 男女通用口味: 原味颜色分类: 推荐三罐装(400g/罐) 划算两罐装(400g/罐) 尝鲜一罐装(400g/罐)保质期: 24个月生产企业: 江西金衡康生物科技有限公司产品剂型: 粉剂规格(粒/袋/ml/g): 400g/罐计价单位: 罐适用人群: 成人是否保健食品(国食健字号): 否',
        2, '蛋白粉营养中老年人乳清蛋白质.jpg'),
       (10, '钙尔奇钙片', '0.6g*60片*1瓶/盒', 110, '66.90',
        '品牌名称:CALTRATE/钙尔奇\n产品参数:\n\n产品名称:CALTRATE/钙尔奇 碳酸钙D...品牌: CALTRATE/钙尔奇批准文号: 国药准字H10950029套餐类型: 【成人/孕妇钙】60片*3丨促销装 1盒装生产企业: 惠氏制药有限公司规格: 0.6g*60片*1瓶/盒类别: 化学药产品剂型: 片剂用法: 口服使用剂量: 一次1片,一日1-2次药品通用名: 碳酸钙D3片药品名称: 碳酸钙D3片有效期: 36个月药品分类: 非处方药',
        2, '钙尔奇钙片60片碳酸钙维D3孕妇成人补钙.jpg'),
       (11, '康王复方酮康唑发用洗剂', '100ml*1瓶/盒', 110, '67.00',
        '品牌名称:康王\n产品参数:\n\n产品名称:康王 复方酮康唑发用洗剂 ...品牌: 康王批准文号: 国药准字H53021775套餐类型: 2盒装 3盒装 5盒装 1盒装生产企业: 滇虹药业集团股份有限公司产品剂型: 洗剂用法: 皮肤外用使用剂量: 取本品约5毫升,涂于患处或已湿润的头发上,详见说明书药品通用名: 复方酮康唑发用洗剂药品名称: 复方酮康唑发用洗剂有效期: 24个月适用人群: 成人药品类别: 化学药药品分类: 处方药疾病: 花斑癣症状: 脱屑 瘙痒药品规格: 100ml*1瓶/盒',
        2, '康王复方酮康唑发用洗剂.jpg'),
       (12, '天草丹参保心茶', '2.5g*180袋/盒', 110, '558.00',
        '品牌名称:天草\n产品参数:\n\n产品名称:天草 丹参保心茶 2.5g*1...品牌: 天草批准文号: 国药准字B20040008套餐类型: 【疗程装】丹参保心茶180袋*1盒 建议2盒1疗程 1盒装 【标准装】丹参保心茶180袋*1盒 建议2盒1疗程 【标准装】丹参保心茶180袋*1盒 2盒1疗程 【新包装】丹参保心茶150袋*1盒生产企业: 大兴安岭天草药业有限公司规格: 2.5g*180袋/盒类别: 茶剂产品剂型: 茶剂用法: 开水泡服使用剂量: 一次1袋,一日三次药品通用名: 丹参保心茶药品名称: 丹参保心茶有效期: 36个月药品分类: 非处方药贮藏: 密闭,防潮。',
        2, '天草丹参保心茶.jpg'),
       (13, '北京同仁堂阿胶块', '31.25g*8块/盒', 123, '399.00',
        '品牌名称:同仁堂\n产品参数:\n\n产品名称:同仁堂 阿胶 31.25g*8块...品牌: 同仁堂批准文号: 国药准字Z11020696套餐类型: 【补血滋阴,润燥止血】北京同仁堂出品250g铁盒 【北京同仁堂出品】250g铁盒装 【滋阴补血】本品1盒+生脉饮(党参方)10支*6盒 【补血调经】本品1盒+思齐堂四物膏250g/瓶 【气血双补】同仁堂阿胶250g+好好黄芪颗粒4g*30袋生产企业: 北京同仁堂(唐山)营养保健品有限公司规格: 31.25g*8块/盒类别: 中药产品剂型: 胶剂用法: 口服使用剂量: 烊化兑服。3~9克。(详见参考服用方法)药品通用名: 阿胶药品名称: 阿胶有效期: 60个月药品分类: 非处方药',
        3, '北京同仁堂阿胶块.jpg'),
       (14, '碧生源减肥茶', '2.5g/袋*20袋/盒*2盒', 123, '136.00',
        '品牌名称:碧生源\n产品参数:\n\n厂名:北京澳特舒尔保健品开发有限公司厂址:北京市房山区窦店镇秋实工业小区1号厂家联系方式:400-686-9299保质期:730 天产品名称:碧生源牌纤纤茶 2.5g/袋...品牌: 碧生源批准文号: 国食健字G20110711具体规格: 2.5g/袋*20袋/盒*2盒是否进口: 否产品剂型: 袋泡茶保健食品产品名称: 碧生源牌纤纤茶是否礼盒装: 否食用方法和食用量:每日2次,每次1袋,饭后半小时,用200-300ml开水冲泡5-10分钟后趁热饮用,一次饮完即可注意事项:本品为保健食品,不能代替药物使用；食用本品出现腹泻者,请立即停止食用产品名称:碧生源牌纤纤茶功能:减肥申请人中文名称:北京澳特舒尔保健品开发有限公司功效成分/标志性成分含量:每100g含:茶多酚 3.0g、总蒽醌 0.6g不适宜人群:少年儿童、孕妇、乳母、慢性腹泻者适宜人群:单纯性肥胖人群贮藏方法:贮存于阴凉干燥处主要原料:番泻叶、绿茶、决明子、荷叶、泽泻批准文号:国食健字G20110711',
        3, '碧生源减肥茶.jpg'),
       (15, '南京同仁堂冬虫夏草', '0.25克/根-40根共10克', 123, '1580.00',
        '品牌名称:六和乾坤\n产品参数:\n\n厂名:安徽忠瑜堂生物科技有限公司厂址:安徽省毫州市谯城区经济开发区科技路199号2号楼厂家联系方式:4000250200保质期:540 天品牌: 六和乾坤系列: 冬虫夏草规格: 10g产地: 中国大陆省份: 湖北省城市: 宜昌市套餐类型: 0.25克/根-40根共10克 头期虫草包装方式: 包装净含量: 10g',
        3, '南京同仁堂冬虫夏草.jpg'),
       (16, '南京同仁堂黄芪片中草药材', '250g', 123, '39.90',
        '品牌名称:放鹤洲\n产品参数:\n\n厂名:云南七洲实业有限公司厂址:云南省昆明阳宗海风景名胜区七甸产业园区小哨箐片区哨望路8号生产加工基地物流项目9幢3层车间厂家联系方式:400-0099-059保质期:730 天品牌: 放鹤洲系列: 放鹤洲规格: 250g产地: 中国大陆省份: 甘肃省城市: 兰州市包装方式: 包装净含量: 250g',
        3, '南京同仁堂黄芪片中草药材.jpg'),
       (17, '杞里香宁夏特红级枸杞', '500g', 152, '39.90',
        '品牌名称:杞里香\n产品参数:\n\n生产许可证编号:SC11464010500672厂名:银川杞里香商贸有限公司厂址:宁夏回族自治区银川市西夏区厂家联系方式:400-870-0951保质期:365 天品牌: 杞里香系列: 黑罐宁夏枸杞规格: 500g产地: 中国大陆省份: 宁夏回族自治区城市: 银川市净含量: 500g包装方式: 包装储存条件: 常温',
        3, '杞里香宁夏特红级枸杞.jpg'),
       (18, '同济堂仙灵骨葆胶囊', '0.5g*50粒/盒', 152, '28.00',
        '品牌名称:同济堂\n产品参数:\n\n产品名称:同济堂 仙灵骨葆胶囊 0.5...品牌: 同济堂批准文号: 国药准字Z20025337套餐类型: 2盒装 3盒装 5盒装 4盒装 1盒装生产企业: 国药集团同济堂(贵州)制药有限公司产品剂型: 胶囊用法: 口服使用剂量: 一次3粒,一日2次药品通用名: 仙灵骨葆胶囊药品名称: 仙灵骨葆胶囊有效期: 36个月适用人群: 成人药品类别: 中药药品分类: 处方药疾病: 骨关节炎 骨质疏松症状: 骨折药品规格: 0.5g*50粒/盒',
        3, '同济堂仙灵骨葆胶囊.jpg'),
       (19, '韩国Comotomo可么多么奶瓶', '150ml*2个', 152, '265.00',
        '品牌名称:COMO TOMO\n产品参数:\n\n品牌: COMO TOMO系列: 150ml*2个适用年龄: 新生 1个月 2个月 3个月 4个月 5个月 6个月 7个月 8个月 9个月 10个月 11个月 10-12个月 12-24个月 30个月 24-36个月 3岁材质: PPSU产地: 韩国颜色分类: 草绿色 粉红色奶瓶是否带柄: 否口径大小: 宽口径容量: 150mL',
        4, '韩国Comotomo可么多么奶瓶.jpg'),
       (20, '秝客75度酒精湿巾卫生湿纸巾', '50抽/包', 152, '12.80',
        '品牌名称:lefeke\n产品参数:\n\n品牌: lefeke产地: 德州颜色分类: 75%酒精湿巾 1包体验装 酒精消毒湿巾50抽 买2发3 共3包 酒精消毒湿巾50抽 买3发5 共5包 酒精消毒湿巾50抽 买6发10 共10包 无醇免洗手消毒凝胶 买2发3 共3包 无醇免洗手消毒凝胶 买3发5 共5包 无醇免洗手消毒凝胶 买6发10 共10包规格: 3包生产企业: 唐派医疗有限公司适用人群: 成人保健用品产品名称: 酒精湿巾消字号: 鲁卫消证字(2020)第1350号',
        4, '秝客75度酒精湿巾卫生湿纸巾.jpg'),
       (21, '强生婴儿爽身粉', '140g/盒', 152, '15.90',
        '品牌:Johnson’s baby/强生婴儿系列(型号):爽身粉容量:140g\n适用年龄:新生 9个月 18个月产地:中国大陆化妆品备案编号/注册证号:沪G妆网备字2019011789\n百货品类:爽身粉/粉扑是否为特殊用途化妆品:否\n',
        4, '强生婴儿爽身粉.jpg'),
       (22, '日本MamaKids 婴儿泡沬洁肤液保湿沐浴', '460ml', 152, '198.00',
        '品牌名称:Mama&Kids\n产品参数:\n\n品牌: Mama&Kids系列(型号): 婴儿护理容量: 460ml适用年龄: 新生 1个月 2个月 3个月 4个月 5个月 6个月 7个月 8个月 9个月 10个月 11个月 12个月 13个月 14个月 15个月 16个月 17个月 18个月 19个月 20个月 21个月 22个月 23个月 2岁 25个月 26个月 27个月 28个月 29个月 30个月 31个月 32个月 33个月 34个月 35个月 3岁 4岁 5岁 6岁产地: 日本颜色分类: 橄榄精华百货品类: 沐浴露是否为特殊用途化妆品: 否净含量: 460ml',
        4, '婴儿泡沬洁肤液保湿沐浴露.jpg'),
       (23, '斯利安叶酸', '0.4mg*31片/盒', 152, '28.00',
        '品牌名称:Scrianen/斯利安\n产品参数:\n\n产品名称:Scrianen/斯利安 斯利安 ...品牌: Scrianen/斯利安批准文号: 国药准字H10970079套餐类型: 3盒装31片*3盒 1盒装31片 【31片*3】备孕孕期补充叶酸 独立三盒包装 每盒1个月 【31片】备孕夫妻出行单盒小包装 1盒装31片+21金维他 30片 夫妻备孕1月量|1盒31片+1盒男叶酸 【31片*6】超值备孕礼包 下单发8盒 夫妻同补 可服用4个月 1月量|1盒31片+1盒dha 1月量|1盒31片+2盒有机钙 孕期营养1月量|1盒31片+2盒有机钙+1瓶dha 【31片*6】超值备孕装 夫妻同补可服用3个月 【31片*3】备孕孕期补充叶酸 独立三盒包装 每盒1个月 【31片】备孕夫妻出行单盒小包装 【31片*6】超值备孕礼包 下单发8盒 夫妻同补 可服用4个月生产企业: 北京斯利安药业有限公司规格: 0.4mg*31片/盒类别: 化学药产品剂型: 片剂用法: 口服使用剂量: 一次0.4毫克,一日1次,详见说明书药品通用名: 叶酸片药品商品名: 斯利安药品名称: 斯利安 叶酸片有效期: 36个月药品分类: 非处方药非处方药类型: 甲类非处方药',
        4, '斯利安叶酸31片孕妇叶酸.jpg'),
       (24, '修正洗眼液', '260ml/瓶', 152, '29.00',
        '品牌名称:修正\n产品参数:\n\n品牌: 修正颜色分类: 一瓶体验装【260ML】 买2送1 三瓶日用装【260ML*3】 买3送2 五瓶囤货装【260ML*5】生产企业: 陕西恩倍唐生物科技有限公司',
        4, '修正洗眼液.jpg'),
       (27, '水仙牌太平风油精', '6ml*1瓶/盒', 152, '6.80',
        '品牌名称:太平\n产品参数:\n\n产品名称:太平 风油精 6ml*1瓶/盒品牌: 太平批准文号: 国药准字Z35020456套餐类型: 本品5盒【家庭装】 本品8盒【多盒实惠装】 本品1盒【方便携带装】规格: 6ml*1瓶/盒生产企业: 福建太平洋制药有限公司产品剂型: 外用液体剂用法: 皮肤外用使用剂量: 外用,涂擦于患处药品通用名: 风油精药品名称: 风油精有效期: 36个月药品类别: 中药药品分类: 非处方药',
        5, '水仙牌风油精.jpg'),
       (28, '漱口水', '200ml/瓶/盒', 152, '25.00',
        '品牌名称:洛芙\n产品参数:\n\n产品名称:洛芙 复方氯己定含漱液 20...品牌: 洛芙批准文号: 国药准字H32026694套餐类型: 【1瓶试用装*200ml/瓶】 -口腔溃疡/牙龈出血 【2瓶疗程装*200ml/瓶】 -牙龈肿痛/口腔异味 【3瓶钜惠装*200ml/瓶】 -牙周炎症/正畸护理 【口腔溃疡】本品200ml*1瓶(含漱)+信龙碘甘油20ml*2(涂) 【日常护理】本品200ml*1+质蕴清爽漱口水85ml*2生产企业: 江苏知原药业股份有限公司规格: 200ml*1瓶/盒类别: 化学药产品剂型: 含漱液用法: 详见说明书使用剂量: 详见说明书药品通用名: 复方氯己定含漱液药品名称: 复方氯己定含漱液有效期: 24个月',
        5, '漱口水.jpg'),
       (29, '医洛油黄道益活洛油原装', '50ml/瓶/盒', 152, '68.00',
        '品牌名称:医洛油\n产品参数:\n\n型号: 50ml品牌: 医洛油尺码: L产地: 贵州颜色分类: 标准装 50ml1207 25ml1207 50ml 25ml 50ml活洛油×2瓶护具种类: 祛风止痛生产企业: 贵州黄道益医药科技有限公司增值服务: 正品保障适用人群: 成人保健用品产品名称: 活络油',
        5, '医洛油黄道益活洛油原装.jpg'),
       (30, '医用碘伏棉棒', '50支/盒', 152, '12.80',
        '品牌名称:可孚\n产品参数:\n\n型号: 50支/盒品牌: 可孚产地: 湖南颜色分类: 0906【碘伏+棉签二合为一】 1盒50只(双头8cm) 1207【碘伏+棉签二合为一】 1盒50只(双头8cm) 【碘伏+棉签合二为一】 1盒50只(双头8cm) 【酒精+棉签合二为一】1盒50支(双头8cm) 0527碘伏棉签3盒,共150支 0527酒精棉签3盒,共150支 0527碘伏棉签2盒加酒精棉签1盒,共3盒 0527酒精棉签2盒加碘伏棉签1盒,共3盒 碘伏棉签3盒(共150支) 酒精棉签3盒(共150支) 碘伏棉签2盒+酒精棉签1盒(共3盒,150支) 酒精棉签2盒+碘伏棉签1盒(共3盒,150支) 碘伏+棉签二合为一】 1盒50只(双头8cm)生产企业: 可孚医疗科技股份有限公司执行标准号: 湘械注准20192140881增值服务: 无适用人群: 不限疾病: 碘伏棉签症状: 碘伏棉签注册证号: 湘械注准20192140881医疗器械产品名称: 可孚碘伏棉签棉签棉球种类: 碘伏棉签',
        5, '医用碘伏棉棒.jpg'),
       (31, '电子红外线测体温度计', '1支', 152, '39.90',
        '品牌名称:卓辰\n产品参数:\n\n型号: IM-9001品牌: 卓辰产地: 惠州颜色分类: 【经典款】双模式测温. 【高配款】智能双测温+语音播报+进口晶源. 【基础款】一键测量 【经典款】双模式测温 【高配款】智能双测温+语音播报+进口晶源 【超值经典款】50只口罩+双模式测温 【超值高配款】50只口罩+语音播报+智能双测温+进口晶源批准文号: 粤械注准20202071341测量部位: 口温 额温 耳温 腋温 肛温生产企业: 惠州安博臣科技有限公司是否为进口: 否执行标准号: 粤械注准20202071341体温计类型: 额温枪适用人群: 不限 儿童 成人疾病: 风热感冒 风寒感冒 上呼吸道感染 流行性感冒 病毒性感冒症状: 发热 头痛 鼻塞 头晕 流涕 发冷 恶寒选购热点: 非接触式 婴儿/儿童专用 女性测排卵备孕医疗器械产品名称: 红外额温计智能类型: 不支持智能',
        6, '电子红外线测体温度计.jpg'),
       (32, '海氏海诺医用脱脂纱布绷带卷家用', '6*600cm*2卷', 152, '7.90',
        '品牌名称:海氏海诺\n产品参数:\n\n型号: 6*600cm品牌: 海氏海诺产地: 山东青岛颜色分类: 无菌纱布绷带6*600CM 6*600CM规格(2卷装)赠医用胶带2*300CM1盒 6*600CM规格买2发3(共6卷)赠医用胶带2*300CM2盒 6*600CM规格买3发5(共10卷)赠医用胶带2*300CM3盒生产企业: 青岛海诺生物工程有限公司执行标准号: 鲁青械备20150027号增值服务: 正品保障适用人群: 不限疾病: 包扎症状: 包扎注册证号: 鲁青械备20150027号医疗器械产品名称: 纱布绷带纱布绷带种类: 医用绷带 纱布绷带尺寸: 6x600cm',
        6, '海氏海诺医用脱脂纱布绷带.jpg'),
       (33, '衡互邦手动轮椅', '1辆', 152, '438.00',
        '品牌名称:衡互邦\n产品参数:\n\n型号: LY-L21品牌: 衡互邦材质: 钢产地: 河北颜色分类: 一辆 灰色蜂网可拆洗双坐垫+便桶 经典小轮款 基础软座款 黑色牛津布款-送便盆 黑色牛津布款-送便盆+凝胶凉垫 黑色牛津布款-送便盆+背兜 黑色牛津布款-送便盆+车筐 蜂网布可拆洗双坐垫-送便桶 蜂网布可拆洗双坐垫-送便桶+凝胶凉垫 蜂网布可拆洗双坐垫-送便桶+背兜 蜂网布可拆洗双坐垫-送便桶+车筐 蜂网布半躺款-送便桶 蜂网布半躺款-送便桶+凝胶凉垫 蜂网布半躺款-送便桶+背兜 蜂网布半躺款-送便桶+车筐 蜂网布全躺款-送便桶 蜂网布全躺款-送便桶+凝胶凉垫 蜂网布全躺款-送便桶+背兜 蜂网布全躺款-送便桶+车筐 升级液压款-送便桶(铝合金轮毂) 升级液压款-送便桶+凝胶坐垫(铝合金轮毂) 升级液压款-送便桶+背兜(铝合金轮毂) 升级液压款-送便桶+车筐(铝合金轮毂)生产企业: 衡水斯瑞医疗器械有限公司执行标准号: GB/T13800-2009附加功能: 带手刹增值服务: 正品保障适用人群: 不限疾病: 下肢残疾 偏瘫 截瘫 摔伤 骨折牵引症状: 无法站立注册证号: 冀食药监械生产许20170015号选购热点: 加厚坐垫 加宽轮椅 大轮稳固医疗器械产品名称: 轮椅+带坐便轮椅种类: 普通轮椅',
        6, '老人手动轮椅.jpg'),
       (34, '欧格斯制氧机家用', '1台', 152, '2080.00',
        '品牌名称:欧格斯\n产品参数:\n\n型号: OZ-3-08UW0/OZ-3-08GW0品牌: 欧格斯产地: 广东广州颜色分类: 院线同款-72小时持续供氧 医用3L【轻音舒适+增配雾化】送吸氧好礼+管路消毒宝 医用3L【轻音舒适+增配雾化】送吸氧好礼生产企业: 广东欧格斯科技有限公司执行标准号: 粤械注准 20172080401增值服务: 正品保障适用人群: 不限注册证号: 粤械注准20172080401选购热点: 静音型 雾化型 3L机 氧浓度监测型 带计时功能医疗器械产品名称: 制氧机制氧机类别: 医用级制氧机',
        6, '欧格斯制氧机.jpg'),
       (35, '欧姆龙家用中频治疗仪', '1台', 152, '1390.00',
        '品牌名称:Omron/欧姆龙\n产品参数:\n\n型号: HV-F2200品牌: Omron/欧姆龙产地: 成都颜色分类: 欧姆龙中频治疗器F2200(6种透热理疗)保健理疗: 经络理疗仪 多功能理疗仪 颈腰椎理疗仪 频谱理疗仪生产企业: 四川千里倍益康医疗科技股份有限公司执行标准号: 川械注准20202090126增值服务: 无理疗方式分类: 生物电疗适用人群: 成人疾病: 遵循医嘱症状: 遵循医嘱注册证号: 川械注准20202090126医疗器械产品名称: 中频治疗器',
        6, '欧姆龙家用中频治疗仪.jpg'),
       (36, '欧姆龙血压测量仪家用', '1台', 152, '209.00',
        '品牌名称:Omron/欧姆龙\n产品参数:\n\n型号: U10、U10K品牌: Omron/欧姆龙功能: 测量血压产地: 大连颜色分类: U726J|语音款+2年全国联保+终身维修 血压计+2年全国联保+4节5号电池+终身维修 U726J|语音款+稳压电源+2年全国联保+终身维修 血压计 +血压计稳压电源+2年全国联保+4节5号电池+终身维修 蓝色 透明适用部位: 上臂生产企业: 欧姆龙(大连)有限公司执行标准号: 辽械注准20172230070增值服务: 正品保障血压仪器种类: 电子血压计适用人群: 不限疾病: 高血压症状: 血压高注册证号: 辽械注准20162070146选购热点: 全自动 屏幕大医疗器械产品名称: 电子血压计 上臂式',
        6, '欧姆龙血压测量仪家用.jpg'),
       (66, '医用酒精喷雾消毒水消毒液', '500ml*3瓶', 100, '41.90',
        '品牌名称:初医生\r\n产品参数:\r\n\r\n品牌: 初医生产地: 安徽省毫州市颜色分类: 300ml医用酒精消毒液 75%医用酒精500ml*1瓶(赠300ml) 75%医用酒精500ml*3瓶(赠100ml) 75%医用酒精500ml*5瓶(赠100ml) 75%医用酒精300ml*5瓶(赠100ml) 75%医用酒精2500ml*1瓶(赠500ml)规格: 300ml生产企业: 安徽省致名堂生物科技有限公司适用人群: 不限保健用品产品名称: 医用酒精消毒液消字号: 皖卫消证字【2020】第S0058号',
        5, '医用酒精喷雾消毒水消毒液.jpg'),
       (67, '美宝湿润烧伤膏', '20g*1支/盒', 100, '43.00',
        '品牌名称:MEBO/美宝\r\n产品参数:\r\n\r\n产品名称:MEBO/美宝 20g*1支/盒 ...品牌: MEBO/美宝批准文号: 国药准字Z20000004套餐类型: 2盒装 1盒装生产企业: 汕头市美宝制药有限公司产品剂型: 软膏剂用法: 皮肤外用使用剂量: 详见说明书药品通用名: 湿润烧伤膏药品名称: 湿润烧伤膏有效期: 36个月适用人群: 不限药品类别: 中药药品分类: 处方药疾病: 烧伤 烫伤 灼伤症状: 烧伤药品规格: 20g*1支/盒',
        5, '美宝湿润烧伤膏.jpg');
/*!40000 ALTER TABLE `shop_goods`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_type`
--

DROP TABLE IF EXISTS `shop_type`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_type`
(
    `id`        int NOT NULL AUTO_INCREMENT,
    `type_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品种类',
    `date`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 18
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_type`
--

LOCK TABLES `shop_type` WRITE;
/*!40000 ALTER TABLE `shop_type`
    DISABLE KEYS */;
INSERT INTO `shop_type`
VALUES (1, '中西药品', '2019-08-07'),
       (2, '人群健康', '2019-08-07'),
       (3, '滋补调养', '2019-08-07'),
       (4, '母婴孕产', '2019-08-07'),
       (5, '居家生活', '2019-08-07'),
       (6, '医疗器械', '2019-08-07');
/*!40000 ALTER TABLE `shop_type`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_user`
(
    `id`          int                                                    NOT NULL AUTO_INCREMENT,
    `users`       varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    `password`    varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '密码',
    `email`       varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '邮箱',
    `iphone`      varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '手机号',
    `address`     varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '地址',
    `is_pay_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 23
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user`
--

LOCK TABLES `shop_user` WRITE;
/*!40000 ALTER TABLE `shop_user`
    DISABLE KEYS */;
INSERT INTO `shop_user`
VALUES (1, 'user', 'user', 'user@ascent.com', NULL, NULL, NULL);
/*!40000 ALTER TABLE `shop_user`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-11-15 20:44:48
