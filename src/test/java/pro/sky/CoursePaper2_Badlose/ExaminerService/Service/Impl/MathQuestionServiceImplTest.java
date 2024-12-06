package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Repository.Impl.MathQuestionsRepositoryImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceImplTest {

    private MathQuestionsRepositoryImpl mathQuestionsRepository;

    @BeforeEach
    public void clear() {
        mathQuestionsRepository = new MathQuestionsRepositoryImpl();
    }

    @Test
    public void shouldAddNewMathQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");

        //when
        Question actualQuestion = mathQuestionsRepository.addQuestion(
                expectedQuestion.getQuestion(),
                expectedQuestion.getAnswer());

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldNotAddNewMathQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        mathQuestionsRepository.addPreparedQuestion(expectedQuestion);
        int expectedSize = mathQuestionsRepository.getAll().size();

        //when
        Question actualQuestion = mathQuestionsRepository.addQuestion(
                expectedQuestion.getQuestion(), null);
        int actualSize = mathQuestionsRepository.getAll().size();

        //then
        assertEquals(expectedSize, actualSize);
    }


    @Test
    void shouldAddNewPreparedMathQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");

        //when
        Question actualQuestion = mathQuestionsRepository.addPreparedQuestion(expectedQuestion);

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }


    @Test
    void shouldNotAddNewPreparedJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        mathQuestionsRepository.addPreparedQuestion(expectedQuestion);
        int expectedSize = mathQuestionsRepository.getAll().size();

        //when
        Question actualQuestion = mathQuestionsRepository.addPreparedQuestion(null);
        int actualSize = mathQuestionsRepository.getAll().size();

        //then
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldFindMathQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        mathQuestionsRepository.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        //when
        Question actualQuestion = mathQuestionsRepository.findQuestion(expectedQuestion.getQuestion());
        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldNotFindMAthQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        Question fakeQuestion = new Question("fake", "fake");

        //when
        Question actualQuestion = mathQuestionsRepository.findQuestion(fakeQuestion.getQuestion());

        //then
        assertNotEquals(expectedQuestion, actualQuestion);
    }


    @Test
    void shouldRemoveMathQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        mathQuestionsRepository.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        //when
        Question actualQuestion = mathQuestionsRepository.removeQuestion(expectedQuestion.getQuestion(),
                expectedQuestion.getAnswer());
        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldNotRemoveJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        mathQuestionsRepository.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        Question fakeQuestion = new Question("fake", "fake");

        //when
        Question actualQuestion = mathQuestionsRepository.removeQuestion(fakeQuestion.getQuestion(),
                fakeQuestion.getAnswer());
        //then
        assertNotEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldGetAllMathQuestions() {
        //given
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Question question3 = new Question("3", "3");
        List<Question> expectedQuestionsList = new ArrayList<>(
                List.of(question1, question2, question3));

        System.out.println(mathQuestionsRepository.getAll());
        mathQuestionsRepository.addPreparedQuestion(question1);
        mathQuestionsRepository.addPreparedQuestion(question2);
        mathQuestionsRepository.addPreparedQuestion(question3);


        //when
        List<Question> actualQuestionsList = mathQuestionsRepository.getAll();
        //then
        assertEquals(expectedQuestionsList, actualQuestionsList);
    }

}