package com.ryerson.rentview.GUI;

import com.ryerson.rentview.Business.MemberManager;
import com.ryerson.rentview.Helper.MemberInfo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MemberInfo memberInfo = MemberManager.authenticateMember(email, password);
        if (memberInfo != null) {
            HttpSession session = request.getSession();
            session.setAttribute("memberInfo", memberInfo);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Login servlet";
    }
}