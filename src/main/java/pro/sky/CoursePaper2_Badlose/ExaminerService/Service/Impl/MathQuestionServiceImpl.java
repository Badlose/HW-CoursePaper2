package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Repository.Impl.MathQuestionsRepositoryImpl;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionsRepositoryService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MathQuestionServiceImpl implements QuestionsRepositoryService {

    private final MathQuestionsRepositoryImpl mathQuestionsRepository;

    public MathQuestionServiceImpl(MathQuestionsRepositoryImpl mathQuestionsRepository) {
        this.mathQuestionsRepository = mathQuestionsRepository;
    }


    @Override
    public Question addQuestion(String q, String a) {
        return mathQuestionsRepository.addQuestion(q, a);
    }

    public Question addPreparedQuestion(Question preparedQuestion) {
        mathQuestionsRepository.addPreparedQuestion(preparedQuestion);
        return preparedQuestion;
    }

    @Override
    public Question findQuestion(String question) {
        return mathQuestionsRepository.getAll().stream()
                .filter((e) -> Objects.equals(e.getQuestion(), question))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Question removeQuestion(String questionText, String questionAnswer) {
        return mathQuestionsRepository.removeQuestion(questionText, questionAnswer);
    }

    @Override
    public List<Question> getAll() {
        return mathQuestionsRepository.getAll();
    }

    public int getRandomQuestion() {
        return ThreadLocalRandom.current().nextInt(mathQuestionsRepository.getAll().size());

    }
}
