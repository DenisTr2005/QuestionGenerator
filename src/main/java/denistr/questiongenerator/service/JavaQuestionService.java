package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;
import denistr.questiongenerator.exception.NoQuestionsInServiceException;
import denistr.questiongenerator.exception.QuestionIsAlreadyAddedException;
import denistr.questiongenerator.exception.QuestionNotFindException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) throws QuestionIsAlreadyAddedException {
        Question newQuestion = new Question(question,answer);
        if (questions.add(newQuestion)) {
            return newQuestion;
        }
        throw new QuestionIsAlreadyAddedException();
    }

    @Override
    public Question add(Question question) throws QuestionIsAlreadyAddedException {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionIsAlreadyAddedException();
    }
    @Override
    public Question remove(Question question) throws QuestionNotFindException {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFindException();
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
    @Override
    public Question getRandomQuestion() {
        int size = questions.size();
        if (size == 0) {
            throw new NoQuestionsInServiceException();
        }
        return questions.toArray(new Question[size])[random.nextInt(size)];
    }
}
