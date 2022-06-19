package com.attoronto.mybatis.test;

import com.attoronto.mybatis.mapper.UserMapper;
import com.attoronto.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    /**
     * SqlSessionManager 默认不自动提交事务， 若需要自动提交事务
     *  可以使用SqlSessionFactory.openSession(true);
     */

    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById();
        System.out.println(user);


       // mapper.updateUser();
       //  mapper.deleteUser();

    }





}
