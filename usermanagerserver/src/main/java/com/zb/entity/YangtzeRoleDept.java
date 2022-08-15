package com.zb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/** 
* @Description: 角色部门关系实体
* @Param: 
* @return: 
* @Author: zb
* @Date: 2022/8/9
*/
@Data
@TableName(value ="sys_role_dept")
public class YangtzeRoleDept {

    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 部门ID
     */
    private Integer deptId;
}
