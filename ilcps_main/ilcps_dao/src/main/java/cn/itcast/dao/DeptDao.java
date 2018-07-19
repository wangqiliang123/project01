package cn.itcast.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.domain.Dept;

/**
 * Spring Data Jpa 支持下的dao的开发，只要继承JpaRepository， 就具备了crud+分页查询
 * @author Administrator
 *
 */
public interface DeptDao extends JpaRepository<Dept, String> {

	//SpringDataJpa查询支持1： findBy+属性查询
	//需求1： 根据部门名称查询
	List<Dept> findByDeptName(String deptname);
	//需求2： 根据部门名称 + 状态查询
	List<Dept> findByDeptNameAndState(String deptName,Integer state);
	//需求3： 根据部门名称模糊查询
	List<Dept> findByDeptNameLike(String deptName);
	
	
	//SpringDataJpa查询支持2： JPQL(相当于HQL)
	// Java Persistent Query Language java持久化的查询语言
	//需求4： 根据父部门名称查询   from Dept where parent.deptName=?
	@Query(value=" from Dept where parent.deptName=?")
	List<Dept> queryByParent(String parentDeptName);
	
	//需求5：根据部门id，修改部门名称。 ----->deptName=?2 对应形参的第二个参数
	@Query(value = "update Dept set deptName=?2 where id=?1")
	@Modifying	// 标识修改操作
	void updateDeptNameById(String id,String deptName);
	
	
	//SpringDataJpa原生SQL. nativeQuery默认值是false标识JPQL查询。 true标识本地sql查询
	@Query(value="select * from dept_p",nativeQuery=true)
	List<Dept> queryAll();
	
}









