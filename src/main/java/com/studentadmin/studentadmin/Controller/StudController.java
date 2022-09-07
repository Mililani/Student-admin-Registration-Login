package com.myproject.myproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myproject.myproject.Model.UsersModel;
import com.myproject.myproject.Service.StudService;

@Controller
public class StudController {

    @Autowired
    private StudService studservice;

    //display list of Users
@GetMapping("/")
    public String Viewhome(Model model){
        model.addAttribute("listUsers",studservice.getAllUsers());
      
        return "index";

    }

    @GetMapping("/showUser")
    public String  showNewUserForm(Model model){
        //created model attribut to bind form data
        UsersModel user= new UsersModel();
        model.addAttribute("user",user);

        return "add_user";

    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user") UsersModel user){
       //save to database
       studservice.saveUsers(user);
       
        return "redirect:/";
    }

    @GetMapping("/showedit/{id}")
    public String showedit(@PathVariable (value ="id")Integer id,Model model){

        //get imp from service vaai id
        UsersModel user= studservice.getUserBiId(id);

        //set user model attributes to pre-populate the form
        model.addAttribute("user",user);
        
        return "edit_user";

    }

    @GetMapping("/delete/{id}")
public String usersedelete(@PathVariable (value ="id")Integer id){

    this.studservice.deleteUserById(id);

    return "redirect:/";

}

}
