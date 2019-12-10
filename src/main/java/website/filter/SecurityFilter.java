package website.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import website.model.User;
import website.request.UserRoleRequestWrapper;
import website.utils.AppUtils;
import website.utils.SecurityUtils;



public class SecurityFilter implements Filter {


    public SecurityFilter() {  }

	public void destroy() { }
	
	public void init(FilterConfig fConfig) throws ServletException { }

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
 
        String servletPath = request.getServletPath();
 
        User loginedUser = AppUtils.getLoginedUser(request.getSession());
 
        if (servletPath.equals("/login")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;
 
        if (loginedUser != null) {
            String userName = loginedUser.getUsername();
 
            String role = loginedUser.getRole();
 
            wrapRequest = new UserRoleRequestWrapper(userName, role, request);
        }
 
        if (SecurityUtils.isSecurityPage(request)) {
 
            if (loginedUser == null) {
 
                String requestUri = request.getRequestURI();
 
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
 
                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }
 
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
 
                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");
 
                dispatcher.forward(request, response);
                return;
            }
        }
 
        chain.doFilter(wrapRequest, response);
	}
}
