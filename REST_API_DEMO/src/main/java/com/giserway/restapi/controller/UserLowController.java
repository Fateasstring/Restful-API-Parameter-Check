package com.giserway.restapi.controller;

import com.giserway.restapi.dto.UserDTO;
import com.giserway.restapi.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 初级程序员处理参数校验 */

@RestController
@RequestMapping("/low")
@Slf4j
public class UserLowController {

    @PostMapping(value = "/paramCheck", consumes = "application/json", produces = "application/json")
    public String paramCheck(@RequestBody UserDTO userDTO){

        log.info("----------paramCheck-----------");

        if(StringUtils.isEmpty(userDTO.getName())){
            return "用户名不能为空";
        }

        if (StringUtils.isEmpty(userDTO.getAge()) || Integer.valueOf(userDTO.getAge()) < 18){
            return "年龄不合法";
        }

        if (StringUtils.isEmpty(userDTO.getSex()) || (!"0".equals(userDTO.getSex()) && !"1".equals(userDTO.getSex()))){
            return "性别不合法";
        }

        User user = new User();
        /** 使用org.springframework.beans.BeanUtils.copyProperties方法进行对象之间属性的赋值，
            避免通过get、set方法一个一个属性的赋值
         BeanUtils.copyProperties(source, target);--->对象属性拷贝
         将源对象的属性拷贝到目标对象:
         @param source 源对象
         @param target 目标对象
         */
        BeanUtils.copyProperties(userDTO,user);
        log.info(user.toString());

        return "新增用户成功！";
    }
}
