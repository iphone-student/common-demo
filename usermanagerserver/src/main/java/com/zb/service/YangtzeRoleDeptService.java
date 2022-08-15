package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleDept;
import com.github.pagehelper.PageInfo;

public interface YangtzeRoleDeptService extends IService<YangtzeRoleDept> {

    PageInfo<YangtzeRoleDept> selRole2Dept(Integer roleId,Integer pageNum, Integer pageSize);
    int addRole2Dept(Integer roleId,Integer deptId);

    int updateRole2Dept(Integer roleId,Integer oldDeptId,Integer newDeptId);

    int deletRole2Dept(Integer roleId,Integer deptId);

}
