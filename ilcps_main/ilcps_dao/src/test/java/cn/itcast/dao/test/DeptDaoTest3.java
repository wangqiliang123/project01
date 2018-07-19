package cn.itcast.dao.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.DeptDao;

/**
 * 测试JpaRepository中的自定义方法
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptDaoTest3 {

	// 注入dao
	@Resource
	private DeptDao deptDao;
	
	@Test
	public void find() throws Exception {
		// 需求1，测试
		System.out.println(deptDao.findByDeptName("商贸集团"));
		// 需求2，测试
		System.out.println(deptDao.findByDeptNameAndState("商贸集团",0));
		// 需求3，测试
		System.out.println(deptDao.findByDeptNameLike("团%"));
		// 需求4，测试
		System.out.println(deptDao.queryByParent("商贸集团"));
	}
	//Caused by: javax.persistence.TransactionRequiredException: Executing an update/delete query
	// 解决： 开启事物注解,问题解决
	@Test
	@Transactional // Rolled back transaction for test context 知道我们执行的是测试，自动回滚
	@Rollback(false) // 不回滚，提交事务。 Committed transaction for test 
	public void update() {
		try {
			deptDao.updateDeptNameById("8a7e8716607d51a601607d51ac5f0000", "财神1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void nativeQuery() throws Exception {
		// 需求1，测试
		System.out.println(deptDao.queryAll().size());
	}
}











