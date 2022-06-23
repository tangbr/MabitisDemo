package com.attoronto.mybatis.test;

import com.attoronto.mybatis.mapper.EmpMapper;
import com.attoronto.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    /**
     * limit index,pageSize
     * index: 当前页的起始索引
     * pageSize:每页显示的条数
     * pageNum:  当前页的页码
     * index = (pageNum-1)*pageSize
     *
     *使用MyBatis的分页插件实现分页功能：
     * 1、需要在查询功能之前开启分页
     *PageHelper.startPage(2,4);         pageNum,   pageSize
     *
     * Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=11, pages=3, reasonable=false, pageSizeZero=false}
     * [Emp{eid=5, empName='田七', age=62, sex='女', email='6542qq.com', did=1},
     * Emp{eid=6, empName='刘八', age=27, sex='女', email='6542qq.com', did=3},
     * Emp{eid=10, empName='a', age=null, sex='null', email='null', did=null},
     * Emp{eid=11, empName='a', age=null, sex='null', email='null', did=null}]
     *
     *PageInfo{pageNum=2, pageSize=4, size=4, startRow=5, endRow=8, total=11, pages=3,
     * list=Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=11, pages=3, reasonable=false, pageSizeZero=false}
     * [Emp{eid=5, empName='田七', age=62, sex='女', email='6542qq.com', did=1},
     * Emp{eid=6, empName='刘八', age=27, sex='女', email='6542qq.com', did=3},
     * Emp{eid=10, empName='a', age=null, sex='null', email='null', did=null},
     * Emp{eid=11, empName='a', age=null, sex='null', email='null', did=null}],
     * prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true,
     * hasNextPage=true, navigatePages=3, navigateFirstPage=1, navigateLastPage=3,
     * navigatepageNums=[1, 2, 3]}
     *
     *
     *2、在查询功能之后获取分页相关信息
     *   PageInfo<Emp> page = new PageInfo<>(list,3);  // odd number recommended
     *   list表示分页数据
     *   3表示当前导航分页的数量
     */


    @Test
    public void testPageHelper(){
        try {
            InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
         //   Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(2, 4);
     //      mapper.selectByExample(null);
            List<Emp> list = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(list,3);  // odd number recommended
      //      list.forEach(emp -> System.out.println(emp));
            System.out.println(page);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
