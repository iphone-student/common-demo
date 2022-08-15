package com.zb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictData;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeDictDataMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 10727
* @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service实现
* @createDate 2022-08-11 09:05:22
*/
@Service
public class YangtzeDictDataServiceImpl extends ServiceImpl<YangtzeDictDataMapper, YangtzeDictData>
implements YangtzeDictDataService{

    @Autowired
    private YangtzeDictDataMapper yangtzeDictDataMapper;
    @Override
    public List<YangtzeDictData> allDictData(){
        return yangtzeDictDataMapper.allDictData();
    }
    @Override
    public List<YangtzeDictData> selectDictDataByType(String dictType){
        return yangtzeDictDataMapper.selectDictDataByType(dictType);
    }
    @Override
    public int  addDictDataByType(Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status, String createBy,  String remark){
        Date createTime = new Date();
        return yangtzeDictDataMapper.addDictDataByType(dictSort, dictLabel, dictValue, dictType, cssClass, listClass, isDefault, status, createBy, createTime, remark);
    }
    @Override
    public int  updateDictDataByType(Integer dictCode,Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status, String updateBy,  String remark){
        Date updateTime = new Date();
        return yangtzeDictDataMapper.updateDictDataByType(dictCode,dictSort, dictLabel, dictValue, dictType, cssClass, listClass, isDefault, status, updateBy, updateTime, remark);
    }
    @Override
    public int  deleteDictDataByType(String dictType){

        return yangtzeDictDataMapper.deleteDictDataByType( dictType);
    }
    @Override
    public int deleteDictDataByCode(Integer dictCode){

        return yangtzeDictDataMapper.deleteDictDataByCode(dictCode);
    }



}
