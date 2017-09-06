package com.eason.core;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args ) throws Exception
    {
        TypeAliasRegistry registry;
        Configuration configuration;
        System.out.println( "Hello World!" );
        String sources = "mybatis-configuration.xml";
        InputStream inputStream = Resources.getResourceAsStream(sources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);

        MappedStatement mappedStatement;
        SqlSessionFactoryBean sqlSessionFactoryBean;
    }
}
