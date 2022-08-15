package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDept;

import java.util.List;

/**
 *
 */
public interface YangtzeDeptService extends IService<YangtzeDept> {

   List<YangtzeDept> allDept(Integer parentId);
   int addDept(Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String createBy);

   int updateDept(Integer deptId,Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String delFlag,String updateBy);

   int deleteByRoleId(Integer deptId);

}
