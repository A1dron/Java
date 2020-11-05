package Testing.servlet;


import Testing.entity.DatabaseWrapper;
import Testing.entity.Question;
import Testing.services.QuestionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/questions")
public class ListQuestionsServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        resp.setContentType("text/html");
        //HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        try {
            List<String> quest = new DatabaseWrapper().listQuestions();
            for (String question : quest) {
                writer.println("<p>Question: " + question + "</p>");
            }
        }finally {
            writer.close();
        }
    }
}
