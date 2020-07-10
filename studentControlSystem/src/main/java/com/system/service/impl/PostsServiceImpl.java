package com.system.service.impl;

import com.system.mapper.PostsMapper;
import com.system.pojo.Posts;
import com.system.pojo.StudentInfo;
import com.system.service.PostsService;
import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-26 22:06
 **/
@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsMapper postsMapper;

    @Override
    public boolean addPosts(Posts posts, StudentInfo student_info) {
        posts.setDispose(0);
        posts.setStudentId(Integer.parseInt(student_info.getStudentNum()));
        postsMapper.insertSelective(posts);
        return true;
    }

    @Override
    public List<Posts> selectAll() {
        List<Posts> posts = postsMapper.selectAll();
        return posts;
    }

    @Override
    public void delPosts(Integer postsId) {
        Posts posts = new Posts();
        posts.setId(postsId);
        postsMapper.delete(posts);
    }

    @Override
    public boolean post(Integer postsId, String oddNumber) {
        Posts posts = new Posts();
        posts.setId(postsId);
        posts.setOddNumber(oddNumber);
        posts.setDispose(1);
        int re = postsMapper.updateByOddNumber(posts);
        return re > 0;
    }

    @Override
    public List<Posts> selectMySelf(Integer id) {
        Posts posts = new Posts();
        posts.setStudentId(id);
        List<Posts> postsList = postsMapper.select(posts);
        return postsList;
    }
}
