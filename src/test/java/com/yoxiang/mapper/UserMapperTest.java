package com.yoxiang.mapper;

import com.yoxiang.model.SysRole;
import com.yoxiang.model.SysRoleExtend;
import com.yoxiang.model.SysRoleExtend2;
import com.yoxiang.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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
    public void testSelectByIdList() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<>();
            idList.add(1l);
            idList.add(1001l);
            List<SysUser> userList = userMapper.selectByIdList(idList);
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectByIdOrUserName() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            query.setId(1l);
            SysUser user = userMapper.selectByIdOrUserName(query);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());

            query = new SysUser();
            query.setUserName("admin");
            user = userMapper.selectByIdOrUserName(query);
            Assert.assertNotNull(user);
            Assert.assertEquals(1l, user.getId().longValue());
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectByUser() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser searchUser = new SysUser();
            searchUser.setUserName("ad");
            List<SysUser> userList = userMapper.selectByUser(searchUser);
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);

            searchUser = new SysUser();
            searchUser.setUserEmail("test@mybatis.tk");
            userList = userMapper.selectByUser(searchUser);
            Assert.assertTrue(userList.size() > 0);

            searchUser = new SysUser();
            searchUser.setUserName("ad");
            searchUser.setUserEmail("test@mybatis.tk");
            userList = userMapper.selectByUser(searchUser);
            Assert.assertTrue(userList.size() == 0);
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
    public void testInsert2Selective() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test_selective");
            user.setUserPassword("123456");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insertUser2(user);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(user.getId());

            user = userMapper.selectById(user.getId());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
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
    public void testInsertList() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysUser> userList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                SysUser user = new SysUser();
                user.setUserName("test" + i);
                user.setUserPassword("123456");
                user.setUserEmail("test@mybatis.tk");
//                user.setUserInfo("test");
//                user.setHeadImg(new byte[]{1, 3, 5});
                user.setCreateTime(new Date());
                userList.add(user);
            }
            int result = userMapper.insertList(userList);
            Assert.assertEquals(2, result);
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
    public void testUpdateByIdSelective() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            Assert.assertEquals("admin", user.getUserName());
            user.setUserName("admin_test");
            user.setUserEmail("test@mybatis.tk");

            int result = userMapper.updateByIdSelective(user);
            Assert.assertEquals(1, result);

            user = userMapper.selectById(1l);
            Assert.assertEquals("admin_test", user.getUserName());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testUpdateByMap() {
        SqlSession session = getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            Map<String, Object> params = new HashMap<>();
            params.put("id", 1l);
            params.put("user_email", "hello@mybatis.tk");
            params.put("user_password", "888888");
            int result = userMapper.updateByMap(params);
            Assert.assertEquals(1, result);

            SysUser user = userMapper.selectById(1l);
            Assert.assertEquals("admin", user.getUserName());
            Assert.assertEquals("hello@mybatis.tk", user.getUserEmail());
            Assert.assertEquals("888888", user.getUserPassword());
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
