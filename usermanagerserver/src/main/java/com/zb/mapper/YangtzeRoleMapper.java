package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @Entity com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRole
 */
@Mapper
public interface YangtzeRoleMapper extends BaseMapper<YangtzeRole> {
    List<YangtzeRole> findRoles();

    String findRoleKey(@Param("roleId") Integer roleId);

    int addRole(@Param("roleName")String roleName,@Param("roleKey")String roleKey,@Param("roleSort")Integer roleSort,@Param("status")String status,@Param("createBy")String createBy,@Param("remark")String remark,@Param("menuCheckStrictly")Integer menuCheckStrictly,@Param("deptCheckStrictly")Integer deptCheckStrictly,@Param("delFlag")String delFlag,@Param("createTime")Date createTime);
    int updateRole(@Param("roleId")Integer roleId,@Param("roleName")String roleName,@Param("roleKey")String roleKey,@Param("roleSort")Integer roleSort,@Param("delFlag")String delFlag,@Param("status")String status,@Param("updateBy")String updateBy,@Param("remark")String remark,@Param("menuCheckStrictly")Integer menuCheckStrictly,@Param("deptCheckStrictly")Integer deptCheckStrictly,@Param("updateTime")Date updateTime);

//    @Delete("delete from sys_role where role_id = #{roleId}")
    @Update("update \"Yangtzedb\".\"SYS_ROLE\" t set t.del_flag = 2 , update_time = #{updateTime} where t.role_id = #{roleId}")
    int deleteRole(@Param("roleId") Integer roleId, @Param("updateTime") Date updateTime);
}
