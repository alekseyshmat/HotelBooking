package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {

    private static final String LANGUAGE = "language";
    private static final String CURRENT_COMMAND = "currentcommand";
    private static final String REDIRECT_COMMAND = "controller?command=";
    private static final String LANG = "lang";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String language = request.getParameter(LANG);
        String page = request.getParameter(CURRENT_COMMAND);

        session.setAttribute(LANGUAGE, language);

        return CommandResult.redirect(REDIRECT_COMMAND + page);
    }
}
