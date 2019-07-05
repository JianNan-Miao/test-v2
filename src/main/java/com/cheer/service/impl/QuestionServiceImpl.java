package com.cheer.service.impl;

import com.cheer.dao.QuestionMapper;
import com.cheer.domain.Question;
import com.cheer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void insertQuestion(Question question) {
        questionMapper.insertQuestion(question);
    }

    @Override
    public List<Question> getQuestion() {
        List<Question> questionList = questionMapper.getQuestion();
        return questionList;
    }

    @Override
    public void deleteQuestion(int id) {
        questionMapper.deleteQuestion(id);
    }
}
