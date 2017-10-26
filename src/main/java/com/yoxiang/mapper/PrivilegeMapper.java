package com.yoxiang.mapper;

import com.yoxiang.model.SysPrivilege;
import com.yoxiang.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Author: Rivers
 * Date: 2017/10/24 22:33
 */
public interface PrivilegeMapper {

    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
