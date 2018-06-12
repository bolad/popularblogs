package com.bolad.popularblogs.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseInterceptor extends HandlerInterceptorAdapter {

    /*
    This method is called immediately after the request is processed by HandlerAdapter,
    but before generating a view and we can use this method to add additional
    attributes to the ModelAndView or to determine the time taken by handler method to process a client’s request.
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {
        String controllerName = "";
        String actionName = "";

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            controllerName = handlerMethod.getBeanType().getSimpleName().replace("Controller", "");
            actionName = handlerMethod.getMethod().getName();
        }

        modelAndView.addObject("controllerName", controllerName);
        modelAndView.addObject("actionName", actionName);
    }
}
