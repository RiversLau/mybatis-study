package com.yoxiang.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Author: Rivers
 * Date: 2017/10/26 22:29
 */
public class PrivilegeProvider {

    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id, privilege_name as privilegeName, privilege_url as privilegeUrl");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
