
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

@WebServlet("/editContact")
public class EditContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int index = Integer.parseInt(request.getParameter("index"));

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();

        List<Contact> contacts =
                (List<Contact>) session.getAttribute("contacts");

        if (contacts != null) {

            Contact contact = contacts.get(index);

            contact.setName(name);
            contact.setPhone(phone);
            contact.setEmail(email);

            session.setAttribute("message",
                    "Contact Updated Successfully");
        }

        response.sendRedirect("showContacts");
    }
}
