package com.zb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeLoginLog;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeLoginLogMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 10727
* @description 针对表【sys_logininfor(系统访问记录)】的数据库操作Service实现
* @createDate 2022-08-15 10:32:43
*/
@Service
public class YangtzeLoginLogServiceImpl extends ServiceImpl<YangtzeLoginLogMapper, YangtzeLoginLog>
implements YangtzeLoginLogService{
    @Autowired
    private YangtzeLoginLogMapper yangtzeLoginLogMapper;

    public List<YangtzeLoginLog> selectLoginLog(){
        return yangtzeLoginLogMapper.selectLoginLog();
    }


}
