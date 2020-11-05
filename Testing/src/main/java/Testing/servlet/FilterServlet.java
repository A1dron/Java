package Testing.servlet;

import Testing.services.UserService;
import Testing.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;

@WebFilter(urlPatterns = "/secured/")
public class FilterServlet implements Filter {
    @Autowired
    UserService user;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        if (session != null) {
            String log = (String) session.getAttribute("login");
            if (log != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }
        } else {
            throw new ServletException("You shall not pass!");
        }

    }
}
