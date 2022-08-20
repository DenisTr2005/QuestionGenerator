package denistr.questiongenerator.exception;

public class NoQuestionsInServiceException extends RuntimeException {
    public NoQuestionsInServiceException() {
        super("Вопросы отсутствуют!");
    }
}
