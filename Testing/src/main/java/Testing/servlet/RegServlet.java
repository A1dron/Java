package Testing.servlet;

import Testing.services.UserService;
import Testing.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;


//@WebServlet(urlPatterns = {"/user/register"})
//@Component
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
        try {
            this.user.registration(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}