package com.zb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRole;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeRoleMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class YangtzeRoleServiceImpl extends ServiceImpl<YangtzeRoleMapper, YangtzeRole>
    implements YangtzeRoleService {
    @Autowired
    private YangtzeRoleMapper yangtzeRoleMapper;
    @Override
    public PageInfo<YangtzeRole> findRoles(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<YangtzeRole> allRoles = yangtzeRoleMapper.findRoles();
        PageInfo<YangtzeRole> pageInfo =  new PageInfo<>( allRoles);
        return pageInfo;
    }
    @Override
    public String findRoleKey(Integer roleId){
        return yangtzeRoleMapper.findRoleKey(roleId);
    }
    @Override
    public int addRole(String roleName,String roleKey,Integer roleSort,String status,String createBy,String remark,Integer menuCheckStrictly,Integer deptCheckStrictly){
            String delFlag = "0";
            Date createTime = new Date();
            return yangtzeRoleMapper.addRole(roleName,roleKey,roleSort,status,createBy,remark,menuCheckStrictly,deptCheckStrictly,delFlag,createTime);
    };

    @Override
    public int updateRole(Integer roleId,String roleName,String roleKey,Integer roleSort,String delFlag,
                          String status,String updateBy,String remark,Integer menuCheckStrictly,Integer deptCheckStrictly){
        Date updateTime = new Date();
        return yangtzeRoleMapper.updateRole(roleId,roleName,roleKey,roleSort,delFlag,status,updateBy,remark,menuCheckStrictly,deptCheckStrictly,updateTime);
    };
    @Override
    public int deleteRole(Integer roleId){
        Date updateTime = new Date();
        return yangtzeRoleMapper.deleteRole(roleId,updateTime);
    };

}




