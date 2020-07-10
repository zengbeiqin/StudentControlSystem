package com.system.mapper;

import com.system.pojo.StuInfo;
import tk.mybatis.mapper.common.Mapper;

public interface StuInfoMapper extends Mapper<StuInfo> {

    StuInfo selectByStudentId(Integer id);
}