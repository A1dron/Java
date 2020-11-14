package Testing.controller;

import Testing.entity.Question;
import Testing.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.List;

@Path("/test")
@Consumes("application/json")
@Produces("application/json")
@Component
public class QuestionRest {

    @Autowired
    private QuestionService questionService;


    @POST
    @Path("/question/view")
    public List<String> getAll() throws Exception {
        return questionService.getListQuestions();
    }

    @GET
    @Path("/question/{id}")
    public Question getQuestion(@PathParam("id") Integer id) throws Exception {
        return questionService.questionInfo(id);
    }

    @PUT
    @Path("/question/{id}")
    public Question updateQuestion(@PathParam("id") int id, String param, String newValue) throws Exception {
        questionService.updateQuestion(id, param, newValue);
        return null;
    }

    @DELETE
    @Path("/question/{id}")
    public void deleteQuestion(@PathParam("id") Integer id) throws Exception {
        questionService.deleteQuestion(id);
    }

    @POST
    @Path("/question")
    public void newQuestion(Question question) throws Exception {
        questionService.addQuestion(question);
    }
}
