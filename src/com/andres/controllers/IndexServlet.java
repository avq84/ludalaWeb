package com.andres.controllers;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import com.andres.parser.RSSParser;

public class IndexServlet extends HttpServlet {

    RSSParser rssParser;

    public IndexServlet() {
        rssParser = new RSSParser();
    }

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost( HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String targetURL = (String) request.getParameter("targetUrl");

        response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(rssParser.parse(targetURL));
    }

}
