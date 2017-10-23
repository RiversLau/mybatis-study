package com.yoxiang.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: Rivers
 * Date: 2017/10/24 07:06
 */
@Getter
@Setter
public class SysRole {

    private Long id;
    private String roleName;
    private Date createBy;
    private Date createTime;
    private Integer enabled;
}
