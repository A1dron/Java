package Testing.entity;

import Testing.services.QuestionServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/questions")
@Consumes("application/json")
@Produces("application/json")
public class QuestionRest {
    @POST
    @Path("/question/view")
    public List<String> getAll(){
        List<String> quest = new DatabaseWrapper().listQuestions();
        return quest;
    }

    @GET
    @Path("/question/{question}")
    public Question getQuestion(@PathParam("question") String quest){
        return new DatabaseWrapper().getQuestion(quest);
    }

    @PUT
    @Path("/question")
    public void updateQuestion(@PathParam("question") String quest, String param, String newValue){
        new QuestionServiceImpl().redactQuestion(quest,param,newValue);
    }

    @DELETE
    @Path("/question/{question}")
    public void delQuest(@PathParam("question") String quest){
        new QuestionServiceImpl().delQuestion(quest);
    }

    @POST
    @Path("/question")
    public void newQuestion(Question question) throws IOException {
        new QuestionServiceImpl().addQuestion(question);
    }
}
