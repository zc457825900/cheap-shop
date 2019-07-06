# cheap-shop
springcloud实战商城项目

技术栈：Sprinboot+mybatis-plus+redis+rabbitmq+mysql
（1）Springboot2.0.7,Spring Cloud Finchley.SR2版本（目前添加eureka、配置中心）
（2）Mybatis-plus简化数据操作,generator自动生成实体、service层、mapper层、rest层
（3）redis缓存用于商品列表、用户缓存
（4）rabbitmq用于订单和库存系统异步处理，缓解服务请求数过大（削峰）
