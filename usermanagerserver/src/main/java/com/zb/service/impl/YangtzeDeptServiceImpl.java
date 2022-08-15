package com.zb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDept;
import com.cttic.yangtzeserver.usermanagerserver.mapper.YangtzeDeptMapper;
import com.cttic.yangtzeserver.usermanagerserver.service.YangtzeDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class YangtzeDeptServiceImpl extends ServiceImpl<YangtzeDeptMapper, YangtzeDept>
    implements YangtzeDeptService {
    @Autowired
    private YangtzeDeptMapper yangtzeDeptMapper;
    @Override
   public List<YangtzeDept> allDept(Integer parentId){

        List<YangtzeDept> allDept = yangtzeDeptMapper.allDept(parentId);


        return allDept;
    }
    @Override
    public int addDept(Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String createBy){
        String delFlag = "0";
        Date createTime = new Date();
        return yangtzeDeptMapper.addDept(parentId,deptName,orderNum,leader,phone,email,status,createBy,delFlag,createTime);

    }
    @Override
    public int updateDept(Integer deptId,Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String delFlag,String updateBy){
        Date updateTime = new Date();
        return yangtzeDeptMapper.updateDept(deptId,parentId,deptName,orderNum,leader,phone,email,status,delFlag,updateBy,updateTime);
    }
    @Override
    public int deleteByRoleId( Integer deptId) {
        Date updateTime = new Date();
        return yangtzeDeptMapper.deleteByDeptId(deptId,updateTime);
    }


}




