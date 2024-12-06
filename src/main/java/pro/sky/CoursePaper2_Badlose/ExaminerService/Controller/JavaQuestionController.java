package pro.sky.CoursePaper2_Badlose.ExaminerService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl.JavaQuestionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/exam/java")

public class JavaQuestionController {

    private final JavaQuestionServiceImpl javaQuestionService;


    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "QuestionText", required = false) String QuestionText,
                                @RequestParam(value = "QuestionAnswer", required = false) String QuestionAnswer) {

        return javaQuestionService.addQuestion(QuestionText, QuestionAnswer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "QuestionText", required = false) String QuestionText,
                                   @RequestParam(value = "QuestionAnswer", required = false) String QuestionAnswer) {

        return javaQuestionService.removeQuestion(QuestionText, QuestionAnswer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam(value = "question", required = false) String question) {

        return javaQuestionService.findQuestion(question);
    }
}

