package pro.sky.CoursePaper2_Badlose.ExaminerService.Service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Exceprions.WrongAmountOfQuestions;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Model.Question;
import pro.sky.CoursePaper2_Badlose.ExaminerService.Service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> questions = new ArrayList<>() {{
        add(new Question("1", "1"));
        add(new Question("2", "2"));
        add(new Question("3", "3"));
        add(new Question("4", "3"));
        add(new Question("5", "3"));
        add(new Question("6", "3"));
    }};

    private final List<Question> questionsList = new ArrayList<>() {{
        add(new Question("2", "2"));
    }};

    @Test
    public void shouldGetRandomQuestions() {
        //given
        int amount = 1;
        int pseudoRandomInt = 1;

        List<Question> expectedQuestions = new ArrayList<>(questionsList);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(pseudoRandomInt);
        Mockito.when(questionService.getAll()).thenReturn(questions);

        //when
        List<Question> actualQuestions = examinerService.getQuestions(amount);

        //then
        assertEquals(expectedQuestions, actualQuestions);
    }

    @Test
    public void shouldThrowWrongAmountOfQuestions() {
        //given
        int amount = 7;
        Mockito.when(questionService.getAll()).thenReturn(questions);

        //then
        assertThrows(WrongAmountOfQuestions.class, () -> examinerService.getQuestions(amount));
    }
}