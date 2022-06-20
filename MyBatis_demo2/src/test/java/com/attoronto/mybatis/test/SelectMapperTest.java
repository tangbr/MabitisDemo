package com.attoronto.mybatis.test;

import com.attoronto.mybatis.mapper.SelectMapper;
import com.attoronto.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {

    /**
     * 1、 若查询出的数据只有一条，可以通过实体类对象或者集合接收, 还可以通过map集合接收，结果如下：
     * {password=123456, sex=M, id=4, age=23, email=12345@qq.com, username=张三}
     * 2、 若查询出的数据有多条， 可以通过List集合或者map类型的list集合来接收，
     * 还可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，
     * 放在同一个map集合中
     * 但一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     *
     * MyBatis中设置了默认的类型别名
     *java.lang.Integer-->int,integer
     * int --> _int, _integer
     * Map-->map
     * String-->string
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(6));
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }


    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }


    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(4));
    }


    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
}
