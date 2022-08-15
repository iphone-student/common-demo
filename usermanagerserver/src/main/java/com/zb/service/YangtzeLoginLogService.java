package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeLoginLog;

import java.util.List;

/**
* @author 10727
* @description 针对表【sys_logininfor(系统访问记录)】的数据库操作Service
* @createDate 2022-08-15 10:32:43
*/
public interface YangtzeLoginLogService extends IService<YangtzeLoginLog> {

    List<YangtzeLoginLog> selectLoginLog();
}
