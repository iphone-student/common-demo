package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YangtzeRoleDeptMapper extends BaseMapper<YangtzeRoleDept> {

    List<YangtzeRoleDept> selRole2Dept(Integer roleId);
    int addRole2Dept(Integer roleId,Integer deptId);
    int updateRole2Dept(@Param("roleId") Integer roleId,@Param("oldDeptId") Integer oldDeptId,@Param("newDeptId") Integer newDeptId);


    int deletRole2Dept(@Param("roleId")Integer roleId,@Param("deptId")Integer deptId);
}
