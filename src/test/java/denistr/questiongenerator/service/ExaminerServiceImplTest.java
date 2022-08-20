package denistr.questiongenerator.service;

import denistr.questiongenerator.data.Question;
import denistr.questiongenerator.exception.NoMoreQuestionsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Set;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private final Question
            question1 = new Question("Какие условные операторы вы знаете?",
                                        "if else, switch case, тернарный оператор ?:");
    private final Set<Question> questions = new HashSet<>(Set.of(question1));
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;
    @BeforeEach
    public void setUp() {
        when(questionService.getAll()).thenReturn(questions);
    }

    @Test
    public void shouldReturnAmountQuestions() {
        when(questionService.getRandomQuestion()).thenReturn(question1);
        assertEquals(questions,out.getQuestions(1));
    }
    @Test
    public void shouldThrowNoMoreQuestionsException() {
        assertThrows(NoMoreQuestionsException.class, () -> out.getQuestions(2));
    }
}
