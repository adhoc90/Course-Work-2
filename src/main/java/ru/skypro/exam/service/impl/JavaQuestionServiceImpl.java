package ru.skypro.exam.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.exam.exception.QuestionNotFoundException;
import ru.skypro.exam.model.Question;
import ru.skypro.exam.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Такого вопроса не существует");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question[] array = getAll().toArray(Question[]::new);
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}