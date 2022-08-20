package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
