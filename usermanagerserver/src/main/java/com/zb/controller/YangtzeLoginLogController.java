package com.zb.controller;

import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeLoginLog;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeLoginLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "登录日志 API")
public class YangtzeLoginLogController {
    @Autowired
    private YangtzeLoginLogServiceImpl yangtzeLoginLogService;


    @GetMapping("/selectLoginLog")
    @ApiOperation(value = "查询登录日志")
    public ServiceResponse<List<YangtzeLoginLog>> selectLoginLog(){
        List<YangtzeLoginLog> selectLoginLog = yangtzeLoginLogService.selectLoginLog();
        if(selectLoginLog != null) {
            return ServiceResponse.ok(selectLoginLog);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }



}
