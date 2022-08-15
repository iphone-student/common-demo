package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictType;

import java.util.List;

/**
* @author 10727
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service
* @createDate 2022-08-11 09:09:27
*/
public interface YangtzeDictTypeService extends IService<YangtzeDictType> {

    List<YangtzeDictType> allDictType();

    int  addDictType(String dictName, String dictType, String status, String createBy, String remark);
    int  updateDictType(Long dictId,String dictName, String dictType, String status, String updateBy, String remark);

    int deleteDictType(Long dictId);
}
