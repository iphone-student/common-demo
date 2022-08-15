package com.zb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleMenu;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeRoleMenuMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeRoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YangtzeRoleMenuServiceImpl extends ServiceImpl<YangtzeRoleMenuMapper, YangtzeRoleMenu>
        implements YangtzeRoleMenuService {

    @Autowired
    private YangtzeRoleMenuMapper yangtzeRoleMenuMapper;


    @Override
    public PageInfo<YangtzeRoleMenu> selRole2Menu(Integer roleId,Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
//        List<YangtzeRoleMenu> Role2Menu = yangtzeRoleMenuMapper.selRole2Menu(roleId);
        List<YangtzeRoleMenu> Role2Menu = yangtzeRoleMenuMapper.selRole2Menu();
        PageInfo<YangtzeRoleMenu> pageInfo =  new PageInfo<>( Role2Menu);
        return pageInfo;
    }
    @Override
    public int addRole2Menu(Integer roleId,Integer MenuId){
        return yangtzeRoleMenuMapper.addRole2Menu(roleId,MenuId);
    }
    @Override
    public int updateRole2Menu(Integer roleId,Integer oldMenuId,Integer newMenuId){
        return yangtzeRoleMenuMapper.updateRole2Menu(roleId,oldMenuId,newMenuId);
    }
    @Override
    public int deletRole2Menu(Integer roleId,Integer MenuId){
        return yangtzeRoleMenuMapper.deletRole2Menu(roleId,MenuId);
    }


}
