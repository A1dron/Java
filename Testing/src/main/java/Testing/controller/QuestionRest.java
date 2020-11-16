package Testing.controller;

import Testing.entity.Question;
import Testing.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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
    public List<String> getAll(){
        return questionService.getListQuestions();
    }

    @GET
    @Path("/question/{id}")
    public Question getQuestion(@PathParam("id") Integer id){
        return questionService.questionInfo(id);
    }

    @PUT
    @Path("/question/{id}")
    public Question updateQuestion(@PathParam("id") Long id, String question, List<String> answer){
        return questionService.updateQuestion(id, question, answer);
    }

    @DELETE
    @Path("/question/{id}")
    public void deleteQuestion(@PathParam("id") Integer id){
        questionService.deleteQuestion(id);
    }

    @POST
    @Path("/question")
    public void newQuestion(Question question){
        questionService.addQuestion(question);
    }
}
