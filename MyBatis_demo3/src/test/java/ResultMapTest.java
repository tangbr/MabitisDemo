import com.attoronto.mybatis.mapper.EmpMapper;
import com.attoronto.mybatis.pojo.Emp;
import com.attoronto.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况：
     * 1、为字段起别名， 保持和属性名的一致
     * 2、设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * 3、通过resultMap 设置自定义的映射关系
     *     <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *     </resultMap>
     *
     *     处理多对一的映射关系：
     *     a>级联属性赋值
     *     b> association
     *     c> 分布查询
     */


    @Test
    public  void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp);
    }


    @Test
    public  void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(3);
       System.out.println(emp);
    }


    @Test
    public  void testGetAllEmp(){
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> list = mapper.getAllEmp();
            list.forEach(emp -> System.out.println(emp));

        }



}
