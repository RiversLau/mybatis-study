package com.yoxiang.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: Rivers
 * Date: 2017/10/24 07:04
 */
@Getter
@Setter
public class SysUser {

    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
}
