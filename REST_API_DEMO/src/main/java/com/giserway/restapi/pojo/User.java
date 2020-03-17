package com.giserway.restapi.pojo;

import java.io.Serializable;

public class User implements Serializable { /** 序列化 */

    /** 用户id*/
    private Integer id;

    /** 用户姓名 */
    private String name;

    /** 用户性别 */
    private String sex;

    /** 用户年龄 */
    private Integer age;

    /** 用户手机号码 */
    private String phone;

    /** 用户邮箱 */
    private String email;

    /** 构造器 */
    public User(){}

    public User(Integer id){
        this.id = id ;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
