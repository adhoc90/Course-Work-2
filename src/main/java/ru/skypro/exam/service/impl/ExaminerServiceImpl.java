package ru.skypro.exam.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.exam.exception.NotEnoughServiceQuestionsException;
import ru.skypro.exam.model.Question;
import ru.skypro.exam.service.ExaminerService;
import ru.skypro.exam.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();

        if (amount > questionService.getAll().size() || amount < 0) {

            throw new NotEnoughServiceQuestionsException("Недостаточно вопросов в сервисе");

        }
        while (questions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            questions.add(question);
        }
        return questions;
    }
}