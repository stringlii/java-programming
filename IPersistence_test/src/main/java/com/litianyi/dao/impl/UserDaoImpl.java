package com.litianyi.dao.impl;

import com.litianyi.dao.UserDao;
import com.litianyi.io.Resource;
import com.litianyi.po.User;
import com.litianyi.sql.session.SqlSession;
import com.litianyi.sql.session.SqlSessionFactory;
import com.litianyi.sql.session.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.io.InputStream;
import java.util.List;

/**
 * @author litianyi
 * @version 1.0
 * @date 2022/3/9 8:16 PM
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        InputStream in = Resource.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession.selectList("user.selectList");
    }

    @Override
    public User findByCondition(User user) {
        InputStream in = Resource.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession.selectOne("user.selectOne", user);
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }
}
