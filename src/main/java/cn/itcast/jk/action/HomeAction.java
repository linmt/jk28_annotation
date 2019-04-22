package cn.itcast.jk.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("homeAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class HomeAction extends BaseAction {
	private String moduleName;		//动态指定跳转的模块，在struts.xml中配置动态的result
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Action(value="homeAction_fmain",results={@Result(name="fmain",location="/WEB-INF/pages/home/fmain.jsp")})
	public String fmain(){
		return "fmain";
	}

	@Action(value="homeAction_title",results={@Result(name="title",location="/WEB-INF/pages/home/title.jsp")})
	public String title(){
		//获取session
		//User curUser = (User)session.get(SysConstant.CURRENT_USER_INFO);
		//ActionContext.getContext().getValueStack().push(curUser);
		
		return "title";
	}

	//转向moduleName指向的模块
	@Action(value="homeAction_tomain",results={@Result(name="tomain",location="/WEB-INF/pages/home/main.jsp")})
	public String tomain(){
		//获取request
		String moduleName = (String)request.get("moduleName");
		
		this.setModuleName(moduleName);
		return "tomain";
	}

	@Action(value="homeAction_toleft",results={@Result(name="toleft",location="/WEB-INF/pages/home/left.jsp")})
	public String toleft(){
		//获取request
		String moduleName = (String)request.get("moduleName");
		this.setModuleName(moduleName);
		return "toleft";
	}
}
