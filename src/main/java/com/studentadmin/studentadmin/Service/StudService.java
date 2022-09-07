package com.myproject.myproject.Service;

import java.util.List;

import com.myproject.myproject.Model.UsersModel;

public interface StudService {
    
    List<UsersModel>getAllUsers();
    
    void saveUsers(UsersModel usersModel);

    UsersModel getUserBiId(Integer id);

    void deleteUserById(Integer id);
}
