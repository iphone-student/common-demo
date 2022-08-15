package com.zb.controller;

import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRoleMenu;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeRoleMenuServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "角色与菜单关联 API")
public class YangtzeRoleMenuController {
    @Autowired
    private YangtzeRoleMenuServiceImpl yangtzeRoleMenuService;

    /**
     * @Description: 根据角色查询菜单
     * @Param:
     * @return:
     * @Author: zb
     * @Date: 2022/8/9
     */
    @GetMapping("/selRole2Menu")
    @ApiOperation(value = "根据角色查询菜单")
    public ServiceResponse<PageInfo<YangtzeRoleMenu>> selRole2Menu(Integer roleId, @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize){
        PageInfo<YangtzeRoleMenu> Role2Menu = yangtzeRoleMenuService.selRole2Menu(roleId,pageNum,pageSize);
        if(Role2Menu != null) {
            return ServiceResponse.ok(Role2Menu);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }

    @PostMapping("/rolesMenu/addRole2Menu")
    @ApiOperation(value = "根据角色新增部门")
    public ServiceResponse addRole2Menu(Integer roleId,Integer MenuId)  {

        int i = yangtzeRoleMenuService.addRole2Menu(roleId,MenuId);
        return i > 0 ? ServiceResponse.ok("增加操作成功") : ServiceResponse.error("增加操作失败！！！");

    }
    @PostMapping("/rolesMenu/updateRole2Menu")
    @ApiOperation(value = "根据角色修改部门")
    public ServiceResponse updateRole2Menu(Integer roleId,Integer oldMenuId,Integer newMenuId)  {

        int i = yangtzeRoleMenuService.updateRole2Menu(roleId,oldMenuId,newMenuId);
        return i > 0 ? ServiceResponse.ok("增加操作成功") : ServiceResponse.error("增加操作失败！！！");

    }

    @PostMapping("/rolesMenu/deletRole2Menu")
    @ApiOperation(value = "根据角色删除部门")
    public ServiceResponse deletRole2Menu(Integer roleId,Integer MenuId)  {

        int i = yangtzeRoleMenuService.deletRole2Menu(roleId,MenuId);
        return i > 0 ? ServiceResponse.ok("删除操作成功") : ServiceResponse.error("删除操作失败！！！");

    }



}
