package com.yoxiang.mapper;

import com.yoxiang.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/10/23 22:10
 */
public class CountryMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {

        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Country> countryList = session.selectList("selectAll");
            for (Country country : countryList) {
                System.out.println(country.getName() + "==" + country.getCode());
            }
        } finally {
            session.close();
        }
    }
}
