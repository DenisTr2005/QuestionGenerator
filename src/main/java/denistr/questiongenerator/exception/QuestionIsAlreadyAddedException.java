package denistr.questiongenerator.exception;

public class QuestionIsAlreadyAddedException extends RuntimeException{
    public QuestionIsAlreadyAddedException() {
        super("Такой вопрос уже есть в списке!");
    }
}
