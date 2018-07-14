# spring-cloud-demo 
##https://windmt.com/tags/Spring-Cloud/
- 以上是所有联系基础的来源,请参阅
 - 练习用
 - 也碰了一些小坑
关于spring boot 的2.0.3的
eureka-client的配置

在依赖里面



除了要加入spring cloud client的依赖

以外需要加入 spring boot web的依赖

```groovy
compile('org.springframework.boot:spring-boot-starter-web')
compile('org.springframework.cloud:spring-cloud-starter-netflix-eureka-client')
```


入口类
2.0的版本里面已经不需要再client类的上面添加标签了

```java
@SpringBootApplication
public class EurekaClientApplication {
	public static void main(String[] args) {
    	SpringApplication.run(EurekaClientApplication.class, args);
	}
}
```


在application.yml里面的配置
已经不需要添加

```yml
  eureka:
    client:
  	register-with-eureka:true
  	fetch-registry:true
# 这后面的需要加
  server:
    port: 8000
  eureka:
    client:
      service-url:
        defaultZone: http://localhost:8761/eureka/
  
```





​	  
	  

