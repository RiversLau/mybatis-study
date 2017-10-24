package com.yoxiang.mapper;

import com.yoxiang.model.SysRole;
import com.yoxiang.model.SysRoleExtend;
import com.yoxiang.model.SysRoleExtend2;
import com.yoxiang.model.SysUser;

import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/24 22:33
 */
public interface UserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long id);

    List<SysRoleExtend> selectRolesByUserId2(Long id);

    List<SysRoleExtend2> selectRolesByUserId3(Long id);

    int insertUser(SysUser user);
}
