package com.hui.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by hujia on 2016/11/16.
 */
@Mapper
public interface UserDao {

	/**
	 * 插入用户
	 *
	 * @return 插入的行数
	 */
	@Insert("INSERT IGNORE INTO user (name, phone, email, industry, type) " +
			"        VALUES (#{name}, #{phone}, #{email}, #{industry}, #{type})")
	boolean insertUser(@Param("name") String name, @Param("email") String email
			, @Param("phone") String phone, @Param("industry") String industry, @Param("type") String type);

	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	@Select("SELECT * FROM user")
	List<Map> selectAllUser();


	/**
	 * 改
	 *
	 * @return
	 */
	@Update("UPDATE `user` SET email = '280@11.com' WHERE id = #{id}")
	Integer updateUserById(@Param("id") String id);

	/**
	 * 删除
	 *
	 * @return
	 */
	@Delete("DELETE FROM `user` WHERE id = #{id}")
	Integer deleteUserById(@Param("id") String id);

}
