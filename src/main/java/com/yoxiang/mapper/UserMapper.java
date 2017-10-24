package com.yoxiang.mapper;

import com.yoxiang.model.SysUser;

import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/24 22:33
 */
public interface UserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();
}
