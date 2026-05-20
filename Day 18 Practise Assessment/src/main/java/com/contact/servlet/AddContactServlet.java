
package com.contact.servlet;

import com.contact.model.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Contact contact = new Contact(name, phone, email);

        HttpSession session = request.getSession();

        List<Contact> contacts =
                (List<Contact>) session.getAttribute("contacts");

        if (contacts == null) {
            contacts = new ArrayList<>();
        }

        contacts.add(contact);

        session.setAttribute("contacts", contacts);

        response.sendRedirect("showContacts");
    }
}
