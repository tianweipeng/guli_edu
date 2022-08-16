package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录、用户信息")
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {
    //login
    @PostMapping("login")
    public R login(){

        return R.ok().data("token", "admin");
    }

    //info
    @GetMapping("info")
    public R info(){
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "http://img.2qqtouxiang.com/pic/TX10402_07.jpg");
    }
}
