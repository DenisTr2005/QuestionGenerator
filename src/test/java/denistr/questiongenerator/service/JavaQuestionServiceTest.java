package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;
import denistr.questiongenerator.exception.NoQuestionsInServiceException;
import denistr.questiongenerator.exception.QuestionIsAlreadyAddedException;
import denistr.questiongenerator.exception.QuestionNotFindException;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final String QUESTION = "Какие условные операторы вы знаете?",
                    ANSWER = "if else, switch case, тернарный оператор ?:";
    private final Question
            question1 = new Question(QUESTION, ANSWER),
            question2 = new Question("Какие циклы вы знаете?", "for, while, do while");
    private final Set<Question> questions = new HashSet<>();
    private final JavaQuestionService out = new JavaQuestionService();


    @Test
    public void shouldAddQuestionByStrings() {
        assertEquals(question1,out.add(QUESTION,ANSWER));
        questions.add(question1);
        assertEquals(questions,out.getAll());
    }
    @Test
    public void shouldAddQuestionByQuestion() {
        assertEquals(question1,out.add(question1));
        questions.add(question1);
        assertEquals(questions,out.getAll());
    }
    @Test
    public void shouldThrowsQuestionIsAlreadyAddedException() {
        out.add(question1);
        assertThrows(QuestionIsAlreadyAddedException.class,()->out.add(question1));
        assertThrows(QuestionIsAlreadyAddedException.class,()->out.add(QUESTION,ANSWER));
    }

    @Test
    public void shouldRemoveQuestion() {
        out.add(question1);
        assertEquals(question1,out.remove(question1));
        assertEquals(questions,out.getAll());
    }
    @Test
    public void shouldThrowsQuestionNotFindException() {
        assertThrows(QuestionNotFindException.class,()->out.remove(question1));
    }

    @Test
    public void shouldReturnAllQuestion() {
        questions.add(question1);
        questions.add(question2);
        out.add(question1);
        out.add(question2);
        assertEquals(questions,out.getAll());
    }

    @Test
    public void shouldReturnRandomQuestion() {
        out.add(question1);
        assertEquals(question1, out.getRandomQuestion());
    }
    @Test
    public void shouldThrowNoQuestionsInServiceException() {
        assertThrows(NoQuestionsInServiceException.class, out::getRandomQuestion);
    }
}
