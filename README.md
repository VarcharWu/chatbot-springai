ChatDemo 项目

一、项目简介
ChatDemo 是一个基于 Spring Boot 的示例应用，演示如何通过 Spring AI 调用 Ollama 本地/远端模型（OllamaChatModel），并结合 MyBatis-Plus 持久化聊天记录到 MySQL 数据库。本 README 将帮助你快速上手现有 Spring Boot 部分。

二、技术栈
- 框架：Spring Boot 3.x
- AI 调用：Spring AI + OllamaChatModel
- 持久化：MyBatis-Plus
- 数据库：MySQL
- 构建：Maven
- 运行端口：8080

三、功能概览
1. AI 聊天接口
   - 通过 OllamaChatModel 向模型发送 prompt，返回模型回复。
2. 聊天记录管理
   - 利用 MyBatis-Plus 对 messages 表进行增删改查。

四、项目结构
```
src/
├── main/
│   ├── java/com/example/chatdemo/
│   │   ├── ChatDemoApplication.java        // 启动类
│   │   ├── controller/MessageController.java // REST 控制器
│   │   ├── entity/Message.java             // 实体类
│   │   ├── mapper/MessageMapper.java       // MyBatis-Plus 映射接口
│   │   └── service/
│   │       ├── IMessageService.java        // Service 接口
│   │       └── MessageServiceImpl.java     // Service 实现
│   └── resources/
│       ├── application.properties          // 配置文件
│   └── mapper/*.xml                        // MyBatis-Plus XML（可选）
└── test/
```

五、环境准备
1. JDK 17+
2. Maven 3.6+
3. MySQL 5.7+，并创建数据库 chat_db：
```sql
   CREATE DATABASE chat_db
     CHARACTER SET utf8mb4
     COLLATE utf8mb4_unicode_ci;
```
4. Ollama 服务
   - 本地或远端运行 Ollama，确保 base-url 可访问
   - 示例：http://mickymmw.online:12379

六、配置说明（application.properties）
```java
spring.application.name=chat-demo
server.port=8080
```
# Ollama AI
```java
spring.ai.ollama.base-url=你的ollama的地址
spring.ai.ollama.chat.options.model=你ollma的模型名称

# MySQL 数据源
spring.datasource.url=你的MySQL数据源地址
spring.datasource.username=你的MySQL数据库账号
spring.datasource.password=你的MySQL数据库密码
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# MyBatis-Plus 配置
mybatis-plus.mapper-locations=classpath:/mapper/*.xml
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 日志级别
logging.level.com.example.chat=DEBUG
```
注意：请根据你本地/测试环境修改数据库连接和 Ollama 服务地址。

七、快速启动
1. 克隆项目并进入目录：
```bash
   git clone https://your-repo-url/chatdemo.git
   cd chatdemo
```
2. 修改 ```src/main/resources/application.properties``` 中的配置。
3. 使用 Maven 构建并启动：
   ```bash
   mvn clean spring-boot:run
   ```
5. 访问 AI 聊天接口：
   ```bash
   GET http://localhost:8080/chat
   ```
   返回 AI 模型对 "hello" 的回答。

八、接口说明
方法    路径    描述
GET     /chat  调用 OllamaChatModel，返回 AI 回复

若需存储消息或扩展其他 CRUD 接口，可在 MessageController 中新增相应方法，并调用 IMessageService。
