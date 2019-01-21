package controller;

import command.Command;
import command.CommandFactory;
import command.CommandResult;
import exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Provides a HTTP servlet class suitable for a Web site.
 */

public class Controller extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private static final String COMMAND = "command";
    private static final String ERROR_PAGE = "/WEB-INF/pages/error/Error500.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    /**
     * Processes the request by obtaining a command from the {@link HttpServletRequest} object, execute this command and redirects or
     * forwards on destination page depending on the result of the command.
     *
     * @param req  an {@link HttpServletRequest} object that contains client request
     * @param resp an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @throws ServletException General exception a servlet can throw when it encounters difficulty.
     * @throws IOException      Signals that an I/O exception of some sort has occurred.
     */

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory factory = new CommandFactory();
        String parameter = req.getParameter(COMMAND);
        Command command = factory.create(parameter);

        LOGGER.info("Command = " + command);

        try {
            CommandResult commandResult = command.execute(req, resp);
            String page = commandResult.getPage();
            if (commandResult.isRedirect()) {
                resp.sendRedirect(page);
            } else {
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
                requestDispatcher.forward(req, resp);
            }
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            CommandResult.forward(ERROR_PAGE);
        }
    }
}
