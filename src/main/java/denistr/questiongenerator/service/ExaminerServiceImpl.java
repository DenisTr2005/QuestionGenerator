package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;
import denistr.questiongenerator.exception.NoMoreQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws NoMoreQuestionsException{
        if (amount > questionService.getAll().size()) {
            throw new NoMoreQuestionsException();
        }
        Collection<Question> collection = new HashSet<>();
        while (collection.size() < amount) {
            collection.add(questionService.getRandomQuestion());
        }
        return collection;
    }
}
