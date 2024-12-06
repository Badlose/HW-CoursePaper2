package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Exceprions.WrongAmountOfQuestions;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.ExaminerService;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    @Autowired
    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService,
                               @Qualifier("math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = javaQuestionService;

    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > (javaQuestionService.getAll().size()) +
                mathQuestionService.getAll().size()) {
            throw new WrongAmountOfQuestions();
        }

        Set<Question> resultQuestions = new HashSet<>();

        while (resultQuestions.size() != amount) {
            int randomInt = javaQuestionService.getRandomQuestion();
            Question question;
            question = javaQuestionService.getAll().stream()
                    .skip(randomInt)
                    .findFirst()
                    .orElse(null);

            resultQuestions.add(question);

            randomInt = mathQuestionService.getRandomQuestion();
            question = javaQuestionService.getAll().stream()
                    .skip(randomInt)
                    .findFirst()
                    .orElse(null);

            resultQuestions.add(question);
        }
        return resultQuestions.stream().toList();
    }

    @Override
    public List<Question> getJavaQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new WrongAmountOfQuestions();
        }

        Set<Question> resultQuestions = new HashSet<>();

        while (resultQuestions.size() != amount) {
            int randomInt = javaQuestionService.getRandomQuestion();
            Question question;
            question = javaQuestionService.getAll().stream()
                    .skip(randomInt)
                    .findFirst()
                    .orElse(null);

            resultQuestions.add(question);
        }
        return resultQuestions.stream().toList();
    }

    @Override
    public List<Question> getMathQuestions(int amount) {
        if (amount > mathQuestionService.getAll().size()) {
            throw new WrongAmountOfQuestions();
        }

        Set<Question> resultQuestions = new HashSet<>();

        while (resultQuestions.size() != amount) {
            int randomInt = mathQuestionService.getRandomQuestion();
            Question question;
            question = mathQuestionService.getAll().stream()
                    .skip(randomInt)
                    .findFirst()
                    .orElse(null);

            resultQuestions.add(question);
        }
        return resultQuestions.stream().toList();
    }


}
