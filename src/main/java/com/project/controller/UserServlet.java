package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.dao.UserDAO;
import com.project.model.User;
import com.project.validation.UserValidator;

@WebServlet("/newForm")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        // ✅ Validation
        List<String> errors = UserValidator.validate(name, email, phone, password, ageStr);

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        // ✅ Model
        User user = new User(name, Integer.parseInt(ageStr), email, Long.parseLong(phone), password);

        // ✅ DAO
        int result = UserDAO.save(user);

        if (result > 0) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            errors.add("Database error occurred");
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}