package pro.sky.CoursePaper2_Badlose.ExaminerService.Service;

import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;

import java.util.List;


public interface QuestionService {

    Question removeQuestion(String question, String answer);

    Question addQuestion(String question, String answer);

    Question findQuestion(String question);

    List<Question> getAll();

    int getRandomQuestion();

    void addPreparedQuestion(Question preparedQuestion);
}

