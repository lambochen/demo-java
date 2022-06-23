# Spring Boot CLI demo

此目录为 Spring Boot CLI 的一个案例，本地运行请使用（运行命令前请确保本地已安装 Spring Boot CLI）：

```shell
spring run ./
```

运行前置依赖：

- 本地已安装 Spring Boot CLI
- 本地已安装 Maven


## 本地完整启动日志

```shell
lambochen@LamboChendeMBP springbootcli-demo % spring run ./

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.0)

2022-06-24 00:30:12.367  INFO 13625 --- [       runner-0] o.s.boot.SpringApplication               : Starting application using Java 1.8.0_282 on LamboChendeMBP.mshome.net with PID 13625 (started by lambochen in /Users/lambochen/workspace/lambochen/demo-java/springbootcli-demo)
2022-06-24 00:30:12.380  INFO 13625 --- [       runner-0] o.s.boot.SpringApplication               : No active profile set, falling back to 1 default profile: "default"
2022-06-24 00:30:15.332  INFO 13625 --- [       runner-0] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-06-24 00:30:15.350  INFO 13625 --- [       runner-0] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-06-24 00:30:15.351  INFO 13625 --- [       runner-0] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.63]
2022-06-24 00:30:15.398  INFO 13625 --- [       runner-0] org.apache.catalina.loader.WebappLoader  : Unknown class loader [org.springframework.boot.cli.compiler.ExtendedGroovyClassLoader$DefaultScopeParentClassLoader@1c1c485b] of class [class org.springframework.boot.cli.compiler.ExtendedGroovyClassLoader$DefaultScopeParentClassLoader]
2022-06-24 00:30:15.491  INFO 13625 --- [       runner-0] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-06-24 00:30:15.491  INFO 13625 --- [       runner-0] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2722 ms
2022-06-24 00:30:15.772  INFO 13625 --- [       runner-0] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-06-24 00:30:16.086  INFO 13625 --- [       runner-0] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-06-24 00:30:16.951  WARN 13625 --- [       runner-0] o.s.b.a.AutoConfigurationPackages        : @EnableAutoConfiguration was declared on a class in the default package. Automatic @Repository and @Entity scanning is not enabled.
2022-06-24 00:30:18.292  INFO 13625 --- [       runner-0] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-06-24 00:30:18.330  INFO 13625 --- [       runner-0] o.s.boot.SpringApplication               : Started application in 6.62 seconds (JVM running for 11.893)
2022-06-24 00:30:31.076  INFO 13625 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-06-24 00:30:31.077  INFO 13625 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-06-24 00:30:31.086  INFO 13625 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 9 ms
^C2022-06-24 00:31:57.733  INFO 13625 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-06-24 00:31:57.746  INFO 13625 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```