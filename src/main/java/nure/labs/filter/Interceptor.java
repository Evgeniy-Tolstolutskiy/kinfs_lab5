package nure.labs.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Евгений on 03.11.2016.
 */
@Component
public class Interceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object logged = httpServletRequest.getSession().getAttribute("logged");
        if (httpServletRequest.getRequestURI().contains("admin") && (logged == null || !logged.toString().equals("true"))
                && !httpServletRequest.getRequestURI().contains("login")) {
            httpServletResponse.sendRedirect("login");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
