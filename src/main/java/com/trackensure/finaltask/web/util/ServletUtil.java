package com.trackensure.finaltask.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
    private final String actionName;
    HttpServletRequest request;
    HttpServletResponse response;

    public ServletUtil(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        actionName = request.getParameter("actionName");
    }

    public String getActionName() {
        return actionName;
    }
}
