package com.zb.controller;

import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleDept;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeRoleDeptServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "角色与部门关联 API")
public class YangtzeRoleDeptController {
    @Autowired
    private YangtzeRoleDeptServiceImpl yangtzeDeptService;

    /**
     * @Description: 根据角色查询部门
     * @Param:
     * @return:
     * @Author: zb
     * @Date: 2022/8/9
     */
    @GetMapping("/selRole2Dept")
    @ApiOperation(value = "根据角色查询部门")
    public ServiceResponse<PageInfo<YangtzeRoleDept>> selRole2Dept(Integer roleId, @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize){
        PageInfo<YangtzeRoleDept> Role2Dept = yangtzeDeptService.selRole2Dept(roleId,pageNum,pageSize);
        if(Role2Dept != null) {
            return ServiceResponse.ok(Role2Dept);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }

    @PostMapping("/rolesDept/addRole2Dept")
    @ApiOperation(value = "根据角色新增部门")
    public ServiceResponse addRole2Dept(Integer roleId,Integer deptId)  {

        int i = yangtzeDeptService.addRole2Dept(roleId,deptId);
        return i > 0 ? ServiceResponse.ok("增加操作成功") : ServiceResponse.error("增加操作失败！！！");

    }
    @PostMapping("/rolesDept/updateRole2Dept")
    @ApiOperation(value = "根据角色修改部门")
    public ServiceResponse updateRole2Dept(Integer roleId,Integer oldDeptId,Integer newDeptId)  {

        int i = yangtzeDeptService.updateRole2Dept(roleId,oldDeptId,newDeptId);
        return i > 0 ? ServiceResponse.ok("增加操作成功") : ServiceResponse.error("增加操作失败！！！");

    }

    @PostMapping("/rolesDept/deletRole2Dept")
    @ApiOperation(value = "根据角色删除部门")
    public ServiceResponse deletRole2Dept(Integer roleId,Integer deptId)  {

        int i = yangtzeDeptService.deletRole2Dept(roleId,deptId);
        return i > 0 ? ServiceResponse.ok("删除操作成功") : ServiceResponse.error("删除操作失败！！！");

    }



}
