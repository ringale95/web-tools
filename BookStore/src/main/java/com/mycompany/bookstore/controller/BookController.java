/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bookstore.controller;

import com.mycompany.bookstore.pojo.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BookController", urlPatterns = {"/book.htm"})
public class BookController extends HttpServlet {

    ArrayList<Book> books;

    public void init() {
        Book b1 = new Book();
        b1.setIsbn("123");
        b1.setTitle("Java Programming Book");
        b1.setAuthor("Deitel");

        Book b2 = new Book();
        b2.setIsbn("246");
        b2.setTitle("Oracle Database Design");
        b2.setAuthor("Ozbek");

        Book b3 = new Book();
        b3.setIsbn("369");
        b3.setTitle("HTML and JavaScript");
        b3.setAuthor("Brown");

        books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);

        ServletContext ctx = this.getServletContext();
        ctx.setAttribute("booklist", books);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        //1. Meta Refresh
        //out.println("<meta http-equiv=\"refresh\" content=\"5; url=book-view.jsp\">");

        //2. response.sendRedirect
        //response.sendRedirect("WEB-INF/book-view.jsp");
        //3. RequestDispatcherObj.forward
        //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/book-view.jsp");
        if (action.equals("view")) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/book-view.jsp");
        } else if (action.equals("search")) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/book-search.jsp");
        } else if (action.equals("result")) {
            String q = request.getParameter("searchkey");
            ArrayList<Book> resultList = new ArrayList<>();
            for (Book b : books) {
                if (b.getIsbn().contains(q) ||  b.getTitle().contains(q) || b.getAuthor().contains(q)) {
                    resultList.add(b);
                }
            }
            request.setAttribute("results", resultList);
            dispatcher = request.getRequestDispatcher("/WEB-INF/book-results.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/WEB-INF/error.jsp");
        }

        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
