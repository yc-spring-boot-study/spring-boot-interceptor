package com.chuan.handlerinterceptor.springbootinterceptor.controller;

import com.chuan.handlerinterceptor.springbootinterceptor.annotation.UserAuthenticate;
import com.chuan.handlerinterceptor.springbootinterceptor.annotation.UserId;
import com.chuan.handlerinterceptor.springbootinterceptor.annotation.UserMobile;
import com.chuan.handlerinterceptor.springbootinterceptor.entry.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//@Validated
@RestController
public class TestAuthController {

    @UserAuthenticate(permission = true)
    @GetMapping("test")
    public String testAuth(@UserId Long userId, @UserMobile String userMobile) {
        String str = "userId : " + userId + "  userMobile :" + userMobile;
        return str;
    }

    @PostMapping("send")
    public String send(@RequestBody User user) {
        return user.toString();
    }

    @PostMapping("/toImport")
    public String toImport(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        return "提示信息：上传成功！";
    }
}
