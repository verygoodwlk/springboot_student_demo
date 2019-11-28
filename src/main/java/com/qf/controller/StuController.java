package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/***
 *
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private IStuService stuService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Student> stu = stuService.list();
        model.addAttribute("stus", stu);
        System.out.println(1/0);
        return "stulist";
    }

    @RequestMapping("/delete")
    public void delete(Integer id, HttpServletRequest request, HttpServletResponse response){
        stuService.removeById(id);

        //处理请求
        //响应结果
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
//        return "redirect:/stu/list";
    }
}
