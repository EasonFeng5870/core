package com.eason.core.mybatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户mapper
 * Created by feng yingsheng on 9/2/2017.
 */
public interface UserMapper {

    @Select("select * from mybatis_user")
    List<User> selectOne();
}
