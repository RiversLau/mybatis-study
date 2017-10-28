package com.yoxiang.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/24 07:06
 */
@Getter
@Setter
public class SysRole {

    private Long id;
    private String roleName;
    private Integer enabled;

    private CreateInfo createInfo;
    private List<SysPrivilege> privilegeList;
}
