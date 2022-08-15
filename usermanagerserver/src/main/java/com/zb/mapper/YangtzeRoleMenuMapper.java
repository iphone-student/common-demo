package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YangtzeRoleMenuMapper extends BaseMapper<YangtzeRoleMenu> {

    List<YangtzeRoleMenu> selRole2Menu();
//    List<YangtzeRoleMenu> selRole2Menu(Integer roleId);
    int addRole2Menu(Integer roleId,Integer MenuId);
    int updateRole2Menu(Integer roleId,Integer oldMenuId,Integer newMenuId);


    int deletRole2Menu(Integer roleId,Integer MenuId);
}
