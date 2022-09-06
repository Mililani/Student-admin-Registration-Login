package com.studentadmin.studentadmin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentadmin.studentadmin.Model.AdminModel;
import com.studentadmin.studentadmin.Repository.AdminRepository;





@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    public AdminModel registerAdmin(String name,String contact,String password){
        if (name == null || password == null) {
            return  null;
        } else {
            if(adminRepository.findFirstByName(name).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            AdminModel adminModel=new AdminModel();
            adminModel.setName(name);
            adminModel.setContact(contact);;
            adminModel.setPassword(password);
            return adminRepository.save(adminModel);
        }
    }

    public  AdminModel authenticate(String name,String password){
        return  adminRepository.findByNameAndPassword(name,password).orElse(null);
    }




    

}
