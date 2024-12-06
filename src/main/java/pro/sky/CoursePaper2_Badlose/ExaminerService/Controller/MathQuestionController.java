package pro.sky.CoursePaper2_Badlose.ExaminerService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl.MathQuestionServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/exam/math")

public class MathQuestionController {

    private final MathQuestionServiceImpl mathQuestionService;

    public MathQuestionController(MathQuestionServiceImpl mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return mathQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "QuestionText", required = false) String QuestionText,
                                @RequestParam(value = "QuestionAnswer", required = false) String QuestionAnswer) {

        return mathQuestionService.addQuestion(QuestionText, QuestionAnswer);
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "QuestionText", required = false) String QuestionText,
                                   @RequestParam(value = "QuestionAnswer", required = false) String QuestionAnswer) {

        return mathQuestionService.removeQuestion(QuestionText, QuestionAnswer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam(value = "question", required = false) String question) {

        return mathQuestionService.findQuestion(question);
    }
}
