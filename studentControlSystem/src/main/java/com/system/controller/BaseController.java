package com.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class BaseController {

    @GetMapping("/show")
    public String show(){
        return "show";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("student_Info");
        session.removeAttribute("adminInfo");
        return "redirect:user/login";
    }

    @GetMapping("/toStuInfo")
    public String toStuInfo(){
        return "stuinfo";
    }
    @GetMapping("/toStuInfoList")
    public String toStuInfoList(){
        return "stuinfoList";
    }



    @GetMapping("/toHealth")
    public String toHealth(){
        return "punch";
    }
    @GetMapping("/toHealthList")
    public String toHealthList(){
        return "healthList";
    }



    @GetMapping("/toPosts")
    public String toPosts(){
        return "posts";
    }
    @GetMapping("/toPostsList")
    public String toPostsList(){
        return "postsList";
    }
    @GetMapping("/toMyPosts")
    public String toMyPosts(){
        return "myPostsList";
    }



    @GetMapping("/toPurchase")
    public String toPurchase(){ return "purchase"; }
    @GetMapping("/toMybuy")
    public String toMybuy(){ return "mybuy"; }
    @GetMapping("/toPurchaseList")
    public String toPurchaseList(){
        return "purchaseList";
    }

    @GetMapping("/toRenliu")
    public String toRenliu(){ return "renliu"; }



    @GetMapping("/toNewsAdd")
    public String toNewsAdd1(){
        return "newsAdd";
    }


    @GetMapping("/toAdddoc")
    public String toAdddoc(){
        return "adddoc";
    }
    @GetMapping("/toForm")
    public String toForm(){ return "form"; }
    @GetMapping("/toDitu")
    public String toDitu(){ return "ditu"; }
    @GetMapping("/toDitu2")
    public String toDitu2(){ return "ditu2"; }
    @GetMapping("/toZhishi")
    public String toZhishi(){ return "zhishi"; }

    @GetMapping("/toNewsList")
    public String toNewsList(){
        return "newsList";
    }
    @GetMapping("/toNewsList1")
    public String toNewsList1(){
        return "newsList1";
    }
}
