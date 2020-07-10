package com.system.mapper;

import com.system.pojo.HealthInfo;
import tk.mybatis.mapper.common.Mapper;

public interface HealthInfoMapper extends Mapper<HealthInfo> {

    HealthInfo selectByStudentId(Integer id);
}