package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictData;

import java.util.List;

/**
* @author 10727
* @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service
* @createDate 2022-08-11 09:05:22
*/
public interface YangtzeDictDataService extends IService<YangtzeDictData> {

    List<YangtzeDictData> allDictData();
    List<YangtzeDictData> selectDictDataByType(String dictType);
   int  addDictDataByType(Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status, String createBy,  String remark);
   int  updateDictDataByType(Integer dictCode,Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status, String updateBy,  String remark);

   int deleteDictDataByType(String dictType);

    int deleteDictDataByCode(Integer dictCode);


}
