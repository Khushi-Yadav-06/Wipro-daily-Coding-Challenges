
package com.contact.servlet;

import com.contact.model.Contact;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteContact")
public class DeleteContactServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int index = Integer.parseInt(request.getParameter("index"));

        HttpSession session = request.getSession();

        List<Contact> contacts =
                (List<Contact>) session.getAttribute("contacts");

        if (contacts != null && index >= 0 && index < contacts.size()) {

            contacts.remove(index);

            session.setAttribute("message",
                    "Contact Deleted Successfully");
        }

        response.sendRedirect("showContacts");
    }
}
