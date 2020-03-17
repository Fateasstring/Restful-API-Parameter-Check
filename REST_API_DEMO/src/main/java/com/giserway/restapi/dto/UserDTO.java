package com.giserway.restapi.dto;

import com.giserway.restapi.annotation.Sex;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDTO {

    /** 定义新增校验组 */
    public interface Add{}

    /** 定义更新校验组 */
    public interface Update{}


    /** 用户id
        添加id校验并指定不同的校验组
     */
    @Null(groups = Add.class, message = "新增用户时id应该为空")
    @NotNull(groups = Update.class, message = "更新用户时id不能为空")
    private Integer id;

    /** 用户姓名 */
    @NotBlank(groups = {Add.class, Update.class} ,message = "用户名不能为空")
    private String name;

    /** 用户性别，在SexValid.java类中自定义了Sex注解 */
    @Sex(groups = {Add.class, Update.class})
    private String sex;

    /** 用户年龄 */
    @Min(groups = {Add.class, Update.class},value = 18, message = "年龄不能必须大于等于18")
    private Integer age;

    /** 用户手机号码 */
    private String phone;

    /** 用户邮箱 */
    @Email(groups = {Add.class, Update.class}, message = "邮箱格式错误")
    private String email;

}
