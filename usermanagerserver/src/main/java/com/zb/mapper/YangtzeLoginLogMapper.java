package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeLoginLog;

import java.util.List;

/**
* @author 10727
* @description 针对表【sys_logininfor(系统访问记录)】的数据库操作Mapper
* @createDate 2022-08-15 10:32:43
* @Entity com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeLoginLog
*/
public interface YangtzeLoginLogMapper extends BaseMapper<YangtzeLoginLog> {

    List<YangtzeLoginLog> selectLoginLog();
}
