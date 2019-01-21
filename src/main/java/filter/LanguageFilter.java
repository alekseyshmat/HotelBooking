package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Designed to perform a language filter operation.
 */

public class LanguageFilter implements Filter {

    private static final String EN = "EN";
    private static final String LANGUAGE = "language";

    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Method of the Filter is called by the
     * container each time a request/response pair is passed through the
     * chain due to a client request for a resource at the end of the chain,
     * checks the language setting and sets the default if the language has not been set.
     *
     * @param servletRequest  an {@link ServletRequest} object that contains client request
     * @param servletResponse an {@link ServletResponse} object that contains the response the servlet
     * @param filterChain     an {@link FilterChain} object that allows the Filter to pass
     *                        on the request and response to the next entity in the chain.
     * @throws IOException      Signals that an I/O exception of some sort has occurred.
     * @throws ServletException General exception a servlet can throw when it encounters difficulty.
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String language = (String) session.getAttribute(LANGUAGE);
        if (language == null) {
            language = EN;
            session.setAttribute(LANGUAGE, language);
        }

        session.setAttribute(LANGUAGE, language);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
