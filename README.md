**项目结构**

![](assets/Screenshot-2023-06-05-144047.png)

各组件介绍

```bash
Controller:Controller是MVC框架中的组件之一,它负责处理用户请求并返回响应。Controller常是一个Java类,其中包含处理请求的方法。在Spring MVC框架中,Controller通常使用@Controller注解进行标记。
DAO:DAO是数据访问对象的缩写,它是用于访问数据库的组件。DAO通常是一个Java接口,其中定义了访问数据库的方法。在MyBatis框架中,DAO通常使用Mapper接口进行标记。
Enums:Enums是Java中的枚举类型,它用于定义一组常量。Enums通常用于表示一组相关的常量,例如颜色、状态等。Enums可以在代码中更好地表达意图,并提供更好的类型安全性。
Interceptors:Interceptors是拦截器的缩写,它是用于在处理过程中拦截请求的组件。Interceptors通常用于实现安全性、日志记录、性能监控等功能。在Spring MVC架中,Interceptors通常使用拦截器接口进行标记。
PO:PO是持久化对象的缩写,它是用于表示数据库中的数据的Java对象。PO通常是普通的Java类,其中包含了与数据库表中列对应的属性。在MyBatis框架中,PO通常使用实体类进行标记。
Service:Service是业务逻辑层的组件,它负责处理业务逻辑并调用DAO层进行数据访问。Service通常是一个Java类,其中包含了处理业务逻辑的方法。在Spring框架中,Service通常使用@Service注解进行标记。
Util:Util是工具类的缩写,它是用于提供一组通用的工具方法的组件。Util通常是一个Java类,其中包含了一组静态方法。在Java开发中,常见的Util包括StringUtils、DateUtils等。
```

开发顺序

```bash
首先,定义PO（Persistence Object）,即持久化对象,用于映射数据库中的表结构。PO常是一个普通的Java类,其中的属性对应着表中的字段。
接下来,定义DAO（Data Access Object）,即数据访问对象,用于对数据库进行操作。DAO通常是一个接口,其中定义了对PO进行增删改查等操作的方法。
然后,编写DAO的实现类,实现DAO接口中定义的方法。在实现类中,通常使用JDBC或ORM框架（如MyBatis、Hibernate等）来操作数据库。
定义Enums,即枚举类型,用于定义一些常量或枚举值。Enums通常是一个Java枚举类。
编写Util,即工具类,用于提供一些通用的方法或工具函数。Util通常是一个静态类,其中的方法都是静态方法。
定义Service,即服务层,用于实现业务逻辑。Service通常一个接口,其中定义了一些业务方法。
编写Service的实现类,实现Service接口中定义的方法。在实现类,通常会调用DAO中的方法来操作数据库。
定义Controller,即控制器,用于接收用户请求并调用相应的Service方法来处理请求。Controller通常是一个类,其中的方法对应着不同的请求路径和请求方法。
最后,定义Interceptors,即拦截器,于在请求处理前后进行一些额外的处理。Interceptors通常是一个类,实现了Spring框架中的HandlerInterceptor接口。
```

**打开文件夹作为 Intellij IDEA 项目**

![](assets/open.png)

**在本地 MySql 数据库执行项目中的 sql/Shop.sql 文件**

![](assets/Run%20the%20shop.sql.png)

![](assets/Configure%20the%20run.png)

**设置本地 Mysql 数据库的账号和密码**

![](assets/Local%20database%20configuration.png)

**maven 插件执行 tomcat7:run-war**

![](assets/The%20maven%20plugin%20executes%20tomcat7-run-war.png)

**用户地址**

`http://localhost:8888/Shop-SSM/shop-user/`

![](assets/User%20address.png)

**后台管理**

`http://localhost:8888/Shop-SSM/admin/`

![](assets/Back-office%20management.png)
