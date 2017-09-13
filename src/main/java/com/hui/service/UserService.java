package com.hui.service;

import java.util.List;
import java.util.Map;

/**
 * Created by JianChengCai on 2017/9/11.
 */
public interface UserService {

	boolean insertUser(String name, String email, String phone, String industry, String type);

	List<Map> selectAllUser();

	Integer updateUserById(String id);

	Integer deleteUserById(String id);

	String testTransaction(String id1, String id2);
}
