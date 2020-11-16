package Testing.repositories;

import Testing.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuestionAccessServiceImpl {
    @Autowired
    QuestionRepository repository;

    public void addQuestion(Question question) {
        repository.save(question);
    }

    public void deleteQuestion(Long id) {

        repository.delete(id);
    }

    public Question getQuestion(Long id) {
        Optional<Question> questions = repository.findById(id);
        return questions.orElseThrow(() -> {
            throw new RuntimeException("No this question");
        });
    }

    public List<Question> viewListQuestions() {
        return repository.findAll();
    }

    public Question updateQuestion(Long id, String question, List<String> answer) {
        Question updateQuestion = getQuestion(id);
        updateQuestion.setQuestion(question);
        updateQuestion.setAnswer(answer);
        return updateQuestion;
    }
}
