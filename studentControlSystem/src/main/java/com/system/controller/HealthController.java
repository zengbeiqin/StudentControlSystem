package com.system.controller;

import com.system.pojo.HealthInfo;
import com.system.pojo.StudentInfo;
import com.system.response.CommonReturnType;
import com.system.service.HealthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/health")
public class HealthController {

    @Autowired
    private HealthInfoService healthInfoService;

    @PostMapping("/addHealth")
    @ResponseBody
    public CommonReturnType addHealth(HealthInfo healthInfo, HttpSession session) {
        if (healthInfo != null) {
            StudentInfo student_info = (StudentInfo) session.getAttribute("student_Info");
            boolean result = healthInfoService.addHealth(healthInfo,student_info);
            if (result) {
                return CommonReturnType.create("打卡成功", "success");
            }
        }
        return CommonReturnType.create("打卡失败", "fail");
    }

    @GetMapping("/healthList")
    @ResponseBody
    public CommonReturnType healthList(){
      List<HealthInfo> healthInfoList =  healthInfoService.selectHealthList();
      return CommonReturnType.create(healthInfoList,"success");
    }

    @GetMapping("/healthDel")
    @ResponseBody
    public CommonReturnType healthDel(Integer healthId){
        healthInfoService.healthDel(healthId);
        return CommonReturnType.create("删除成功","success");
    }
}
