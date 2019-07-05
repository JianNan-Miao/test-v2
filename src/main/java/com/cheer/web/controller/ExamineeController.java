package com.cheer.web.controller;

import com.cheer.domain.Examinee;
import com.cheer.service.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutorService;

@Controller
public class ExamineeController {
    @Autowired
    private ExamineeService examineeService;

    @RequestMapping("page_examinee_index")
    public String index(){
        return "page_examinee_index";
    }

    @GetMapping("examineeLogin")
    public String examineeLogin(){
        return "examinee_login1";
    }

    @PostMapping("examineeLogin")
    public String examineeIndex(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session){
        Examinee examinee = examineeService.findExaminee(Integer.parseInt(id));
        System.out.println(examinee);
        if(password==null||examinee==null||!password.equals(examinee.getPassword())){
            return "examinee_login1";
        }else{
            session.setAttribute("examinee",examinee);
            return "redirect:page_examinee_index";
        }

    }

}
