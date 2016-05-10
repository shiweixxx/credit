package apix.credit.com.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SpringMVCInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
//		String url=request.getRequestURL().toString();
//		if ((url.indexOf("credit/index/") > 0)||(url.indexOf("credit/loginsucc/") > 0)
//				||(url.indexOf("credit/img/") > 0)||(url.indexOf("credit/css/") > 0)
//				||(url.indexOf("credit/js/") > 0)||(url.indexOf("credit/font/") > 0)
//				||(url.indexOf("credit/jqvmap/") > 0)){
//			System.out.println("当前请求路径："+request.getRequestURL());
//			return true;
//		}
//		Object obj = ActionContext.getContext().getSession().get(Constants.SESSION_USER);
//		if(obj==null){
//			ActionContext.getContext().put("timeout","登陆超时。");
//			return false;
//		}
		return true;
	}

}
