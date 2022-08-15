package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;
import denistr.questiongenerator.exception.QuestionIsAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
        random = new Random();
    }

    @Override
    public Question add(String question, String answer) throws QuestionIsAlreadyAddedException {
        Question newQuestion = new Question(question,answer);
        if (questions.add(newQuestion)) {
            return newQuestion;
        }
        throw new QuestionIsAlreadyAddedException();
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        random.nextInt(questions.size());
        return null;
    }
}
