package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Exceprions.WrongAmountOfQuestions;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.ExaminerService;


import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionServiceImpl javaQuestionService;
    private final MathQuestionServiceImpl mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionService, MathQuestionServiceImpl mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    private Set<Question> resultQuestions;


    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > (javaQuestionService.getAll().size()) +
                mathQuestionService.getAll().size()) {
            throw new WrongAmountOfQuestions();
        }
        Set<Question> resultQuestions = new HashSet<>(0);

        while (resultQuestions.size() < amount) {
            if (resultQuestions.size() < amount - 1) {
                resultQuestions.add(getOneJavaQuestion());
                resultQuestions.add(getOneMathQuestion());
            } else {
                Question b = new Random().nextBoolean() ? getOneMathQuestion() : getOneJavaQuestion();
                resultQuestions.add(b);
            }
        }
        return resultQuestions;
    }

    @Override
    public List<Question> getJavaQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new WrongAmountOfQuestions();
        }

        resultQuestions = new HashSet<>();

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

    public Question getOneJavaQuestion() {
        int randomInt = javaQuestionService.getRandomQuestion();
        return javaQuestionService.getAll().stream()
                .skip(randomInt)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Question> getMathQuestions(int amount) {
        if (amount > mathQuestionService.getAll().size()) {
            throw new WrongAmountOfQuestions();
        }

        resultQuestions = new HashSet<>();

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

    public Question getOneMathQuestion() {
        int randomInt = mathQuestionService.getRandomQuestion();
        return mathQuestionService.getAll().stream()
                .skip(randomInt)
                .findFirst()
                .orElse(null);
    }

}
