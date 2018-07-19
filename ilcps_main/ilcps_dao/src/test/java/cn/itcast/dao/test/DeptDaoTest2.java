package cn.itcast.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.DeptDao;
import cn.itcast.domain.Dept;

/**
 * 测试JpaRepository中的CRUD + 分页查询方法
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptDaoTest2 {

	// 注入dao
	@Resource
	private DeptDao deptDao;
	
	// 1. 保存
	@Test
	public void save() throws Exception {
		// 模拟一个对象（游离）
		Dept dept = new Dept();
		dept.setDeptName("java教研部");
		// 父部门
		Dept parent = new Dept();
		parent.setId("100");
		// 设置保存对象的父部门
		dept.setParent(parent);

		// 保存
		deptDao.save(dept);
	}
	// 2. 修改
	@Test
	public void update() throws Exception {
		Dept dept = new Dept();
		dept.setId("8a7e853360eed5fb0160eed600e20000_a");// 如果设置的主键不存在执行insert新增
		dept.setDeptName("java教研部2");
		
		// 修改
		deptDao.save(dept);
	}
	
	//3. 删除
	@Test
	public void delete() throws Exception {
		deptDao.delete("8a7e82886095b7df016095b7e7a70000");
	}
	
	//4. 分页
	@Test
	public void page() throws Exception {
		int page = 1;
		int size = 5;
		// 分页参数(查询第一页)
		Pageable pageable = new PageRequest(page-1, size);
		// 调用分页方法
		Page<Dept> pageData = deptDao.findAll(pageable);
		
		//1. 获取当前页数据
		List<Dept> list = pageData.getContent();
		//2. 获取总记录数
		long totalElements = pageData.getTotalElements();
		//3. 总页数
		int totalPage = pageData.getTotalPages();
		
		System.out.println();
	}
}











