package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Repository.Impl.JavaQuestionsRepositoryImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {

    private JavaQuestionsRepositoryImpl javaQuestionsRepository;

    @BeforeEach
    public void clear() {
        javaQuestionsRepository = new JavaQuestionsRepositoryImpl();
    }

    @Test
    public void shouldAddNewJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");

        //when
        Question actualQuestion = javaQuestionsRepository.addQuestion(
                expectedQuestion.getQuestion(),
                expectedQuestion.getAnswer());

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldNotAddNewJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        javaQuestionsRepository.addPreparedQuestion(expectedQuestion);
        int expectedSize = javaQuestionsRepository.getAll().size();

        //when
        Question actualQuestion = javaQuestionsRepository.addQuestion(
                expectedQuestion.getQuestion(), null);
        int actualSize = javaQuestionsRepository.getAll().size();

        //then
        assertEquals(expectedSize, actualSize);
    }


    @Test
    void shouldAddNewPreparedJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");

        //when
        Question actualQuestion = javaQuestionsRepository.addPreparedQuestion(expectedQuestion);

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void shouldNotAddNewPreparedJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        javaQuestionsRepository.addPreparedQuestion(expectedQuestion);
        int expectedSize = javaQuestionsRepository.getAll().size();

        //when
        Question actualQuestion = javaQuestionsRepository.addPreparedQuestion(null);
        int actualSize = javaQuestionsRepository.getAll().size();

        //then
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldFindJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        javaQuestionsRepository.addQuestion(
                expectedQuestion.getQuestion(),
                expectedQuestion.getAnswer());

        //when
        Question actualQuestion = javaQuestionsRepository.findQuestion(expectedQuestion.getQuestion());
        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldNotFindJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        Question fakeQuestion = new Question("fake", "fake");

        //when
        Question actualQuestion = javaQuestionsRepository.findQuestion(fakeQuestion.getQuestion());

        //then
        assertNotEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldRemoveJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        javaQuestionsRepository.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        //when
        Question actualQuestion = javaQuestionsRepository.removeQuestion(expectedQuestion.getQuestion(),
                expectedQuestion.getAnswer());
        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldNotRemoveJavaQuestion() {
        //given
        Question expectedQuestion = new Question("123", "123");
        javaQuestionsRepository.addQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        Question fakeQuestion = new Question("fake", "fake");

        //when
        Question actualQuestion = javaQuestionsRepository.removeQuestion(fakeQuestion.getQuestion(),
                fakeQuestion.getAnswer());
        //then
        assertNotEquals(expectedQuestion, actualQuestion);
    }


    @Test
    public void shouldGetAllJavaQuestions() {
        //given
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Question question3 = new Question("3", "3");
        List<Question> expectedQuestionsList = new ArrayList<>(
                List.of(question1, question2, question3));

        javaQuestionsRepository.addPreparedQuestion(question1);
        javaQuestionsRepository.addPreparedQuestion(question2);
        javaQuestionsRepository.addPreparedQuestion(question3);

        //when
        List<Question> actualQuestionsList = javaQuestionsRepository.getAll();
        //then
        assertEquals(expectedQuestionsList, actualQuestionsList);
    }


}