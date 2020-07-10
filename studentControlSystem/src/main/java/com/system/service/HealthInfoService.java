package com.system.service;

import com.system.pojo.HealthInfo;
import com.system.pojo.StudentInfo;

import java.util.List;


public interface HealthInfoService {
    boolean addHealth(HealthInfo healthInfo, StudentInfo student_info);

    List<HealthInfo> selectHealthList();

    void healthDel(Integer id);
}
