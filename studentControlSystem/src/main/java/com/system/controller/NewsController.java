package com.system.controller;

import cn.hutool.core.util.StrUtil;
import com.system.pojo.AdminInfo;
import com.system.pojo.News;
import com.system.response.CommonReturnType;
import com.system.service.NewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("news")
public class NewsController {
    @Resource
    private NewsService newsService;
    @Resource
    private HttpServletRequest httpServletRequest;
    @GetMapping("selectOne")
    public News selectOne(Integer id) {
        return this.newsService.queryById(id);
    }
    @PostMapping("addNews")
    @ResponseBody
    public CommonReturnType addNews(@RequestParam("newsName") String newsName,
                                    @RequestParam("content") String content) {
        if (StrUtil.isEmpty(newsName)
                || StrUtil.isEmpty(content)) {
            return CommonReturnType.create("新闻标题或内容不能为空","fail");
        }
        AdminInfo adminInfo = (AdminInfo) httpServletRequest.getSession().getAttribute("adminInfo");
        if (adminInfo==null){
            return CommonReturnType.create("请登录后再编辑新闻","fail");
        }
        News news = new News();
        news.setNewsName(newsName);
        news.setContent(content);
        news.setCreateTime(LocalDateTime.now());
        news.setRoleId(adminInfo.getId());

        Boolean result = newsService.addNews(news);
        if (result != null && result) {
            return CommonReturnType.create("添加成功", "success");
        }
        return CommonReturnType.create("添加失败", "fail");
    }

    /* 删除新闻*/
    @GetMapping("newsDel")
    @ResponseBody
    public CommonReturnType newsDel(@RequestParam("newsId") Integer newsId) {
        Boolean result = newsService.delRole(newsId);
        if (result != null && result) {
            return CommonReturnType.create("删除成功", "success");
        }
        return CommonReturnType.create("删除失败", "fail");
    }

    /*查询所有新闻*/
    @GetMapping("newsList")
    @ResponseBody
    public CommonReturnType newsList() {
            List<News> newsList = newsService.queryAll();
        if (newsList != null && !newsList.isEmpty()) {
            return CommonReturnType.create(newsList, "success");
        }
        return CommonReturnType.create(null, "fail");
    }
}