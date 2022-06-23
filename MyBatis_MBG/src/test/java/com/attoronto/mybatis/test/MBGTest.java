package com.attoronto.mybatis.test;

import com.attoronto.mybatis.mapper.EmpMapper;
import com.attoronto.mybatis.pojo.Emp;
import com.attoronto.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {

    @Test
    public void testMBG() throws IOException {
        try {
            InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
 //           List<Emp> list = mapper.selectByExample(null);
 //           list.forEach(emp -> System.out.println(emp));

            //根据条件查询 qbc 风格 query by criteria 的简写
/*            EmpExample example = new EmpExample();
            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
            example.or().andDidIsNotNull();
            List<Emp> list = mapper.selectByExample(example);
            list.forEach(emp -> System.out.println(emp));*/

            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null, "988@qq.com" ,3));

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
