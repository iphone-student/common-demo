package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author 10727
* @description 针对表【sys_dict_data(字典数据表)】的数据库操作Mapper
* @createDate 2022-08-11 09:05:22
* @Entity com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDictData
*/
@Mapper
public interface YangtzeDictDataMapper extends BaseMapper<YangtzeDictData> {

    List<YangtzeDictData> allDictData();
    List<YangtzeDictData> selectDictDataByType(String dictType);
    int  addDictDataByType(@Param("dictSort") Integer dictSort, @Param("dictLabel")String dictLabel, @Param("dictValue")String dictValue,@Param("dictType") String dictType, @Param("cssClass")String cssClass, @Param("listClass")String listClass, @Param("isDefault")String isDefault,@Param("status") String status, @Param("createBy")String createBy, @Param("createTime")Date createTime,@Param("remark") String remark);
    int  updateDictDataByType(@Param("dictCode")Integer dictCode,@Param("dictSort")Integer dictSort, @Param("dictLabel")String dictLabel,@Param("dictValue") String dictValue,@Param("dictType") String dictType, @Param("cssClass")String cssClass,@Param("listClass") String listClass,@Param("isDefault") String isDefault,@Param("status") String status,@Param("updateBy") String updateBy, @Param("updateTime")Date updateTime, @Param("remark") String remark);
    @Delete("DELETE FROM  \"Yangtzedb\".\"SYS_DICT_DATA\" WHERE dict_type = #{dictType}")
    int deleteDictDataByType(String dictType);
    @Delete("DELETE FROM  \"Yangtzedb\".\"SYS_DICT_DATA\" WHERE dict_code = #{dictCode}")
    int deleteDictDataByCode(Integer dictCode);

    }
