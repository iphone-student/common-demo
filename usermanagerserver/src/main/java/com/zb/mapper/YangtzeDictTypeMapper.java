package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
* @author 10727
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Mapper
* @createDate 2022-08-11 09:09:27
* @Entity com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictType
*/
public interface YangtzeDictTypeMapper extends BaseMapper<YangtzeDictType> {

    List<YangtzeDictType> allDictType();

    int  addDictType(@Param("dictName") String dictName, @Param("dictType")String dictType,@Param("status") String status, @Param("createBy")String createBy,@Param("createTime") Date createTime, @Param("remark")String remark);

    int  updateDictType(@Param("dictId") Long dictId,@Param("dictName")String dictName, @Param("dictType")String dictType, @Param("status")String status,@Param("updateBy") String updateBy,@Param("updateTime")Date updateTime, @Param("remark")String remark);
    @Delete("DELETE FROM  \"Yangtzedb\".\"SYS_DICT_TYPE\" WHERE dict_id = #{dictId}")
    int deleteDictType(@Param("dictId") Long dictId);

}
