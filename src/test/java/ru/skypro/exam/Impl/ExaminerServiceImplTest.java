package ru.skypro.exam.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.exam.exception.NotEnoughServiceQuestionsException;
import ru.skypro.exam.service.QuestionService;
import ru.skypro.exam.service.impl.ExaminerServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;
import static ru.skypro.exam.Impl.QuestionTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void should_Throw_NotEnoughServiceQuestionsException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThatExceptionOfType(NotEnoughServiceQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(NotEnoughServiceQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));
    }

    @Test
    public void should_Return_Questions() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4,
                QUESTION_5
        );

        int questionAmount = (MOCK_QUESTIONS.size() - 2);
        assertThat(examinerService.getQuestions(questionAmount))
                .hasSize(questionAmount);
    }
}
