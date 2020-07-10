package com.system.controller;

import com.system.pojo.StuInfo;
import com.system.pojo.StudentInfo;
import com.system.response.CommonReturnType;
import com.system.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/stuinfo")
public class StuinfoController {

    @Autowired
    public StuInfoService stuInfoService;

    @PostMapping("/addStuInfo")
    @ResponseBody
    public CommonReturnType addStuInfo(StuInfo stu_info, HttpSession session) {
        if (stu_info != null) {
            StudentInfo student_info = (StudentInfo) session.getAttribute("student_Info");//不用改
            boolean result = stuInfoService.addStuInfo(stu_info,student_info);
            if (result) {
                return CommonReturnType.create("完善个人信息成功", "success");
            }
        }
        return CommonReturnType.create("完善个人信息失败", "fail");
    }

    @GetMapping("/StuInfoList")
    @ResponseBody
    public CommonReturnType StuInfoList(){
      List<StuInfo> stuInfoList =  stuInfoService.selectStuInfoList();
      return CommonReturnType.create(stuInfoList,"success");
    }
    @GetMapping("/StuInfoDel")
    @ResponseBody
    public CommonReturnType StuInfoDel(Integer stuinfoId){
        stuInfoService.StuInfoDel(stuinfoId);
        return CommonReturnType.create("删除成功","success");
    }

}
