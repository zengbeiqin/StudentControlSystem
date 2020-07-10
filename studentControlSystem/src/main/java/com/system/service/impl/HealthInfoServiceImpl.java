package com.system.service.impl;

import com.system.mapper.HealthInfoMapper;
import com.system.pojo.HealthInfo;
import com.system.pojo.StudentInfo;
import com.system.service.HealthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-26 21:06
 **/
@Service
public class HealthInfoServiceImpl implements HealthInfoService {
    @Autowired
    private HealthInfoMapper healthInfoMapper;

    @Override
    public boolean addHealth(HealthInfo healthInfo, StudentInfo student_info) {
       HealthInfo health_info  = healthInfoMapper.selectByStudentId(Integer.parseInt(student_info.getStudentNum()));
       if (null==health_info){
           healthInfo.setTimes(new Date());
           healthInfo.setStudentId(Integer.parseInt(student_info.getStudentNum()));
           healthInfoMapper.insertSelective(healthInfo);
           return true;
       }
        return false;
    }

    @Override
    public List<HealthInfo> selectHealthList() {
        List<HealthInfo> healthInfos = healthInfoMapper.selectAll();
        return healthInfos;
    }

    @Override
    public void healthDel(Integer id) {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setId(id);
        healthInfoMapper.delete(healthInfo);
    }
}
