package pro.sky.CoursePaper2_Badlose.ExaminerService.Service;

import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;

import java.util.List;
import java.util.Set;

public interface ExaminerService {

    Set<Question> getQuestions(int amount);

    List<Question> getJavaQuestions(int amount);

    List<Question> getMathQuestions(int amount);

}
