package cn.itcast.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.DeptDao;
import cn.itcast.domain.Dept;

/**
 * dao 接口的测试
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptDaoTest {

	// 注入dao
	@Resource
	private DeptDao deptDao;
	
	// 1. 查询全部
	@Test
	public void findAll() throws Exception {
		// org.springframework.data.jpa.repository.support.SimpleJpaRepository@775d8d51
		System.out.println(deptDao);
		// class com.sun.proxy.$Proxy33
		System.out.println(deptDao.getClass());
		
		// 测试方法
		List<Dept> list = deptDao.findAll();
		System.out.println(list);
		System.out.println(list.size());
	}
	
	//2. 根据主键查询
	@Test
	public void findOne() throws Exception {
		// 主键查询
		Dept dept = deptDao.findOne("100");
		System.out.println(dept);
	}
}











