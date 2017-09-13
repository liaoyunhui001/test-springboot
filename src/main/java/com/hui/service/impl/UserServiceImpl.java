package com.hui.service.impl;

import com.hui.dao.UserDao;
import com.hui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * Created by JianChengCai on 2017/9/11.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean insertUser(String name, String email, String phone, String industry, String type) {
		return userDao.insertUser(name, email, phone, industry, type);
	}

	@Override
	public List<Map> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public Integer updateUserById(String id) {
		return userDao.updateUserById(id);
	}

	@Override
	public Integer deleteUserById(String id) {
		return userDao.deleteUserById(id);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public String testTransaction(String id1, String id2) {
		Integer res1 = userDao.updateUserById(id1);
		Assert.isTrue(false, "中间出现异常");
		Integer res2 = userDao.updateUserById(id2);
		//Assert.isTrue(false, "结尾出现异常");
		return res1 + res2 >= 0 ? "success" : "failed";
	}

}
