package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Qualifier("math")
public class MathQuestionServiceImpl implements QuestionService {

    private final Set<Question> mathQuestionsSet = new HashSet<>();

    @PostConstruct
    public void initQuestions() {
        Question question1 = new Question("11", "11");
        Question question2 = new Question("21", "21");
        Question question3 = new Question("31", "31");
        Question question4 = new Question("41", "41");
        Question question5 = new Question("51", "51");
        Question question6 = new Question("61", "61");
        Question question7 = new Question("71", "71");
        Question question8 = new Question("81", "81");
        Question question9 = new Question("91", "91");
        Question question10 = new Question("101", "101");

        Set<Question> questionsToAdd = Set.of(question1, question2, question3, question4, question5, question6, question7,
                question8, question9, question10);

        mathQuestionsSet.addAll(questionsToAdd);
    }


    @Override
    public Question addQuestion(String q, String a) {
        Question question = new Question(q, a);

        mathQuestionsSet.add(question);

        return question;
    }

    public void addPreparedQuestion(Question preparedQuestion) {
        mathQuestionsSet.add(preparedQuestion);
    }

    @Override
    public Question findQuestion(String question) {
        return mathQuestionsSet.stream()
                .filter((e) -> Objects.equals(e.getQuestion(), question))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Question removeQuestion(String questionText, String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);

        mathQuestionsSet.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        return mathQuestionsSet.stream().toList();
    }

    public int getRandomQuestion() {
        return ThreadLocalRandom.current().nextInt(mathQuestionsSet.size());

    }

    public int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(mathQuestionsSet.size());
    }

    public List<Question> getPseudoRandomQuestion(int amount) {
        Set<Question> resultQuestions = new HashSet<>();
        int pseudoRandomInt = 0;

        while (resultQuestions.size() != amount) {
            Question question;
            question = mathQuestionsSet.stream()
                    .skip(pseudoRandomInt)
                    .findFirst()
                    .orElse(null);

            resultQuestions.add(question);
            pseudoRandomInt++;
        }
        return resultQuestions.stream().toList();
    }
}
