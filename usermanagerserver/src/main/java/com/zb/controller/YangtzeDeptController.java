package com.zb.controller;

import com.cttic.yangtzeserver.usermanagerserver.entity.YangtzeDept;
import com.cttic.yangtzeserver.usermanagerserver.model.ServiceResponse;
import com.cttic.yangtzeserver.usermanagerserver.service.impl.YangtzeDeptServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "部门 API")
public class YangtzeDeptController {
    @Autowired
    private YangtzeDeptServiceImpl yangtzeDeptService;

    /**
    * @Description: 查询部门
    * @Param:
    * @return:
    * @Author: zb
    * @Date: 2022/8/9
    */
    @GetMapping("/allDept")
    @ApiOperation(value = "查询所有部门（树形）")
    public ServiceResponse<List<YangtzeDept>> deptTree(@RequestParam(defaultValue = "0")Integer parentId){
        List<YangtzeDept> deptTreStr = allDept(parentId);
        if(deptTreStr != null) {
            return ServiceResponse.ok(deptTreStr);
        }
        else{
            return ServiceResponse.error("查询失败！！！");
        }
    }
    public List<YangtzeDept> allDept(Integer parentId) {

        List<YangtzeDept> depts = yangtzeDeptService.allDept(parentId);

       for(YangtzeDept parent : depts){
           parent.setChildDept(allDept(parent.getDeptId()));
       }
        return depts;
    }

/**
* @Description: 增加部门
* @Param:
* @return:
* @Author: zb
* @Date: 2022/8/10
*/

@PostMapping("/dept/addDept")
@ApiOperation(value = "新增部门（包括父部门Id，部门名称，显示顺序，负责人，联系电话，邮箱，部门状态，创建者））")
public ServiceResponse addDept(Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String createBy)  {

    int i = yangtzeDeptService.addDept(parentId,deptName,orderNum,leader,phone,email,status,createBy);
    return i > 0 ? ServiceResponse.ok("增加部门操作成功") : ServiceResponse.error("增加部门失败！！！");

}
/** 
* @Description: 修改部门
* @Param: 
* @return: 
* @Author: zb
* @Date: 2022/8/10
*/
@PostMapping("/dept/updateDept")
@ApiOperation(value = "修改部门（包括部门ID，父部门Id，部门名称，显示顺序，负责人，联系电话，邮箱，部门状态，删除标志，更新者）")
public ServiceResponse updateDept(Integer deptId,Integer parentId,String deptName,Integer orderNum,String leader,String phone,String email,String status,String delFlag,String updateBy
)  {
    int i = yangtzeDeptService.updateDept(deptId,parentId,deptName,orderNum,leader,phone,email,status,delFlag,updateBy);
    return i > 0 ? ServiceResponse.ok("修改部门操作成功") : ServiceResponse.error("修改部门失败！！！");

}
    /**
     * 后台管理删除部门
     *删除状态改为2
     * @param deptId
     */
    @DeleteMapping("/dept/{deptId}")
    @ApiOperation(value = "后台管理删除部门")
    public ServiceResponse deleteByRoleId(@PathVariable Integer deptId) {
            int i = yangtzeDeptService.deleteByRoleId(deptId);
            return i > 0 ? ServiceResponse.ok("操作成功") : ServiceResponse.error("删除失败！！！");
        }




}
