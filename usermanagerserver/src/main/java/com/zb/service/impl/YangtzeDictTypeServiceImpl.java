package com.zb.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictType;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeDictTypeMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 10727
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service实现
* @createDate 2022-08-11 09:09:27
*/
@Service
public class YangtzeDictTypeServiceImpl extends ServiceImpl<YangtzeDictTypeMapper, YangtzeDictType>
implements YangtzeDictTypeService{
    @Autowired
    private YangtzeDictTypeMapper yangtzeDictTypeMapper;

    public List<YangtzeDictType> allDictType(){
        return yangtzeDictTypeMapper.allDictType();
    }
    public int  addDictType(String dictName, String dictType, String status, String createBy, String remark){
        Date createTime = new Date();
        return yangtzeDictTypeMapper.addDictType(dictName,dictType,status,createBy,createTime,remark);
    }

    public int  updateDictType(Long dictId,String dictName, String dictType, String status, String updateBy, String remark){
        Date updateTime = new Date();
        return yangtzeDictTypeMapper.updateDictType(dictId,dictName,dictType,status,updateBy,updateTime,remark);
    }

    public int deleteDictType(Long dictId){
        return yangtzeDictTypeMapper.deleteDictType(dictId);
    }

}
