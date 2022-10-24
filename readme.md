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

