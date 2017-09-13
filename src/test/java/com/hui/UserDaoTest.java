package com.hui;

import com.hui.dao.UserDao;
import com.hui.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hujia on 2016/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@Test
	public void testInsertUser() throws Exception {
		String name = "test01";
		String phone = "13554716412";

		if (userDao.insertUser(name, "未填写", phone, "未填写", "ow")) {
			System.out.println("添加用户成功");
		} else {
			System.out.println("添加用户失败");
		}
	}

	@Test
	public void testSelectAllUser() throws Exception {
		System.out.println(userDao.selectAllUser());
	}

	@Test
	public void testUpdateUserById() throws Exception {
		String id = "10012";
		Integer result = userDao.updateUserById(id);
		System.out.println("成功修改" + result + "条数据");
	}

	@Test
	public void testDeleteUserById() throws Exception {
		String id = "10031";
		Integer result = userDao.deleteUserById(id);
		System.out.println("成功删除" + result + "条数据");
	}

	/**
	 * Spring事务：网上说要在Application中通过@EnableTransactionManagement启动事务管理，实测不需要。
	 * 只需要在对应的服务中添加@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	 * 注解即可。
	 * <p>
	 * 测试结果：只要方法在未执行完就出现异常，那么就会触发事务回滚
	 *
	 * @throws Exception
	 */
	@Test
	public void testTransaction() throws Exception {
		String id1 = "10012";
		String id2 = "10069";
		String result = userService.testTransaction(id1, id2);
		System.out.println(result);
	}

}
