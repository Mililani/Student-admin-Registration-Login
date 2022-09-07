package com.studentadmin.studentadmin.Service;


import java.util.List;

import com.studentadmin.studentadmin.Model.StudentModel;



public interface StudService {
    
    List<StudentModel>getAllStudent();
    
    void saveStudent(StudentModel studentModel);

    StudentModel getStudentById(Integer id);

    void deleteStudentById(Integer id);
}
