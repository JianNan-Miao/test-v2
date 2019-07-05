package com.cheer.service;

import com.cheer.domain.Question;

import java.util.List;

public interface QuestionService {
    public  void insertQuestion(Question question);

    public List<Question> getQuestion();

    public void  deleteQuestion(int id);
}
