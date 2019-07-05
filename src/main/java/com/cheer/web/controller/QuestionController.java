package com.cheer.web.controller;

import com.cheer.domain.Examinee;
import com.cheer.domain.Information;
import com.cheer.domain.Question;
import com.cheer.service.ExamineeService;
import com.cheer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {
    Map<String,String> map=new HashMap<>();
    @Autowired
    private QuestionService questionService;

    @Autowired
     private ExamineeService examineeService;

    @ResponseBody
    @RequestMapping("getQueslist")
    public List<Question> getQueslist(){
        List<Question> questionList = questionService.getQuestion();

        return questionList;
    }

    @RequestMapping("nextQuestion")
    public String nextQuestion(String val, String num, HttpSession session){
        int size = questionService.getQuestion().size();
        session.setAttribute("size",size);
        session.setAttribute("num",num);
        map.put(num,val);
        System.out.println(map);
        return "redirect:page_examinee_index";
    }

    @ResponseBody
    @RequestMapping("beforeQuestion")
    public String beforeQuestion(String keys){
        String value = map.get(keys);
        System.out.println(value);
        return value;
    }

    @RequestMapping("submitQues")
    public String submitQues(String val, String num,HttpSession session){
        int pazz=0;
        int correct=0;
        int incorrect=0;
        double score=0.0;
        String pass=null;
        map.put(num,val);
        System.out.println(map);
        Examinee examinee = (Examinee) session.getAttribute("examinee");
        List<Question> list = questionService.getQuestion();
        if(examinee!=null){
            int id = examinee.getId();
            int  miss_answer=list.size()-map.size();
            for(int i=0;i<list.size();i++){
                String correct_answer = list.get(i).getAnswer();
                String my_answer = map.get(String.valueOf((i + 1)));
                if (my_answer!=null) {
                    if(correct_answer.indexOf(my_answer)!=-1){
                        correct++;
                    }else{
                        incorrect++;
                    }
                }
            }
            score=100/(list.size())*correct;
            if(score>=90){
                pass="及格";
                pazz=1;
            }else{
                pass="不及格";
                pazz=0;
            }

            //将考生的考试状态，成绩等信息更新到数据库
            examinee.setStatus(1);
            examinee.setScore(score);
            examinee.setPass(pazz);
            examineeService.updateExaminee(examinee);
            //将结果封装成information对象，方便最后考试信息的解析
            Information inf=new Information(id,correct,incorrect,miss_answer,score,pass);
            System.out.println(inf);
            session.setAttribute("inf",inf);
        }
        return "redirect:exam_end";
    }

    @RequestMapping("exam_end")
    public  String exam_end(){
        return  "exam_end";
    }
}
