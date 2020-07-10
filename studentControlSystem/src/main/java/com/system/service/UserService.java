package com.system.service;

import com.system.pojo.StudentInfo;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-22 20:48
 **/
public interface UserService {
    StudentInfo login(StudentInfo studentInfo);

    boolean register(StudentInfo studentInfo);
}
