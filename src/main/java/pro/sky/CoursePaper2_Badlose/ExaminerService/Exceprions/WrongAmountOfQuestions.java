package pro.sky.CoursePaper2_Badlose.ExaminerService.Exceprions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongAmountOfQuestions extends RuntimeException {

    public WrongAmountOfQuestions() {
        System.out.println("Неверное количесво вопросов");
    }
}
