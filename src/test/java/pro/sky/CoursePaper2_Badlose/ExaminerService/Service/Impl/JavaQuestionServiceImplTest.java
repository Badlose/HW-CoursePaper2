package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {

    private JavaQuestionServiceImpl questionService;

    @BeforeEach
    public void clear() {
        questionService = new JavaQuestionServiceImpl();
    }

    @Test
    void shouldAddNewQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");

        //when
        Question actualQuestion = questionService.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldFindQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        questionService.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        //when
        Question actualQuestion = questionService.findQuestion(expectedQuestion.getQuestion());
        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldRemoveQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        questionService.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        //when
        Question actualQuestion = questionService.removeQuestion(expectedQuestion.getQuestion(),
                expectedQuestion.getAnswer());
        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldGetAllQuestions() {
        //given
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Question question3 = new Question("3", "3");
        List<Question> expectedQuestionsList = new ArrayList<>(
                List.of(question1, question2, question3));

        questionService.addPreparedQuestion(question1);
        questionService.addPreparedQuestion(question2);
        questionService.addPreparedQuestion(question3);


        //when
        List<Question> actualQuestionsList = questionService.getAll();
        //then
        assertEquals(expectedQuestionsList, actualQuestionsList);
    }


    //Единственное, что смог придумать для теста с рандомом
    @Test
    void shouldGetRandomQuestion() {
        //given
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Question question3 = new Question("3", "3");
        List<Question> expectedQuestionsList = new ArrayList<>(
                List.of(question1, question2));

        questionService.addPreparedQuestion(question1);
        questionService.addPreparedQuestion(question2);
        questionService.addPreparedQuestion(question3);

        //when
        List<Question> actualQuestionsList = questionService.getPseudoRandomQuestion(2);

        //then
        assertEquals(expectedQuestionsList, actualQuestionsList);
    }
}