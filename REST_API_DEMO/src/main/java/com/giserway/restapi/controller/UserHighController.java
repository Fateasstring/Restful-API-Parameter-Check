package com.giserway.restapi.controller;

import com.giserway.restapi.dto.ResponseDTO;
import com.giserway.restapi.dto.ResponseStatusCode;
import com.giserway.restapi.dto.UserDTO;
import com.giserway.restapi.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
    高级程序员处理参数
 */
@RestController
@RequestMapping("/high")
@Slf4j
public class UserHighController {

    @PostMapping(value = "/paramCheck", consumes = "application/json", produces = "application/json")
    public ResponseDTO paramCheck(@Valid @RequestBody UserDTO userDTO){
        log.info("-------------------high paramCheck-----------------");
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        log.info(user.toString());

        /** 调用业务逻辑层 */
        return new ResponseDTO(ResponseStatusCode.SUCCESS,userDTO);
    }

        /** 分组校验测试1
            @param: userDTO
            @return
         */
    @PostMapping(value = "/users")
    public ResponseDTO addUser(@Validated(UserDTO.Add.class) @RequestBody UserDTO userDTO){
            log.info("addUser-------------------------");
            userDTO.setId(1);

            /** doSomething() */
            return new ResponseDTO(ResponseStatusCode.SUCCESS, userDTO);
    }

        /**分组校验测试2
            @param: userDTO
            @return
         */
    @PutMapping(value = "/users")
    public ResponseDTO updateUser(@Validated(UserDTO.Update.class) @RequestBody UserDTO userDTO){
            log.info("updateUser-------------");

            /** dosmething() **/
            return new ResponseDTO(ResponseStatusCode.SUCCESS, userDTO);

    }
}u