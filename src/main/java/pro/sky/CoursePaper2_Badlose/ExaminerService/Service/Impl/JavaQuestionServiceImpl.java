package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionService;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Qualifier("java")
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> JavaQuestionsSet = new HashSet<>();

    @PostConstruct
    public void initQuestions() {
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Question question3 = new Question("3", "3");
        Question question4 = new Question("4", "4");
        Question question5 = new Question("5", "5");
        Question question6 = new Question("6", "6");
        Question question7 = new Question("7", "7");
        Question question8 = new Question("8", "8");
        Question question9 = new Question("9", "9");
        Question question10 = new Question("10", "10");

        Set<Question> questionsToAdd = Set.of(question1, question2, question3, question4, question5, question6, question7,
                question8, question9, question10);

        JavaQuestionsSet.addAll(questionsToAdd);
    }


    @Override
    public Question addQuestion(String q, String a) {
        Question question = new Question(q, a);

        JavaQuestionsSet.add(question);

        return question;
    }

    public void addPreparedQuestion(Question preparedQuestion) {
        JavaQuestionsSet.add(preparedQuestion);
    }

    @Override
    public Question findQuestion(String question) {
        return JavaQuestionsSet.stream()
                .filter((e) -> Objects.equals(e.getQuestion(), question))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Question removeQuestion(String questionText, String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);

        JavaQuestionsSet.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        return JavaQuestionsSet.stream().toList();
    }

    public int getRandomQuestion() {
        return ThreadLocalRandom.current().nextInt(JavaQuestionsSet.size());

    }

    public int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(JavaQuestionsSet.size());
    }

    public List<Question> getPseudoRandomQuestion(int amount) {
        Set<Question> resultQuestions = new HashSet<>();
        int pseudoRandomInt = 0;

        while (resultQuestions.size() != amount) {
            Question question;
            question = JavaQuestionsSet.stream()
                    .skip(pseudoRandomInt)
                    .findFirst()
                    .orElse(null);

            resultQuestions.add(question);
            pseudoRandomInt++;
        }
        return resultQuestions.stream().toList();
    }
}

