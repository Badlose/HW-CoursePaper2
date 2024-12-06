package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Repository.Impl.JavaQuestionsRepositoryImpl;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionsRepositoryService;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionServiceImpl implements QuestionsRepositoryService {

    private final JavaQuestionsRepositoryImpl javaQuestionsRepository;

    public JavaQuestionServiceImpl(JavaQuestionsRepositoryImpl javaQuestionsRepositoryService) {
        this.javaQuestionsRepository = javaQuestionsRepositoryService;
    }


    @Override
    public Question addQuestion(String q, String a) {
        return javaQuestionsRepository.addQuestion(q, a);
    }

    public Question addPreparedQuestion(Question preparedQuestion) {
        javaQuestionsRepository.addPreparedQuestion(preparedQuestion);
        return preparedQuestion;
    }

    @Override
    public Question findQuestion(String question) {
        return javaQuestionsRepository.findQuestion(question);
    }

    @Override
    public Question removeQuestion(String questionText, String questionAnswer) {
        return javaQuestionsRepository.removeQuestion(questionText, questionAnswer);
    }

    @Override
    public List<Question> getAll() {
        return javaQuestionsRepository.getAll();
    }

    public int getRandomQuestion() {
        return ThreadLocalRandom.current().nextInt(javaQuestionsRepository.getAll().size());
    }

}

