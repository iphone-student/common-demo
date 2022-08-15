package com.zb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统访问记录
 * @TableName sys_logininfor
 */
@Data
@TableName(value ="sys_logininfor")
public class YangtzeLoginLog implements Serializable {
    /**
     * 访问ID
     */
    private Long infoId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录状态（0成功 1失败）
     */
    private String status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 访问时间
     */
    private Date accessTime;

    private static final long serialVersionUID = 1L;
}