package Testing.servlet;


import Testing.entity.Question;
import Testing.repositories.QuestionAccessServiceImpl;
import Testing.repositories.QuestionRepository;

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
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //ObjectMapper objectMapper = new ObjectMapper();
        resp.setContentType("text/html");
        //HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        try {
            List<Question> quest = new QuestionAccessServiceImpl().viewListQuestions();
            for (Question question : quest) {
                writer.println("<p>Question: " + question.getQuestion() + "</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
