## **Spring Web MVC REST**

### 主要类

#### DispatcherServlet

* ```java
  doDispatch
  ```

  * ```java
    getHandler
    ```

  * ```java
    getHandlerAdapter
    ```

  * ```java
    handle
    ```

#### InvocableHandlerMethod

* ```
  invokeForRequest
  ```

#### HandlerMethodArgumentResolver

#### HandlerMethodReturnValueHandler

#### HttpMessageConverter

#### RequestResponseBodyMethodProcessor

* ```
  resolveArgument
  ```

* ```
  handleReturnValue
  ```

## Web MVC REST 注解

### 定义

| 注解            | 说明                                |      |
| --------------- | ----------------------------------- | ---- |
| @Controller     | 应用控制器注解声明，Spring 模式注解 |      |
| @RestController | 等效于 @Controller + @ReponseBody   |      |

### 映射

| 注解            | 说明                                                         |      |
| --------------- | ------------------------------------------------------------ | ---- |
| @RequestMapping | 应用控制器注解声明，请求方法和处理方法之间的映射             |      |
| @GetMapping     | GET 方法映射，等效于 @RequestMapping(method = RequestMethod.GET) |      |
| @PostMapping    | POST 方法映射，等效于 @RequestMapping(method = RequestMethod.POST) |      |
| @PutMapping     | PUT 方法映射，等效于 @RequestMapping(method = RequestMethod.PUT) |      |
| @DeleteMapping  | DELETE 方法映射，等效于 @RequestMapping(method = RequestMethod.DELETE) |      |
| @PatchMapping   | PATCH 方法映射，等效于 @RequestMapping(method = RequestMethod.PATCH) |      |

### 请求

| 注解           | 说明                                 |      |
| -------------- | ------------------------------------ | ---- |
| @RequestParam  | 获取请求参数                         |      |
| @RequestHeader | 获取请求头                           |      |
| @CookieValue   | 获取 Cookie 值                       |      |
| @RequestBody   | 获取完整请求主体内容                 |      |
| @PathVariable  | 获取请求路径变量                     |      |
| RequestEntity  | 获取请求内容（包括请求头和请求主体） |      |

### 响应

| 注解           | 说明                             |      |
| -------------- | -------------------------------- | ---- |
| @ResponseBody  | 响应主体注解声明                 |      |
| ResponseEntity | 响应内容（包括响应头和响应主体） |      |
| ResponseCookie | 响应 Cookie 内容                 |      |

### 拦截

| 注解                  | 说明                         |      |
| --------------------- | ---------------------------- | ---- |
| @RestControllerAdvice | @RestController 注解切面通知 |      |
| HandlerInterceptor    | 处理方法拦截器               |      |

### 跨域

| 注解                             | 说明             |      |
| -------------------------------- | ---------------- | ---- |
| @CrossOrigin                     | 资源跨域声明注解 |      |
| CorsFilter                       | 资源跨域拦截器   |      |
| WebMvcConfigurer#addCorsMappings | 注册资源跨域信息 |      |

## 参考

* https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/spring-framework-reference/web.html#mvc-controller