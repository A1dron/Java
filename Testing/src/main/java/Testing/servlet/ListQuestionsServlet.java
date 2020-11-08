package Testing.servlet;


import Testing.repositories.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/questions.json")
public class ListQuestionsServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        resp.setContentType("text/html");
        //HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        try {
            List<String> quest = new QuestionRepository().listQuestions();
            for (String question : quest) {
                writer.println("<p>Question: " + question + "</p>");
            }
        }finally {
            writer.close();
        }
    }
}
