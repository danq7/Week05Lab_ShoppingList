package servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("logout")) {

            session.invalidate();
            session = request.getSession();
            response.sendRedirect("ShoppingList");
        }

        if (session.getAttribute("username") != null) {

            request.setAttribute("displayName", ((String) session.getAttribute("username")));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        } else if (action == null) {

            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String regName;
        String itemName;
        ArrayList<String> itemList = new ArrayList<>();

        if (action.equals("register")) {

            regName = request.getParameter("name_input");
            session.setAttribute("username", regName);
        }

        if (action.equals("add")) {

            itemName = request.getParameter("item");

            if (itemName != null & !itemName.isEmpty()) {
                
                itemList.add(itemName);
                session.setAttribute("listOfItems", itemList);
            }
        }

        if (action.equals("delete")) {

            itemName = request.getParameter("item");
            itemList.remove("deleteItem");
            session.setAttribute("listOfItems", itemList);
        }
        
        response.sendRedirect("ShoppingList");
    }

}
