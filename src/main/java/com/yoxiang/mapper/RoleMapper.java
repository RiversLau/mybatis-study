package com.yoxiang.mapper;

import com.yoxiang.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/24 22:33
 */
public interface RoleMapper {

    @Select({"select id, role_name as roleName, enabled, create_by as createBy, create_time as createTime",
                " from sys_role", " where id = #{id}"})
    SysRole selectById(Long id);

    @Select({"select id, role_name as roleName, enabled, create_by as createBy, create_time as createTime" +
            " from sys_role where id = #{id}"})
    SysRole selectById2(Long id);

    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column="enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({"select id, role_name, enabled, create_by, create_time" +
            " from sys_role where id = #{id}"})
    SysRole selectById3(Long id);

    @ResultMap("roleResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    @Insert({"insert into sys_role(id, role_name, enabled, create_by, create_time)" +
            " values(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})"})
    int insert(SysRole role);

    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time) " +
            "values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true)
    int insert2(SysRole role);

    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time) " +
            "values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",
                keyProperty = "id",
                resultType = Long.class,
                before = false)
    int insert3(SysRole role);

    @Update({"update sys_role set " +
            "role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}," +
            "create_time = #{createTime, jdbcType=TIMESTAMP}" +
            "where id = #{id}"})
    int updateById(SysRole role);

    @Delete({"delete from sys_role where id = #{id}"})
    int deleteById(Long id);
}
