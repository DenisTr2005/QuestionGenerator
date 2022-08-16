package denistr.questiongenerator.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoMoreQuestionsException extends RuntimeException {
    public NoMoreQuestionsException() {
        super("Запрошено слишком много вопросов!");
    }
}
