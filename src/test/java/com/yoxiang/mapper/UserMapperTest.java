package com.yoxiang.mapper;

import com.yoxiang.model.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/24 23:06
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1l);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectRolesByUserId2() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRoleExtend> roleList = userMapper.selectRolesByUserId2(1l);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectRolesByUserId3() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRoleExtend2> roleList = userMapper.selectRolesByUserId3(1l);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            session.close();
        }
    }
}
