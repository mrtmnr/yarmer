package com.example.yarmer.Service;

import com.example.yarmer.Model.Question;

public interface QuizService {

    Question getQuestion(int index);
    int getTotalQuestions();
}
