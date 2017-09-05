package com.eason.core.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by feng yingsheng on 9/2/2017.
 */
public class SimpleJavaMybatisBuilder {

    public static void main(String[] args) throws Exception {
        SqlSessionFactory sqlSessionFactory = buildSqlSessionFactory();
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = getSqlSession(sqlSessionFactory);
        getSelectTest(sqlSession);
    }

    private static void getSelectTest(SqlSession sqlSession) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectOne();
        System.out.println(users);
        if(users.size() > 0) {
            User user = users.get(0);
            System.out.println(user.getUserName());
        }
        sqlSession.close();
    }

    private static SqlSession getSqlSession(SqlSessionFactory sqlSessionFactory) {
        return sqlSessionFactory.openSession();
    }

    private static SqlSessionFactory buildSqlSessionFactory() throws Exception {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://123.56.100.200:3306/myspider?autoReconnect=true&characterEncoding=utf8");
        pooledDataSource.setUsername("myspider");
        pooledDataSource.setPassword("10eOIi&w");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, pooledDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.getTypeAliasRegistry().registerAlias("user", User.class);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

}
