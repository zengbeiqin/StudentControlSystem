package com.system.service.impl;

import com.system.mapper.StudentInfoMapper;
import com.system.pojo.StudentInfo;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-22 20:49
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public StudentInfo login(StudentInfo studentInfo) {
        StudentInfo info = studentInfoMapper.selectOne(studentInfo);
        if (info != null) {
            return info;
        }
        return null;
    }

    @Override
    public boolean register(StudentInfo studentInfo) {
        StudentInfo studentInfo1 = studentInfoMapper.selectOne(studentInfo);
        if (studentInfo1!=null){
            return false;
        }
        int result = studentInfoMapper.insertSelective(studentInfo);
        return result>0;
    }
}
