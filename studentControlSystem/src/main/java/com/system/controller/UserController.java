package com.system.controller;

import cn.hutool.core.util.StrUtil;
import com.system.pojo.StudentInfo;
import com.system.response.CommonReturnType;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public CommonReturnType checkLogin(StudentInfo studentInfo, HttpSession session) {
        if (StrUtil.isBlank(studentInfo.getName())
                || StrUtil.isBlank(studentInfo.getPassword())
                || StrUtil.isBlank(studentInfo.getStudentNum())) {
            return CommonReturnType.create("信息不能为空", "fail");
        }
        StudentInfo student_info = userService.login(studentInfo);
        session.setAttribute("student_Info", student_info);
        return CommonReturnType.create("登录成功！");
    }

    @RequestMapping("/checkRegister")
    @ResponseBody
    public CommonReturnType checkRegister(StudentInfo studentInfo, HttpSession session) {
        if (StrUtil.isBlank(studentInfo.getName())
                || StrUtil.isBlank(studentInfo.getPassword())
                || StrUtil.isBlank(studentInfo.getStudentNum())) {
            return CommonReturnType.create("信息不能为空", "fail");
        }
        boolean result = userService.register(studentInfo);
        if (result) {
            return CommonReturnType.create("注册成功！");
        }
        return CommonReturnType.create("注册失败!", "fail");
    }
}




