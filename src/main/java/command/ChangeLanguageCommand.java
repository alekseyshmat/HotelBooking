package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {

    private static final String LANGUAGE = "language";
    private static final String REDIRECT_COMMAND = "controller?command=";
    private static final String LANG = "lang";
    private static final Integer COMMAND_INDEX = 46;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String language = request.getParameter(LANG);
        String query = request.getQueryString();
        String page = query.substring(COMMAND_INDEX);
        session.setAttribute(LANGUAGE, language);

        return CommandResult.redirect(REDIRECT_COMMAND + page);
    }
}
