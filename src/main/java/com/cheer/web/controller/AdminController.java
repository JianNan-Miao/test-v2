package com.cheer.web.controller;

import com.cheer.domain.Administrator;
import com.cheer.domain.Examinee;
import com.cheer.domain.Question;
import com.cheer.service.ExamineeService;
import com.cheer.service.QuestionService;
import com.cheer.service.QuestionService1;

import com.cheer.util.IOUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionService1 questionService1;
    @Autowired
    private ExamineeService examineeService;

    @GetMapping("page_admin_index1")
    public String page_admin_index1(){
        return "page_admin_index1";
    }

    @GetMapping("admin_login1")
    public String admin_login1(){
        return "admin_login1";
    }

    @PostMapping("admin_login1")
    public String admin_login2(Administrator administrator){
        if("admin".equals(administrator.getAccountName())&&"admin".equals(administrator.getPassword())){

            return "redirect:page_admin_index1";
        }else{
            return "admin_login1";
        }
    }

    @RequestMapping("getQuestion")
    public String getQuestion(MultipartFile file) throws Exception {
         String src=null;
        String originalFilename = file.getOriginalFilename();
        if(file!=null&&originalFilename!=null){
            src="c:/avatar/";
            File file1=new File(src,originalFilename);
            file.transferTo(file1);
            String newSrc=src+file.getOriginalFilename();
            System.out.println(newSrc);
            questionService1.insertQuestion(newSrc);
        }

        return "redirect:page_admin_index1";
    }

    @ResponseBody
    @RequestMapping("questionList")
    public List<Question> questionList(){
        List<Question> questions = questionService.getQuestion();
        return questions;
    }

    @ResponseBody
    @RequestMapping("examineeList")
    public List<Examinee>  examineeList(){
        List<Examinee> examinees = examineeService.getExaminee();
        return examinees;
    }
}
