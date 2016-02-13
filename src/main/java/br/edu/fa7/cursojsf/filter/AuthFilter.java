package br.edu.fa7.cursojsf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*.xhtml")
public class AuthFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);

        if (!uri.endsWith("login.xhtml") && (session == null || (session.getAttribute("userLogged") == null))) {
            this.context.log("acesso nao autorizado");
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
