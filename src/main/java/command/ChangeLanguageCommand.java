package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Designed to change language.
 */

public class ChangeLanguageCommand implements Command {

    private static final String START_PAGE = "startPage";
    private static final String LANGUAGE = "language";
    private static final String REDIRECT_COMMAND = "controller?command=";
    private static final String LANG = "lang";
    private static final Integer COMMAND_INDEX = 46;

    /**
     * Process the request, change language and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String language = request.getParameter(LANG);
        String query = request.getQueryString();
        session.setAttribute(LANGUAGE, language);
        if (query.length() > COMMAND_INDEX) {
            String page = query.substring(COMMAND_INDEX);
            return CommandResult.redirect(REDIRECT_COMMAND + page);
        } else {
            return CommandResult.redirect(REDIRECT_COMMAND + START_PAGE);
        }
    }
}
