-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ascent
-- ------------------------------------------------------
-- Server version	8.0.28

DROP DATABASE IF EXISTS ascent;
CREATE DATABASE ascent;
USE ascent;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_shiro`
--

DROP TABLE IF EXISTS `admin_shiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_shiro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shiro_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `shiro_cont` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_shiro`
--

LOCK TABLES `admin_shiro` WRITE;
/*!40000 ALTER TABLE `admin_shiro` DISABLE KEYS */;
INSERT INTO `admin_shiro` VALUES (1,'超级管理员','增改删'),(2,'普通管理员','增改');
/*!40000 ALTER TABLE `admin_shiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_users`
--

DROP TABLE IF EXISTS `admin_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员昵称',
  `admin_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账户',
  `admin_pwd` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员密码',
  `admin_shiro` int DEFAULT NULL COMMENT '管理员权限',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `admin_shiro` (`admin_shiro`) USING BTREE,
  CONSTRAINT `admin_users_ibfk_1` FOREIGN KEY (`admin_shiro`) REFERENCES `admin_shiro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_users`
--

LOCK TABLES `admin_users` WRITE;
/*!40000 ALTER TABLE `admin_users` DISABLE KEYS */;
INSERT INTO `admin_users` VALUES (1,'超级管理员','SuperAdmin','SuperAdmin',1),(2,'普通管理员','GeneralAdmin','GeneralAdmin',2);
/*!40000 ALTER TABLE `admin_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_userid` int DEFAULT NULL COMMENT '用户ID',
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '收货地址',
  `pay_type` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支付方式',
  `goods_name` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `goods_num` int DEFAULT NULL COMMENT '商品数量',
  `goods_price` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品单价',
  `order_date` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下单时间',
  `order_succ` int DEFAULT NULL COMMENT '是否成功付款',
  `order_counts` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总价',
  `order_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
  `order_state` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发货状态',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `users_id` (`order_userid`) USING BTREE,
  CONSTRAINT `users_id` FOREIGN KEY (`order_userid`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (123,23,'广东省深圳市坪山区石井街道深圳技术大学  (WhimsyQuester 收)18888888888','货到付款','医洛油黄道益活洛油原装',2,'68.00','2023-11-26 06:13:51',1,'136.00','33298700','查物流'),(124,23,'广东省深圳市坪山区石井街道深圳技术大学  （WhimsyQuester 收）18888888888','支付宝支付','太极藿香正气水藿香正气口服液',1,'49.80','2023-11-26 06:28:13',1,'49.80','56810833','未发货');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rece_address`
--

DROP TABLE IF EXISTS `rece_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rece_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人姓名',
  `address` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细地址',
  `zipcode` varchar(20) DEFAULT NULL COMMENT '邮政编码',
  `iphone` varchar(35) DEFAULT NULL COMMENT '收货人手机号码',
  `user_id` int DEFAULT NULL COMMENT '该地址的所有者',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `address_id` (`user_id`) USING BTREE,
  CONSTRAINT `address_id` FOREIGN KEY (`user_id`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rece_address`
--

LOCK TABLES `rece_address` WRITE;
/*!40000 ALTER TABLE `rece_address` DISABLE KEYS */;
INSERT INTO `rece_address` VALUES (12,'WhimsyQuester','广东省深圳市坪山区石井街道深圳技术大学','518118','18888888888',23);
/*!40000 ALTER TABLE `rece_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_cart`
--

DROP TABLE IF EXISTS `shop_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `goods_unit` varchar(25) DEFAULT NULL COMMENT '商品规格',
  `goods_price` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品单价',
  `goods_num` int DEFAULT NULL COMMENT '商品数量',
  `users_id` int DEFAULT NULL COMMENT '购物车用户id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `usersid` (`users_id`) USING BTREE,
  CONSTRAINT `usersid` FOREIGN KEY (`users_id`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_cart`
--

LOCK TABLES `shop_cart` WRITE;
/*!40000 ALTER TABLE `shop_cart` DISABLE KEYS */;
INSERT INTO `shop_cart` VALUES (72,'太极藿香正气水藿香正气口服液','10ml*18支/盒','49.80',1,23);
/*!40000 ALTER TABLE `shop_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_goods`
--

DROP TABLE IF EXISTS `shop_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
  `goods_unit` varchar(35) DEFAULT NULL COMMENT '商品规格',
  `goods_stock` int DEFAULT NULL COMMENT '库存数量',
  `goods_price` varchar(30) DEFAULT NULL COMMENT '商品单价',
  `goods_present` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '商品简介',
  `goods_type` int DEFAULT NULL COMMENT '商品种类',
  `goods_img` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `type_id` (`goods_type`) USING BTREE,
  CONSTRAINT `type_id` FOREIGN KEY (`goods_type`) REFERENCES `shop_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_goods`
--

LOCK TABLES `shop_goods` WRITE;
/*!40000 ALTER TABLE `shop_goods` DISABLE KEYS */;
INSERT INTO `shop_goods` VALUES (1,'感康复方氨酚烷胺片','12片/盒',34,'16.00','品牌名称: 感康 <br>\n批准文号: 国药准字H22026193 <br>\n生产企业: 吉林省吴太感康药业有限公司 <br>\n类别: 复方制剂 <br>\n产品剂型: 片剂 <br>\n用法: 口服 <br>\n使用剂量: 成人一次1片,一日2次 <br>\n药品通用名: 复方氨酚烷胺片 <br>\n有效期: 36个月 <br>\n药品分类: 非处方药 <br>\n非处方药类型: 甲类非处方药 <br>',1,'感康复方氨酚烷胺片.jpg'),(2,'汇仁肾宝片','0.7g*63片*1瓶/盒',125,'197.00','品牌名称: 汇仁 <br>\n批准文号: 国药准字Z20080627 <br>\n生产企业: 江西汇仁药业股份有限公司 <br>\n类别: 中药 <br>\n产品剂型: 片剂 <br>\n用法: 口服 <br>\n使用剂量: 一次3片,一日3次。 <br>\n药品通用名: 肾宝片 <br>\n药品名称: 肾宝片 <br>\n有效期: 36个月 <br>',1,'汇仁肾宝片.jpg'),(3,'太极藿香正气水藿香正气口服液','10ml*18支/盒',38,'49.80','品牌名称: 太极 <br>\n批准文号: 国药准字Z50020409 <br>\n生产企业: 太极集团重庆涪陵制药厂有限公司 <br>\n类别: 中药 <br>\n产品剂型: 口服液 <br>\n用法: 口服 <br>\n使用剂量: 一次5~10毫升,一日2次 <br>\n药品通用名: 藿香正气口服液 <br>\n药品名称: 藿香正气口服液 <br>\n有效期: 36个月  <br>',1,'藿香正气水.jpg'),(4,'京都念慈菴蜜炼川贝枇杷膏','150ml/瓶',124,'24.30 ','品牌名称: 京都念慈菴 <br>\n批准文号: 医药产品注册证号ZC20160005 <br>\n生产企业: 京都念慈菴总厂有限公司 <br>\n类别: 中药 <br>\n产品剂型: 口服液 <br>\n用法: 口服 <br>\n使用剂量: 成人每日三次,一次15ml <br>\n药品通用名: 京都念慈菴蜜炼川贝枇杷膏 <br>\n药品名称: 京都念慈菴蜜炼川贝枇杷膏 <br>\n有效期: 36个月 <br>\n药品分类: 非处方药  <br>',1,'京都念慈庵蜜炼川贝枇杷膏.jpg'),(5,'美林布洛芬混悬液','35ml/瓶',37,'20.80','品牌名称: 美林 <br>\n批准文号: 国药准字H20000359 <br>\n生产企业: 上海强生制药有限公司 <br>\n类别: 化学药 <br>\n产品剂型: 口服液 <br>\n用法: 口服 <br>\n使用剂量: 1-3岁一次4毫升;4-6岁一次5毫升 <br>\n药品通用名: 布洛芬混悬液 <br>\n药品商品名: 美林 <br>\n药品名称: 美林 布洛芬混悬液 <br>\n有效期: 暂定36个月 <br>\n药品分类: 非处方药 <br>\n非处方药类型: 甲类非处方药 <br>',1,'美林布洛芬混悬液.jpg'),(6,'仁和氧氟沙星滴耳液','10ml*1支/盒',24,'12.00','品牌名称: 仁和 <br>\n批准文号: 国药准字H20083321 <br>\n生产企业: 武汉诺安药业有限公司 <br>\n产品剂型: 滴耳剂 <br>\n用法: 滴耳 <br>\n使用剂量: 一次6~10滴,一日2次 <br>\n有效期: 24个月 <br>\n适用人群: 不限 <br>\n药品类别: 化学药 <br>\n药品分类: 处方药 <br>\n疾病: 外耳炎 耳内炎症 中耳炎 外耳道炎 耳膜炎 <br>\n症状: 中耳炎 外耳道炎 耳肿疼痛 <br>',1,'仁和氧氟沙星滴耳液.jpg'),(7,'vc汤臣倍健维生素c咀嚼片','600mg/片*120片*1瓶装',67,'69.00','品牌名称: BY-HEALTH/汤臣倍健 <br>\n生产许可证编号: SC12744040400094 <br>\n厂名: 汤臣倍健股份有限公司 <br>\n厂址: 珠海市金湾区三灶科技工业园星汉路17、19号 <br>\n厂家联系方式: 4006869797 <br>\n保质期: 730 天 <br>\n品牌: BY-HEALTH/汤臣倍健系列 维生素C <br>\n省份: 广东 <br>\n城市: 广州 <br>\n产地: 中国大陆地区 <br>\n适用性别: 男女通用 <br>\n保质期: 24个月生产 <br>\n企业: 汤臣倍健股份有限公司 <br>\n产品剂型: 片剂 <br>\n计价单位: 瓶 <br>\n适用人群: 成人保健 <br>\n食品批准证号: 国食健字G20160085 <br>\n是否保健食品(国食健字号): 是 <br>\n产品名称: 维生素C片(橘子味) <br>\n功能: 补充维生素C <br>\n功效成分/标志性成分含量: 每片含维生素C 100mg <br>\n不适宜人群: 婴幼儿、少年儿童、孕妇、乳母 <br>\n主要原料: 维生素C(L-抗坏血酸)、抗坏血酸钠、白砂糖、淀粉、橘子果汁粉(橘子浓缩汁、糊精、β-胡萝卜素、橘子香料)、硬脂酸镁、甜橙香精、三氯蔗糖、薄膜包衣剂(羟丙基甲基纤维素、二氧化钛、滑石粉、三乙酸甘油酯、柠檬黄铝色淀、胭脂红铝色淀) <br>\n批准文号: 国食健字G20160085 <br>',2,'vc汤臣倍健维生素c咀嚼片.jpg'),(8,'澳洲bio island孕妇专用dha海藻油备孕孕期哺乳期黄金营养品','60粒/瓶',91,'238.00','品牌名称: bio island <br>\n厂名: JBX Pty Ltd <br>\n厂址: 22/252 New Line Road,Dural NSW 2158 Austrialia <br> \n保质期: 1095 天 <br>\n产地: 澳大利亚 <br>\n包装种类: 罐装 <br>\n货号: DHA <br>\n储存条件: 常温 <br>',2,'澳洲孕妇专用dha海藻油.jpg'),(9,'蛋白粉营养中老年人乳清蛋白质','400g/罐',44,'69.00','品牌名称: 仁和 <br>\n生产许可证编号: SC10636098210852 <br>\n厂名: 江西金衡康生物科技有限公司 <br>\n厂址: 江西省樟树市药都医药工业园泰欣大道1号 <br>\n厂家联系方式: 400-881-8196 <br>\n保质期: 730 天 <br>\n省份: 江西 <br>\n城市: 南昌 <br>\n产地: 中国大陆地区 <br>\n适用性别: 男女 <br>\n通用口味: 原味 <br>\n保质期: 24个月 <br>\n生产企业: 江西金衡康生物科技有限公司 <br>\n产品剂型: 粉剂 <br>\n计价单位: 罐 <br>\n适用人群: 成人 <br>\n是否保健食品(国食健字号): 否 <br>',2,'蛋白粉营养中老年人乳清蛋白质.jpg'),(10,'钙尔奇钙片','0.6g*60片*1瓶/盒',35,'66.90','品牌名称: CALTRATE/钙尔奇 <br>\n批准文号: 国药准字H10950029 <br>\n生产企业: 惠氏制药有限公司 <br>\n类别: 化学药 <br>\n产品剂型: 片剂 <br>\n用法: 口服 <br>\n使用剂量: 一次1片,一日1-2次 <br>\n有效期: 36个月 <br>\n药品分类: 非处方药 <br>',2,'钙尔奇钙片60片碳酸钙维D3孕妇成人补钙.jpg'),(11,'康王复方酮康唑发用洗剂','100ml*1瓶/盒',77,'67.00','品牌名称: 康王 <br>\n批准文号: 国药准字H53021775 <br>\n生产企业: 滇虹药业集团股份有限公司 <br>\n产品剂型: 洗剂 <br>\n用法: 皮肤外用 <br>\n使用剂量: 取本品约5毫升,涂于患处或已湿润的头发上,详见说明书 <br>\n药品通用名: 复方酮康唑发用洗剂 <br>\n药品名称: 复方酮康唑发用洗剂 <br>\n有效期: 24个月 <br>\n适用人群: 成人 <br>\n药品类别: 化学药 <br>\n药品分类: 处方药 <br>\n疾病: 花斑癣 <br>\n症状: 脱屑 瘙痒 <br>',2,'康王复方酮康唑发用洗剂.jpg'),(12,'天草丹参保心茶','2.5g*180袋/盒',29,'558.00','品牌名称: 天草 <br>\n批准文号: 国药准字B20040008 <br>\n生产企业: 大兴安岭天草药业有限公司 <br>\n产品剂型: 茶剂 <br>\n用法: 开水泡服 <br>\n使用剂量: 一次1袋,一日三次 <br>\n药品通用名: 丹参保心茶 <br>\n药品名称: 丹参保心茶 <br>\n有效期: 36个月 <br>\n药品分类: 非处方药 <br>\n贮藏: 密闭,防潮 <br>',2,'天草丹参保心茶.jpg'),(13,'北京同仁堂阿胶块','31.25g*8块/盒',7,'399.00','品牌名称: 同仁堂 <br>\n批准文号: 国药准字Z11020696 <br>\n生产企业: 北京同仁堂(唐山)营养保健品有限公司 <br>\n类别: 中药 <br>\n产品剂型: 胶剂 <br>\n用法: 口服 <br>\n使用剂量: 烊化兑服。3~9克。(详见参考服用方法) <br>\n药品通用名: 阿胶 <br>\n药品名称: 阿胶 <br>\n有效期: 60个月 <br>\n药品分类: 非处方药 <br>\n',3,'北京同仁堂阿胶块.jpg'),(14,'碧生源减肥茶','2.5g/袋*20袋/盒*1盒',10,'68.00','品牌名称: 碧生源 <br>\n厂名: 北京澳特舒尔保健品开发有限公司 <br>\n厂址: 北京市房山区窦店镇秋实工业小区1号 <br>\n厂家联系方式: 400-686-9299 <br>\n保质期: 730 天 <br>\n批准文号: 国食健字G20110711 <br>\n是否进口: 否 <br>\n产品剂型: 袋泡茶保健食品 <br>\n产品名称: 碧生源牌纤纤茶 <br>\n是否礼盒装: 否 <br>\n食用方法和食用量: 每日2次,每次1袋,饭后半小时,用200-300ml开水冲泡5-10分钟后趁热饮用,一次饮完即可 <br>\n注意事项: 本品为保健食品,不能代替药物使用；食用本品出现腹泻者,请立即停止食用 <br>\n产品名称: 碧生源牌纤纤茶 <br>\n公司名称: 北京澳特舒尔保健品开发有限公司 <br>\n功效成分/标志性成分含量: 每100g含:茶多酚 3.0g、总蒽醌 0.6g <br>\n不适宜人群: 少年儿童、孕妇、乳母、慢性腹泻者 <br>\n适宜人群: 单纯性肥胖人群 <br>\n贮藏方法: 贮存于阴凉干燥处 <br>\n主要原料: 番泻叶、绿茶、决明子、荷叶、泽泻 <br>\n批准文号: 国食健字G20110711 <br>',3,'碧生源减肥茶.jpg'),(15,'南京同仁堂冬虫夏草','0.25克/根-40根,共10克',3,'1580.00','品牌名称: 六和乾坤 <br>\n厂名: 安徽忠瑜堂生物科技有限公司 <br>\n厂址: 安徽省毫州市谯城区经济开发区科技路199号2号楼 <br>\n厂家联系方式: 4000250200 <br>\n保质期: 540 天 <br>\n系列: 冬虫夏草 <br>\n产地: 中国大陆 <br>\n省份: 湖北省 <br>\n城市: 宜昌市 <br>\n净含量: 10g <br>',3,'南京同仁堂冬虫夏草.jpg'),(16,'南京同仁堂黄芪片中草药材','250g',83,'39.90','品牌名称: 放鹤洲 <br>\n厂名: 云南七洲实业有限公司 <br>\n厂址: 云南省昆明阳宗海风景名胜区七甸产业园区小哨箐片区哨望路8号生产加工基地物流项目9幢3层车间 <br>\n厂家联系方式: 400-0099-059 <br>\n保质期: 730 天 <br>\n产地: 中国大陆 <br>\n省份: 甘肃省 <br>\n城市: 兰州市 <br>',3,'南京同仁堂黄芪片中草药材.jpg'),(17,'杞里香宁夏特红级枸杞','500g',50,'39.90','品牌名称: 杞里香 <br>\n生产许可证编号: SC11464010500672 <br>\n厂名: 银川杞里香商贸有限公司 <br>\n厂址: 宁夏回族自治区银川市西夏区 <br>\n厂家联系方式: 400-870-0951 <br>\n保质期: 365 天 <br>\n品牌: 杞里香 <br>\n系列: 黑罐宁夏枸杞 <br>\n产地: 中国大陆 <br>\n省份: 宁夏回族自治区 <br>\n城市: 银川市 <br>\n净含量: 500g <br>\n储存条件: 常温 <br>',3,'杞里香宁夏特红级枸杞.jpg'),(18,'同济堂仙灵骨葆胶囊','0.5g*50粒/盒',47,'28.00','品牌名称: 同济堂 <br>\n批准文号: 国药准字Z20025337 <br>\n生产企业: 国药集团同济堂(贵州)制药有限公司 <br>\n产品剂型: 胶囊 <br>\n用法: 口服 <br>\n使用剂量: 一次3粒,一日2次 <br>\n药品通用名: 仙灵骨葆胶囊 <br>\n药品名称: 仙灵骨葆胶囊 <br>\n有效期: 36个月 <br>\n适用人群: 成人 <br>\n药品类别: 中药 <br>\n药品分类: 处方药 <br>\n疾病: 骨关节炎 骨质疏松 <br>\n症状: 骨折 <br>',3,'同济堂仙灵骨葆胶囊.jpg'),(19,'韩国Comotomo可么多么奶瓶','150ml/个',13,'130.00','品牌名称: COMO TOMO <br>\n材质: PPSU <br>\n产地: 韩国 <br>\n颜色分类: 草绿色 粉红色 <br>\n奶瓶是否带柄: 否 <br>\n口径大小: 宽口 <br>\n径容量: 150mL <br>',4,'韩国Comotomo可么多么奶瓶.jpg'),(20,'秝客75度酒精湿巾卫生湿纸巾','50抽/包',68,'12.80','品牌名称: lefeke <br>\n产地: 德州 <br>\n生产企业: 唐派医疗有限公司 <br>\n适用人群: 成人保健用品 <br>\n产品名称: 酒精湿巾 <br>\n消字号: 鲁卫消证字(2020)第1350号 <br>',4,'秝客75度酒精湿巾卫生湿纸巾.jpg'),(21,'强生婴儿爽身粉','140g/盒',72,'15.90','品牌: Johnson’s baby/强生婴儿 <br>\n系列(型号): 爽身粉 <br>\n容量: 140g <br>\n产地: 中国大陆 <br>\n化妆品备案编号/注册证号: 沪G妆网备字2019011789 <br>\n百货品类: 爽身粉/粉扑 <br>\n是否为特殊用途化妆品: 否 <br>\n',4,'强生婴儿爽身粉.jpg'),(22,'日本MamaKids 婴儿泡沬洁肤液保湿沐浴','460ml',40,'198.00','品牌名称: Mama&Kids <br>\n系列(型号): 婴儿护理 <br>\n产地: 日本 <br>\n颜色分类: 橄榄精华 <br>\n百货品类: 沐浴露 <br>\n是否为特殊用途化妆品: 否 <br>\n净含量: 460ml <br>',4,'婴儿泡沬洁肤液保湿沐浴露.jpg'),(23,'斯利安叶酸','0.4mg*31片/盒',85,'28.00','品牌名称: Scrianen/斯利安 <br>\n批准文号: 国药准字H10970079 <br>\n生产企业: 北京斯利安药业有限公司 <br>\n类别: 化学药产品 <br>\n剂型: 片剂 <br>\n用法: 口服 <br>\n使用剂量: 一次0.4毫克,一日1次,详见说明书 <br>\n药品通用名: 叶酸片药品 <br>\n有效期: 36个月 <br>\n药品分类: 非处方药 <br>\n非处方药类型: 甲类非处方药 <br>',4,'斯利安叶酸31片孕妇叶酸.jpg'),(24,'修正洗眼液','260ml/瓶',16,'29.00','品牌名称: 修正 <br>\n生产企业: 陕西恩倍唐生物科技有限公司 <br>',4,'修正洗眼液.jpg'),(27,'水仙牌太平风油精','6ml*1瓶/盒',45,'6.80','品牌名称: 太平 <br>\n批准文号: 国药准字Z35020456 <br>\n生产企业: 福建太平洋制药有限公司 <br>\n产品剂型: 外用液体剂 <br>\n用法: 皮肤外用 <br>\n使用剂量: 外用,涂擦于患处 <br>\n有效期: 36个月 <br>\n药品类别: 中药 <br>\n药品分类: 非处方药 <br>',5,'水仙牌风油精.jpg'),(28,'漱口水','200ml/瓶/盒',26,'25.00','品牌名称: 洛芙 <br>\n批准文号: 国药准字H32026694 <br>\n生产企业: 江苏知原药业股份有限公司 <br>\n类别: 化学药产品 <br>\n剂型: 含漱液 <br>\n用法: 详见说明书 <br>\n使用剂量: 详见说明书 <br>\n药品通用名: 复方氯己定含漱液 <br>\n有效期: 24个月 <br>',5,'漱口水.jpg'),(29,'医洛油黄道益活洛油原装','50ml/瓶/盒',55,'68.00','品牌名称: 医洛油 <br>\n护具种类: 祛风止痛 <br>\n生产企业: 贵州黄道益医药科技有限公司 <br>\n增值服务: 正品保障 <br>\n适用人群: 成人保健用品 <br>\n产品名称: 活络油 <br>',5,'医洛油黄道益活洛油原装.jpg'),(30,'医用碘伏棉棒','50支/盒',27,'12.80','产地: 湖南 <br>\n生产企业: 可孚医疗科技股份有限公司 <br>\n执行标准号: 湘械注准20192140881 <br>\n增值服务: 无 <br>\n适用人群: 不限 <br>\n疾病: 碘伏棉签 <br>\n症状: 碘伏棉签 <br>\n注册证号: 湘械注准20192140881 <br>\n医疗器械产品名称: 可孚碘伏棉签 <br>\n棉签棉球种类: 碘伏棉签 <br>',5,'医用碘伏棉棒.jpg'),(31,'电子红外线测体温度计','1支',13,'39.90','品牌名称: 卓辰 <br>\n型号: IM-9001 <br>\n品牌: 卓辰 <br>\n产地: 惠州 <br>\n批准文号: 粤械注准20202071341 <br>\n测量部位: 口温 额温 耳温 腋温 肛温 <br>\n生产企业: 惠州安博臣科技有限公司 <br>\n是否为进口: 否 <br>\n执行标准号: 粤械注准20202071341 <br>\n体温计类型: 额温枪 <br>\n适用人群: 不限 儿童 成人 <br>\n疾病: 风热感冒 风寒感冒 上呼吸道感染 流行性感冒 病毒性感冒 <br>\n症状: 发热 头痛 鼻塞 头晕 流涕 发冷 恶寒 <br>\n智能类型: 不支持智能 <br>',6,'电子红外线测体温度计.jpg'),(32,'海氏海诺医用脱脂纱布绷带卷家用','6*600cm*1卷',60,'3.90','品牌名称: 海氏海诺 <br>\n品牌: 海氏海诺 <br>\n产地: 山东青岛 <br>\n生产企业: 青岛海诺生物工程有限公司 <br>\n执行标准号: 鲁青械备20150027号 <br>\n增值服务: 正品保障 <br>\n适用人群: 不限 <br>\n疾病: 包扎 <br>\n症状: 包扎 <br>\n注册证号: 鲁青械备20150027号 <br>\n医疗器械产品名称: 纱布绷带纱布绷带 <br>\n纱布绷带尺寸: 6x600cm <br>',6,'海氏海诺医用脱脂纱布绷带.jpg'),(33,'衡互邦手动轮椅','1辆',3,'438.00','品牌名称: 衡互邦 <br>\n型号: LY-L21 <br>\n品牌: 衡互邦 <br>\n材质: 钢 <br>\n产地: 河北 <br>\n生产企业: 衡水斯瑞医疗器械有限公司 <br>\n执行标准号: GB/T13800-2009 <br>\n附加功能: 带手刹 <br>\n增值服务: 正品保障 <br>\n适用人群: 不限 <br>\n疾病: 下肢残疾 偏瘫 截瘫 摔伤 骨折牵引 <br>\n症状: 无法站立 <br>\n注册证号: 冀食药监械生产许20170015号 <br>\n选购热点: 加厚坐垫 加宽轮椅 大轮稳固医疗器械 <br>\n轮椅种类: 普通轮椅 <br>',6,'老人手动轮椅.jpg'),(34,'欧格斯制氧机家用','1台',2,'2080.00','品牌名称: 欧格斯 <br>\n型号: OZ-3-08UW0/OZ-3-08GW0 <br>\n品牌: 欧格斯 <br>\n产地: 广东广州 <br>\n生产企业: 广东欧格斯科技有限公司 <br>\n执行标准号: 粤械注准 20172080401 <br>\n增值服务: 正品保障 <br>\n适用人群: 不限 <br>\n注册证号: 粤械注准20172080401 <br>\n选购热点: 静音型 雾化型 3L机 氧浓度监测型 带计时功能医疗器械 <br>\n产品名称: 制氧机制氧机 <br>\n类别: 医用级制氧机 <br>',6,'欧格斯制氧机.jpg'),(35,'欧姆龙家用中频治疗仪','1台',5,'1390.00','品牌名称: Omron/欧姆龙 <br>\n型号: HV-F2200 <br>\n品牌: Omron/欧姆龙 <br>\n产地: 成都 <br>\n生产企业: 四川千里倍益康医疗科技股份有限公司 <br>\n执行标准号: 川械注准20202090126 <br>\n增值服务: 无理疗方式 <br>\n分类: 生物电疗 <br>\n适用人群: 成人 <br>\n疾病: 遵循医嘱 <br>\n症状: 遵循医嘱 <br>\n注册证号: 川械注准20202090126 <br>\n产品名称: 中频治疗器 <br>',6,'欧姆龙家用中频治疗仪.jpg'),(36,'欧姆龙血压测量仪家用','1台',10,'209.00','品牌名称: Omron/欧姆龙 <br>\n型号: U10、U10K <br>\n功能: 测量血压 <br>\n产地: 大连 <br>\n适用部位: 上臂 <br>\n生产企业: 欧姆龙(大连)有限公司 <br>\n执行标准号: 辽械注准20172230070 <br>\n增值服务: 正品保障 <br>\n血压仪器种类: 电子血压计 <br>\n适用人群: 不限 <br>\n疾病: 高血压 <br>\n症状: 血压高 <br>\n注册证号: 辽械注准20162070146 <br>\n选购热点: 全自动 屏幕大 <br>\n产品名称: 电子血压计 上臂式 <br>',6,'欧姆龙血压测量仪家用.jpg'),(66,'医用酒精喷雾消毒水消毒液','500ml/瓶',18,'9.90','品牌名称: 初医生 <br>\r\n产地: 安徽省毫州市 <br>\r\n生产企业: 安徽省致名堂生物科技有限公司 <br>\r\n适用人群: 不限 <br>\r\n保健用品产品名称: 医用酒精消毒液 <br>\r\n消字号: 皖卫消证字【2020】第S0058号 <br>',5,'医用酒精喷雾消毒水消毒液.jpg'),(67,'美宝湿润烧伤膏','20g*1支/盒',6,'43.00','品牌名称: MEBO/美宝 <br>\r\n批准文号: 国药准字Z20000004 <br>\r\n生产企业: 汕头市美宝制药有限公司 <br>\r\n产品剂型: 软膏剂 <br>\r\n用法: 皮肤外用 <br>\r\n使用剂量: 详见说明书 <br>\r\n药品通用名: 湿润烧伤膏 <br>\r\n药品名称: 湿润烧伤膏 <br>\r\n有效期: 36个月 <br>\r\n适用人群: 不限 <br>\r\n药品类别: 中药 <br>\r\n药品分类: 处方药 <br>\r\n疾病: 烧伤 烫伤 灼伤 <br>\r\n症状: 烧伤 <br>',5,'美宝湿润烧伤膏.jpg');
/*!40000 ALTER TABLE `shop_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_type`
--

DROP TABLE IF EXISTS `shop_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品种类',
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_type`
--

LOCK TABLES `shop_type` WRITE;
/*!40000 ALTER TABLE `shop_type` DISABLE KEYS */;
INSERT INTO `shop_type` VALUES (1,'中西药品','2019-08-07'),(2,'人群健康','2019-08-07'),(3,'滋补调养','2019-08-07'),(4,'母婴孕产','2019-08-07'),(5,'居家生活','2019-08-07'),(6,'医疗器械','2019-08-07');
/*!40000 ALTER TABLE `shop_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `users` varchar(15) NOT NULL COMMENT '用户名称',
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `iphone` varchar(40) DEFAULT NULL COMMENT '手机号码',
  `address` varchar(60) DEFAULT NULL COMMENT '用户地址',
  `is_pay_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user`
--

LOCK TABLES `shop_user` WRITE;
/*!40000 ALTER TABLE `shop_user` DISABLE KEYS */;
INSERT INTO `shop_user` VALUES (23,'test','123456','test@ascent.com','18888888888','广东省深圳市坪山区石井街道深圳技术大学',NULL);
/*!40000 ALTER TABLE `shop_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-26 21:10:52
