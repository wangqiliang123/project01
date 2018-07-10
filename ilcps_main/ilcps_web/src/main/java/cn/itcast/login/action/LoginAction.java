package cn.itcast.login.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class LoginAction {

	@Action(value="loginAction_login",
			results={@Result(name="success",location="/WEB-INF/pages/home/fmain.jsp")})
	public String login(){
		//1. 获取输入的账号密码
		
		//2. 校验（查询数据）
		
		//3. 保存用户到session
		
		//4. 登陆成功，跳转到“主页”
		return "success";	// 目前，默认全是登陆成功，都去到主页
	}
}












