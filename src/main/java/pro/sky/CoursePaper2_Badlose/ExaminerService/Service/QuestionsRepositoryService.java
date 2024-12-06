package pro.sky.CoursePaper2_Badlose.ExaminerService.Service;

import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;

import java.util.List;

public interface QuestionsRepositoryService {

    Question addQuestion(String q, String a);

    Question addPreparedQuestion(Question question);

    Question findQuestion(String question);

    Question removeQuestion(String questionText, String questionAnswer);

    List<Question> getAll();

}
