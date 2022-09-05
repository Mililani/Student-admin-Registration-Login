package com.studentadmin.studentadmin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentadmin.studentadmin.Model.StudentModel;
import com.studentadmin.studentadmin.Service.StudentService;




@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //display html register page
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new StudentModel());
        return "register_page";
    }


    //Display login page
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest",new StudentModel());
        return "login_page";
    }

    //Post data to database
    @PostMapping("/register")
    public  String register(@ModelAttribute StudentModel studentModel){
        System.out.println("register request: "+studentModel);
        StudentModel registeredStudent=studentService.registerStudent(studentModel.getName(),studentModel.getEmail(), studentModel.getAddress(), studentModel.getCourse(), studentModel.getPassword());
         return registeredStudent==null ? "error_page" : "redirect:/login";
    }

    //post date to login to student page
    @PostMapping("/login")
    public  String login(@ModelAttribute StudentModel studentModel,Model model){
        System.out.println("login request: "+studentModel);
        StudentModel authenticated=studentService.authenticate(studentModel.getName(),studentModel.getPassword());
        if(authenticated !=null){
            model.addAttribute("userLogin",authenticated.getName());
            return "student_page";

        }else {
            return "error_page";
        }
    }



    

}
