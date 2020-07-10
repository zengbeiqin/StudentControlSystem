package com.system.service.impl;

import com.system.mapper.StuInfoMapper;
import com.system.pojo.StuInfo;
import com.system.pojo.StudentInfo;
import com.system.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class StuInfoServiceImpl implements StuInfoService {

//    @Autowired(required = false)
     @Autowired
    private StuInfoMapper stuInfoMapper;

    @Override
    public boolean addStuInfo(StuInfo stuinfo, StudentInfo student_info) {
       StuInfo stu_info  = stuInfoMapper.selectByStudentId(Integer.parseInt(student_info.getStudentNum()));
       if (null==stu_info){
           stuinfo.setTimes(new Date());
           stuinfo.setStu_id(Integer.parseInt(student_info.getStudentNum()));
           stuInfoMapper.insertSelective(stuinfo);
           return true;
       }
        return false;
    }

    @Override
    public List<StuInfo> selectStuInfoList() {
        List<StuInfo> stuInfos = stuInfoMapper.selectAll();
        return stuInfos;
    }

    @Override
    public void StuInfoDel(Integer id) {
        StuInfo stuInfo = new StuInfo();
        stuInfo.setId(id);
        stuInfoMapper.delete(stuInfo);
    }
}
