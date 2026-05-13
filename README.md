# pet-care-cloud

基础 Spring Cloud Alibaba 学习项目，Java 版本为 1.8。

## 模块

- `pet-common`: 公共响应对象和基础 DTO。
- `pet-user-service`: 用户服务示例，提供用户查询接口。
- `pet-order-service`: 订单服务示例，通过 OpenFeign 调用用户服务。
- `pet-gateway`: Spring Cloud Gateway 示例，按路径转发到微服务。

## 技术版本

- JDK 1.8
- Spring Boot 2.6.13
- Spring Cloud 2021.0.5
- Spring Cloud Alibaba 2021.0.5.0
- Nacos Discovery / Config
- OpenFeign
- Spring Cloud Gateway

## 本地启动

1. 启动 Nacos，默认地址为 `127.0.0.1:8848`。
2. 编译项目：

```bash
mvn clean package
```

3. 分别启动服务：

```bash
mvn -pl pet-user-service spring-boot:run
mvn -pl pet-order-service spring-boot:run
mvn -pl pet-gateway spring-boot:run
```

如需修改 Nacos 地址：

```bash
NACOS_SERVER_ADDR=192.168.1.10:8848 mvn -pl pet-user-service spring-boot:run
```

## 示例接口

- 用户服务: `GET http://localhost:8081/users/1`
- 订单服务: `GET http://localhost:8082/orders/1001`
- 网关转发用户服务: `GET http://localhost:9000/user/users/1`
- 网关转发订单服务: `GET http://localhost:9000/order/orders/1001`
