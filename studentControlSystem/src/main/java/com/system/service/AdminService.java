package com.system.service;

import com.system.pojo.AdminInfo;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-22 21:11
 **/
public interface AdminService {
    AdminInfo login(AdminInfo adminInfo);

    boolean register(AdminInfo adminInfo);
}
