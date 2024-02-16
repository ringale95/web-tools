/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ingale.r
 */
@WebServlet(name = "quiz", urlPatterns = "/quiz.htm")
public class QuizServlet extends HttpServlet {

    List<String> answers = new ArrayList<>();

    public void init() {
        answers.add("a");
        answers.add("b");
        answers.add("c");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handle(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handle(request, response);

    }

    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //create a session cannot be controlled by user and is present in memory of container
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 30);// this is not controlled by user

        String qn = request.getParameter("q"); //first time when user runs value of q =

        if (qn == null) {
            qn = "0";
        }

        String ans = request.getParameter("ans");
        if (!qn.equals("0")) {
            session.setAttribute(qn, ans);
        }
//            Cookie c = new Cookie(qn, ans);
//            c.setMaxAge(60*60*24); //for 1 day cookie is valid
//            response.addCookie(c);

        out.println("<html>");
        out.println("<body>");

        //We cant add cookie here as we have printed already. So before anything is printed cookie must be 
        if (!qn.equals("3")) {
            out.println("<form method='post' action='quiz.htm'>");
        }
        out.println("<h2>SessionID:" + session.getId() + "</h2>");
        out.println("<h2>LastAccessID:" + session.getLastAccessedTime() + "</h2>");

        if (qn.equals("0")) {
            out.println("<h2>Question 1 What is correct syntaz?</h2>");
            out.println("<input type ='radio' name='ans' value='optionA'/>A print (\"Hello World\");<br>");
            out.println("<input type ='radio' name='ans' value='optionA'/> print (\"Hello World\");<br>\n"
                    + "\n" + "Console.WriteLine(\"Hello World\");");
            out.println("<input type ='radio' name='ans' value='optionA'/> echo(\"Hello World\");");
            out.println("<input type ='radio' name='ans' value='optionA'/>D");
            out.println("<input type='hidden' name='number' value='1'>"); //this field is used to keep track of current ques
            out.println("<input type='hidden' name='q' value='1'>"); //1 means read answer for question 1 and display question2
        } else if (qn.equals("1")) {
            //this means that question 1 was submitted and we have to read it and showing question 2
//            ans = request.getParameter("ans");
            out.println("<h2>Question 2 What is correct value?</h2>");
            out.println("<input type ='radio' name='ans' value='optionA'/>A print (\"Hello World\");<br>");
            out.println("<input type ='radio' name='ans' value='optionA'/> print (\"Hello World\");<br>\n"
                    + "\n" + "Console.WriteLine(\"Hello World\");");
            out.println("<input type ='radio' name='ans' value='optionA'/> echo(\"Hello World\");");
            out.println("<input type ='radio' name='ans' value='optionA'/>D");
            out.println("<input type='hidden' name='number' value='1'>"); //this field is used to keep track of current ques
            out.println("<input type='hidden' name='q' value='2'>"); //change value to 2 

        } else if (qn.equals("2")) {
//            ans = request.getParameter("ans");
            out.println("<h2>Question 3 What is your name value?</h2>");
            out.println("<input type ='radio' name='ans' value='optionA'/>A print (\"Hello World\");<br>");
            out.println("<input type ='radio' name='ans' value='optionA'/> print (\"Hello World\");<br>\n"
                    + "\n" + "Console.WriteLine(\"Hello World\");");
            out.println("<input type ='radio' name='ans' value='optionA'/> echo(\"Hello World\");");
            out.println("<input type ='radio' name='ans' value='optionA'/>D");
            out.println("<input type='hidden' name='number' value='1'>"); //this field is used to keep track of current ques
            out.println("<input type='hidden' name='q' value='3'>"); //change value to 2 

        } else if (qn.equals("3")) {

            //get the cookies or cookie array as browser supports 20 cookies from request
//            Cookie[] cookies= request.getCookies();
//                out.println("<ul>"); //this will not print again and again
//            for (Cookie cookie : cookies)
//            {
//                out.println("<li>"+ cookie.getName() + " "+ cookie.getValue()) ;
//            }
//                 out.println("</ul>");
            out.println("<p>Here are your answers!</h2>");
            out.println("<ul>");
            out.println("<li> Answer 1: " + session.getAttribute("1") + "</li>");
            out.println("<li> Answer 2: " + session.getAttribute("2") + "</li>");

            out.println("<li> Answer 3: " + session.getAttribute("3") + "</li>");

            out.println("<li> Answer1 : " + answers.get(0) + "</li>");
            out.println("<li> Answer1 : " + answers.get(1) + "</li>");

            out.println("<li> Answer1 : " + answers.get(2) + "</li>");

        }

        if (!qn.equals("3")) {

            out.println("<input type = 'submit' value='Submit your answerr'>");
            out.println("</form>");
        }

        out.println("</html>");
        out.println("</body>");
    }

}
