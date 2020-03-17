package com.giserway.restapi.controller;


import org.springframework.web.bind.annotation.*;


/** 用户的CRUD接口 */
@RestController
public class UserController {

    /** 获取所有用户信息
        @return
     */
    @GetMapping(value = "/users", produces = "application/json")
    public String getUsers(){
        /** 返回体后面统一封装Json对象 */
        return "get users !";
    }

    /** 通过userId获取用户信息
        @param userId
        @return
     */
    @GetMapping(value = "/user/{userId}", produces = "application/json")
    public String getUserById(@RequestParam(value = "userId") String userId){
        /** 返回体后面统一封装Json对象 */
        return "get user !";
    }

    /** 创建用户
        @return
     */
    @PostMapping(value = "/users", consumes = "application/json",produces = "application/json")
    public String createser(){
        /** 返回体后面统一封装Json对象 */
        return "create users!";
    }

    /** 更新所有用户信息
        @return
     */
    @PutMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public String updateUserById(){
        return "update users !";
    }

    /** 删除所有用户信息
        @return
     */
    @DeleteMapping(value = "/users", produces = "application/json")
    public String deleteUsers(){
        /** 返回体后面统一封装Json对象 */
        return "delete all users !";
    }

    /** 通过 userId 删除用户信息
        @return
     */
    @DeleteMapping(value = "/users/{useId}",consumes = "application/json", produces = "application/json")
    public String deleteUserById(@RequestParam(value = "userId") String userID){
        return "delete user !";
    }
}

/**
 @RequestMapping 用于映射 url 到控制器类的一个特别处理程序方法。
                    可用于方法和类上面，也就是通过url找到对应的方法
    其有8个属性：
 1.value ：指定请求的实际地址。
 2.method ：指定请求的method类型（GET,POST,PUT,DELETE）等。
 3.consumes ： 指定处理请求的提交内容类型（Context-Type）。
 4.produces ： 指定返回的内容类型，还可以设置返回值的字符编码。
 5.params : 指定request中必须包含某些参数值，才让该方法处理。
 6.headers : 指定request中必须包含某些特定的header值，才让该方法处理请求。

 @GetMapping 与 @PostMapping 是组合注解
    @GetMapping = @RequestMapping(method = Request.GET)
    @PostMapping = @RequestMapping(method = Request.POST)

 * */