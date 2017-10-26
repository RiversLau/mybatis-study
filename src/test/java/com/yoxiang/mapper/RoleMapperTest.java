package com.yoxiang.mapper;

import com.yoxiang.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/26 21:48
 */
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1l);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectById2() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById2(1l);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectById3() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById3(1l);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectAll();
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
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("test");
            role.setEnabled(1);
            role.setCreateBy(1l);
            role.setCreateTime(new Date());
            int result = roleMapper.insert(role);
            Assert.assertEquals(1, result);
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("test");
            role.setEnabled(1);
            role.setCreateBy(1l);
            role.setCreateTime(new Date());
            int result = roleMapper.insert2(role);
            Assert.assertEquals(1, result);
            System.out.println(role.getId());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("test");
            role.setEnabled(1);
            role.setCreateBy(1l);
            role.setCreateTime(new Date());
            int result = roleMapper.insert3(role);
            Assert.assertEquals(1, result);
            System.out.println(role.getId());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setId(1l);
            role.setRoleName("test");
            role.setEnabled(1);
            role.setCreateBy(1l);
            role.setCreateTime(new Date());
            int result = roleMapper.updateById(role);
            Assert.assertEquals(1, result);

            role = roleMapper.selectById(1l);
            Assert.assertEquals("test", role.getRoleName());
        } finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession session = getSession();
        try {
            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            int result = roleMapper.deleteById(1l);
            Assert.assertEquals(1, result);

            SysRole role = roleMapper.selectById(1l);
            Assert.assertNull(role);
        } finally {
            session.rollback();
            session.close();
        }
    }
}
