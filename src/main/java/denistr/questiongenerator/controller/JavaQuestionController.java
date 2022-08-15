package denistr.questiongenerator.controller;

import denistr.questiongenerator.data.Question;
import denistr.questiongenerator.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return null;
    }
    @GetMapping
    public Collection<Question> getQuestions() {
        return null;
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return null;
    }
}
