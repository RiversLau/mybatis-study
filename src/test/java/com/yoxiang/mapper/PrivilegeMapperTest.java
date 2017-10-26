package com.yoxiang.mapper;

import com.yoxiang.model.SysPrivilege;
import com.yoxiang.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Rivers
 * Date: 2017/10/26 22:32
 */
public class PrivilegeMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession session = getSession();
        try {
            PrivilegeMapper privilegeMapper = session.getMapper(PrivilegeMapper.class);
            SysPrivilege result = privilegeMapper.selectById(1l);
            Assert.assertNotNull(result);
            Assert.assertEquals("用户管理", result.getPrivilegeName());
        } finally {
            session.rollback();
            session.close();
        }
    }
}
