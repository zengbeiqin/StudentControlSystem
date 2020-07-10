package com.system.controller;

import com.system.pojo.Purchase;
import com.system.pojo.StudentInfo;
import com.system.response.CommonReturnType;
import com.system.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/add")
    @ResponseBody
    public CommonReturnType add(Purchase purchase, HttpSession session) {
        if (null != purchase) {
            StudentInfo student_info = (StudentInfo) session.getAttribute("student_Info");
            purchaseService.add(purchase, student_info);
            return CommonReturnType.create("保存成功", "success");
        }
        return CommonReturnType.create("保存失败", "fail");
    }

    @GetMapping("/purchaseList")
    @ResponseBody
    public CommonReturnType purchaseList() {
        List<Purchase> purchases = purchaseService.selectAll();
        return CommonReturnType.create(purchases, "success");
    }

    @GetMapping("/delPurchase")
    @ResponseBody
    public CommonReturnType delPurchase(Integer purchaseId) {
        purchaseService.delPurchase(purchaseId);
        return CommonReturnType.create("删除成功！", "success");
    }
}
