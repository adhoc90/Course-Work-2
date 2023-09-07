package ru.skypro.exam.Impl;

import ru.skypro.exam.model.Question;

import java.util.Collection;
import java.util.Set;

public class QuestionTestConstants {

    public static final Question QUESTION_1 = new Question("Q1", "A1");
    public static final Question QUESTION_2 = new Question("Q2", "A2");
    public static final Question QUESTION_3 = new Question("Q3", "A3");
    public static final Question QUESTION_4 = new Question("Q4", "A4");
    public static final Question QUESTION_5 = new Question("Q5", "A5");

    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5
    );
}
