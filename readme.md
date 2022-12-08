<img src="https://o2oresourse.oss-cn-hangzhou.aliyuncs.com/head.jpg" alt="头像" style="zoom:25%;" />

#技术栈<br>
##后端<br>
spring  springMVC  mybatis <br>
##数据库<br>
mysql5.5+<br>
##web容器<br>
tomcat9<br>
##IDE<br>
eclipse2018-9<br>

## 前言

o2o项目希望完成一个文件共享系统，采用现阶段公司常用技术来实现，例如Redis,spring、springmvc、 Mybatis, Nginx等。总的目的是用来熟悉这些技术。

## 目录

  - [前言](#前言)
  - [项目介绍](#项目介绍)
  - [项目演示](#项目演示)
    - [用户端演示](#用户端演示)
    - [商家端演示](#商家端演示)
    - [管理端演示](#管理端演示)
  - [技术选型](#技术选型)
    - [后端技术](#后端技术)
    - [前端技术](#前端技术)
  - [环境搭建](#环境搭建)
    - [开发工具](#开发工具)
    - [开发环境](#开发环境)
    - [搭建具体环境](#搭建具体环境)
  - [相关学习文档](#相关学习文档)
  - [数据库设计](#数据库设计)
  - [前后端接口文档](#前后端接口文档)

[本项目面试总结](#环境搭建)

- [MySQL存储引擎InnoDB与Myisam的区别](#MySQL存储引擎InnoDB与Myisam的区别)
- [mysql主从分离](#mysql主从分离)
- [搭建具体环境](#搭建具体环境)

## 项目介绍

file_management_sys 是一个文件共享系统，包括前端文件展示系统和后台管理系统，基于SpringBoot + MyBatis实现。

## 项目演示

### 用户端演示

### 商家端演示

### 管理端演示




## 技术选型

### 后端技术

| 技术        | 说明                  | 官网                                        | demo地址 |
| :---------- | :-------------------- | :------------------------------------------ | :------- |
| Spring Boot | 容器                  | https://spring.io/projects/spring-boot      |          |
| MyBatis     | ORM 框架              | https://mybatis.org/mybatis-3/zh/index.html |          |
| MySQL       | 关系型数据库          | https://dev.mysql.com/doc/refman/8.0/en/    |          |
| Redis       | 分布式缓存            | https://redis.io/                           |          |
| Nginx       | 负载均衡              | https://www.nginx.com/                      |          |
| LogBack     | 日志                  | http://logback.qos.ch/manual/index.html     |          |
| Lombok      | 简化对象封装工具      | https://github.com/rzwitserloot/lombok      |          |
| Swagger     | 生成前后端api接口文档 | https://swagger.io/specification/v2/        |          |

### 前端技术

| 技术       | 说明         | 官网                  |
| :--------- | :----------- | :-------------------- |
| SUI Mobile | 响应式UI组件 | http://m.sui.abdl.cn/ |

## 环境搭建

初始搭建均基于阿里云ECS服务器的centos系统。

### 开发工具

| 工具                  | 说明                                                         | 官网                                         |
| :-------------------- | :----------------------------------------------------------- | :------------------------------------------- |
| IDEA                  | 开发IDE                                                      | https://www.jetbrains.com/idea/              |
| Redis Desktop Manager | redis客户端连接工具                                          | https://redisdesktop.com/download            |
| MySQL workbench       | MySQL 可视化工具                                             | https://www.mysql.com/cn/products/workbench/ |
| GitHub                | 版本管理工具                                                 | https://github.com                           |
| Maven                 | 项目管理                                                     | https://maven.apache.org                     |
| PostMan               | 接口请求测试                                                 | https://www.getpostman.com/                  |
| Gifox                 | gif录制工具                                                  | https://gifox.io/                            |
| Axure                 | 原型设计工具                                                 | https://www.axure.com/                       |
| bootschool            | banner 生成工具                                              | https://www.bootschool.net/ascii             |
| MarkDown              | MarkDown语法说明                                             | http://www.markdown.cn                       |
| RoeketMQ 可视化控制台 | 在子项目rocketmq-console里面，打包mvn clean package -Dmaven.test.skip=true | https://github.com/apache/rocketmq-externals |


### 开发环境

| 工具       | 版本   | 官网                                                         |
| :--------- | :----- | :----------------------------------------------------------- |
| SpringBoot | 2.2.4  | https://spring.io/projects/spring-boot                       |
| JDK        | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql      | 5.7.26 | https://www.mysql.com/                                       |
| Redis      | 4.0.10 | https://redis.io                                             |
| Nginx      | 待定   | https://www.nginx.com                                        |

### 搭建具体环境(docker搭建，基于centos 7)

  首先安装docker，启动docker systemctl start docker.
  注意： 当各个容器启动后，在服务器端的安全组一定要配置相应端口，不然外部访问不到。

 - 1.安装 MySQL  
   1.1 拉取最新镜像 docker pull centos/mysql-57-centos7  
   1.2 运行一个容器 docker run -id --name=mysql-57-centos7 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=717294 centos/mysql-57-centos7  

 - 2.安装 Redis 4.0.10  
   2.1  拉取redis镜像 docker pull redis  
   2.2  运行redis容器 docker run -id --name=redis -p 6379:6379 redis  

 - 3.安装 RocketMQ 4.6.0    
 - 4.安装 nginx1.16.1  
   4.1 安装相关环境   
         &nbsp;&nbsp; yum install gcc-c++  
         &nbsp;&nbsp; yum install -y pcre pcre-devel  
         &nbsp;&nbsp; yum install -y zlib zlib-devel  
         &nbsp;&nbsp; yum install -y openssl openssl-devel  
   4.2 获取 安装包 wget -c https://nginx.org/download/nginx-1.16.1.tar.gz  
   4.3 解压安装   
         &nbsp;&nbsp; tar -zxvf nginx-1.16.1.tar.gz  
         &nbsp;&nbsp; cd nginx-1.16.1  
         &nbsp;&nbsp; ./configure  
         &nbsp;&nbsp; make install  
    4.4 运行  
         &nbsp;&nbsp; cd /usr/local/nginx/sbin/  
         &nbsp;&nbsp; ./nginx  

## 相关学习文档

| 技术                      | 说明                          | 网址                                                         |
| :------------------------ | :---------------------------- | :----------------------------------------------------------- |
| Spring Data Elasticsearch | spring data整合 Elasticsearch | https://github.com/spring-projects/spring-data-elasticsearch/blob/master/README.adoc |
| RocketMQ                  | 阿里中间件团队博客            | http://jm.taobao.org/2017/01/12/rocketmq-quick-start-in-10-minutes/ |

## 数据库设计



## 前后端接口文档





### MySQL存储引擎InnoDB与Myisam的区别

|                                                 | **MyISAM**                                                   | **InnoDB**                                                   |
| ----------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **构成上的区别**                                | 每个MyISAM在磁盘上存储成三个文件。第一个文件的名字以表的名字开始，扩展名指出文件类型。.frm文件存储表定义。数据文件的扩展名为.MYD (MYData)。索引文件的扩展名是.MYI (MYIndex)。 | 基于磁盘的资源是InnoDB表空间数据文件和它的日志文件，InnoDB 表的大小只受限于操作系统文件的大小，一般为 2GB |
| **事务处理上方面**                              | MyISAM类型的表强调的是性能，其执行数度比InnoDB类型更快，但是不提供事务支持 | InnoDB提供事务支持事务，外部键（foreign key）等高级数据库功能 |
| **SELECT  UPDATE,INSERT**，**Delete**，**操作** | 如果执行大量的SELECT，MyISAM是更好的选择                     | **1.**如果你的数据执行大量的**INSERT**或**UPDATE**，出于性能方面的考虑，应该使用InnoDB表<br /> **2.DELETE  FROM table**时，InnoDB不会重新建立表，而是一行一行的删除。**3.LOAD  TABLE FROM MASTER**操作对InnoDB是不起作用的，解决方法是首先把InnoDB表改成MyISAM表，导入数据后再改成InnoDB表，但是对于使用的额外的InnoDB特性（例如外键）的表不适用 |

与 MyISAM相同的一点是，InnoDB 也采用 B+Tree这种数据结构来实现 B-Tree索引。而很大的区别在于，InnoDB 存储引擎采用“聚集索引”的数据存储方式实现B-Tree索引，所谓“聚集”，就是指数据行和相邻的键值紧凑地存储在一起，注意 InnoDB 只能聚集一个叶子页（16K）的记录（即聚集索引满足一定的范围的记录），因此包含相邻键值的记录可能会相距甚远。在 InnoDB 中，表被称为 索引组织表（index organized table），InnoDB 按照主键构造一颗 B+Tree （如果没有主键，则会选择一个唯一的并且非空索引替代，如果没有这样的索引，InnoDB则会隐式地定义一个主键来作为聚集索引），同时叶子页中存放整张表的行记录数据，也可以将聚集索引的叶子节点称为数据页，非叶子页可以看做是叶子页的稀疏索引。

全表扫描

当InnoDB做全表扫描时并不高效，因为 InnoDB 实际上并没有顺序读取,在大多情况下是在随机读取。做全表扫描时,InnoDB 会按主键顺序扫描页面和行。这应用于所有的InnoDB 表，包括碎片化的表。如果主键页表没有碎片（存储主键和行的页表),全表扫描是相当快，因为读取顺序接近物理存储顺序。但是当主键页有碎片时，该扫描就会变得十分缓慢

行级锁

提供行锁(locking on row level)，提供与 Oracle 类型一致的不加锁读取(non-locking read in SELECTs)，另外，InnoDB表的行锁也不是绝对的，如果在执行一个SQL语句时MySQL不能确定要扫描的范围，InnoDB表同样会锁全表
表级锁

小结：Innodb强调多功能性，支持的拓展功能比较多，myisam主要侧重于性能

区别

1、InnoDB支持事务，MyISAM不支持，对于InnoDB每一条SQL语言都默认封装成事务，自动提交，这样会影响速度，所以最好把多条SQL语言放在begin和commit之间，组成一个事务；

2、InnoDB是聚集索引，数据文件是和索引绑在一起的，必须要有主键，通过主键索引效率很高。但是辅助索引需要两次查询，先查询到主键，然后再通过主键查询到数据。因此，主键不应该过大，因为主键太大，其他索引也都会很大。而MyISAM是非聚集索引，数据文件是分离的，索引保存的是数据文件的指针。主键索引和辅助索引是独立的。

3、InnoDB不保存表的具体行数，执行select count(*) from table时需要全表扫描。而MyISAM用一个变量保存了整个表的行数，执行上述语句时只需要读出该变量即可，速度很快；

4、Innodb不支持全文索引，而MyISAM支持全文索引，查询效率上MyISAM要高；
---------------------------------------------------------------------划水线---------------------------------------------

### mysql主从分离
-----------------------------------------划水----------------------------------------------------------------------------
数据库层面主从分离配置

将读操作和写操作分离到不同的数据库上，避免主服务器出现性能瓶颈

主服务器进行写操作时，不影响查询应用服务器的查询性能，降低阻塞，提高并发

数据拥有多个容灾副本，提高数据安全性，同时当主服务器故障时，可立即切换到其他服务器，提高系统可用性
代码层面读写分离
当mysql服务器只有一台的时候，可能又以下的问题：1.读和写所有压力都由一台数据库承担，压力大 2.数据库服务器磁盘损坏则数据丢失，单点故障

解决方案：准备两台MySQL，一台主(Master)服务器，一台从(Slave)服务器，主库的数据变更，需要同步到从库中(主从复制)。而用户在访问我们项目时，如果是写操作(insert、update、delete)，则直接操作主库；如果是读(select)操作，则直接操作从库(在这种读写分离的结构中，从库是可以有多个的)，这种结构我们称为 读写分离 。

MySQL数据库默认是支持主从复制的。

MySQL主从复制是一个异步的过程，底层是mysql数据库自带的二进制功能，就是一台或多台MySQL数据库（slave，即从库）从另一台MySQL数据库（master，即主库）进行日志的复制，然后再解析日志并应用到自身，最终实现从库和主库的数据保持一致。

二进制日志：二进制日志BINLOG记录了所有DDL数据定义语言和DML数据操作语言，不包括数据查询语言。此日治对于灾难时数据恢复有重要作用，mysql的主从复制，就是binglog实现的。默认的mysql是未开启该日志的



### 搭建具体环境(docker搭建，基于centos 7)



后台修改dynamic web moudle 版本，到3.1＋，以达到更高的性能

步骤：修改项目文件夹下的.setting文件 org.eclipse.wst.common.project.facet.core.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<faceted-project>
  <fixed facet="wst.jsdt.web"/>
  <installed facet="java" version="1.8"/>
  <installed facet="jst.web" version="3.1"/>
  <installed facet="wst.jsdt.web" version="1.0"/>
</faceted-project>

```

- 实体类自动生成get和set方法，在eclipse里面右键resource选择即可；注意是在主方法里面。
- 可通过web.xml配置项目的首加载页，即http://localhost:8080/o2o 即可访问项目
- 实体类中的数据类型都是大写字母开头Integer   String    Date   Long
- 关系型数据库mysql的索引index就像词典的偏旁部首，但物极必反，要维护。
- dao层作用，与数据相关的操作，文件读写，redis
- dto弥补entity的不足
- interceptor拦截器
- WEB-INF的安全性，浏览器输入URL，不能访问其目录下HTML
- mapper.xml里面的

  ```xml
  <select></select>
  ```

  标签id即对应的方法接口名，在该标签下写该方法所需要的SQL语句。例：<br>

```xml
<mapper namespace="com.xinsheng.o2o.dao.AreaDao">
	<select id="queryArea" resultType="com.xinsheng.o2o.entity.Area">
	<!-- id为对应查询方法名  resultType为返回值类型，以实体类形式返回 -->
		SELECT area_id,area_name,priority,create_time,
		last_edit_time
		FROM tb_area
		ORDER BY priority DESC 
	
	</select>
</mapper>
```

对应dao层方法：<br>

```java
package com.xinsheng.o2o.dao;
import  com.xinsheng.o2o.entity.Area;
import java.util.List;

import com.xinsheng.o2o.entity.Area;

public interface AreaDao {

	/*
	 * 列出区域列表
	 * @return areaList
	 */
	List<Area> queryArea();//这里的方法名要写在select标签的id  不能写错
}
```



- ***主要检查包名，namespace，方法名等能否对应上***。开发过程中有时候敲错一个字母都有问题，需要认真的检查。对于这块地方，建议粘贴复制，不要自己手敲。  本次的bug是包名后面出现了空格<br>

  ```xml
  <mapper namespace="com.xinsheng.o2o.dao.AreaDao     空格          "></mapper>
  ```

  1.xml 文件中是有中文注释，有的话全部删除<br>

  ​         xml 的文件名 是否与 dao 接口名保持一致[参考链接](https://blog.csdn.net/weixin_43570367/article/details/103147854)<br>

  

  - impl实现层 接口 用implements  + 对应实现类

  - RequestMethod.POST 相对安全，，而GET 的参数信息都会反映在URL上
  
  - JUnit测试要写@Test注解
  
    属性之间要有空格
  
	  ```xml
    <insert id="insertShop" useGeneratedKeys="true" keyProperty="shopId" keyColumn="shop_id"></insert>
    ```
  
    mybatis支持动态SQL语句，也就是更新A而不更新B、更新B而不更新A、两者都更新的情况那就要写三条语句，那利用mybatis的，set标签即可用一条实现，例如：
  

```xml
<update id="updateShop" parameterType="com.xinsheng.o2o.entity.Shop">
		update tb_shop
		<set>
			<if test="shopName != null">shop_name=#{shopName},</if>
			<if test="shopDesc != null">shop_desc=#{shopDesc},</if>
			<if test="shopAddr != null">shop_addr=#{shopAddr},</if>
			<if test="phone != null">phone=#{phone},</if>
			<if test="shopImg != null">shop_img=#{shopImg},</if>
			<if test="priority != null">priority=#{priority},</if>
			<if test="lastEditTime != null">last_edit_time=#{lastEditTime},</if>
			<if test="enableStatus != null">enable_status=#{enableStatus},</if>
			<if test="advice != null">advice=#{advice},</if>
			<if test="area != null">area_id=#{area.areaId},</if>
			<if test="shopCategory != null">shop_category_id=#{shopCategory.shopCategoryId},</if>
		</set>
		where shop_id=#{shopId}
	
	</update>
```

[图片处理工具Thumbnail](https://github.com/coobird/thumbnailator/wiki/Examples)

[博客项目集成PDF.js后，文件在阿里云对象存储oss后出现跨域问题解决方案](https://blog.csdn.net/MASILEJFOAISEGJIAE/article/details/126162430)



在静态的方法中不能直接调用非静态的方法或属性。因为一个类的静态方法在这个Class文件被加载之后，就可以由这个Class类型对象来调用，而非静态的方法需要一个实例对象，有可能还未被创建，所以为了避免在静态方法中调用一个还不存在的实例对象的非静态方法，编译期就会直接阻止这个行为。

解决的方法有两种，

第一种是将被调用的方法设置成静态方法；
第二种是new本类，然后通过实例来调用。

**BUG**

在mybatis里面的ShopCategoryDao.xml里面有parentId,而在实体类里面private ShopCategory parent;漏掉了id

Error evaluating expression 'shopCategoryCondition.parentId!=null'. Cause: org.apache.ibatis.ognl.NoSuchPropertyException: com.xinsheng.o2o.entity.ShopCategory.parentId

was not registered for synchronization because synchronization is not active
[解决连接](https://blog.csdn.net/ChinaMuZhe/article/details/103886730)
[解决措施2](https://blog.csdn.net/weixin_43304253/article/details/128025661)

###设计思路
店铺类别全部放在二级分类下，所以parent_id要not null

## Browsers support

| [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/edge/edge_48x48.png" alt="IE / Edge" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>IE / Edge | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/firefox/firefox_48x48.png" alt="Firefox" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Firefox | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/chrome/chrome_48x48.png" alt="Chrome" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Chrome | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/safari/safari_48x48.png" alt="Safari" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Safari | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/safari-ios/safari-ios_48x48.png" alt="iOS Safari" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>iOS Safari | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/samsung-internet/samsung-internet_48x48.png" alt="Samsung" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Samsung | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/opera/opera_48x48.png" alt="Opera" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Opera | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/opera-mini/opera-mini_48x48.png" alt="Opera Mini" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Opera Mini | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/vivaldi/vivaldi_48x48.png" alt="Vivaldi" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Vivaldi | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/yandex/yandex_48x48.png" alt="Yandex" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Yandex | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/electron/electron_48x48.png" alt="Electron" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)<br/>Electron |
| --------- | --------- | --------- | --------- | --------- | --------- | --------- | --------- | --------- | --------- | --------- |
| IE11, Edge| last 2 versions| last 2 versions| last 4 versions| last 2 versions| last 2 versions| last 2 versions| last 2 versions| last 2 versions| last 2 versions| last 2 versions



