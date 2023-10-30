# 主要类

## SpringApplication

主要方法：

* 构造函数
* run();

## ApplicationContextInitializer

## ApplicationListener

## SpringApplicationRunListener 

唯一实现 EventPublishingRunListener 监听多个运行状态方法：

| **监听方法**                                     | Spring Boot 事件                      | 阶段说明                                                     | Spring Boot 起始版本 |
| ------------------------------------------------ | ------------------------------------- | ------------------------------------------------------------ | -------------------- |
| starting()                                       | `ApplicationStartingEvent`            | Spring 应用刚启动                                            | 1.0                  |
| environmentPrepared(ConfigurableEnvironment)     | `ApplicationEnvironmentPreparedEvent` | ConfigurableEnvironment 准备妥当，允许将其调整               | 1.0                  |
| contextPrepared(ConfigurableApplicationContext)  | 没有发送事件                          | ConfigurableApplicationContext 准备妥当，允许将其调整        | 1.0                  |
| contextLoaded(ConfigurableApplicationContext)    | `ApplicationPreparedEvent`            | ConfigurableApplicationContext 已装载，但仍未启动            | 1.0                  |
| started(ConfigurableApplicationContext)          | `ApplicationStartedEvent`             | ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成 | 2.0                  |
| running(ConfigurableApplicationContext)          | `ApplicationReadyEvent`               | Spring 应用正在运行                                          | 2.0                  |
| failed(ConfigurableApplicationContext,Throwable) | `ApplicationFailedEvent`              | Spring 应用运行失败                                          | 2.0                  |

# 主要文件

META-INF/spring.factories