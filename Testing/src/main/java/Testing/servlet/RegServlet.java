package Testing.servlet;

import Testing.DataBaseWrapper.DatabaseWrapperUser;
import Testing.services.UserService;
import Testing.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/user/register"})
@Component
public class RegServlet extends HttpServlet {
    @Autowired
    UserService user;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String dataLine = req.getReader().lines().collect(Collectors.joining());
        User user = objectMapper.readValue(dataLine, User.class);
        new DatabaseWrapperUser().regUser(user);
    }
}