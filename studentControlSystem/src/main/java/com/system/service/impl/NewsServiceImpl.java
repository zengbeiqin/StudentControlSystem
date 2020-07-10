package com.system.service.impl;

import com.system.mapper.AdminInfoMapper;
import com.system.mapper.NewsMapper;
import com.system.pojo.AdminInfo;
import com.system.pojo.News;
import com.system.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsDao;
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public News queryById(Integer id) {
        return this.newsDao.selectByPrimaryKey(id);
    }


    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News insert(News news) {
        this.newsDao.insert(news);
        return news;
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News update(News news) {
        this.newsDao.updateByPrimaryKey(news);
        return this.queryById(news.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.newsDao.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean addNews(News news) {
        int re = newsDao.insertSelective(news);
        return re > 0;
    }

    @Override
    public Boolean delRole(Integer newsId) {
        int re = newsDao.deleteByPrimaryKey(newsId);
        return re > 0;
    }

    @Override
    public List<News> queryAll() {
        List<News> newsList = newsDao.selectAll();
        for (News news : newsList) {
            Integer roleId = news.getRoleId();
            AdminInfo admin  = new AdminInfo();
            admin.setId(roleId);
            AdminInfo adminInfo = adminInfoMapper.selectOne(admin);
            news.setName(adminInfo.getAdminName());
        }

        return newsList;
    }
}