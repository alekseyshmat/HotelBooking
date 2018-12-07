package controller;

import command.Command;
import command.CommandFactory;
import command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory factory = new CommandFactory();
        String parametr = req.getParameter("command");
        Command command = factory.create(parametr);
        CommandResult commandResult = command.execute(req, resp);

        String page = commandResult.getPage();
       /* if (commandResult.isRedirect()) {
            sendRedirect(resp, page);
        } else {*/
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
            requestDispatcher.forward(req, resp);
//        }
    }

    private void sendRedirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }
}
