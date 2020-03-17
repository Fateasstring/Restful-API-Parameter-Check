package com.giserway.restapi.controller;

import com.giserway.restapi.dto.ResponseDTO;
import com.giserway.restapi.dto.ResponseStatusCode;
import com.giserway.restapi.dto.UserDTO;
import com.giserway.restapi.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/** 中级程序员参数校验 */

@RestController
@RequestMapping("/mid")
@Slf4j
public class UserMidController {
    /**
     Controller控制层写参数接收的入口，需要注意的是 @Valid和BindingResult是一一对应的
     如果有多个@Valid，那么每个@Valid后面都需要添加BindingResult用于接收bean中的校验信息
     @param userDTO
     @param bindingResult
     @return
     */

    @PostMapping(value = "/paramCheck", consumes = "application/json", produces = "application/json")
    public ResponseDTO paramCheck(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult){

        log.info("---------------mid paramCheck----------------");
        if (bindingResult.hasErrors()){
            return new ResponseDTO(ResponseStatusCode.PARAMETER_ERROR, handleError(bindingResult));
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        log.info(user.toString());
        /** 调用业务逻辑层 */
        return new ResponseDTO(ResponseStatusCode.SUCCESS,userDTO);
    }

    /** 处理校验错误的方法
        @param bindingResult
        @return
     */
    private String handleError(BindingResult bindingResult){

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuffer sb = new StringBuffer();

        for (ObjectError error : allErrors){
            sb.append("[").append(error.getDefaultMessage()).append("]");
        }

        return sb.toString();
    }

}
