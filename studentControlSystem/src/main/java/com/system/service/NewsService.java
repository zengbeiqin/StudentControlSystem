package com.system.service;


import com.system.pojo.News;

import java.util.List;

public interface NewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    News queryById(Integer id);



    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News update(News news);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Boolean addNews(News news);

    Boolean delRole(Integer newsId);

    List<News> queryAll();
}