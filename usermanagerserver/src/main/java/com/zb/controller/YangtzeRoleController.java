package com.zb.controller;


import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeRole;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeRoleServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "角色 API")
public class YangtzeRoleController {

    @Autowired
    private YangtzeRoleServiceImpl yangtzeRoleService;

    /**
     * 后台管理查询所有角色
     *
     */
    @GetMapping("/roles")
    @ApiOperation(value = "后台管理查询所有角色（带分页功能）")
    public ServiceResponse<PageInfo<YangtzeRole>> findRoles( @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize) {

        PageInfo<YangtzeRole> roles = yangtzeRoleService.findRoles(pageNum,pageSize);

        if(roles != null) {
            return ServiceResponse.ok(roles);
        }
        else{
            return ServiceResponse.error("查询角色失败！！！");
        }

    }

    /**
     * 角色新增
     * @param
     * @return
     * @throws
     */
    @PostMapping("/roles/addRole")
    @ApiOperation(value = "新增角色（包括角色ID，名称，权限，顺序，状态，创建者，备注,菜单关联（1关联0无关联），部门关联（1关联0无关联））")
    public ServiceResponse addRole(String roleName,String roleKey,Integer roleSort,
                                   String status,String createBy,String remark,Integer menuCheckStrictly,Integer deptCheckStrictly
    )  {

        int i = yangtzeRoleService.addRole(roleName,roleKey,roleSort, status,createBy,remark,menuCheckStrictly,deptCheckStrictly);
        return i > 0 ? ServiceResponse.ok("增加角色操作成功") : ServiceResponse.error("增加角色失败！！！");

    }

    @PostMapping("/roles/updateRole")
    @ApiOperation(value = "修改角色（包括角色ID，名称，权限，顺序,删除标志，状态，更新者，备注,菜单关联（1关联0无关联），部门关联（1关联0无关联））")
    public ServiceResponse updateRole(Integer roleId,String roleName,String roleKey,Integer roleSort,String delFlag,
                                   String status,String updateBy,String remark,Integer menuCheckStrictly,Integer deptCheckStrictly
    )  {

        int i = yangtzeRoleService.updateRole(roleId,roleName,roleKey,roleSort, delFlag,status,updateBy,remark,menuCheckStrictly,deptCheckStrictly);
        return i > 0 ? ServiceResponse.ok("修改角色操作成功") : ServiceResponse.error("修改角色失败！！！");

    }

    /**
     * 后台管理删除角色
     *删除状态改为2
     * @param roleId
     */
    @DeleteMapping("/roles/{roleId}")
    @ApiOperation(value = "后台管理删除角色")
    public ServiceResponse deleteRole(@PathVariable int roleId) {

       String roleKey = yangtzeRoleService.findRoleKey(roleId);
        if (roleKey.equals("admin") ){
            return ServiceResponse.error("管理员不可删除！！！");
        }else {
            int i = yangtzeRoleService.deleteRole(roleId);
            return i > 0 ? ServiceResponse.ok("操作成功") : ServiceResponse.error("删除失败！！！");
        }
    }


}
