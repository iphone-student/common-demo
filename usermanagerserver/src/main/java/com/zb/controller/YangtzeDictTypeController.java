package com.zb.controller;


import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictType;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeDictTypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "字典类型 API")
public class YangtzeDictTypeController {

    @Autowired
    private YangtzeDictTypeServiceImpl yangtzeDictTypeService;

    @GetMapping("/allDictType")
    @ApiOperation(value = "查询字典类型")
    public ServiceResponse<List<YangtzeDictType>> allDictType(){
        List<YangtzeDictType> allDictType = yangtzeDictTypeService.allDictType();
        if(allDictType != null) {
            return ServiceResponse.ok(allDictType);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }

    @GetMapping("/addDictType")
    @ApiOperation(value = "新增字典类型")
    public ServiceResponse addDictType(String dictName, String dictType, String status, String createBy,String remark){
       int  i = yangtzeDictTypeService.addDictType(dictName,dictType,status,createBy,remark);
       return i > 0 ? ServiceResponse.ok("新增字典类型操作成功") : ServiceResponse.error("新增字典类型失败！！！");

    }

    @GetMapping("/updateDictType")
    @ApiOperation(value = "修改字典类型")
    public ServiceResponse updateDictType(Long dictId,String dictName, String dictType, String status, String updateBy,String remark){
        int  i = yangtzeDictTypeService.updateDictType(dictId,dictName,dictType,status,updateBy,remark);
        return i > 0 ? ServiceResponse.ok("新增字典类型操作成功") : ServiceResponse.error("新增字典类型失败！！！");

    }
    @DeleteMapping("/deleteDictType")
    @ApiOperation(value = "删除字典类型")
    public ServiceResponse deleteDictType( Long dictId) {

        int i = yangtzeDictTypeService.deleteDictType(dictId);
            return i > 0 ? ServiceResponse.ok("操作成功") : ServiceResponse.error("删除失败！！！");

    }



}
