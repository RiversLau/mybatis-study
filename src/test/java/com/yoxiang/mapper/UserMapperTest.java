package com.yoxiang.mapper;

import com.yoxiang.model.SysRole;
import com.yoxiang.model.SysRoleExtend;
import com.yoxiang.model.SysRoleExtend2;
import com.yoxiang.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
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

    @Test
    public void testInsert() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insertUser(user);
            Assert.assertEquals(1, result);
            Assert.assertNull(user.getId());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insertUser2(user);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(user.getId());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insertUser3(user);
            Assert.assertEquals(1, result);
            System.out.println(user.getId());
            Assert.assertNotNull(user.getId());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            Assert.assertEquals("admin", user.getUserName());
            user.setUserName("admin_test");
            user.setUserEmail("test@mybatis.tk");
            int result = userMapper.updateById(user);
            Assert.assertEquals(1, result);
            user = userMapper.selectById(1l);
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            Assert.assertNotNull(user);

            int result = userMapper.deleteById(1l);
            Assert.assertEquals(1, result);

            user = userMapper.selectById(1l);
            Assert.assertNull(user);

            SysUser user2 = userMapper.selectById(1001l);
            Assert.assertNotNull(user2);

            int result2 = userMapper.deleteById(1001l);
            Assert.assertEquals(1, result2);

            Assert.assertNull(userMapper.selectById(1001l));
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1l, 1);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled2() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(1l);
            SysRole role = new SysRole();
            role.setEnabled(1);
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled2(user, role);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            session.rollback();
            session.close();
        }
    }
}
