package Testing.servlet;

import Testing.entity.DatabaseWrapper;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
//Реализовать сервлет для логина пользователя, обрабатывающего запрос GET /user/login. При
// успешном логине данные о пользователе должны сохраняться в сессии.

@WebServlet(name = "Nechto", urlPatterns = {"/user/login"})
@Component
public class LogServlet extends HttpServlet {
    @Autowired
    UserService user;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
//        User user = objectMapper.readValue(dataLine, User.class);
//        if (new DatabaseWrapper().isExistUser(user)){
//            String login = user.getLogin();
//            String name = user.getName();
//            if (login == null){
//                session.setAttribute("login", name);
//                out.println("Hi");
//            }
//        }else{
//            out.println("I don't know you, pls registration");
//        }
    }
}
