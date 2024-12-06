package pro.sky.CoursePaper2_Badlose.ExaminerService.Repository.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionsRepositoryService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Repository
public class JavaQuestionsRepositoryImpl implements QuestionsRepositoryService {

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

    private final Set<Question> questionsToAdd = new HashSet<>();


    @PostConstruct
    private void initQuestions() {
        questionsToAdd.add(question1);
        questionsToAdd.add(question2);
        questionsToAdd.add(question3);
        questionsToAdd.add(question4);
        questionsToAdd.add(question5);
        questionsToAdd.add(question6);
        questionsToAdd.add(question7);
        questionsToAdd.add(question8);
        questionsToAdd.add(question9);
        questionsToAdd.add(question10);
    }

    @Override
    public Question addQuestion(String q, String a) {
        Question question = new Question(q, a);

        if (q != null && a != null) {
            questionsToAdd.add(question);
        }
        return question;
    }

    public Question addPreparedQuestion(Question question) {
        if (question != null) {
            questionsToAdd.add(question);
        }
        return question;
    }

    @Override
    public Question findQuestion(String question) {
        return questionsToAdd.stream()
                .filter((e) -> Objects.equals(e.getQuestion(), question))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Question removeQuestion(String questionText, String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);

        questionsToAdd.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        return questionsToAdd.stream().toList();
    }

}
