package com.giserway.restapi.advice;

import com.giserway.restapi.dto.ResponseDTO;
import com.giserway.restapi.dto.ResponseStatusCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/** 全局异常处理 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandlerAdvice {

    /** 接口参数异常校验
        @param e
        @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO handleIllegalParamException(MethodArgumentNotValidException e){
        String tips = "参数不合法";
        BindingResult bindingResult = e.getBindingResult();
        if (e.getBindingResult().hasErrors()){
            tips = handleError(bindingResult);
        }
        return new ResponseDTO(ResponseStatusCode.PARAMETER_ERROR, tips);
    }

    /**
        处理校验错误的方法
        @param： bindingResult
        @return
     * */
    private String handleError(BindingResult bindingResult){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : allErrors){
            sb.append("[").append(error.getDefaultMessage()).append("]");
        }
        return sb.toString();
    }

    @ExceptionHandler(Exception.class)
    public ResponseDTO handleException(Exception e){
        return new ResponseDTO(ResponseStatusCode.CUSTOMEXCEPTION);
    }


}
