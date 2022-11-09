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
- mapper.xml里面的<select>标签id即对应的方法接口名，在该标签下写该方法所需要的SQL语句。例：<br>

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
  <mapper namespace="com.xinsheng.o2o.dao.AreaDao     空格          ">
  ```

  1.xml 文件中是有中文注释，有的话全部删除<br>

  1. xml 的文件名 是否与 dao 接口名保持一致<br>

  [参考链接]:https://blog.csdn.net/weixin_43570367/article/details/103147854

  <br>

  
  
  - impl实现层 接口 用implements  + 对应实现类
  - RequestMethod.POST 相对安全，，而GET 的参数信息都会反映在URL上
  - JUnit测试要写@Test注解
  	<insert id="insertShop" useGeneratedKeys="true" keyProperty="shopId"
		keyColumn="shop_id">属性之间要有空格
  
  

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

[图片处理工具Thumbnail]([示例 ·咕咕鸟/缩略图维基 (github.com)](https://github.com/coobird/thumbnailator/wiki/Examples))

[博客项目集成PDF.js后，文件在阿里云对象存储oss后出现跨域问题解决方案](https://blog.csdn.net/MASILEJFOAISEGJIAE/article/details/126162430)



在静态的方法中不能直接调用非静态的方法或属性。因为一个类的静态方法在这个Class文件被加载之后，就可以由这个Class类型对象来调用，而非静态的方法需要一个实例对象，有可能还未被创建，所以为了避免在静态方法中调用一个还不存在的实例对象的非静态方法，编译期就会直接阻止这个行为。

解决的方法有两种，

第一种是将被调用的方法设置成静态方法；
第二种是new本类，然后通过实例来调用。
