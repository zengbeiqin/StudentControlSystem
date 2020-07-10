package com.system.controller;

import cn.hutool.system.UserInfo;
import com.system.pojo.Posts;
import com.system.pojo.StudentInfo;
import com.system.response.CommonReturnType;
import com.system.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @PostMapping("/addPosts")
    @ResponseBody
    public CommonReturnType addPosts(Posts posts, HttpSession session) {
        if (null != posts) {
            StudentInfo student_info = (StudentInfo) session.getAttribute("student_Info");
            boolean result = postsService.addPosts(posts, student_info);
            if (result) {
                return CommonReturnType.create("提交成功", "success");
            }
        }
        return CommonReturnType.create("提交失败", "fail");
    }

    @GetMapping("/postsList")
    @ResponseBody
    public CommonReturnType postsList() {
        List<Posts> posts = postsService.selectAll();
        return CommonReturnType.create(posts, "success");
    }

    @GetMapping("/delPosts")
    @ResponseBody
    public CommonReturnType delPosts(Integer postsId) {
        postsService.delPosts(postsId);
        return CommonReturnType.create("删除成功！", "success");
    }

    @PostMapping("/post")
    @ResponseBody
    public CommonReturnType post(Integer postsId, String oddNumber) {
        boolean result = postsService.post(postsId, oddNumber);
        if (result) {
            return CommonReturnType.create("邮寄成功！", "success");
        }
        return CommonReturnType.create("邮寄失败！", "fail");
    }

    @GetMapping("/myPostsList")
    @ResponseBody
    public CommonReturnType myPostsList(HttpSession session) {
        StudentInfo student_info = (StudentInfo)session.getAttribute("student_Info");
        List<Posts> posts = postsService.selectMySelf(Integer.parseInt(student_info.getStudentNum()));
        return CommonReturnType.create(posts, "success");
    }

}
