package com.giserway.restapi.dto;

import lombok.Data;

/** 接口统一返回对象 */

@Data
public class ResponseDTO<T> {

    /** 状态响应码 */
    private String code;

    /** 响应描述信息 */
    private String msg;

    /** 响应数据 */
    private T data;

    /** 无data的返回构造方法
        @param: responseStatusCode
     */
    public ResponseDTO(ResponseStatusCode responseStatusCode){
        this.code = responseStatusCode.getCode();
        this.msg = responseStatusCode.getMsg();
    }

    /** 有data的方法返回构造方法
        @param: responseStatusCode
        @param: data
     * */
    public ResponseDTO(ResponseStatusCode responseStatusCode, T data){
        this(responseStatusCode);
        this.data = data ;
    }
}
