package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @Entity com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRole
 */
@Mapper
public interface YangtzeDeptMapper extends BaseMapper<YangtzeDept> {
    List<YangtzeDept> allDept(@Param("parentId")Integer parentId);
    int addDept(Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String createBy,String delFlag,Date createTime);
    int updateDept(Integer deptId,Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String delFlag,String updateBy,Date updateTime);

    @Update("update \"Yangtzedb\".\"SYS_DEPT\" t set t.del_flag = 2 , update_time = #{updateTime} where t.dept_id = #{deptId}")
    int deleteByDeptId(@Param("deptId") Integer deptId,@Param("updateTime")Date updateTime);
}
