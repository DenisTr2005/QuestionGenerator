package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
