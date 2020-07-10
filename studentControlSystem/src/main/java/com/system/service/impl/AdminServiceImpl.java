package com.system.service.impl;

import com.system.mapper.AdminInfoMapper;
import com.system.pojo.AdminInfo;
import com.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-22 21:12
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo login(AdminInfo adminInfo) {
        AdminInfo adminInfo1 = adminInfoMapper.selectOne(adminInfo);
        if (adminInfo1 != null) {
            return adminInfo1;
        }
        return null;
    }

    @Override
    public boolean register(AdminInfo adminInfo) {
        AdminInfo adminInfo1 = adminInfoMapper.selectOne(adminInfo);
        if (adminInfo1 != null) {
            return false;
        }
        int result = adminInfoMapper.insertSelective(adminInfo);
        return result > 0;
    }
}
