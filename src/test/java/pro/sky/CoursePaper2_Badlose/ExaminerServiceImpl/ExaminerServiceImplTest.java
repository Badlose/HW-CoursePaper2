package pro.sky.CoursePaper2_Badlose.ExaminerServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Exceprions.WrongAmountOfQuestions;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl.ExaminerServiceImpl;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl.JavaQuestionServiceImpl;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl.MathQuestionServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl javaQuestionService;

    @Mock
    private MathQuestionServiceImpl mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> javaQuestions = new ArrayList<>() {{
        add(new Question("1", "1"));
        add(new Question("2", "2"));
        add(new Question("3", "3"));
    }};

    private final List<Question> mathQuestions = new ArrayList<>() {{
        add(new Question("11", "11"));
        add(new Question("21", "21"));
        add(new Question("31", "31"));
    }};

    @Test
    public void shouldThrowWrongAmountOfQuestions() {
        //given
        int amount = 7;
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);

        //then
        assertThrows(WrongAmountOfQuestions.class, () -> examinerService.getQuestions(amount));
    }


    @Test
    public void shouldGetAllQuestions() {
        //given
        int pseudoRandomInt = 2;
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(pseudoRandomInt);
        when(mathQuestionService.getRandomQuestion()).thenReturn(pseudoRandomInt);
        Set<Question> expectedQuestion = new HashSet<>();
        expectedQuestion.add(javaQuestions.get(2));
        expectedQuestion.add(mathQuestions.get(2));

        //when
        Set<Question> actualQuestion = examinerService.getQuestions(pseudoRandomInt);

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }


    @Test
    public void shouldGetJavaQuestion() {
        //given
        int pseudoRandomInt = 2;
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(pseudoRandomInt);

        List<Question> expectedList = new ArrayList<>();
        expectedList.add(javaQuestions.get(2));

        //when
        List<Question> actualList = new ArrayList<>(examinerService.getJavaQuestions(1));

        //then
        assertEquals(expectedList, actualList);
    }

    @Test
    public void ShouldGetOneJavaQuestion() {
        //given
        int pseudoRandomInt = 2;
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(pseudoRandomInt);

        Question expectedQuestion = javaQuestions.get(2);

        //when
        Question actualQuestion = examinerService.getOneJavaQuestion();

        //then
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldGetMathQuestions() {
        //given
        int pseudoRandomInt = 2;
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(mathQuestionService.getRandomQuestion()).thenReturn(pseudoRandomInt);

        List<Question> expectedList = new ArrayList<>();
        expectedList.add(mathQuestions.get(2));

        //when
        List<Question> actualList = new ArrayList<>(examinerService.getMathQuestions(1));

        //then
        assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldGetIneMathQuestion() {
        //given
        int pseudoRandomInt = 2;
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(mathQuestionService.getRandomQuestion()).thenReturn(pseudoRandomInt);

        Question expectedQuestion = mathQuestions.get(2);

        //when
        Question actualQuestion = examinerService.getOneMathQuestion();


        //then
        assertEquals(expectedQuestion, actualQuestion);
    }
}