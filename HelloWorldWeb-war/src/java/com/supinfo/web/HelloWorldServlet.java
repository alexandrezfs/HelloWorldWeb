/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.web;

import com.supinfo.bean.HelloWorldBeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexandrenguyen
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        try {
            
            response.setContentType("text/html;charset=UTF-8");
            
            //Getting HelloWorldBean by network (JNDI)
            Context context = new InitialContext();
            HelloWorldBeanInterface helloService = (HelloWorldBeanInterface) context.lookup("java:global/HelloWorldWeb/HelloWorldWeb-ejb/HelloWorldBean");
            String hello = helloService.hello();
                        
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet HelloWorldServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>" + hello + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (NamingException ex) {
            Logger.getLogger(HelloWorldServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
