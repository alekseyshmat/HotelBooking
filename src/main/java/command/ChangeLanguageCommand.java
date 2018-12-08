package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {

    private static final String RU = "ru";
    private static final String EN = "en";
    private static final String LANGUAGE = "language";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String language = request.getParameter("lang");
        String page = request.getParameter("page");
        session.setAttribute(LANGUAGE, language);
        String path = request.getRequestURI();
        System.out.println(path);
        System.out.println(page);
        return new CommandResult("/controller?command=login" , true);
    }
}
