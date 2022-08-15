package com.zb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: 角色菜单关系实体
 * @Param:
 * @return:
 * @Author: zb
 * @Date: 2022/8/9
 */
@Data
@TableName(value ="sys_role_menu")
public class YangtzeRoleMenu {
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 菜单ID
     */
    private Integer menuId;
}
