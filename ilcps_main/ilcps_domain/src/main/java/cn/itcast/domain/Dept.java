package cn.itcast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity 	// 标识一个持久化对象
@Table(name = "dept_p")
public class Dept {

	// 部门id
	@Id		// 标识主键
	@Column(name="dept_id")	// 对应表的字段
	// uuid作为主键， generator="system-uuid" 要对应@GenericGenerator中的name值
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id;
	
	// 部门名称
	@Column(name="dept_name")
	private String deptName;
	
	// 状态
	@Column(name="state")
	private Integer state;
	
	// 父部门 (如何把一个对象映射到数据库对应一个外键字段？)
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Dept parent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Dept getParent() {
		return parent;
	}
	public void setParent(Dept parent) {
		this.parent = parent;
	}
	
}
