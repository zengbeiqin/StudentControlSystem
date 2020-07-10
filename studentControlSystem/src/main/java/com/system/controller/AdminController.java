package com.system.controller;

import cn.hutool.core.util.StrUtil;
import com.system.pojo.AdminInfo;
import com.system.pojo.StudentInfo;
import com.system.response.CommonReturnType;
import com.system.service.AdminService;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login() {
        return "adminlogin";
    }

    @RequestMapping("/register")
    public String register() {
        return "adminregister";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public CommonReturnType checkLogin(AdminInfo adminInfo, HttpSession session) {
        if (StrUtil.isBlank(adminInfo.getAdminName())
                || StrUtil.isBlank(adminInfo.getAdminPassword())) {
            return CommonReturnType.create("信息不能为空", "fail");
        }
        AdminInfo adminInfo1 = adminService.login(adminInfo);
        if (adminInfo1!=null){
        session.setAttribute("adminInfo", adminInfo1);
        return CommonReturnType.create("登录成功！");
        }
        return CommonReturnType.create("用户名或密码输入错误！","fail");
    }

    @RequestMapping("/checkRegister")
    @ResponseBody
    public CommonReturnType checkRegister(AdminInfo adminInfo, HttpSession session) {
        if (StrUtil.isBlank(adminInfo.getAdminName())
                || StrUtil.isBlank(adminInfo.getAdminPassword())) {
            return CommonReturnType.create("信息不能为空", "fail");
        }
        boolean result = adminService.register(adminInfo);
        if (result) {
            return CommonReturnType.create("注册成功！");
        }
        return CommonReturnType.create("注册失败！", "fail");
    }

}
