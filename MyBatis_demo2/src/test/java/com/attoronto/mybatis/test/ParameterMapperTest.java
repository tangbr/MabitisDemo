package com.attoronto.mybatis.test;

import com.attoronto.mybatis.mapper.ParameterMapper;
import com.attoronto.mybatis.pojo.User;
import com.attoronto.mybatis.utils.SqlSessionUtils;
import com.mysql.cj.xdevapi.PreparableStatement;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

        /**
         * MyBatis获取参数值的两种方式： ${} 和  #{}
         * ${}本质字符串拼接
         * #{}本质占位符赋值
         * MyBatis获取参数值的各种情况：
         * 1、mapper接口方法的参数为单个的字面量类型
         * 可以通过${}和#{} 以任意的字符串获取参数值，但是需要注意${}的单引号问题
         * 2、mapper接口方法的参数为多个时
         * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
         * a>以arg0,arg1...为健， 以参数为值
         * b>以param1,param2...为健， 以参数为值
         * 因此只需要通过${}和#{}以健的方式访问值即可，  但是需要注意${}的单引号问题
         * 3、若mapper接口的参数有多个时，可以手动将这些参数放在一个map中存储
         * 只需要通过${}和#{}以健的方式访问值即可，  但是需要注意${}的单引号问题
         * 4、mapper接口方法的参数是实体类类型的参数的时候
         * 只需要通过${}和#{}以属性的方式访问值即可，  但是需要注意${}的单引号问题
         * 5、使用@Param注解命名参数
         *此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
         * a>以@Param注解的值为键，以参数为值
         * b>以param1,param2的值为键，以参数为值
         * 因此只需要通过${}和#{}以健的方式访问值即可，  但是需要注意${}的单引号问题
         */
        @Test
        public void testCheckLoginByParam(){
                SqlSession sqlSession = SqlSessionUtils.getSqlSession();
                ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
                User user=mapper.checkLoginByParam("张三","123456");
                System.out.println(user);
        }

        @Test
        public void testInsertUser(){
                SqlSession sqlSession = SqlSessionUtils.getSqlSession();
                ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
                int result = mapper.insertUser(new User(null,"李四","123",23,"男","456@qq.com"));
                System.out.println(result);
        }


        @Test
        public void testCheckLoginByMap(){
                SqlSession sqlSession = SqlSessionUtils.getSqlSession();
                ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
                Map<String,Object> map = new HashMap<>();
                map.put("username","张三");
                map.put("password","123456");
                User user=mapper.checkLoginByMap(map);
                System.out.println(user);
        }


        @Test
        public void testCheckLogin(){
                SqlSession sqlSession = SqlSessionUtils.getSqlSession();
                ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
                User user=mapper.checkLogin("张三","123456");
                System.out.println(user);
        }


        @Test
        public void testGetUserByUsername(){
                SqlSession sqlSession = SqlSessionUtils.getSqlSession();
                ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
                User user=mapper.getUserByUsername("张三");
                System.out.println(user);
        }

        @Test
        public void testGetAllUser(){
                SqlSession sqlSession = SqlSessionUtils.getSqlSession();
                ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
                List<User> list = mapper.getAllUser();
                list.forEach(user-> System.out.println(user));
        }

        @Test
        public void testJDBC() throws Exception {
                String username = "admin";
                Class.forName("");
                Connection connection = DriverManager.getConnection("","","");
      /*          PreparableStatement ps =
                     connection.prepareStatement("select * from t_user where username='"+username+"'");*/
                PreparableStatement ps = (PreparableStatement) connection.prepareStatement("select * from t_user where username=?");
                ((PreparedStatement) ps).setString(1,username);
        }














}
