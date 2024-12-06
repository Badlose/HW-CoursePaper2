package pro.sky.CoursePaper2_Badlose.ExaminerService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.ExaminerService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController implements ExaminerService {

    @Autowired
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

    @GetMapping("/java/get/{amount}")
    public List<Question> getJavaQuestions(@PathVariable int amount) {
        return examinerService.getJavaQuestions(amount);
    }

    @GetMapping("/math/get/{amount}")
    public List<Question> getMathQuestions(@PathVariable int amount) {
        return examinerService.getMathQuestions(amount);
    }
}
