package com.attoronto.mybatis.mapper;

public interface UserMapper {
    /**
     * MyBatis 面向接口编程的两个一致：
     * 1. 映射文件的namespace要和mapper接口的全类名保持一致
     * 2. 映射文件中的SQL语句的id要和mapper接口中的方法名一致
     *
     * 表-- 实体类--mapper接口--映射文件
     */

    /**
     * 添加用户信息
     */
    int insertUser();
/**
 * 修改用户信息
 */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();
}
