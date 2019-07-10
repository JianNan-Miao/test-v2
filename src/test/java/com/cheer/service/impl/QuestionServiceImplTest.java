package com.cheer.service.impl;

import com.cheer.config.AppConfig;
import com.cheer.domain.Question;
import com.cheer.service.QuestionService;
import com.cheer.service.QuestionService1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.annotation.ApplicationScope;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class QuestionServiceImplTest {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionService1 questionService1;

    @Test
    public void insertQuestion() {
        Question question=new Question(1,"haha","a","b","c","d","isa");
        questionService1.insertQuestion("d:/题目.xlsx");
    }

    @Test
    public void getQuestion() {
    }

    @Test
    public void deleteQuestion() {
    }
}