package cn.itcast.jk.action;


import cn.itcast.jk.utils.SysConstant;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("loginAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;



	//SSH传统登录方式
	@Action(value="login",
			results={
					@Result(name="success",location="/WEB-INF/pages/home/fmain.jsp"),
					@Result(name="login",location="/WEB-INF/pages/sysadmin/login/login.jsp")
			})
	public String login() throws Exception {
		
//		if(true){
//			String msg = "登录错误，请重新填写用户名密码!";
//			this.addActionError(msg);
//			throw new Exception(msg);
//		}
//		User user = new User(username, password);
//		User login = userService.login(user);
//		if (login != null) {
//			ActionContext.getContext().getValueStack().push(user);
//			session.put(SysConstant.CURRENT_USER_INFO, login);	//记录session
//			return SUCCESS;
//		}
//		return "login";
		
		return SUCCESS;
	}
	
	
	//退出
	@Action(value="logout",results={@Result(name="logout",location="/WEB-INF/pages/sysadmin/login/logout.jsp")})
	public String logout(){
		session.remove(SysConstant.CURRENT_USER_INFO);		//删除session
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

