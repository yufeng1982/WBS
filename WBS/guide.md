# 代码生成器
### 注意事项
* 如果数据库带schema 生成代码的时候需要设置相关schema
* dsc.setSchemaName("public"); // TODO 配置 schema
* 注入自定义配置  map.put("schema", "public"); // TODO 自定义实体类对应表的schema
* 修改模板使用自定义配置 @TableName(value="${table.name}",schema="${cfg.schema}")

# mybatis-plus
### 相关配置
* 自动设置值配置 参照BaseEntity.java,MyMetaObjectHandler.java
* 乐观锁插件，分页插件，使用枚举用名字存储 参照 CommonConfiguration.java
* 如果使用枚举名字存储，在枚举类中使用@EnumValue//标记数据库存的值

### DB 配置信息加密
* 生成加密信息保存，参照DBConfigEncrypt.java
* 服务器启动输入秘钥，参照ServletInitializer.java run方法

# shiro-jwt
### 原理
* shiro-jwt 适合前后端分离系统，用户登录之后在后端生产一个token(加密处理过),该token携带用户名、密码、过期时间等信息返回给前端，然后在其他请求体的header中携带此token，访问就可以畅通无阻了

### 配置
* 参照ShiroConfiguration.java 和com.wbs.shiro包代码


# 安全 性能
* db配置加密代码，代码生成器代码，可以统一都放到test资源文件夹，相关的jar包使用test scope,这样打包发布的时候就不会将这些代码或者jar一起打包发布，可以提高性能和安全性。