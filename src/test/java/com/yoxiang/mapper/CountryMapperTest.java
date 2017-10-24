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
public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll() {

        SqlSession session = getSession();
        try {
            List<Country> countryList = session.selectList("com.yoxiang.mapper.CountryMapper.selectAll");
            for (Country country : countryList) {
                System.out.println(country.getName() + "==" + country.getCode());
            }
        } finally {
            session.close();
        }
    }
}
