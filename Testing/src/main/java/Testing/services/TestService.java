package Testing.services;

import Testing.entity.Test;
import Testing.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestService {

    @Autowired
    TestRepository repository;

    public void addTest(Test test){
        repository.save(test);
    }

    public void deleteTest(Long id){
        repository.delete(id);
    }

    public Optional<Test> getTest(Long id){
        Optional<Test> test = repository.findById(id);
        return test;
    }
}
