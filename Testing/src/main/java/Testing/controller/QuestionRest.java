package Testing.controller;

import Testing.repositories.QuestionRepository;
import Testing.entity.Question;
import Testing.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.List;

@Path("/questions")
@Consumes("application/json")
@Produces("application/json")
@Component
public class QuestionRest {

    @Autowired
    QuestionService questionService;


    @POST
    @Path("/question/view")
    public List<String> getAll(){
        return questionService.getListQuestions();
    }

    @GET
    @Path("/question/{id}")
    public Question getQuestion(@PathParam("id") int id){
        return questionService.questionInfo(id);
    }

    @PUT
    @Path("/question/{id}")
    public Question updateQuestion(@PathParam("id") int id, String param, String newValue){
        questionService.updateQuestion(id,param,newValue);
        return null;
    }

    @DELETE
    @Path("/question/{id}")
    public void delQuest(@PathParam("id") String quest){
        questionService.delQuestion(quest);
    }

    @POST
    @Path("/question")
    public void newQuestion(Question question) throws IOException {
        questionService.addQuestion(question);
    }
}
