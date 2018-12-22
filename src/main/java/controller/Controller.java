package controller;

import command.Command;
import command.CommandFactory;
import command.CommandResult;
import exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String COMMAND = "command";

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
        String parametr = req.getParameter(COMMAND);
        Command command = factory.create(parametr);
        CommandResult commandResult = null;
        try {
            commandResult = command.execute(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        String page = commandResult.getPage();
        if (commandResult.isRedirect()) {
            resp.sendRedirect(page);
        } else {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
            requestDispatcher.forward(req, resp);
        }
    }
}
