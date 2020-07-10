package com.system.service;

import com.system.pojo.StuInfo;
import com.system.pojo.StudentInfo;
import java.util.List;

public interface StuInfoService {
    boolean addStuInfo(StuInfo stuInfo, StudentInfo student_info);

    List<StuInfo> selectStuInfoList();

    void StuInfoDel(Integer id);
}
