package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleMenu;
import com.github.pagehelper.PageInfo;

public interface YangtzeRoleMenuService extends IService<YangtzeRoleMenu> {


    PageInfo<YangtzeRoleMenu> selRole2Menu(Integer roleId,Integer pageNum, Integer pageSize);
    int addRole2Menu(Integer roleId,Integer MenuId);

    int updateRole2Menu(Integer roleId,Integer oldMenuId,Integer newMenuId);

    int deletRole2Menu(Integer roleId,Integer MenuId);

}
