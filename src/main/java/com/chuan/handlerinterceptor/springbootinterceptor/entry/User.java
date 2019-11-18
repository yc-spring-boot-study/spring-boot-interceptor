package com.chuan.handlerinterceptor.springbootinterceptor.entry;

import lombok.Data;

@Data
public class User {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
