package com.system.mapper;

import com.system.pojo.Posts;
import tk.mybatis.mapper.common.Mapper;

public interface PostsMapper extends Mapper<Posts> {

   Integer  updateByOddNumber(Posts posts);
}