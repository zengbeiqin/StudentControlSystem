package com.system.service;

import com.system.pojo.Posts;
import com.system.pojo.StudentInfo;

import java.util.List;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-26 22:04
 **/
public interface PostsService {
    boolean addPosts(Posts posts, StudentInfo student_info);

    List<Posts> selectAll();

    void delPosts(Integer postsId);

    boolean post(Integer postsId, String oddNumber);

    List<Posts> selectMySelf(Integer id);
}
