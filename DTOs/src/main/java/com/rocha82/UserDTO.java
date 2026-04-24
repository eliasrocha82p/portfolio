package com.rocha82.dto;
import com.rocha82.repository.Repository;
public class UserDTO{
    Repository repository = new Repository();
    public String getByID(int id){
        return "Object from dto";
    }
}