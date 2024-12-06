package pro.sky.CoursePaper2_Badlose.ExaminerService.Service;

import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;

import java.util.List;

public interface ExaminerService {

    List<Question> getQuestions(int amount);

    List<Question> getJavaQuestions(int amount);

    List<Question> getMathQuestions(int amount);

}
