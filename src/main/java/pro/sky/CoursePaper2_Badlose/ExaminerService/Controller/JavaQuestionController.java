package pro.sky.CoursePaper2_Badlose.ExaminerService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam/java")

public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "QuestionText", required = false) String QuestionText,
                                @RequestParam(value = "QuestionAnswer", required = false) String QuestionAnswer) {

        return questionService.addQuestion(QuestionText, QuestionAnswer);
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "QuestionText", required = false) String QuestionText,
                                   @RequestParam(value = "QuestionAnswer", required = false) String QuestionAnswer) {

        return questionService.removeQuestion(QuestionText, QuestionAnswer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam(value = "question", required = false) String question) {

        return questionService.findQuestion(question);
    }
}

