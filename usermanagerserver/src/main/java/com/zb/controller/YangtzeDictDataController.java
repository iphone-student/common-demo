package com.zb.controller;

import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictData;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeDictDataServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "字典数据 API")
public class YangtzeDictDataController {

    @Autowired
    private YangtzeDictDataServiceImpl yangtzeDictDataService;

    @GetMapping("/allDictData")
    @ApiOperation(value = "查询所有字典信息")
    public ServiceResponse<List<YangtzeDictData>> allDictData(){
        List<YangtzeDictData> allDictData = yangtzeDictDataService.allDictData();
        if(allDictData != null) {
            return ServiceResponse.ok(allDictData);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }
    @GetMapping("/selectDictDataByType")
    @ApiOperation(value = "根据类型查询字典信息")
    public ServiceResponse<List<YangtzeDictData>> selectDictDataByType(String dictType){
        List<YangtzeDictData> selectDictDataByType = yangtzeDictDataService.selectDictDataByType(dictType);
        if(selectDictDataByType != null) {
            return ServiceResponse.ok(selectDictDataByType);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }

    //=================================================================================
    @GetMapping("/addDictDataByType")
    @ApiOperation(value = "添加字典信息")
    public ServiceResponse addDictDataByType(Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass
    , String isDefault, String status, String createBy, String remark
    ){
        int i = yangtzeDictDataService.addDictDataByType( dictSort,  dictLabel,  dictValue,  dictType,  cssClass,  listClass
                ,  isDefault,  status,  createBy,  remark);
        return i > 0 ? ServiceResponse.ok("添加操作成功") : ServiceResponse.error("添加失败！！！");
    }
    //=================================================================================

    @GetMapping("/updateDictDataByType")
    @ApiOperation(value = "根据类型修改字典信息")
    public ServiceResponse updateDictDataByType(Integer dictCode,Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass
            , String isDefault, String status, String updateBy, String remark){
        int i = yangtzeDictDataService.updateDictDataByType(dictCode,dictSort, dictLabel, dictValue, dictType, cssClass, listClass
                , isDefault, status, updateBy, remark);
        return i > 0 ? ServiceResponse.ok("修改操作成功") : ServiceResponse.error("修改失败！！！");
    }
    @GetMapping("/deleteDictDataByType")
    @ApiOperation(value = "根据编码或类型删除字典信息(可以根据dictCode或dictType进行选择,选择那个填写那个参数)")
    public ServiceResponse deleteDictDataByType(Integer dictCode,@RequestParam(defaultValue = "a")String dictType){
       int i = 0;
        if(!dictType.equals("a")) {
             i = yangtzeDictDataService.deleteDictDataByType(dictType);
        }else{
        i = yangtzeDictDataService.deleteDictDataByCode(dictCode);
        }
        return i > 0 ? ServiceResponse.ok("删除成功") : ServiceResponse.error("删除失败！！！");
    }


}
