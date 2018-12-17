package command;

import entity.types.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {

    private static final String LANGUAGE = "language";
    private static final String ROLE = "role";
    private static final String LOGIN = "login";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String language = request.getParameter("lang");
        String page = request.getParameter("currentcommand");

        session.setAttribute(LANGUAGE, language);

        return CommandResult.forward("/controller?command=" + page);
    }
}
