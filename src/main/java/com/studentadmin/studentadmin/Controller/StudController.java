package com.studentadmin.studentadmin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentadmin.studentadmin.Model.StudentModel;
import com.studentadmin.studentadmin.Service.StudService;



@Controller
public class StudController {

    @Autowired
    private StudService studservice;

    //display list of Users
@GetMapping("/")
    public String Viewhome(Model model){
        model.addAttribute("ListOfStudent",studservice.getAllStudent());
      
        return "index";

    }

    @GetMapping("/showUser")
    public String  showNewUserForm(Model model){
        //created model attribut to bind form data
        StudentModel student= new StudentModel();
        model.addAttribute("students",student);

        return "add_user";

    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute ("students") StudentModel student){
       //save to database
       studservice.saveStudent(student);
       
        return "redirect:/";
    }

    @GetMapping("/showedit/{id}")
    public String showedit(@PathVariable (value ="id")Integer id,Model model){

        //get imp from service vaai id
        StudentModel user= studservice.getStudentById(id);

        //set user model attributes to pre-populate the form
        model.addAttribute("user",user);
        
        return "edit_user";

    }

    @GetMapping("/delete/{id}")
public String usersedelete(@PathVariable (value ="id")Integer id){

    this.studservice.deleteStudentById(id);

    return "redirect:/";

}

}
