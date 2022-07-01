package de.hsesslingen.StudienprojektKneisel.WebConfig;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class PathForwardHandlerInterceptor implements HandlerInterceptor {

    abstract protected String provideAlternative(String path);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final String alternative = provideAlternative(request.getServletPath());
        if (alternative != null) {
            request.getRequestDispatcher(alternative).forward(request, response);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
