package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRole;
import com.github.pagehelper.PageInfo;

/**
 *
 */
public interface YangtzeRoleService extends IService<YangtzeRole> {

    PageInfo<YangtzeRole> findRoles(Integer pageNum, Integer pageSize);
    String findRoleKey(Integer roleId);
    int addRole(String roleName,String roleKey,Integer roleSort,
                String status,String createBy,String remark,Integer menuCheckStrictly,Integer deptCheckStrictly);
    int updateRole(Integer roleId,String roleName,String roleKey,Integer roleSort,String delFlag,
                   String status,String updateBy,String remark,Integer menuCheckStrictly,Integer deptCheckStrictly);
    int deleteRole(Integer roleId);

}
