package denistr.questiongenerator.exception;

public class QuestionNotFindException extends RuntimeException {
    public QuestionNotFindException() {
        super("Вопрос не найден!");
    }
}
