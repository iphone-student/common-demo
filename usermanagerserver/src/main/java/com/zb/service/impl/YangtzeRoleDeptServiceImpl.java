package com.zb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleDept;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeRoleDeptMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeRoleDeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YangtzeRoleDeptServiceImpl extends ServiceImpl<YangtzeRoleDeptMapper, YangtzeRoleDept>
        implements YangtzeRoleDeptService {

    @Autowired
    private YangtzeRoleDeptMapper yangtzeRoleDeptMapper;

    @Override
    public PageInfo<YangtzeRoleDept> selRole2Dept(Integer roleId,Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<YangtzeRoleDept> Role2Dept = yangtzeRoleDeptMapper.selRole2Dept(roleId);
        PageInfo<YangtzeRoleDept> pageInfo =  new PageInfo<>( Role2Dept);
        return pageInfo;
    }
    @Override
    public int addRole2Dept(Integer roleId,Integer deptId){
        return yangtzeRoleDeptMapper.addRole2Dept(roleId,deptId);
    }
    @Override
    public int updateRole2Dept(Integer roleId,Integer oldDeptId,Integer newDeptId){
        return yangtzeRoleDeptMapper.updateRole2Dept(roleId,oldDeptId,newDeptId);
    }
    @Override
    public int deletRole2Dept(Integer roleId,Integer deptId){
        return yangtzeRoleDeptMapper.deletRole2Dept(roleId,deptId);
    }


}
